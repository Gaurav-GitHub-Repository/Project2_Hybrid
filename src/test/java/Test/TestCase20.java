package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.DashboardPage2;
import Pages.LoginPage;

@SuppressWarnings("deprecation")
public class TestCase20 {

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
		public void product() throws InterruptedException
		{
		//Method to call DashboardPage2
		DashboardPage2 dashboardpage2 = new DashboardPage2(driver); 
		//TestCase3
		dashboardpage2.product();
		//TestCase4
		dashboardpage2.verifyProduct();
		//TestCase5
		dashboardpage2.search("Polo");
		dashboardpage2.searchButton();
		//TestCase6
		dashboardpage2.verifySearchPage();
		//TestCase7&8
		dashboardpage2.scrollDown();
		dashboardpage2.PoloProduct();
		//TestCase9
		dashboardpage2.viewCart();
		//Method to call LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.signup();
		//TestCase10
		loginpage.loginEmail("inevitablegaurav@gmail.com");
		loginpage.password("Gaurav");
		loginpage.login();
		//TestCase11
		dashboardpage2.cart();
		//TestCase12
		dashboardpage2.productQuantity();
		}		
	}

