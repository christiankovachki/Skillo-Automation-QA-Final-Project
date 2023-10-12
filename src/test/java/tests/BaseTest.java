package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HeaderPage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseTest {
    private SimpleDateFormat simpleDateFormat;
    private Timestamp timestamp;
    private static final String SCREENSHOT_DIR = "src\\test\\java\\resources\\screenshots\\";
    protected WebDriver driver;
    protected HomePage homePage;
    protected HeaderPage headerPage;

    @BeforeMethod
    public void setUp() {
        cleanDirectory(SCREENSHOT_DIR);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        headerPage = new HeaderPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        takeScreenshot(testResult);
        //driver.close();
    }

    private void takeScreenshot(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName().concat(getCurrentTime());
            //String testName = testResult.getMethod().getMethodName().concat(getCurrentTime());
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOT_DIR.concat(testName).concat(".jpeg")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void cleanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        try {
            FileUtils.cleanDirectory(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCurrentTime() {
        simpleDateFormat = new SimpleDateFormat("'_'dd-MM-yyyy'_'HH.mm");
        timestamp = new Timestamp(System.currentTimeMillis());

        return simpleDateFormat.format(timestamp);
    }
}