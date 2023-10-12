package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ModalPage extends BasePage {

    public ModalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}