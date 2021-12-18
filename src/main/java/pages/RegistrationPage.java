package pages;

import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ConfigReader config = new ConfigReader();
    static Faker faker = new Faker();



    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
    }


    public void completeFirstPartOfRegistration() {
       driver.findElement(Locators.TEXT_FIELD_EMAIL_REGISTRATION).sendKeys(randomEmail());
       driver.findElement(Locators.TEXT_FIELD_PASSWORD_REGISTRATION).sendKeys(config.getPassword());
       driver.findElement(Locators.BUTTON_NEXT).click();
    }


    public static String randomEmail() {

        return faker.internet().emailAddress();
    }

    public static String randomId() {
        return faker.idNumber().valid();
    }

    public static String randomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }



    public void completeSecondPartOfRegistration(String month, String day,
                                                 String year, String city, String location){


        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(randomId());
        driver.findElement(Locators.LIST_DAYS).click();
        clickValueOfLists(Locators.LIST_VALUE_DAY, day);
        driver.findElement(Locators.LIST_MONTHS).click();
        clickValueOfLists(Locators.LIST_VALUE_MONTH, month);
        driver.findElement(Locators.LIST_YEARS).click();
        clickValueOfLists(Locators.LIST_VALUE_YEAR, year);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(randomPhoneNumber());
        driver.findElement(Locators.CHECKBOX_CONFIRMATION).click();
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).clear();
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys(city);
        clickValueOfLists(Locators.LIST_VALUE_LOCATION, location);

    }


    public void clickValueOfLists(By locator, String text){
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i <elements.size() ; i++) {

            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText();
            System.out.println(text);
            if(value.contains(text)){
                elementOfList.click();
                break;
            }
        }
    }


    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void ajaxClick(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }


}
