package ta.training.test.task3;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ta.training.page_object_model.page.task3.GoogleCloudCalculatorPage;
import ta.training.page_object_model.page.task3.GoogleCloudCalculatorPreviewPage;
import ta.training.page_object_model.page.task3.GoogleCloudHomePage;
import ta.training.page_object_model.page.task3.GoogleCloudSearchResultsPage;

import java.time.Duration;
import java.util.*;

import static ta.training.constants.Constants.*;

public class GoogleCloudEstimateCalculationTest {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        //this thread sleep is added so the reviewer can see if the values are filled correctly before the driver gets closed
        Thread.sleep(5000);
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "formData")
    public static Object[][] getData() {
        Map<String, String> formDataMap = new HashMap<>();
        formDataMap.put(NUMBER_OF_INSTANCES, "4");
        formDataMap.put(OPERATING_SYSTEM_SOFTWARE, "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
        formDataMap.put(PROVISIONING_MODEL, "Regular");
        formDataMap.put(MACHINE_FAMILY, "General Purpose");
        formDataMap.put(SERIES, "N1");
        formDataMap.put(MACHINE_TYPE, "n1-standard-8");
        formDataMap.put(GPU_MODEL, "NVIDIA V100");
        formDataMap.put(NUMBER_OF_GPUS, "1");
        formDataMap.put(LOCAL_SSD, "2x375 GB");
        formDataMap.put(REGION, "Netherlands (europe-west4)");
        formDataMap.put(COMMITTED_USE_DISCOUNT_OPTIONS, "1 year");
        formDataMap.put(TOTAL_ESTIMATED_COST, "5,628.90");
        return new Object[][]{{formDataMap}};
    }

    @Test(description = "Fill the google cloud calculator form and validate filled information against preview", dataProvider = "formData")
    public void createAPasteAndValidateFormattingAndContent(Map<String, String> formDataMap){

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        googleCloudHomePage.searchText("Google Cloud Platform Pricing Calculator");

        GoogleCloudSearchResultsPage googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        googleCloudSearchResultsPage.clickOnSearchResult("Google Cloud Pricing Calculator");


        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        googleCloudCalculatorPage.clickOnAddToEstimateAndSelectComputeEngine();
        googleCloudCalculatorPage.fillAndSubmitEstimateForm(formDataMap.get(NUMBER_OF_INSTANCES), formDataMap.get(OPERATING_SYSTEM_SOFTWARE), formDataMap.get(PROVISIONING_MODEL)
                , formDataMap.get(MACHINE_FAMILY), formDataMap.get(SERIES), formDataMap.get(MACHINE_TYPE), formDataMap.get(GPU_MODEL), formDataMap.get(NUMBER_OF_GPUS)
                , formDataMap.get(LOCAL_SSD), formDataMap.get(REGION), formDataMap.get(COMMITTED_USE_DISCOUNT_OPTIONS),formDataMap.get(TOTAL_ESTIMATED_COST));


        GoogleCloudCalculatorPreviewPage googleCloudCalculatorPreviewPage = new GoogleCloudCalculatorPreviewPage(driver);
        googleCloudCalculatorPreviewPage.switchToNewTab();

        Assert.assertEquals("Expected Number of Instances matches estimate preview", formDataMap.get(NUMBER_OF_INSTANCES), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_INSTANCES));
        Assert.assertEquals("Expected Operating system/software value matches estimate preview", formDataMap.get(OPERATING_SYSTEM_SOFTWARE), googleCloudCalculatorPreviewPage.getSpanTextByName(OPERATING_SYSTEM_SOFTWARE));
        Assert.assertEquals("Expected Provisioning model matches estimate preview", formDataMap.get(PROVISIONING_MODEL), googleCloudCalculatorPreviewPage.getSpanTextByName(PROVISIONING_MODEL));
        Assert.assertEquals("Machine Type expected matches estimate preview", "n1-standard-8, vCPUs: 8, RAM: 30 GB", googleCloudCalculatorPreviewPage.getSpanTextByName(MACHINE_TYPE));
        Assert.assertEquals("Expected GPU model matches estimate preview", formDataMap.get(GPU_MODEL), googleCloudCalculatorPreviewPage.getSpanTextByName(GPU_MODEL));
        Assert.assertEquals("Expected Number of GPUs matches estimate preview", formDataMap.get(NUMBER_OF_GPUS), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_GPUS));
        Assert.assertEquals("Expected Local SSD matches estimate preview", formDataMap.get(LOCAL_SSD), googleCloudCalculatorPreviewPage.getSpanTextByName(LOCAL_SSD));
        Assert.assertEquals("Expected Region value matches estimate preview", formDataMap.get(REGION), googleCloudCalculatorPreviewPage.getSpanTextByName(REGION));
        Assert.assertEquals("Expected Committed use discount options matches estimate preview", formDataMap.get(COMMITTED_USE_DISCOUNT_OPTIONS), googleCloudCalculatorPreviewPage.getSpanTextByName(COMMITTED_USE_DISCOUNT_OPTIONS));
        Assert.assertTrue("Expected Total estimated cost matches estimate preview", googleCloudCalculatorPreviewPage.getTotalEstimatedCostValueText().contains(formDataMap.get(TOTAL_ESTIMATED_COST)));

    }

}
