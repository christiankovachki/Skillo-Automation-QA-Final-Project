package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewPostPage;

public class NewPostTests extends BaseTest {

    @DataProvider(name = "dataForOverLongCaptionTest")
    public Object[][] dataForOverLongCaptionTest() {
        return new Object[][]{
                {"proba123", "123123Az", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ma"}
        };
    }

    @Test(dataProvider = "dataForOverLongCaptionTest")
    public void uploadAnImageWithCaptionOverHundredCharacters(String username, String password, String caption) {
        navigateToNewPostPage(username, password);

        System.out.println("6. Verify that the Upload Form is visible");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.verifyUploadFormIsVisible();

        System.out.println("7. Upload a picture");
        newPostPage.uploadNormalSizedFile();

        System.out.println("8. Verify that the image is visible");
        newPostPage.verifyImageIsVisible();

        System.out.println("9. Verify that the image name is correct");
        Assert.assertEquals(newPostPage.getUploadedImageName(), newPostPage.getNormalSizedFileName(), "The names do not match!");

        System.out.println("10. Populate the Post Caption field with a text over 100 characters");
        newPostPage.typeInCaptionField(caption);

        System.out.println("11. Click Submit button");
        newPostPage.clickSubmitButton();

        System.out.println("12. Verify that the toast message is as expected");
        Assert.assertEquals(newPostPage.getToastMessage(), "Creation of post failed!", "The toast message is not correct!");

        System.out.println("13. Verify that the URL hasn't changed");
        newPostPage.verifyForCorrectUrl();
    }
    @DataProvider(name = "dataForOverSizedImageTest")
    public Object[][] dataForOverSizedImageTest() {
        return new Object[][]{
                {"proba123", "123123Az", "Some random picture which is over 10MB"}
        };
    }

    @Test(dataProvider = "validCredentials")
    public void uploadAnImageOverTheSizeLimit(String username, String password, String caption) {
        navigateToNewPostPage(username, password);

        System.out.println("6. Verify that the Upload Form is visible");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.verifyUploadFormIsVisible();

        System.out.println("7. Upload a picture which is over 10 MB");
        newPostPage.uploadOverSizedFile();

        System.out.println("8. Verify that the image is visible");
        newPostPage.verifyImageIsVisible();

        System.out.println("9. Verify that the image name is correct");
        Assert.assertEquals(newPostPage.getUploadedImageName(), newPostPage.getOverSizedFileName(), "The names do not match!");

        System.out.println("10. Populate the Post Caption field");
        newPostPage.typeInCaptionField(caption);

        System.out.println("11. Click Submit button");
        newPostPage.clickSubmitButton();

        System.out.println("12. Verify that the toast message is as expected");
        Assert.assertEquals(newPostPage.getToastMessage(), "Creation of post failed!", "The toast message is not correct!");

        System.out.println("13. Verify that the URL hasn't changed");
        newPostPage.verifyForCorrectUrl();
    }

    private void navigateToNewPostPage(String username, String password) {
        System.out.println("1. Go to homepage");
        homePage.navigateToHomePage();

        System.out.println("2. Click Login link");
        headerPage.clickLoginLink();

        System.out.println("3. Verify that the Login Form is visible");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginFormIsVisible();

        System.out.println("4. Populate Username and Password fields with valid credentials and click Sign in button");
        loginPage.loginSteps(username, password);

        System.out.println("5. Click New Post link");
        headerPage.clickNewPostLink();
    }
}