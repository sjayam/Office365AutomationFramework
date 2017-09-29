package packPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import packCucumberRunner.MainRunner;

public  class Home extends MainRunner
{
	
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	public WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//img[@src='images/logo.jpg']")
	public WebElement logo;
	
	
	public Home(WebDriver driver)
	{
		Home.driver = driver;
		 PageFactory.initElements(driver, this);
		 System.out.println("Instant");
	}

	public void OpenHomePage()
	{
		String url="http://softest-training.com";
	    driver.get(url); 
	    String title=driver.getTitle();
	    System.out.println("Home Page : " + title);
	 }
	
	public void VerifyLogo()
	{
		Boolean logoDisplayed=logo.isDisplayed();
	    System.out.println("Logo is Displayed : " + logoDisplayed);
	}
	
	public void ClickLogin()
	{
		if(loginLink.isDisplayed())
			{
			loginLink.click();
			}
	}

}
