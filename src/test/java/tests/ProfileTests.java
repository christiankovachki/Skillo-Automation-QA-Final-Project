package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ModalPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {
    private ProfilePage profilePage;

    @DataProvider(name = "credentialsInfo")
    private Object[][] credentialsInfo() {
        return new Object[][]{
                {"proba123", "123123Az"}
        };
    }

    @Test(dataProvider = "credentialsInfo")
    public void likePostAsLoggedInUserTest(String username, String password) {
        profilePage = new ProfilePage(driver);

        navigateToProfilePage(username, password);

        System.out.println("6. Open the latest post on the profile");
        ModalPage modalPage = profilePage.openLatestPost();

        System.out.println("7. Verify that the Modal is visible");
        modalPage.waitForVisibilityOfModal();

        System.out.println("8. Get the initial count of likes");
        int initialLikesCount = modalPage.getLikesCount();

        System.out.println("8. Click the Heart Icon");
        modalPage.likePost();

        System.out.println("9. Verify that the Heart Icon is liked and the likes count has increased by 1");
        Assert.assertTrue(modalPage.isHeartIconLiked());
        Assert.assertEquals(modalPage.getLikesCount(), initialLikesCount + 1);

        System.out.println("10. Verify that the toast message is as expected");
        Assert.assertEquals(modalPage.getLikedPostToastMessage(), "Post liked");
    }

    @Test(dataProvider = "credentialsInfo")
    public void dislikePostAsLoggedInUserTest(String username, String password) {
        profilePage = new ProfilePage(driver);

        navigateToProfilePage(username, password);

        System.out.println("6. Open the latest post on the profile");
        ModalPage modalPage = profilePage.openLatestPost();

        System.out.println("7. Verify that the Modal is visible");
        modalPage.waitForVisibilityOfModal();

        System.out.println("8. Get the initial count of dislikes");
        int initialDislikesCount = modalPage.getDislikesCount();

        System.out.println("8. Click the Thumbs Down Icon");
        modalPage.dislikePost();

        System.out.println("9. Verify that the Thumbs Down Icon is liked and the dislikes count has increased by 1");
        Assert.assertTrue(modalPage.isThumbsDownIconLiked());
        Assert.assertEquals(modalPage.getDislikesCount(), initialDislikesCount + 1);

        System.out.println("10. Verify that the toast message is as expected");
        Assert.assertEquals(modalPage.getDislikedPostToastMessage(), "Post disliked");
    }

    @DataProvider(name = "dataForWriteCommentTest")
    private Object[][] dataForWriteCommentTest() {
        return new Object[][]{
                {"proba123", "123123Az", "Some random comment"}
        };
    }

    @Test(dataProvider = "dataForWriteCommentTest")
    public void writeCommentTest(String username, String password, String comment) {
        profilePage = new ProfilePage(driver);

        navigateToProfilePage(username, password);

        System.out.println("6. Open the latest post on the profile");
        ModalPage modalPage = profilePage.openLatestPost();

        System.out.println("7. Verify that the Modal is visible");
        modalPage.waitForVisibilityOfModal();

        System.out.println("8. Write a comment on the post");
        modalPage.addComment(comment);

        System.out.println("9. Verify that the comment is posted");
        Assert.assertTrue(modalPage.isCommentPosted(comment));
    }

    @Test(dataProvider = "credentialsInfo")
    public void deleteLatestPostTest(String username, String password) {
        profilePage = new ProfilePage(driver);

        navigateToProfilePage(username, password);

        System.out.println("6. Get the initial count of Public Posts");
        int initialPostsCount = profilePage.getUsersPostsCount();

        System.out.println("7. Open the latest post on the profile");
        ModalPage modalPage = profilePage.openLatestPost();

        System.out.println("8. Verify that the Modal is visible");
        modalPage.waitForVisibilityOfModal();

        System.out.println("9. Click on Delete Post link and then confirm the deletion of the post");
        modalPage.deletePost();

        System.out.println("10. Verify that the toast message is as expected");
        Assert.assertEquals(modalPage.getDeletedPostToastMessage(), "Post Deleted!", "The toast message is not correct!");

        System.out.println("11. Verify that the Public Posts count has decreased by 1");
        int afterDeletionPostsCount = profilePage.getUsersPostsCount();
        Assert.assertEquals(afterDeletionPostsCount, initialPostsCount - 1);
    }

    private void navigateToProfilePage(String username, String password) {
        System.out.println("1. Go to homepage");
        homePage.navigateToHomePage();

        System.out.println("2. Click Login link");
        headerPage.clickLoginLink();

        System.out.println("3. Verify that the Login Form is visible");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginFormIsVisible();

        System.out.println("4. Populate Username and Password fields with valid credentials and click Sign in button");
        loginPage.loginSteps(username, password);

        System.out.println("5. Click Profile link");
        headerPage.clickProfileLink();
    }
}