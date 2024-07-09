package ta.training.page_object_model.page.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return commonPageInteractions.getWebElement(By.xpath("//span[text()='" + strSelectName + "']/ancestor::div[@role='combobox']"));
    }

    /**
     * Finds a list item element based on its associated span's text.
     *
     * @param strSelectOptionName the text of the associated span element within the list item.
     * @return the WebElement of the list item that contains the given text.
     */
    private WebElement getSelectOptionByName(String strSelectOptionName) {
        return commonPageInteractions.getWebElement(By.xpath("//ul/li//span[text()='" + strSelectOptionName + "']/ancestor::li"));
    }

    /**
     * Finds a button element based on its associated label's text.
     *
     * @param strButtonName the text of the associated label element.
     * @return the WebElement of the button that is associated with the given text.
     */
    private WebElement getButtonByName(String strButtonName) {
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
    }

    /**
     * Clicks on the "Add to Estimate" button and then selects the Compute Engine card.
     */
    public void clickOnAddToEstimateAndSelectComputeEngine() {
        commonPageInteractions.clickOnElement(addToEstimateButton);
        commonPageInteractions.clickOnElement(computeEngineCard);
    }

    /**
     * Fills out the estimate form with the provided values. submits it by clicking on share and open estimate summary
     *
     * @param numberOfInstances              the number of instances.
     * @param operatingSystem                the operating system.
     * @param provisioningModel              the provisioning model.
     * @param machineFamily                  the machine family.
     * @param series                         the series.
     * @param machineType                    the machine type.
     * @param gpuModel                       the GPU model.
     * @param numberOfGPUs                   the number of GPUs.
     * @param localSSD                       the local SSD.
     * @param region                         the region.
     * @param committedUseDiscountsOption    the committed use discounts option.
     * @param estimatedCost                  the estimated cost.
     */
    public void fillAndSubmitEstimateForm(String numberOfInstances, String operatingSystem, String provisioningModel, String machineFamily, String series, String machineType,
                                 String gpuModel, String numberOfGPUs, String localSSD, String region, String committedUseDiscountsOption, String estimatedCost) {
        commonPageInteractions.sendTextToInput(numberOfInstancesInput, numberOfInstances);
        setSelectOptionByName(OPERATING_SYSTEM_SOFTWARE, operatingSystem);
        commonPageInteractions.clickOnElement(getButtonByName(provisioningModel));
        setSelectOptionByName(MACHINE_FAMILY, machineFamily);
        setSelectOptionByName(SERIES, series);
        setSelectOptionByName(MACHINE_TYPE, machineType);
        commonPageInteractions.clickOnElement(addGPUsButton);
        setSelectOptionByName(GPU_MODEL, gpuModel);
        setSelectOptionByName(NUMBER_OF_GPUS, numberOfGPUs);
        setSelectOptionByName(LOCAL_SSD, localSSD);
        setSelectOptionByName(REGION, region);
        commonPageInteractions.clickOnElement(getButtonByName(committedUseDiscountsOption));
        commonPageInteractions.waitUntilWebElementTextHasExpectedValue(estimatedCostValue, estimatedCost);
        commonPageInteractions.clickOnElement(shareButton);
        commonPageInteractions.clickOnElement(openEstimateSummaryButton);
    }
}
