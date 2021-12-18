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

import java.util.List;

public class HomePageSteps extends Configuration {
    Scenario logger ;
    WebDriver driver = pageLib.getDriver();
    HomePage homePage = pageLib.getHomePage();

    @Before
    public void beforeStep(Scenario scenario) {
        this.logger = scenario;
    }

    @Given("user hits the application url")
    public void user_is_on_the_homepage_by_hitting_the_url() {
        logger.log("Testing Home Page");
        setDriverProperties(driver);
        logger.log("Url hit successful");
    }

    @Then("^validate title \"([^\"]*)\" and that user is navigated to the HomePage$")
    public void user_is_navigated_to_the_home_page(String title) {
        try{
            logger.log("On the Home Page Validating Title:  " + title);
            Assert.assertEquals(driver.getTitle(), title);
        } catch (Exception e){
            e.getStackTrace();
        }
    }
    @Then("^Check main tabs by name")
    public void validateMainTabByName(DataTable data) {
        try{
            List<List<String>> obj = data.asLists();
            for (int i = 1; i < obj.size(); i++) {
                String tabName = obj.get(i).get(0);
                logger.log("On the Home validate tab name: " + tabName);
                boolean display = homePage.homepageAnyMainTabTextAreDisplayed(tabName);
                Assert.assertTrue(display);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }
    @Then("validate that registration button is displayed")
    public void validateJoinFreeButton() {
        try{
            logger.log("On the Home Page Validating Join Free button");
            boolean display = homePage.homepageJoinFreeButtonIsDisplayed();
            Assert.assertTrue(display);
        } catch (Exception e){
            e.getStackTrace();
        }
    }


    @Then("^validate that \"([^\"]*)\" text is displayed$")
    public void validateBooNowButton(String text) {
        try{
            logger.log("On the Home Page Validating Book now text");
            boolean display = homePage.setAnyElementWithText(text).isDisplayed();
            Assert.assertTrue(display);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    @When("^click registration button$")
    public void clickRegistrationButton() {
        try{
            logger.log("Click on registration button");
            homePage.clickJoinFreeButton();
        } catch (Exception e){
            e.getStackTrace();
        }
    }


}
