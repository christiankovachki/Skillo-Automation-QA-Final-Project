package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL + "/posts/all";

    @FindBy(css = ".post-feed-img")
    private WebElement latestPost;

    @FindBy(css = ".toast-message")
    private WebElement loginToastMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(HOME_URL);
    }

    public void verifyForCorrectUrl() {
        waitUrlToBe(HOME_URL);
    }

    public String getToastMessage() {
        return getToastMessage(loginToastMessage);
    }

    public ModalPage openLatestPost() {
        clickOnElement(latestPost);

        return new ModalPage(driver);
    }
}