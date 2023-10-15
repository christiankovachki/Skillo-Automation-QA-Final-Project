package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL + "/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(HOME_URL);
    }

    public void verifyForCorrectUrl() {
        waitUrlToBe(HOME_URL);
    }
}