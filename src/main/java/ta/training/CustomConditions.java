package ta.training;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return new ExpectedCondition<Boolean>() {

            //this method executes a script to check that there are no more things loading in page
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active == = 0);");
            }
        };
    }
}
