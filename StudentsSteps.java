package packGlueMethods;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import packCucumberRunner.MainRunner;
import packPages.Home;
import packPages.Login;
import packPages.Students;

public class StudentsSteps extends MainRunner
{
	Students students=new Students(driver);
	
	
	@Given("^user is in the students page$")
	public void user_is_in_the_students_page() throws Throwable 
	{
		Home home=new Home(driver);
		home.OpenHomePage();
		home.loginLink.click();
		Login login=new Login(driver);
		login.enterUser("smita");
		login.enterPwd("password@12");
		login.clickSubmit();
		wait.until(ExpectedConditions.urlContains("student"));
		
	 }

	@When("^user clicks on signout link$")
	public void user_clicks_on_signout_link() throws Throwable 
	{
		students.SignOut();
	   
	}

	@Then("^user is back to the Home Page$")
	public void user_is_back_to_the_Home_Page() throws Throwable
	{
		students.VerifyHome();
		
		
	}	
	
	
}
