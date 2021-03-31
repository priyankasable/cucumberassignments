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

import java.util.concurrent.TimeUnit;

public class StepDefs
{

    WebDriver driver;
    String base_url = "http://automationpractice.com/";
    int implicit_wait_timeout_in_sec = 20;


    @Given("User Opend the Browser")
    public void user_opened_browser() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @Given("User redirected to the application url")
    public void redirect_homepage() 
    {
        driver.get(base_url);
        String expected = "My Store";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }

    @When("User Search for product {string}")
    public void product_search(String productName) 
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));

        elementSearchBox.sendKeys(productName);
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
    }

    @Then("Search Result page is displayed")
    public void result_displyed() 
    {
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,30);
        
        webDriverWait1.until(ExpectedConditions.titleIs("Search - My Store"));

        Assert.assertEquals("Page Title validation","Search - My Store", driver.getTitle());
        
        driver.quit();
    }
}
