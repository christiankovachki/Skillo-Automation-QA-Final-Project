package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ModalPage;

public class HomePageTests extends BaseTest {

    @Test
    public void likePostAsLoggedOutUserTest() {
        openLatestPost();

        ModalPage modalPage = new ModalPage(driver);

        System.out.println("4. Click the Heart Icon");
        modalPage.likePost();

        System.out.println("5. Verify that the toast message is 'You must login'");
        Assert.assertEquals(homePage.getToastMessage(), "You must login", "The toast message is not 'You must login'");

        System.out.println("6. Verify that the user is redirected to the Login Page and the Login Form is visible");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginFormIsVisible();
        loginPage.verifyForCorrectUrl();
    }

    @Test
    public void dislikePostAsLoggedOutUserTest() {
        openLatestPost();

        ModalPage modalPage = new ModalPage(driver);

        System.out.println("4. Click the Thumbs Down Icon");
        modalPage.dislikePost();

        System.out.println("5. Verify that the toast message is 'You must login'");
        Assert.assertEquals(homePage.getToastMessage(), "You must login", "The toast message is not 'You must login'");

        System.out.println("6. Verify that the user is redirected to the Login Page and the Login Form is visible");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginFormIsVisible();
        loginPage.verifyForCorrectUrl();
    }

    private void openLatestPost() {
        System.out.println("1. Go to homepage");
        homePage.navigateToHomePage();

        System.out.println("2. Open the latest post on the homepage");
        ModalPage modalPage = homePage.openLatestPost();

        System.out.println("3. Verify that the Modal is visible");
        modalPage.waitForVisibilityOfModal();
    }
}