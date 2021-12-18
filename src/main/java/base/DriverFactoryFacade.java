package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

@UtilityClass
//Factory class to take in input and generate driver of different browser types based on input
public class DriverFactoryFacade {
    //This demonstrates the Singleton Pattern. Each class gets it own single threaded driver
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    @SneakyThrows
    //This is method demonstrates the FACADE Design Pattern hiding the implementation complexity logic from the caller
    public WebDriver setDriver(String browserName) {
        String browser = browserName.toUpperCase();
        WebDriver webDriver;
        if (getDriver() == null) {
            switch (browser) {
                case "CHROME":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    val options = new ChromeOptions();
                    options.addArguments("--disable-cache", "--incognito ", "--ignore-certificate-errors");
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(options);
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "OPERA":
                    WebDriverManager.operadriver().setup();
                    webDriver = new OperaDriver();
                    break;
                case "EDGE":
                    webDriver = new EdgeDriver();
                    break;
                case "IEXPLORER":
                    WebDriverManager.iedriver().setup();
                    webDriver = new InternetExplorerDriver();
                    break;
                default:
                    throw new UnsupportedOperationException("Driver " + browserName + " not supported");
            }
            DriverFactoryFacade.driver.set(webDriver);

        }
        return getDriver();
    }

    public static void quitDriver() {
        getDriver().quit();
    }


}