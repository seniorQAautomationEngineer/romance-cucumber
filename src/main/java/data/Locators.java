package data;

import org.openqa.selenium.By;

public class Locators {


    public static final By BUTTON_JOIN_FREE = By.cssSelector("button#show-registration-block");
    public static  final By TEXT_FIELD_EMAIL_REGISTRATION = By.cssSelector("input#email");
    public static  final By TEXT_FIELD_PASSWORD_REGISTRATION = By.cssSelector("input#password");
    public static  final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static  final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static  final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static  final By LIST_DAYS = By.cssSelector("#daySelect");
    public static  final By LIST_MONTHS = By.cssSelector("#monthSelect");
    public static  final By LIST_YEARS = By.cssSelector("#yearSelect");
    public static  final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static  final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static  final By LIST_VALUE_YEAR =By.xpath("//li[@data-handler='selectYear']");
    public static  final By CHECKBOX_CONFIRMATION =By.cssSelector("input#confirmation");
    public static  final By AUTOFILLING_FORM_LOCATION =By.xpath("//input[@name='region_name']");
    public static  final By LIST_VALUE_LOCATION =By.xpath("//div[@class='dropdown dropdown_location']//ul//li");

}
