package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.DashboardPage2;

@SuppressWarnings("deprecation")
public class TestCase11 {

		WebDriver driver;
		
		@Test(priority=0)
		public void initialize()
		{
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
		public void verify()
		{
		DashboardPage2 dashboardpage2 = new DashboardPage2(driver);
		//TestCase4
		dashboardpage2.cart();
		//TestCase6
		dashboardpage2.verifySubscription();
		//TestCase7
		dashboardpage2.email("gaurav.pathangej@gmail.com");
		dashboardpage2.button();
		//TestCase8
		dashboardpage2.verifyCartSubscription();
		}
}
