package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.DashboardPage2;

@SuppressWarnings("deprecation")
public class TestCase18 {

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
		public void verify() throws InterruptedException
		{
		//Method to call DashboardPage
		DashboardPage2 dashboardpage2 = new DashboardPage2(driver);
		dashboardpage2.product();
		//TestCase3		
		dashboardpage2.verifyCategory();
		//TestCase4
		dashboardpage2.verifyWomen();
		//TestCase5
		dashboardpage2.dress();
		//TestCase6
		dashboardpage2.verifyWomenDress();
		//TestCase7
		dashboardpage2.scroll();
		dashboardpage2.men();
		dashboardpage2.menCategory();
		//TestCase8
		dashboardpage2.verifyMenPage();
		}
	}
