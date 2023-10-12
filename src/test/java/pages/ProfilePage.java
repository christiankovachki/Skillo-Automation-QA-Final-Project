package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    public final String PROFILE_URL = "http://training.skillo-bg.com:4200/users/";
    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}