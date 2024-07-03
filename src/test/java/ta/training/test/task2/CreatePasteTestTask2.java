package ta.training.test.task2;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import ta.training.page_object_model.page.task2.PasteBinHomePageTask2;
import ta.training.page_object_model.page.task2.PasteDetailsPage;

import java.time.Duration;

public class CreatePasteTestTask2 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        //this thread sleep is added so the reviewer can see if the values are filled correctly before the driver gets closed
        Thread.sleep(5000);
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "pasteContents")
    private static Object[][] pasteContent() {
        return new Object[][]{{
                ("            git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force"),
        }
        };
    }

    @Test(description = "Create a paste and validate the paste format and content",dataProvider = "pasteContents")
    public void createAPasteAndValidateFormattingAndContent(String expectedPasteContent) throws InterruptedException {

        String expectedPasteName = "how to gain dominance among developers";
        String textFormat = "Bash";

        PasteBinHomePageTask2 pasteBinHomePageTask2 = new PasteBinHomePageTask2(driver);
        pasteBinHomePageTask2.openPage();
        pasteBinHomePageTask2.fillPasteContent(expectedPasteContent);
        pasteBinHomePageTask2.clickSpecificFormatOption(textFormat);
        pasteBinHomePageTask2.selectPasteExpiration("10 Minutes");
        pasteBinHomePageTask2.fillPasteName(expectedPasteName);
        //Added this thead sleep so the reviewer can see if the values are filled correctly before passing to the next page
        Thread.sleep(5000);
        pasteBinHomePageTask2.clickOnCreatePaste();

        PasteDetailsPage pasteDetailsPage = new PasteDetailsPage(driver);

        Assert.assertTrue("Page title matches paste name", driver.getTitle().contains(expectedPasteName));
        Assert.assertEquals("paste content matches", expectedPasteContent, pasteDetailsPage.getTextFromTextBox());
        Assert.assertTrue("Code style is Bash", pasteDetailsPage.checkTextFormatMatches(textFormat));


    }
}
