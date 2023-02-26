package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OpenPositionsPage {

    private WebDriver driver;
    private By dropdownLocator = By.id("select2-filter-by-location-container");
    private By optionLocator = By.xpath(
            "//li[contains(text(),'Istanbul')]");
    //private By jobsList = By.id("jobs-list");
    private By positionLocator = By.xpath(
            "//*[@class='position-title font-weight-bold']");
    private By departmentLocator = By.xpath(
            "//*[@class='position-department text-large font-weight-600 text-primary']");
    private By locationLocator = By.xpath(
            "//*[@class='position-location text-large']");
    private By applyNowButton = By.xpath(
            "//*[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5']");

    public void selectFromDropDown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        driver.findElement(dropdownLocator).click();
        waitForASpecificDuration(500);
        WebElement option = driver.findElement(optionLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", option);
        waitForASpecificDuration(500);
        Actions actions = new Actions(driver);
        //actions.moveToElement(option);
        actions.click(option).build().perform();
        waitForASpecificDuration(1000);
    }
    public boolean isTitleContain() {
        //WebElement option = driver.findElement(positionLocator);
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", option);
        waitForASpecificDuration(1000);
        List<WebElement> jobPostings = driver.findElements(positionLocator);
        boolean allPositionsContainQA = true;
        for (WebElement jobPosting : jobPostings) {
            // Check if Position contains "Quality Assurance"
            String positionText = jobPosting.getText();
            if (!positionText.contains("Quality Assurance")) {
                // Position doesn't contain "Quality Assurance"
                allPositionsContainQA = false;
                break;
            }
        }
        return allPositionsContainQA;
    }
    public boolean isDepartmentContain() {
        waitForASpecificDuration(1000);
        List<WebElement> jobPostings = driver.findElements(departmentLocator);
        boolean allPositionsContainQA = true;
        for (WebElement jobPosting : jobPostings) {
            // Check if department contains "Quality Assurance"
            String positionText = jobPosting.getText();
            if (!positionText.contains("Quality Assurance")) {
                // Department doesn't contain "Quality Assurance"
                allPositionsContainQA = false;
                break;
            }
        }
        return allPositionsContainQA;
    }
    public boolean isLocationContain() {
        waitForASpecificDuration(1000);
        List<WebElement> jobPostings = driver.findElements(locationLocator);
        boolean allPositionsContainQA = true;
        for (WebElement jobPosting : jobPostings) {
            // Check if department contains "Quality Assurance"
            String positionText = jobPosting.getText();
            if (!positionText.contains("Istanbul, Turkey")) {
                // Department doesn't contain "Quality Assurance"
                allPositionsContainQA = false;
                break;
            }
        }
        return allPositionsContainQA;
    }
    public void hoverOverApplylNowButton(int index) {
        WebElement title = (WebElement) driver.findElements(positionLocator).get(index - 1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        waitForASpecificDuration(1000);
        actions.sendKeys(Keys.ARROW_DOWN);
        waitForASpecificDuration(1000);
        actions.sendKeys(Keys.ARROW_DOWN);
        waitForASpecificDuration(1000);
        actions.sendKeys(Keys.ARROW_DOWN);
        waitForASpecificDuration(1000);
        actions.moveToElement(title).perform();
    }
    public void clickApplyNowButton(int index){
        WebElement button = (WebElement) driver.findElements(applyNowButton).get(index - 1);
        Actions actions = new Actions(driver);
        actions.click(button).build().perform();
        waitForASpecificDuration(3000);
    }
    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        for(String window : windows){
            driver.switchTo().window(window);

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }
    public String getTitle(){
        return driver.getTitle();
    }

    public OpenPositionsPage(WebDriver driver){
        this.driver=driver;
    }
    public void waitForASpecificDuration(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
