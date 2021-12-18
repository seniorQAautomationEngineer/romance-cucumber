package base;

import common.PageFactory;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.util.concurrent.TimeUnit;

public class Configuration {

    public ConfigReader config = new ConfigReader();
    public String url = config.getApplicationUrl();
    //Browser Type picked here and make sure to pass the browser that is available in the local machine
    public PageFactory pageLib = new PageFactory("Chrome");

    public void setDriverProperties(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

}

