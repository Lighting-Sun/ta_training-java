package ta.training.page_object_model.page.task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;
import ta.training.page_object_model.page.task2.PasteBinHomePageTask2;

import java.time.Duration;

public class GoogleCloudCalculatorPage extends BasePage{

    public static final String GOOGLE_CLOUD_CALCULATOR_PAGE = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[text()='Compute Engine']/parent::div")
    private WebElement computeEngineCard;

    @FindBy(xpath = "//h2[text()='Compute Engine']/parent::div")
    private WebElement computeEngineHeader;

    @FindBy(xpath = "//div[contains(text(),'Number of instances')]/parent::div/following-sibling::div/div//input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//span[text()='Operating System / Software']/ancestor::div[@role='combobox']")
    private WebElement operatingSystemSoftwareCombobox;

    @FindBy(xpath = "//ul/li//span[text()='Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)']")
    private WebElement operatingSystemOwnLicenseOption;

    @FindBy(xpath = "//label[text()='Regular']/parent::div")
    private WebElement regularProvisioningModelButton;

    @FindBy(xpath = "//span[text()='Machine Family']/ancestor::div[@role='combobox']")
    private WebElement machineFamilyCombobox;

    @FindBy(xpath = "//ul/li//span[text()='General Purpose']")
    private WebElement generalPurposeOption;

    @FindBy(xpath = "//span[text()='Series']/ancestor::div[@role='combobox']")
    private WebElement seriesCombobox;

    @FindBy(xpath = "//ul/li//span[text()='N1']")
    private WebElement n1Option;

    @FindBy(xpath = "//span[text()='Machine type']/ancestor::div[@role='combobox']")
    private WebElement machineTypeCombobox;

    @FindBy(xpath = "//ul/li//span[text()='n1-standard-8']")
    private WebElement n1Standard8Option;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGPUsButton;

    @FindBy(xpath = "//span[text()='GPU Model']/ancestor::div[@role='combobox']")
    private WebElement gpuModelCombobox;

    @FindBy(xpath = "//ul/li//span[text()='NVIDIA V100']")
    private WebElement nvidiaV100Option;

    @FindBy(xpath = "//span[text()='Number of GPUs']/ancestor::div[@role='combobox']")
    private WebElement numberOfGPUsCombobox;

    @FindBy(xpath = "//ul/li//span[text()='1']")
    private WebElement oneGpuOption;

    @FindBy(xpath = "//span[text()='Local SSD']/ancestor::div[@role='combobox']")
    private WebElement localSSDsCombobox;

    @FindBy(xpath = "//ul/li//span[text()='2x375 GB']")
    private WebElement Two375GBOption;

    @FindBy(xpath = "//span[text()='Region']/ancestor::div[@role='combobox']")
    private WebElement regionCombobox;

    @FindBy(xpath = "//ul/li//span[text()='Netherlands (europe-west4)']")
    private WebElement netherlandsRegionOption;

    @FindBy(xpath = "//label[@for='1-year']")
    private WebElement oneYearDiscountOptionsButton;

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    protected GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public GoogleCloudCalculatorPage openPage() {
        driver.get(GOOGLE_CLOUD_CALCULATOR_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
}
