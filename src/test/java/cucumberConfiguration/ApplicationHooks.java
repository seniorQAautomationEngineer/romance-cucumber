package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static base.DriverFactoryFacade.quitDriver;

public class ApplicationHooks {

    @Before
    public void initialStep(Scenario scenario) {
        scenario.log("Executing >>>>>"+scenario.getName());
    }

    @After(order=2)
    public void takeScreenshotForFailedScenario(Scenario scenario){
        if(scenario.isFailed()){
            //TODO RetryLOGIC
            //TODO Screenshot Code
        }
    }

    @After(order=1)
    public void quitDrivers(){
        System.out.println("Quitting Driver");
        quitDriver();
    }
}
