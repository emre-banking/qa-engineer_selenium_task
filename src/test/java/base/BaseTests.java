package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.InsiderHomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected InsiderHomePage homePage;
    private File screenshot;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://useinsider.com/");
        driver.manage().window().maximize();
        homePage = new InsiderHomePage(driver);
        driver.findElement(By.id("wt-cli-accept-all-btn")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            Files.move(screenshot, new File("resources/screenshots/test.png"));

            try{
                Files.move(screenshot, new File("resources/screenshots/test.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
