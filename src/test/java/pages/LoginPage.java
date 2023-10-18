package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private final String LOGIN_URL = BASE_URL + "/users/login";

    @FindBy(css = "app-login form")
    private WebElement loginForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderPage login(String username, String password) {
        typeInField(usernameField, username);
        typeInField(passwordField, password);
        clickOnElement(signInButton);
        return new HeaderPage(driver);
    }

    public void verifyLoginFormIsVisible() {
        waitForVisibilityOfElement(loginForm);
    }

    public void verifyForCorrectUrl() {
        waitUrlToBe(LOGIN_URL);
    }

    public RegisterPage clickRegisterLink() {
        clickOnElement(registerLink);
        return new RegisterPage(driver);
    }
}