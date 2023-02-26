package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class InsiderHomePage {

    private WebDriver driver;
    private By moreMenu = By.xpath("//*[@id='mega-menu-1']//span[text()='More']");
    private By careersLink = By.xpath("//h5[text()='Careers']");

    public InsiderHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Get title of the Insider homepage
    public String getTitle(){
        return driver.getTitle();
    }

    public CareersPage clickCareers(){
        driver.findElement(moreMenu).click();
        driver.findElement(careersLink).click();
        return new CareersPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}