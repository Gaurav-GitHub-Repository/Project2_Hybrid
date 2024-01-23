package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase1 {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void initialize()
	{
	//TestCase1	
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\V120\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
	//TestCase2
	driver.get("https://automationexercise.com/");
	//TestCase3		
	String ActualCurrentURL = "https://automationexercise.com/";
	String ActualTitle = "Automation Exercise";		    
	if(driver.getCurrentUrl().equals(ActualCurrentURL) && driver.getTitle().equals(ActualTitle))
	{
	System.out.println("TestCase1:Current URL of the page is verified." + "Current URL:" + ActualCurrentURL);
	System.out.println("TestCase1:Page Title of the page is verified." + "Page Title:" +  ActualTitle);	
	}  	
	else
	{
		System.out.println("Exception: TimeOutException");
	}
	}
	@Test(priority=1)
	public void login()
	{
	//Method to call Loginpage
	LoginPage loginpage = new LoginPage(driver);
	//TestCase4
	loginpage.signup();
	//TestCase5
	loginpage.verifySignup();
	//TestCase6
	loginpage.name("Pathange Gaurav");
	loginpage.email("inevitablegaurav@gmail.com");
	//TestCase7
	loginpage.signupbutton();
	}
	@Test(priority=2)
	public void registration() throws InterruptedException, IOException
	{
	//Method to call Dashboard page
	DashboardPage dashboardpage = new DashboardPage(driver);
	//TestCase8
	dashboardpage.verifyAccountInformationForm();
	//TestCase9
	dashboardpage.title();
	dashboardpage.accountName("Pathange Gaurav");
	dashboardpage.accountEmail("gaurav.pathangej@gmail.com");
	dashboardpage.password("Gaurav");
	dashboardpage.day();
	dashboardpage.month();
	dashboardpage.year();
	//TestCase10
	dashboardpage.checkbox1();
	//TestCase11
	dashboardpage.checkbox2();
	//TestCase12
	dashboardpage.firstName("Pathange");
	dashboardpage.lastName("Gaurav");
	dashboardpage.company("Working in company");
	dashboardpage.address("Gachibowli");
	dashboardpage.addressInfo("Gachibowli");
	dashboardpage.country();
	dashboardpage.state("Telangana");
	dashboardpage.city("Hyderabad");
	dashboardpage.zipcode("518002");
	dashboardpage.mobile("8919876100");
	//TestCase13
	dashboardpage.createButton();
	//TestCase14
	dashboardpage.verifyAccount();
	//TestCase15
	dashboardpage.continueButton();
	//TestCase16
	dashboardpage.verifyLoggedUsername();
	}
	@Test(priority=3)
	public void logout() throws InterruptedException
	{
	//Method to call Logoutpage
	LogoutPage logoutpage = new LogoutPage(driver);	
	//TestCase17
	logoutpage.deleteAccount();
	//TestCase18
	logoutpage.verifyDeletedAccount();
	logoutpage.ContinueButton();
	//Assert.assertTrue(false);
	}
	}

	

