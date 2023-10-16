package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {
    RegisterPage registerPage;
    SoftAssert softAssert;

    @DataProvider(name = "dataForTestWithValidCredentials")
    public Object[][] dataForTestWithValidCredentials() {
        return new Object[][]{
                {"aide3", "aide3@abv.bg", "123456", "123456"}
        };
    }

    @Test(dataProvider = "dataForTestWithValidCredentials")
    public void registerTestWithValidCredentials(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Successful register!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL has changed to /posts/all");
        homePage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_1")
    public Object[][] dataForTestWithInvalidCredentials_1() {
        return new Object[][]{
                {"randomuser1_sk10", "randomuser_sk10#something.com", "12345", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_1")
    public void registerTestWithInvalidCredentials_1(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with invalid email and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        Assert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "Email invalid!", "The Email field feedback message is not correct!");

        System.out.println("10. Populate Password field with invalid password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldInvalidSignDisplayed(), "The Password field sign is not correct!");
        Assert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "Minimum 6 characters !", "The Password field feedback message is not correct!");

        System.out.println("11. Populate Confirm Password field with invalid confirm password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_2")
    public Object[][] dataForTestWithInvalidCredentials_2() {
        return new Object[][]{
                {"r", "randomuser_sk10", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_2")
    public void registerTestWithInvalidCredentials_2(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with invalid username and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");
        Assert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "Minimum 2 characters !", "The Username field feedback message is not correct!");

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
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_3")
    public Object[][] dataForTestWithInvalidCredentials_3() {
        return new Object[][]{
                {"randomuser_sk10", "randomuser_sk10@something.com", "12345secretsauce12345", "12345secretsauce12345"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_3")
    public void negativeRegisterTest_3(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with invalid password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldInvalidSignDisplayed(), "The Password field sign is not correct!");
        Assert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "Maximum 20 characters!", "The Password field feedback message is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_4")
    public Object[][] dataForTestWithInvalidCredentials_4() {
        return new Object[][]{
                {"randomuser_sk10000000", "randomuser_sk10@something.com", "12345678910111213141", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_4")
    public void registerTestWithInvalidCredentials_4(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with invalid username and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");
        Assert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "Maximum 20 characters!", "The Username field feedback message is not correct!");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with invalid confirm password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_5")
    public Object[][] dataForTestWithInvalidCredentials_5() {
        return new Object[][]{
                {"proba123", "proba123@asd.com", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_5")
    public void registerTestWithInvalidCredentials_5(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);
        softAssert = new SoftAssert();

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with a username which is already taken");
        registerPage.populateUsernameField(username);
        softAssert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Username taken", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();

        softAssert.assertAll();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_6")
    public Object[][] dataForTestWithInvalidCredentials_6() {
        return new Object[][]{
                {"randomuser_sk10", "randomuser_sk10@something.com", "123123", "321321"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_6")
    public void registerTestWithInvalidCredentials_6(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with invalid confirm password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_7")
    public Object[][] dataForTestWithInvalidCredentials_7() {
        return new Object[][]{
                {"proba3213214", "email@email.com", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_7")
    public void registerTestWithInvalidCredentials_7(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);
        softAssert = new SoftAssert();

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with a email which is already taken");
        registerPage.populateEmailField(email);
        softAssert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Email taken", "The toast message is not correct!");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();

        softAssert.assertAll();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_8")
    public Object[][] dataForTestWithInvalidCredentials_8() {
        return new Object[][]{
                {"", "", "", ""}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_8")
    public void registerTestWithInvalidCredentials_8(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);
        softAssert = new SoftAssert();

        navigateToRegisterPage();

        System.out.println("8. Leave Username, Email, Password and Confirm Password fields blank");
        registerPage.populateUsernameField(username);
        registerPage.populateEmailField(email);
        registerPage.populatePasswordField(password);
        registerPage.populateConfirmPasswordField(confirmPassword);
        registerPage.populateUsernameField(username);

        System.out.println("9. Verify that the invalid signs and the correct feedback messages are displayed");
        softAssert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");
        softAssert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "This field is required!", "The Username field feedback message is not correct!");
        softAssert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        softAssert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "This field is required!", "The Email field feedback message is not correct!");
        softAssert.assertTrue(registerPage.isPasswordFieldInvalidSignDisplayed(), "The Password field sign is not correct!");
        softAssert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "This field is required!", "The Password field feedback message is not correct!");
        softAssert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("10. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("11. Verify that the toast message is as expected");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

        System.out.println("12. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();

        softAssert.assertAll();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_10")
    public Object[][] dataForTestWithInvalidCredentials_10() {
        return new Object[][]{
                {"proba3213211", "email1@email", "123123", "123123"}, // фейлва, защото показва валиден знак за невалиден имейл
                {"proba32132131", "email1@asd.", "123123", "123123"}, // фейлва, защото ме регистрира с невалиден имейл
                {"proba3213213121", "email1@", "123123", "123123"}  // фейлва, защото ме регистрира с невалиден имейл
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_10")
    public void registerTestWithInvalidCredentials_10(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

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
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not correct!");

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