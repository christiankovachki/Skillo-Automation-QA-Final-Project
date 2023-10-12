package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginLink() {
        clickOnElement(loginLink);
        return new LoginPage(driver);
    }

    public NewPostPage clickNewPostLink() {
        clickOnElement(newPostLink);
        return new NewPostPage(driver);
    }

    public ProfilePage clickProfileLink() {
        clickOnElement(profileLink);
        return new ProfilePage(driver);
    }
}