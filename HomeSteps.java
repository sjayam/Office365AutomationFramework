package packGlueMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import packCucumberRunner.MainRunner;
import packPages.Home;

public class HomeSteps extends MainRunner
{
	
	Home home=new Home(driver);
	
	@Given("^HomePage is open$")
	public void HomePage_is_open() throws Throwable 
	{
		home.OpenHomePage();
		//PageFactory.initElements(driver, Home.class);
		/*System.out.println("hi");
		String url="http://softest-training.com";
	    driver.get(url); 
	    String title=driver.getTitle();
	    System.out.println("Home Page : " + title);
	    Boolean logoDisplayed=logo.isDisplayed();
	    System.out.println("Logo is Displayed : " + logoDisplayed);*/
	    //return this;
	}
	
	@When("^user clicks on the Login link$")
	public void user_clicks_on_the_Login_link() throws Throwable 
	{
	    //driver.findElement(By.xpath("//a[text()='Login']")).click();
	   home.loginLink.click();
		//loginLink.click();
	   // return new Login(driver);
	}

}
