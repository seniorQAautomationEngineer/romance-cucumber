package pages;

import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;




    public HomePage(WebDriver driver) {
        this.driver=driver;
    }




    public boolean homepageAnyMainTabTextAreDisplayed(String name) {
        return driver.findElement(setAnyTabName(name)).isDisplayed() ;
    }

    public By setAnyTabName(String text){
        return By.xpath("//li[@class='nav-item']//a[text() = '" + text + "']");
    }


      public WebElement setAnyElementWithText(String text){
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

    public boolean homepageJoinFreeButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BUTTON_JOIN_FREE));
        return driver.findElement(Locators.BUTTON_JOIN_FREE).isDisplayed();
    }


    public void clickJoinFreeButton(){
        driver.findElement(Locators.BUTTON_JOIN_FREE).click();
    }

}
