package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase2 {

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
		System.out.println("TestCase2:Current URL of the page is verified." + "Current URL:" + ActualCurrentURL);
		System.out.println("TestCase2:Page Title of the page is verified." + "Page Title:" +  ActualTitle);	
		}  
		else
		{
			System.out.println("Exception: TimeOutException");
		}
		}
		@Test(priority=1)
		public void login() throws InterruptedException
		{
		//Method to call Loginpage
		LoginPage loginpage = new LoginPage(driver);
		//TestCase4
		loginpage.signup();
		//TestCase5
		loginpage.verifyForm();
		//TestCase6
		loginpage.loginEmail("inevitablegaurav@gmail.com");
		loginpage.password("Gaurav");
		//TestCase7
		loginpage.login();
		}
		@Test(priority=2)
		public void verify() throws InterruptedException
		{
		//Method to call DashboardPage
		DashboardPage dashboardpage = new DashboardPage(driver);
		//TestCase8
		dashboardpage.verifyLoggedUsername();
		}
		@Test(priority=3)
		public void logout() throws InterruptedException
		{
		//Method to call LogoutPage
		LogoutPage logoutpage = new LogoutPage(driver);
		//TestCase9
		logoutpage.deleteAccount();
		//TestCase10
		logoutpage.verifyDeletedAccount();
		}
}

