package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage {

    private WebDriver driver;
    private By selectAllQAJobsButton = By.xpath("//a[text()='See all QA jobs']");

    public OpenPositionsPage clickSelectAllQAJobsButton(){
        driver.findElement(selectAllQAJobsButton).click();
        return new OpenPositionsPage(driver);
    }
    public QualityAssurancePage(WebDriver driver) {
        this.driver=driver;
    }
}
