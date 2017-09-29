package packGlueMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import packCucumberRunner.MainRunner;
import packPages.Login;

public class LoginSteps extends MainRunner
{
	Login login=new Login(driver);
	
	@When("^user enters username \"([^\"]*)\" And enters password \"([^\"]*)\"$")
	public void user_enters_username_And_enters_password(String user, String pwd) throws Throwable 
	{
	   login.enterUser(user);
		login.enterPwd(pwd);
	}

	@Then("^user clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable 
	{
		Thread.sleep(1000);
		login.clickSubmit();
		
	}
	
	@Then("^the page expected is \"([^\"]*)\"$")
	public void the_page_expected_is(String expUrl)
	{
		login.VerifyExpPage(expUrl);
	}

	@And("^expected message is \"([^\"]*)\" for type \"([^\"]*)\"$")
	public void expected_message_is_for_type  (String expMsg, String status) throws Exception
	{
		login.VerifyMsg(expMsg, status);
	}
	
	
	

}
