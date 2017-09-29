package packPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Students 
{

private WebDriver driver;
	
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	WebElement logout;
	
	public Students(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignOut()
	{
		logout.click();
	}
	
	public void VerifyHome()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("index"));
	}
	
}
