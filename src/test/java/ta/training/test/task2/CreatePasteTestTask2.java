package ta.training.test.task2;

import org.junit.Assert;

import org.junit.runners.Parameterized;
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
    public void tearDown() {
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
    public void createAPasteAndValidateFormattingAndContent(String expectedPasteContent) {

        PasteBinHomePageTask2 pasteBinHomePageTask2 = new PasteBinHomePageTask2(driver);
        pasteBinHomePageTask2.openPage();
        pasteBinHomePageTask2.fillPasteContent(expectedPasteContent);
        pasteBinHomePageTask2.selectSyntaxFormat(pasteBinHomePageTask2.bashFormatOption);
        pasteBinHomePageTask2.selectPasteExpiration(pasteBinHomePageTask2.tenMinutesExpirationOption);
        pasteBinHomePageTask2.fillPasteName("how to gain dominance among developers");
        PasteDetailsPage pasteDetailsPage = pasteBinHomePageTask2.clickOnCreatePaste();

        Assert.assertTrue("Page title matches paste name", driver.getTitle().contains(pasteBinHomePageTask2.pasteName));
        Assert.assertEquals("paste content matches", expectedPasteContent, pasteDetailsPage.getTextFromTextBox());
        Assert.assertEquals("Code style is Bash", "Bash", pasteDetailsPage.codeStyle.getText());


    }
}
