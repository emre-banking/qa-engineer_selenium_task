package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {

    private WebDriver driver;
    private By ourLocationsBlock = By.id("career-our-location");
    private By ourTeamsBlock = By.id("career-find-our-calling");
    private By lifeAtInsiderBlock = By.xpath(
            "//div[@class='elementor-widget-wrap e-swiper-container']");
    private By qualityAssuranceLink = By.xpath(
            "//h3[@class='text-center mb-4 mb-xl-5' and text()='Quality Assurance']");

    public String getTitle(){
        return driver.getTitle();
    }
    public boolean isLocationsBlockDisplayed(){
        return driver.findElement(ourLocationsBlock).isDisplayed();
    }
    public boolean isTeamsBlockDisplayed(){
        return driver.findElement(ourTeamsBlock).isDisplayed();
    }
    public boolean isLifeAtInsiderBlockDisplayed(){
        return driver.findElement(lifeAtInsiderBlock).isDisplayed();
    }
    public void clickSeeAllTeams(){
        WebElement clickAllTeamsLink = driver.findElement(By.cssSelector("a.loadmore"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickAllTeamsLink);
    }

    public QualityAssurancePage clickQualityAssurance() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(qualityAssuranceLink));
        WebElement clickQALink = driver.findElement(qualityAssuranceLink);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickQALink);
        return new QualityAssurancePage(driver);
    }
    public CareersPage(WebDriver driver){
        this.driver = driver;
    }
}
