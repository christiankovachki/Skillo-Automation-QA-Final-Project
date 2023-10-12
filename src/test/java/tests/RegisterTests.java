package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {

    @Test
    public void successfulRegisterTest() {

    }

    // The data must be updated before submitting!
    @DataProvider(name = "dataForNegativeRegisterTest_7")
    public Object[][] dataForNegativeRegisterTest_7() {
        return new Object[][]{
                {"randomuser_sk10_2", "randomuser_sk10_2@", "secretsauce", "secretsauce"}
        };
    }

    // Registration Test with VALID Username, Password, Confirm Password and INVALID Email
    @Test(dataProvider = "dataForNegativeRegisterTest_7")
    public void negativeRegisterTest_7(String username, String email, String password, String confirmPassword) {
        navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with invalid email and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        Assert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "Email invalid!", "The Email field feedback message is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not the one which is expected!");
        // The test fails on line 52 because the system allows registration with an invalid email even though the email field displays invalid sign

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    private void navigateToRegisterPage() {
        System.out.println("1. Go to homepage");
        homePage.navigateToHomePage();

        System.out.println("2. Click Login link");
        LoginPage loginPage = headerPage.clickLoginLink();

        System.out.println("3. Verify that the URL has changed to /login");
        loginPage.verifyForCorrectUrl();

        System.out.println("4. Verify that the Login Form is visible");
        loginPage.verifyLoginFormIsVisible();

        System.out.println("5. Click Register link");
        RegisterPage registerPage = loginPage.clickRegisterLink();

        System.out.println("6. Verify that the URL has changed to /register");
        registerPage.verifyForCorrectUrl();

        System.out.println("7. Verify that the Register Form is visible");
        registerPage.verifyRegisterFormIsVisible();
    }
}