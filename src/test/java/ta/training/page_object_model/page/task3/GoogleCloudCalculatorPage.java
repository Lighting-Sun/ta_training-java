package ta.training.page_object_model.page.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ta.training.model.CalculatorForm;

import static ta.training.constants.Constants.*;

public class GoogleCloudCalculatorPage extends BasePage{

    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[text()='Compute Engine']/parent::div")
    private WebElement computeEngineCard;

    @FindBy(xpath = "//div[contains(text(),'Number of instances')]/parent::div/following-sibling::div/div//input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGPUsButton;

    @FindBy(xpath = "//span[text()='Share']/parent::button")
    private WebElement shareButton;

    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//div[text()='Estimated cost']/following-sibling::div/label")
    private WebElement estimatedCostValue;

    /**
     * Finds a combobox element based on its associated span's text.
     *
     * @param strSelectName the text of the associated span element.
     * @return the WebElement of the combobox that is associated with the given text.
     */
    private WebElement getSelectByName(String strSelectName) {
        logger.info("Getting Select by name: " + strSelectName);
        return commonPageInteractions.getWebElement(By.xpath("//span[text()='" + strSelectName + "']/ancestor::div[@role='combobox']"));
    }

    /**
     * Finds a list item element based on its associated span's text.
     *
     * @param strSelectOptionName the text of the associated span element within the list item.
     * @return the WebElement of the list item that contains the given text.
     */
    private WebElement getSelectOptionByName(String strSelectOptionName) {
        logger.info("Getting Select Option by name: " + strSelectOptionName);
        return commonPageInteractions.getWebElement(By.xpath("//ul/li//span[text()='" + strSelectOptionName + "']/ancestor::li"));
    }

    /**
     * Finds a button element based on its associated label's text.
     *
     * @param strButtonName the text of the associated label element.
     * @return the WebElement of the button that is associated with the given text.
     */
    private WebElement getButtonByName(String strButtonName) {
        logger.info("Getting Button by name: " + strButtonName);
        return commonPageInteractions.getWebElement(By.xpath("//label[text()='" + strButtonName + "']/parent::div"));
    }

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected GoogleCloudCalculatorPage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }

    /**
     * Sets a select option by its name.
     *
     * @param strSelectName       the name of the select element.
     * @param strSelectOptionName the name of the option to select.
     */
    public void setSelectOptionByName(String strSelectName, String strSelectOptionName) {
        commonPageInteractions.clickOnElement(getSelectByName(strSelectName));
        commonPageInteractions.clickOnElement(getSelectOptionByName(strSelectOptionName));
        logger.info("Clicking on select "+ strSelectName +" and clicking on the option "+ strSelectOptionName);
    }

    /**
     * Clicks on the "Add to Estimate" button and then selects the Compute Engine card.
     */
    public void clickOnAddToEstimateAndSelectComputeEngine() {
        commonPageInteractions.clickOnElement(addToEstimateButton);
        commonPageInteractions.clickOnElement(computeEngineCard);
        logger.info("Clicking on Add to Estimate and select Compute Engine");
    }

    /**
     * Checks for the presence of the "Welcome to Google Cloud's Pricing Calculator" H1 element.
     *
     * @return true if the H1 element is present, false otherwise
     */
    public boolean presenceOfWelcomeToGoogleCloudsPricingCalculatorH1() {
        return commonPageInteractions.waitUntilWebElementIsPresentByLocator(By.xpath("//h1"));
    }

    /**
     * Fills out the estimate form with the provided values. submits it by clicking on share and open estimate summary
     *
     * @param formData the data to fill the form with
     */
    public void fillAndSubmitEstimateForm(CalculatorForm formData) {
        commonPageInteractions.sendTextToInput(numberOfInstancesInput, formData.getNumberOfInstances());
        setSelectOptionByName(OPERATING_SYSTEM_SOFTWARE, formData.getOperatingSystemSoftware());
        commonPageInteractions.clickOnElement(getButtonByName(formData.getProvisioningModel()));
        setSelectOptionByName(MACHINE_FAMILY, formData.getMachineFamily());
        setSelectOptionByName(SERIES, formData.getSeries());
        setSelectOptionByName(MACHINE_TYPE, formData.getMachineType());
        commonPageInteractions.clickOnElement(addGPUsButton);
        setSelectOptionByName(GPU_MODEL, formData.getGpuModel());
        setSelectOptionByName(NUMBER_OF_GPUS, formData.getNumberOfGpus());
        setSelectOptionByName(LOCAL_SSD, formData.getLocalSsd());
        setSelectOptionByName(REGION, formData.getRegion());
        commonPageInteractions.clickOnElement(getButtonByName(formData.getCommittedUseDiscountOptions()));
        logger.info("clicking on " + formData.getCommittedUseDiscountOptions());
        commonPageInteractions.waitUntilWebElementTextHasExpectedValue(estimatedCostValue, formData.getTotalEstimatedCost());
        commonPageInteractions.clickOnElement(shareButton);
        logger.info("clicking on Share button");
        commonPageInteractions.clickOnElement(openEstimateSummaryButton);
        logger.info("clicking on Open Estimate Summary Button");
    }
}
