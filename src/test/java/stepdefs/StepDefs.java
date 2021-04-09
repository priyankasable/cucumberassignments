package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.visionit.automation.stepdefs.StepDefs;

import pageobjects.Assignmentobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.util.concurrent.TimeUnit;

public class StepDefs
{	
    WebDriver driver;
    String base_url = "http://automationpractice.com/";
    int implicit_wait_timeout_in_sec = 20;
    private static final Logger logger = LogManager.getLogger(StepDefs.class);
    Scenario scn;
    Assignmentobjects assignmentsobj;

    
    @Before
    public void setUp(Scenario scn){
        this.scn = scn; 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
        logger.info("Browser Invoked.");
        assignmentsobj = new Assignmentobjects(driver);
       
    }

    @After
    public void cleanUp(){
        driver.quit();
        scn.log("Browser Closed");
    }

 
    
    @Given("User Opend the Home Page")
    public void check_title() {
        driver.get(base_url);
        scn.log("Browser navigated to URL: " + base_url);
        String expected = "My Store";
        assignmentsobj.checktitle(expected);
    }
    

    @When("User Search for product {string}")
    public void product_search(String productName) 
    { 
        assignmentsobj.searchproduct(productName);
        scn.log("Product Searched: " + productName);
    }

    @Then("Search Result page is displayed")
    public void result_displyed() 
    {
    	  String expected = "Search - My Store";
          assignmentsobj.displayresult(expected);
          scn.log("Search Page Displayed");
    }
    
   @Then("User Check for Logo result is diplyed")
    public void check_logo() 
    {
          assignmentsobj.checklogo();
          scn.log("User Check for Logo result is diplyed");
    }
}
