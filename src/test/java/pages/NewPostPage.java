package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage extends BasePage {
    private final String NEW_POST_URL = BASE_URL + "/posts/create";

    @FindBy(css = "app-create-post form")
    private WebElement uploadForm;

    @FindBy(css = ".image-preview")
    private WebElement imagePreview;

    @FindBy(css = ".input-group input")
    private WebElement imageNameInfo;

    @FindBy(css = "input[name='caption']")
    private WebElement captionField;

    @FindBy(id = "create-post")
    private WebElement submitButton;

    @FindBy(css = "input[type='file']")
    private WebElement fileInput;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeInCaptionField(String text) {
        typeInField(captionField, text);
    }

    public ProfilePage clickSubmitButton() {
        clickOnElement(submitButton);
        return new ProfilePage(driver);
    }
}