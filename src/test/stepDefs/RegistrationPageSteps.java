package stepDefs;

import base.Configuration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.List;

public class RegistrationPageSteps extends Configuration {
    Scenario logger ;
    WebDriver driver = pageLib.getDriver();
    RegistrationPage registrationPage = pageLib.getRegistrationPage();

    @Before
    public void beforeStep(Scenario scenario) {
        this.logger = scenario;
    }



    @When("^complete first part of registration$")
    public void completeFirstPartOfRegistration() {
        try{
            logger.log("Complete first part of registration");
            registrationPage.completeFirstPartOfRegistration();
        } catch (Exception e){
            e.getStackTrace();
        }
    }


    @When("^complete second part of registration$")
    public void completeSecondPartOfRegistration(DataTable data) {
        try{
            logger.log("Complete second part of registration");
            List<List<String>> obj = data.asLists();
            for (int i = 1; i < obj.size(); i++) {
                String month = obj.get(i).get(0);
                String day = obj.get(i).get(1);
                String year = obj.get(i).get(2);
                String city = obj.get(i).get(3);
                String location = obj.get(i).get(4);
                registrationPage.completeSecondPartOfRegistration(month, day,
                        year, city, location);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }


}
