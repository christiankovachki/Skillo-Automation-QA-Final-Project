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
                {"kovachki_111", "kovachki_111@abv.bg", "123456", "123456"}
        };
    }

    @Test(dataProvider = "dataForTestWithValidCredentials")
    public void registerWithValidCredentialsTest(String username, String email, String password, String confirmPassword) {
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

        System.out.println("13. Verify that the toast message is 'Successful register!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Successful register!", "The toast message is not 'Successful register!'");

        System.out.println("14. Verify that the URL has changed to /posts/all");
        homePage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_1")
    public Object[][] dataForTestWithInvalidCredentials_1() {
        return new Object[][]{
                {"kovachki_11_sk10", "kovachki_11_sk10#something.com", "12345", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_1")
    public void registerWithInvalidCredentialsTest_1(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with invalid email and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        Assert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "Email invalid!", "The Email field feedback message is not 'Email invalid!'");

        System.out.println("10. Populate Password field with invalid password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldInvalidSignDisplayed(), "The Password field sign is not correct!");
        Assert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "Minimum 6 characters !", "The Password field feedback message is not 'Minimum 6 characters !'");

        System.out.println("11. Populate Confirm Password field with invalid confirm password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not 'Passwords do not match!'");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_2")
    public Object[][] dataForTestWithInvalidCredentials_2() {
        return new Object[][]{
                {"k", "kovachki_11_sk10", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_2")
    public void registerWithInvalidCredentialsTest_2(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with invalid username and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");
        Assert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "Minimum 2 characters !", "The Username field feedback message is not 'Minimum 2 characters !'");

        System.out.println("9. Populate Email field with invalid email and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        Assert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "Email invalid!", "The Email field feedback message is not 'Email invalid!'");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_3")
    public Object[][] dataForTestWithInvalidCredentials_3() {
        return new Object[][]{
                {"kovachki_22", "kovachki_22_sk10@something.com", "12345secretsauce12345", "12345secretsauce12345"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_3")
    public void registerWithInvalidCredentialsTest_3(String username, String email, String password, String confirmPassword) {
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
        Assert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "Maximum 20 characters!", "The Password field feedback message is not 'Maximum 20 characters!'");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_4")
    public Object[][] dataForTestWithInvalidCredentials_4() {
        return new Object[][]{
                {"kovachki_1_sk10000001", "kovachki_33_sk10@something.com", "12345678910111213141", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_4")
    public void registerWithInvalidCredentialsTest_4(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with invalid username and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldInvalidSignDisplayed(), "The Username field sign is not correct!");
        Assert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "Maximum 20 characters!", "The Username field feedback message is not 'Maximum 20 characters!'");

        System.out.println("9. Populate Email field with valid email and verify a valid sign is displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldValidSignDisplayed(), "The Email field sign is not correct!");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with invalid confirm password and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not 'Passwords do not match!'");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_5")
    public Object[][] dataForTestWithInvalidCredentials_5() {
        return new Object[][]{
                {"proba123", "1proba13@asd.com", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_5")
    public void registerWithInvalidCredentialsTest_5(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with a username which is already taken");
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

        System.out.println("13. Verify that the toast message is 'Username taken'");
        Assert.assertEquals(registerPage.getToastMessage(), "Username taken", "The toast message is not 'Username taken'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_6")
    public Object[][] dataForTestWithInvalidCredentials_6() {
        return new Object[][]{
                {"kovachki_44", "kovachki_44_sk10@something.com", "123123", "321321"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_6")
    public void registerWithInvalidCredentialsTest_6(String username, String email, String password, String confirmPassword) {
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
        Assert.assertEquals(registerPage.getConfirmPasswordFieldFeedbackMessage(), "Passwords do not match!", "The Confirm Password field feedback message is not 'Passwords do not match!'");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_7")
    public Object[][] dataForTestWithInvalidCredentials_7() {
        return new Object[][]{
                {"kovachki_222", "email@email.com", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_7")
    public void registerWithInvalidCredentialsTest_7(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");

        System.out.println("9. Populate Email field with an email which is already taken");
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

        System.out.println("13. Verify that the toast message is 'Email taken'");
        Assert.assertEquals(registerPage.getToastMessage(), "Email taken", "The toast message is not 'Email taken'");

        System.out.println("14. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_8")
    public Object[][] dataForTestWithInvalidCredentials_8() {
        return new Object[][]{
                {"", "", "", ""}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_8")
    public void registerWithInvalidCredentialsTest_8(String username, String email, String password, String confirmPassword) {
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
        softAssert.assertEquals(registerPage.getUsernameFieldFeedbackMessage(), "This field is required!", "The Username field feedback message is not 'This field is required!'");
        softAssert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        softAssert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "This field is required!", "The Email field feedback message is not 'This field is required!'");
        softAssert.assertTrue(registerPage.isPasswordFieldInvalidSignDisplayed(), "The Password field sign is not correct!");
        softAssert.assertEquals(registerPage.getPasswordFieldFeedbackMessage(), "This field is required!", "The Password field feedback message is not 'This field is required!'");
        softAssert.assertTrue(registerPage.isConfirmPasswordFieldInvalidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("10. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("11. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

        System.out.println("12. Verify that the URL hasn't changed");
        registerPage.verifyForCorrectUrl();

        softAssert.assertAll();
    }

    @DataProvider(name = "dataForTestWithInvalidCredentials_9")
    public Object[][] dataForTestWithInvalidCredentials_9() {
        return new Object[][]{
                {"proba3214213212", "email1@email", "123123", "123123"},
                {"proba3243213313", "email2@asd.", "123123", "123123"},
                {"proba32432131213", "email2@", "123123", "123123"}
        };
    }

    @Test(dataProvider = "dataForTestWithInvalidCredentials_9")
    public void registerWithInvalidCredentialsTest_9(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver);

        navigateToRegisterPage();

        System.out.println("8. Populate Username field with valid username and verify a valid sign is displayed");
        registerPage.populateUsernameField(username);
        Assert.assertTrue(registerPage.isUsernameFieldValidSignDisplayed(), "The Username field sign is not correct!");


        System.out.println("9. Populate Email field with invalid email and verify that the invalid sign and the correct feedback message are displayed");
        registerPage.populateEmailField(email);
        Assert.assertTrue(registerPage.isEmailFieldInvalidSignDisplayed(), "The Email field sign is not correct!");
        Assert.assertEquals(registerPage.getEmailFieldFeedbackMessage(), "Email invalid!", "The Email field feedback message is not 'Email invalid!'");

        System.out.println("10. Populate Password field with valid password and verify a valid sign is displayed");
        registerPage.populatePasswordField(password);
        Assert.assertTrue(registerPage.isPasswordFieldValidSignDisplayed(), "The Password field sign is not correct!");

        System.out.println("11. Populate Confirm Password field with valid confirm password and verify a valid sign is displayed");
        registerPage.populateConfirmPasswordField(confirmPassword);
        Assert.assertTrue(registerPage.isConfirmPasswordFieldValidSignDisplayed(), "The Confirm Password field sign is not correct!");

        System.out.println("12. Click Sign In button");
        registerPage.clickSignInButton();

        System.out.println("13. Verify that the toast message is 'Registration failed!'");
        Assert.assertEquals(registerPage.getToastMessage(), "Registration failed!", "The toast message is not 'Registration failed!'");

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