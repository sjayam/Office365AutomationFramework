package packCucumberRunner;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import packPages.Login;
import packPages.Students;




@RunWith(Cucumber.class)
@CucumberOptions
(
	
		//format = {"pretty", "json:target/cucumber.json","pretty","html:target/cucumber"},
		plugin = {"pretty",
						"html:target/cucumber",
						"json:results/cucumber.json",
						"junit:results/cucumber.xml"
						},
		features = {"src\\test\\resources\\FeaturesFolder\\SoftestTraining.feature"},
		glue = { "packGlueMethods"},
		tags = {"@SoftestTraining"}
)

public class MainRunner extends AbstractTestNGCucumberTests

{
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	@BeforeTest
	public void OpenBrowser()
	{
		String fn="D:\\SeleniumSetUp\\ChromeAgain\\chromedriver_win32 (1)\\chromedriver.exe" ;   //D:\\SeleniumSetUp\\ChromeAgain\\chromedriver_win32 (1)\\chromedriver.exe   C:\\SeleniumSetup\\ChromeDriver\\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", fn);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver,20);
		
		

	}
	
	@Test
	public void StartTest()
	{
		
		System.out.println("test starts");
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		//driver.close();
		driver.quit();
	}
	
	
	
}
