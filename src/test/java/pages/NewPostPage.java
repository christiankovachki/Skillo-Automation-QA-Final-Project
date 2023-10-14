package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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

    @FindBy(css = ".toast-message[aria-label='Creation of post failed!']")
    private WebElement toastMessage;

    private File overSizedFile = new File("src/test/java/images/Pano-bayer-leverkusen.jpg");

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUploadFormIsVisible() {
        waitForVisibilityOfElement(uploadForm);
    }

    public void uploadOverSizedFile() {
        uploadFile(overSizedFile);
    }

    public void verifyImageIsVisible() {
        waitForVisibilityOfElement(imagePreview);
    }

    public String getUploadedImageName() {
        waitForVisibilityOfElement(imageNameInfo);
        return imageNameInfo.getAttribute("placeholder");
    }

    public String getFileToUploadName() {
        return overSizedFile.getName();
    }

    public String getToastMessage() {
        waitForVisibilityOfElement(toastMessage);
        return toastMessage.getText();
    }

    public void verifyForCorrectUrl() {
        waitUrlToBe(NEW_POST_URL);
    }

    private void uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void typeInCaptionField(String text) {
        typeInField(captionField, text);
    }

    public ProfilePage clickSubmitButton() {
        clickOnElement(submitButton);
        return new ProfilePage(driver);
    }
}