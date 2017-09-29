package packPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.inject.Inject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import packCucumberRunner.MainRunner;


public class Login //extends MainRunner
{
	private WebDriver driver;
	@CacheLookup
	@FindBy(how = How.ID, using = "textfield")
	WebElement username;
	
	@FindBy(how = How.ID, using = "textfield2")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id='submit']")
	WebElement submit;
	
	@FindBy(how = How.XPATH, using = "//td[@class='menu_link2']/p[8]")
	WebElement msgLoginSuccess;
	
	@FindBy(how = How.CLASS_NAME, using = "style1")
	WebElement msgLoginFail;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void enterUser(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public void VerifyExpPage(String expUrl)
	{
		 System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), expUrl);

	}
	
	public void VerifyMsg(String expMsg,String status) throws Exception
	{
		if(status.equalsIgnoreCase("valid"))
	    {
			System.out.println("Valid Test : message displayed : " + msgLoginSuccess.getText());
			Assert.assertTrue(msgLoginSuccess.getText().contains(expMsg));
			Students student=new Students(driver);
			student.SignOut();
			
			Thread.sleep(3000);
			
	    
	    }
	    else
	    {
	    	
	    	System.out.println("Invalid Test==message displayed: " +msgLoginFail.getText());
	    	Assert.assertEquals(msgLoginFail.getText(),expMsg);
	    	
	    	
	    }
	}
	
	
}
