package ta.training.test.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ta.training.page_object_model.page.task1.PasteBinHomePageTask1;

import java.time.Duration;

public class CreatePasteTestTask1 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        //this thread sleep is added so the reviewer can see if the values are filled correctly
        Thread.sleep(5000);
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test(description = "Create a new paste with duration of 10 Minutes")
    public void create10MinuteDurationPaste() throws InterruptedException {

        PasteBinHomePageTask1 pasteBinHomePageTask1 = new PasteBinHomePageTask1(driver);

        pasteBinHomePageTask1.openPage();
        pasteBinHomePageTask1.fillPasteContent("Hello from WebDriver");
        pasteBinHomePageTask1.selectPasteExpiration();
        pasteBinHomePageTask1.fillPasteName("helloweb");
        //this thread sleep is added so the reviewer can see if the values are filled correctly before continuing to the next page
        Thread.sleep(5000);
        pasteBinHomePageTask1.clickOnCreatePaste();
    }
}
