package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ModalPage extends BasePage {

    @FindBy(className = "modal-content")
    private WebElement modal;

    @FindBy(css = ".like.fa-heart")
    private WebElement heartIcon;

    @FindBy(css = ".fa-heart.liked")
    private WebElement likedHeartIcon;

    @FindBy(xpath = "//strong[contains(.,' likes')]")
    private WebElement likesCount;

    @FindBy(css = ".fa-thumbs-down")
    private WebElement thumbsDownIcon;

    @FindBy(css = ".fa-thumbs-down.liked")
    private WebElement likedThumbsDownIcon;

    @FindBy(xpath = "//strong[contains(.,' dislikes')]")
    private WebElement dislikesCount;

    @FindBy(css = ".delete-ask")
    private WebElement deleteLink;

    @FindBy(css = "button.btn:first-child")
    private WebElement deleteConfirmButton;

    @FindBy(css = "input[placeholder='Comment here']")
    private WebElement commentField;

    @FindBy(css = ".comment-content")
    private List<WebElement> commentsList;

    @FindBy(css = ".toast-message[aria-label='Post liked']")
    private WebElement likedPostToastMessage;

    @FindBy(css = ".toast-message[aria-label='Post disliked']")
    private WebElement dislikedPostToastMessage;

    @FindBy(css = ".toast-message[aria-label='Post Deleted!']")
    private WebElement deletedPostToastMessage;

    public ModalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibilityOfModal() {
        waitForVisibilityOfElement(modal);
    }

    public void addComment(String text) {
        typeInField(commentField, text);
        commentField.sendKeys(Keys.ENTER);
    }

    public boolean isCommentPosted(String comment) {
        for (int i = 0; i < commentsList.size(); i++) {
            String currentComment = commentsList.get(i).getText();
            if (currentComment.equals(comment)) {
                return true;
            }
        }

        return false;
    }

    public void likePost() {
        clickOnElement(heartIcon);
    }

    public boolean isHeartIconLiked() {
        waitForVisibilityOfElement(likedHeartIcon);

        return heartIcon.getAttribute("class").contains(" liked");
    }

    public int getLikesCount() {
        waitForVisibilityOfElement(likesCount);

        return Integer.parseInt(String.valueOf(likesCount.getText().charAt(0)));
    }

    public void dislikePost() {
        clickOnElement(thumbsDownIcon);
    }

    public boolean isThumbsDownIconLiked() {
        waitForVisibilityOfElement(likedThumbsDownIcon);

        return likedThumbsDownIcon.getAttribute("class").contains("liked");
    }

    public int getDislikesCount() {
        waitForVisibilityOfElement(dislikesCount);

        return Integer.parseInt(String.valueOf(dislikesCount.getText().charAt(0)));
    }

    public void deletePost() {
        clickOnElement(deleteLink);
        clickOnElement(deleteConfirmButton);
    }

    public String getLikedPostToastMessage() {
        return getToastMessage(likedPostToastMessage);
    }

    public String getDislikedPostToastMessage() {
        return getToastMessage(dislikedPostToastMessage);
    }

    public String getDeletedPostToastMessage() {
        return getToastMessage(deletedPostToastMessage);
    }
}