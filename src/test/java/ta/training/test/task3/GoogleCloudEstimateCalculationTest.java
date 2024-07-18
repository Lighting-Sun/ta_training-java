package ta.training.test.task3;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ta.training.model.CalculatorForm;
import ta.training.page_object_model.page.task3.GoogleCloudCalculatorPage;
import ta.training.page_object_model.page.task3.GoogleCloudCalculatorPreviewPage;
import ta.training.page_object_model.page.task3.GoogleCloudHomePage;
import ta.training.page_object_model.page.task3.GoogleCloudSearchResultsPage;
import ta.training.service.FormCreator;

import static ta.training.constants.Constants.*;

public class GoogleCloudEstimateCalculationTest extends CommonConditions {

    @DataProvider(name = "formData")
    public static Object[][] getData() {
        CalculatorForm formDataMap = FormCreator.withFieldsFilled();
        return new Object[][]{{formDataMap}};
    }

    @Test(description = "Fill the google cloud calculator form and validate filled information against preview", dataProvider = "formData")
    public void calculateGoogleCloudEstimateAllTests(CalculatorForm calculatorForm) {

        GoogleCloudCalculatorPreviewPage googleCloudCalculatorPreviewPage = task3TestFlow();

        Assert.assertEquals("Expected Number of Instances matches estimate preview", calculatorForm.getNumberOfInstances(), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_INSTANCES));
        Assert.assertEquals("Expected Operating system/software value matches estimate preview", calculatorForm.getOperatingSystemSoftware(), googleCloudCalculatorPreviewPage.getSpanTextByName(OPERATING_SYSTEM_SOFTWARE));
        Assert.assertEquals("Expected Provisioning model matches estimate preview", calculatorForm.getProvisioningModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(PROVISIONING_MODEL));
        Assert.assertEquals("Machine Type expected matches estimate preview", calculatorForm.getExpectedMachineType(), googleCloudCalculatorPreviewPage.getSpanTextByName(MACHINE_TYPE));
        Assert.assertEquals("Expected GPU model matches estimate preview", calculatorForm.getGpuModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(GPU_MODEL));
        Assert.assertEquals("Expected Number of GPUs matches estimate preview", calculatorForm.getNumberOfGpus(), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_GPUS));
        Assert.assertEquals("Expected Local SSD matches estimate preview", calculatorForm.getLocalSsd(), googleCloudCalculatorPreviewPage.getSpanTextByName(LOCAL_SSD));
        Assert.assertEquals("Expected Region value matches estimate preview", calculatorForm.getRegion(), googleCloudCalculatorPreviewPage.getSpanTextByName(REGION));
        Assert.assertEquals("Expected Committed use discount options matches estimate preview", calculatorForm.getCommittedUseDiscountOptions(), googleCloudCalculatorPreviewPage.getSpanTextByName(COMMITTED_USE_DISCOUNT_OPTIONS));
        Assert.assertTrue("Expected Total estimated cost matches estimate preview", googleCloudCalculatorPreviewPage.getTotalEstimatedCostValueText().contains(calculatorForm.getTotalEstimatedCost()));
    }


    @Test(description = "Fill the google cloud calculator form and validate filled information against preview", dataProvider = "formData", groups = {"smoke"})
    public void calculateGoogleCloudEstimateSmoke(CalculatorForm calculatorForm) {

        GoogleCloudCalculatorPreviewPage googleCloudCalculatorPreviewPage = task3TestFlow();

        Assert.assertEquals("Expected Number of Instances matches estimate preview", calculatorForm.getNumberOfInstances(), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_INSTANCES));
        Assert.assertEquals("Expected Operating system/software value matches estimate preview", calculatorForm.getOperatingSystemSoftware(), googleCloudCalculatorPreviewPage.getSpanTextByName(OPERATING_SYSTEM_SOFTWARE));
        Assert.assertEquals("Expected Provisioning model matches estimate preview", calculatorForm.getProvisioningModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(PROVISIONING_MODEL));
        Assert.assertEquals("Machine Type expected matches estimate preview", calculatorForm.getExpectedMachineType(), googleCloudCalculatorPreviewPage.getSpanTextByName(MACHINE_TYPE));
        Assert.assertEquals("Expected GPU model matches estimate preview", calculatorForm.getGpuModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(GPU_MODEL));
        Assert.assertEquals("Expected Number of GPUs matches estimate preview", calculatorForm.getNumberOfGpus(), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_GPUS));
        Assert.assertEquals("Expected Local SSD matches estimate preview", calculatorForm.getLocalSsd(), googleCloudCalculatorPreviewPage.getSpanTextByName(LOCAL_SSD));
        Assert.assertEquals("Expected Region value matches estimate preview", calculatorForm.getRegion(), googleCloudCalculatorPreviewPage.getSpanTextByName(REGION));
        Assert.assertEquals("Expected Committed use discount options matches estimate preview", calculatorForm.getCommittedUseDiscountOptions(), googleCloudCalculatorPreviewPage.getSpanTextByName(COMMITTED_USE_DISCOUNT_OPTIONS));
        Assert.assertTrue("Expected Total estimated cost matches estimate preview", googleCloudCalculatorPreviewPage.getTotalEstimatedCostValueText().contains(calculatorForm.getTotalEstimatedCost()));
    }

    @Test(description = "Fill the google cloud calculator form and validate filled information against preview", dataProvider = "formData", groups = {"groupFail"})
    public void calculateGoogleCloudEstimateGroup3(CalculatorForm calculatorForm) {

        GoogleCloudCalculatorPreviewPage googleCloudCalculatorPreviewPage = task3TestFlow();

        //This following assert makes the test fail, so it can take the screen capture
        Assert.assertEquals("Expected Number of Instances matches estimate preview", "6", googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_INSTANCES));
        Assert.assertEquals("Expected Operating system/software value matches estimate preview", calculatorForm.getOperatingSystemSoftware(), googleCloudCalculatorPreviewPage.getSpanTextByName(OPERATING_SYSTEM_SOFTWARE));
        Assert.assertEquals("Expected Provisioning model matches estimate preview", calculatorForm.getProvisioningModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(PROVISIONING_MODEL));
        Assert.assertEquals("Machine Type expected matches estimate preview", calculatorForm.getExpectedMachineType(), googleCloudCalculatorPreviewPage.getSpanTextByName(MACHINE_TYPE));
        Assert.assertEquals("Expected GPU model matches estimate preview", calculatorForm.getGpuModel(), googleCloudCalculatorPreviewPage.getSpanTextByName(GPU_MODEL));
        Assert.assertEquals("Expected Number of GPUs matches estimate preview", calculatorForm.getNumberOfGpus(), googleCloudCalculatorPreviewPage.getSpanTextByName(NUMBER_OF_GPUS));
        Assert.assertEquals("Expected Local SSD matches estimate preview", calculatorForm.getLocalSsd(), googleCloudCalculatorPreviewPage.getSpanTextByName(LOCAL_SSD));
        Assert.assertEquals("Expected Region value matches estimate preview", calculatorForm.getRegion(), googleCloudCalculatorPreviewPage.getSpanTextByName(REGION));
        Assert.assertEquals("Expected Committed use discount options matches estimate preview", calculatorForm.getCommittedUseDiscountOptions(), googleCloudCalculatorPreviewPage.getSpanTextByName(COMMITTED_USE_DISCOUNT_OPTIONS));
        Assert.assertTrue("Expected Total estimated cost matches estimate preview", googleCloudCalculatorPreviewPage.getTotalEstimatedCostValueText().contains(calculatorForm.getTotalEstimatedCost()));
    }


    private GoogleCloudCalculatorPreviewPage task3TestFlow() {
        //creates a CalculatorForm object with test data
        CalculatorForm calculatorForm = FormCreator.withFieldsFilled();

        //Opens the Google Cloud Home page and search for Google Cloud Platform Pricing Calculator
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        Assert.assertTrue(googleCloudHomePage.presenceOfNewWayToCloudStartsHereH1());
        googleCloudHomePage.searchText("Google Cloud Platform Pricing Calculator");

        //Clicks Google Cloud Pricing Calculator search result on the search results page
        GoogleCloudSearchResultsPage googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        Assert.assertTrue(googleCloudSearchResultsPage.presenceOfSearchSummaryAiDiv());
        googleCloudSearchResultsPage.clickOnSearchResult("Google Cloud Pricing Calculator");

        //Fills the Google Calculator Form using the CalculatorForm object and submits it
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertTrue(googleCloudCalculatorPage.presenceOfWelcomeToGoogleCloudsPricingCalculatorH1());
        googleCloudCalculatorPage.clickOnAddToEstimateAndSelectComputeEngine();
        googleCloudCalculatorPage.fillAndSubmitEstimateForm(calculatorForm);

        //Switches to the newly opened calculator Preview Page tab
        GoogleCloudCalculatorPreviewPage googleCloudCalculatorPreviewPage = new GoogleCloudCalculatorPreviewPage(driver);
        googleCloudCalculatorPreviewPage.switchToNewTab("Estimate Summary");
        Assert.assertTrue(googleCloudCalculatorPreviewPage.presenceOfCostEstimateSummaryH4());

        return googleCloudCalculatorPreviewPage;
    }
}
