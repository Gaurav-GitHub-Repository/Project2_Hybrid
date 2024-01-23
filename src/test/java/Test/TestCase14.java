package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.DashboardPage2;
import Pages.DashboardPage3;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase14 {

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
	public void addProduct() throws InterruptedException
	{
		//Method to call
		DashboardPage2 dashboardpage2 = new DashboardPage2(driver);
		//TestCase4
		dashboardpage2.product();
		dashboardpage2.scroll();
		dashboardpage2.addCart();
		dashboardpage2.continueButton();
		//TestCase5
		dashboardpage2.cart();
		//TestCase6
		dashboardpage2.verifyProductCartPage();
		//Method to call DashboardPage3
		DashboardPage3 dashboardpage3 = new DashboardPage3(driver);
		//TestCase7
		dashboardpage3.checkout();
		//TestCase8
		dashboardpage3.login();
	}
	@Test(priority=2)
	public void SignUp() throws InterruptedException, IOException
	{
		//Method to call LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.name("Pathange Gaurav");
		loginpage.email("inevitablegaurav@gmail.com");
		loginpage.signupbutton();
		//Method to call DashboardPage
		DashboardPage dashboardpage = new DashboardPage(driver);
		//TestCase9
		dashboardpage.title();
		dashboardpage.accountName("Pathange Gaurav");
		dashboardpage.accountEmail("gaurav.pathangej@gmail.com");
		dashboardpage.password("Gaurav");
		dashboardpage.day();
		dashboardpage.month();
		dashboardpage.year();
		dashboardpage.checkbox1();
		dashboardpage.checkbox2();
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
		dashboardpage.createButton();
		//TestCase10
		dashboardpage.verifyAccount();
		dashboardpage.continueButton();
		//TestCase11
		dashboardpage.verifyLoggedUsername();
	}
	@Test(priority=3)
	public void cart() throws InterruptedException
	{
		//Method to call DashboardPage2
		DashboardPage2 dashboardpage2 = new DashboardPage2(driver);
		//TestCase12
		dashboardpage2.cart();
		//Method to call DashboardPage3
		DashboardPage3 dashboardpage3 = new DashboardPage3(driver);
		//TestCase13
		dashboardpage3.checkout();
		//TestCase14
		dashboardpage3.verifyAddress();
		dashboardpage2.productQuantity();
		//TestCase15
		dashboardpage3.enterDescription("Page is continuously running");
		dashboardpage3.button();
		//TestCase16
		dashboardpage3.cardName("Pathange Gaurav");
		dashboardpage3.cardNumber("123456789123");
		dashboardpage3.cvcNumber("123");
		dashboardpage3.enterMonth("12");
		dashboardpage3.enterYear("2024");
		//TestCase17
		dashboardpage3.paymentBtn();
		//TestCase18
		dashboardpage3.verifySuccess();		
	}
	@Test(priority=4)
	public void logout() throws InterruptedException
	{
		//Method to call LogoutPage
		LogoutPage logoutpage  = new LogoutPage(driver);
		//TestCase19
		logoutpage.deleteAccount();
		//TestCase20
		logoutpage.verifyDeletedAccount();
		logoutpage.ContinueButton();
	}
}
