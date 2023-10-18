package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BasePage {
    public final String PROFILE_URL = BASE_URL + "/users";

    @FindBy(css = ".gallery-item")
    private List<WebElement> listOfUsersPosts;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ModalPage openLatestPost() {
        int latestPostIndex = listOfUsersPosts.size() - 1;

        try {
            clickOnElement(listOfUsersPosts.get(latestPostIndex));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("The User does NOT have any Public Posts!");
            throw new IndexOutOfBoundsException();
        }

        return new ModalPage(driver);
    }

    public int getUsersPostsCount() {
        return listOfUsersPosts.size();
    }
}