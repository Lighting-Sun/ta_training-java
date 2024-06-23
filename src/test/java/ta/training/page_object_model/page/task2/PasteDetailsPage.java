package ta.training.page_object_model.page.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PasteDetailsPage extends BasePage {


    protected PasteDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='top-buttons']//a[contains(@class,'btn -small')]")
    public WebElement codeStyle;

    @FindBy(xpath = "//div[@class='source bash']/ol/li//div")
    public List<WebElement> textLines;

    public String getTextFromTextBox() {

        StringBuilder result = new StringBuilder();
        for (WebElement element : textLines) {
            String divText = element.getText();
            result.append(divText).append("\n");
        }
        return result.toString();
    }


    @Override
    public BasePage openPage() {
        throw new RuntimeException("This page should only be opened as a result of opening");
    }
}
