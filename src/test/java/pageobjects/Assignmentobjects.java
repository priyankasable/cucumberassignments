package pageobjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Assignmentobjects 
{
	private static final Logger logger = LogManager.getLogger(Assignmentobjects.class);
	WebDriver driver;
	
	private By search_button = By.xpath("//button[@class='btn btn-default button-search']");
	private By searchBox = By.id("search_query_top");
	private By logo = By.xpath("//img[@class='logo img-responsive']");

	
	public Assignmentobjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checktitle(String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		Boolean a = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, a);
		logger.info("Page title matched: " + expectedTitle );
	}
	
	public void searchproduct(String productname)
	{
		 WebDriverWait webDriverWait = new WebDriverWait(driver,30);
	     WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBox));
	     elementSearchBox.sendKeys(productname);
	     driver.findElement(search_button).click();
	}
	
	public void displayresult(String expectedTitle)
	{
		WebDriverWait webDriverWait1 = new WebDriverWait(driver,30);
		Boolean b = webDriverWait1.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Search Result page displyed and Title Matched" + expectedTitle );
	}
	
	public void checklogo()
	{
		boolean searchLogo = driver.findElement(logo).isDisplayed();		
		Assert.assertEquals("Title Validation",true, searchLogo);
		logger.info("Logo Test case Passed");
		
	}

}
