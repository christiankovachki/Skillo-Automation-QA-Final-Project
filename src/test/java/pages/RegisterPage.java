package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    private final String REGISTER_URL = BASE_URL + "/users/register";

    @FindBy(css = ".login-container form")
    private WebElement registerForm;

    @FindBy(css = "input[name='username']")
    private WebElement usernameField;

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(id = "defaultRegisterFormPassword")
    private WebElement passwordField;

    @FindBy(id = "defaultRegisterPhonePassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(css = ".input-filed:nth-child(2) > .invalid-feedback")
    private WebElement usernameFieldFeedbackMessage;

    @FindBy(css = ".input-filed:nth-child(3) > .invalid-feedback")
    private WebElement emailFieldFeedbackMessage;

    @FindBy(css = ".input-filed:nth-child(4) > .invalid-feedback")
    private WebElement passwordFieldFeedbackMessage;

    @FindBy(css = ".input-filed:nth-child(5) > .invalid-feedback")
    private WebElement confirmPasswordFieldFeedbackMessage;

    @FindBy(css = ".toast-message")
    private WebElement registerToastMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyForCorrectUrl() {
        waitUrlToBe(REGISTER_URL);
    }

    public void verifyRegisterFormIsVisible() {
        waitForVisibilityOfElement(registerForm);
    }

    public void populateUsernameField(String username) {
        typeInField(usernameField, username);
    }

    public void populateEmailField(String email) {
        typeInField(emailField, email);
    }

    public void populatePasswordField(String password) {
        typeInField(passwordField, password);
    }

    public void populateConfirmPasswordField(String confirmPassword) {
        typeInField(confirmPasswordField, confirmPassword);
    }

    public HomePage clickSignInButton() {
        clickOnElement(signInButton);
        return new HomePage(driver);
    }

    public boolean isUsernameFieldValidSignDisplayed() {
        return isValidSignDisplayed(usernameField);
    }

    public boolean isEmailFieldValidSignDisplayed() {
        return isValidSignDisplayed(emailField);
    }

    public boolean isPasswordFieldValidSignDisplayed() {
        return isValidSignDisplayed(passwordField);
    }

    public boolean isConfirmPasswordFieldValidSignDisplayed() {
        return isValidSignDisplayed(confirmPasswordField);
    }

    public boolean isUsernameFieldInvalidSignDisplayed() {
        return isInvalidSignDisplayed(usernameField);
    }

    public boolean isEmailFieldInvalidSignDisplayed() {
        return isInvalidSignDisplayed(emailField);
    }

    public boolean isPasswordFieldInvalidSignDisplayed() {
        return isInvalidSignDisplayed(passwordField);
    }

    public boolean isConfirmPasswordFieldInvalidSignDisplayed() {
        return isInvalidSignDisplayed(confirmPasswordField);
    }

    public String getUsernameFieldFeedbackMessage() {
        return usernameFieldFeedbackMessage.getText();
    }

    public String getEmailFieldFeedbackMessage() {
        return emailFieldFeedbackMessage.getText();
    }

    public String getPasswordFieldFeedbackMessage() {
        return passwordFieldFeedbackMessage.getText();
    }

    public String getConfirmPasswordFieldFeedbackMessage() {
        return confirmPasswordFieldFeedbackMessage.getText();
    }

    public String getToastMessage() {
        return getToastMessage(registerToastMessage);
    }

    private boolean isValidSignDisplayed(WebElement webElement) {
        waitForVisibilityOfElement(webElement);
        return webElement.getAttribute("class").contains("is-valid");
    }

    private boolean isInvalidSignDisplayed(WebElement webElement) {
        waitForVisibilityOfElement(webElement);
        return webElement.getAttribute("class").contains("is-invalid");
    }
}