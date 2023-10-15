package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final String BASE_URL = "http://training.skillo-bg.com:4200";
    protected WebDriver driver;
    private WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected void clickOnElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    protected void typeInField(WebElement webElement, String input) {
        waitForVisibilityOfElement(webElement);
        webElement.sendKeys(input);
    }

    protected void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    protected String getToastMessage(WebElement webElement) {
        waitForVisibilityOfElement(webElement);
        return webElement.getText();
    }
}