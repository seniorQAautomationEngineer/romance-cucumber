package common;

import base.DriverFactoryFacade;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegistrationPage;

@Getter
//This class is the implementation of Factory Pattern which renders the page object to the clients
//It is hiding the complexities(Singleton Driver Object and Browser type) involved in constructing the Page objects
public class PageFactory {
    private WebDriver driver ;
    private HomePage homePage;
    private  RegistrationPage registrationPage;

    public PageFactory(String browser){
        this.driver =  DriverFactoryFacade.setDriver(browser);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);


    }

}
