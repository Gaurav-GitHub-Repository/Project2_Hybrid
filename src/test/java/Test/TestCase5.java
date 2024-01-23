package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;

@SuppressWarnings("deprecation")
public class TestCase5 {

		WebDriver driver;
		
		@Test(priority=0)
		public void initialize()
		{
		//TestCase1	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\V120\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		//TestCase2
		driver.get("https://automationexercise.com/");
		//TestCase3		
		String ActualCurrentURL = "https://automationexercise.com/";
		String ActualTitle = "Automation Exercise";		    
		if(driver.getCurrentUrl().equals(ActualCurrentURL) && driver.getTitle().equals(ActualTitle))
		{
		System.out.println("Current URL of the page is verified." + "Current URL:" + ActualCurrentURL);
		System.out.println("Page Title of the page is verified." + "Page Title:" +  ActualTitle);	
		} 
		else
		{
			System.out.println("Exception: TimeOutException");
		}
		}
		@Test(priority=1)
		public void login()
		{
		//Method to call LoginPage
		LoginPage loginpage = new LoginPage(driver);
		//TestCase4	
		loginpage.signup();
		//TestCase5
		loginpage.verifySignup();
		//TestCase6	
		loginpage.name("Pathange Gaurav");
		loginpage.email("gaurav.pathangej@gmail.com");
		//TestCase7
		loginpage.signupbutton();
		//TestCase8
		loginpage.verifySignupError();
		}
	}
	

