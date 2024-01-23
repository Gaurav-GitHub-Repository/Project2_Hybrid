package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Utility;


public class DashboardPage extends Utility{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to scroll footer
	By Footer = By.xpath("//footer[@id='footer']");
	//Locator to verify subscription
	By Subscription = By.xpath("//div[@class='single-widget']/h2");
	//Locator to enter email
	By Email = By.xpath("//div[@class='single-widget']/form/input[2]");
	//Locator to click on button
	By Button = By.xpath("//div[@class='single-widget']/form/button");
	//Locator for SubscriptionSuccessMessage
	By SubscriptionSuccess = By.xpath("//div[text()='You have been successfully subscribed!']");
	
	
	//TestCase1 Locators	
	//Locator for enter account information text
	By Enter_Account_Information_Form = By.xpath("//div[@class='login-form']/h2/b");
	//Locator for Title
	By Title = By.xpath("//form[@action='/signup']/div/div/label/div/span/input[@id='id_gender1']");
	//Locator for AccountName
	By AccountName = By.xpath("//form[@action='/signup']/div[2]/input[@id='name']");
	//Locator for Email
	By AccountEmail = By.xpath("//form[@action='/signup']/div[3]/input[@id='email']");
	//Locator for Password
	By Password = By.xpath("//form[@action='/signup']/div[4]/input[@id='password']");
	//Locator for Day
	By Day = By.xpath("//select[@id='days']");
	//Locator for Month
	By Month = By.xpath("//select[@id='months']");
	//Locator for Year
	By year = By.xpath("//select[@id='years']");
	//Locator for Signup newsletter checkbox
	By Signupcheckbox = By.xpath("//form[@action='/signup']/div[6]/div/span/input[@id='newsletter']");
	//Locator for offer checkbox
	By Offercheckbox = By.xpath("//input[@type='checkbox' and @id='optin']");
	//Locator for First Name
	By First_name = By.xpath("//input[@id='first_name' and @data-qa='first_name']");
	//Locator for Last Name
	By Last_Name = By.xpath("//input[@id='last_name']");
	//Locator for Company
	By Company = By.xpath("//input[@id='company']");
	//Locator for Address
	By Address = By.xpath("//input[@id='address1']");
	//Locator for Address2
	By AddressInfo = By.xpath("//input[@id='address2']");
	//Locator to select country
	By Country = By.xpath("//select[@id='country']");
	//Locator to enter state
	By State = By.xpath("//input[@id='state']");
	//Locator to enter city
	By City = By.xpath("//input[@id='city']");
	//Locator to enter ZipCode
	By Zipcode = By.xpath("//input[@id='zipcode']");
	//Locator to enter ZipCode
	By Mobile_Number = By.xpath("//input[@id='mobile_number']");
	//Locator for Create Button
	By Create_Button = By.xpath("//button[text()='Create Account']");
	//Locator to verify account created text
	By Account_Created = By.xpath("/html/body/section/div/div/div/h2/b");
	//Locator to click on continue button
	By button = By.xpath("//a[text()='Continue']");
	//Locator for Close_Ad
	By Close_Ad = By.xpath("//div[@id='dismiss-button']");
	//Locator to verify logged in username
	By Logged_Username = By.xpath("//div[@class='shop-menu pull-right']/ul/li[10]/a");
	//Locator to verify logged in username
	By Delete_Account = By.xpath("//a[@href='/delete_account']");
	//Locator to verify account deleted
	By Account_Deleted_Text = By.xpath("//h2[@class='title text-center']/b[text()='Account Deleted!']");
	//Locator to click on continue button
	By ContinueButton = By.linkText("Continue");

	//Locator for testcase4
	//Locator to verify username
	By LoggedIn_Username = By.xpath("//div[@class='shop-menu pull-right']/ul/li[10]/a");
	
	//Locator for testcase6
	//Locator for contact us
	By Contact = By.xpath("//div[@class='shop-menu pull-right']/ul/li[8]/a");
	//Locator for contact us form
	By form = By.xpath("//div[@class='contact-form']/h2");
	//Locator for name
	By Name = By.xpath("//form[@id='contact-us-form']/div/input");
	//Locator for email
	By ContactForm_Email = By.xpath("//form[@id='contact-us-form']/div[2]/input");
	//Locator for subject
	By Subject = By.xpath("//form[@id='contact-us-form']/div[3]/input");
	//Locator for message
	By Message = By.xpath("//form[@id='contact-us-form']/div[4]/textarea[@id='message']");
	//Locator to click on upload button
	By Upload = By.xpath("//input[@name='upload_file']");
	//Locator for submit button
	By Submit = By.xpath("//form[@id='contact-us-form']/div[6]/input");
	//Locator to verify success message 
	By details = By.xpath("//div[text()='Success! Your details have been submitted successfully.']");
	//Locator for home button
	By ContactForm_Button = By.xpath("//div[@class='contact-form']/div[3]/a");
			
	//Locator for testcase7
	By Test_Case = By.xpath("//div[@class='shop-menu pull-right']/ul/li[5]/a");
	//Locator to verify test cases page
	By test_case_page = By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']");
	
	
	//Method to scroll footer
	public void scroll()
	{
		WebElement Element = driver.findElement(Footer);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	//Method to verify subscription
	public void verifySubscription()
	{
		String subscription = driver.findElement(Subscription).getText();
		System.out.println(subscription);
		Assert.assertEquals(subscription, "SUBSCRIPTION");
	}
	//Method to enter email
	public void footerEmail(String EmailAddress)
	{
		driver.findElement(Email).sendKeys(EmailAddress);
	}
	//Method to click on button
	public void button()
	{
		driver.findElement(Button).click();
	}
	public void subscriptionSuccess()
	{
		String subscription = driver.findElement(SubscriptionSuccess).getText();
		System.out.println(subscription);
		Assert.assertEquals(subscription, "You have been successfully subscribed!");
	}
	
	//Method to verify Enter_Account_Information
	public void verifyAccountInformationForm() throws InterruptedException
	{
		Thread.sleep(2000);
		String AccountInformationtext = driver.findElement(Enter_Account_Information_Form).getText();
		Assert.assertEquals(AccountInformationtext, "ENTER ACCOUNT INFORMATION");
	}	
	//Method to click on Title 
	public void title()
	{
		driver.findElement(Title).click();
	}
	//Method to enter AccountName
	public void accountName(String accountname)
	{
		driver.findElement(AccountName).clear();
		driver.findElement(AccountName).sendKeys(accountname);
	}
	//Method to enter AccountEmail
	public void accountEmail(String accountemail)
	{
		try 
		{
		  driver.findElement(AccountEmail).clear();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.presenceOfElementLocated(AccountEmail));
		  driver.findElement(AccountEmail).sendKeys(accountemail);
		}
		catch(InvalidElementStateException e)
		{
			System.out.println("Unable to enter Email Address. Exception: InvalidElementStateException");
		}
	}
	//Method to enter password
	public void password(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	//Method to select day
	public void day()
	 {
		 Select select = new Select(driver.findElement(Day));
		 select.selectByValue("10");
	 }
	//Method to select month
	public void month()
	{
		Select select = new Select(driver.findElement(Month));
		select.selectByVisibleText("November");
	}
	//Method to select year
	public void year()
	{
		Select select = new Select(driver.findElement(year));
		select.selectByValue("1995");
	}
	//Method to click on signup newsletter checkbox	
	public void checkbox1() throws InterruptedException, IOException
	{
//		driver.findElement(year).sendKeys(Keys.TAB);
		try {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Signupcheckbox));
		driver.findElement(Signupcheckbox).click();
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("Unable to select checkbox. Exception: ElementClickInterceptedException");
		}	
	}	
	//Method to click on offer checkbox
	public void checkbox2()
	{
		driver.findElement(Signupcheckbox).sendKeys(Keys.TAB);
		try {
		     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.presenceOfElementLocated(Offercheckbox));
			 driver.findElement(Offercheckbox).click();
			}
			catch(ElementClickInterceptedException e)
			{
				System.out.println("Unable to select checkbox. Exception: ElementClickInterceptedException");
			}		
	}
	//Method to enter first name 
	public void firstName(String AddressFirstName)
	{
	  driver.findElement(First_name).sendKeys(AddressFirstName);
	}
	//Method to enter last name 
	public void lastName(String AddressLastName)
	{
	  driver.findElement(Last_Name).sendKeys(AddressLastName);	
	}
	//Method to enter company name
	public void company(String companyName)
	{
	  driver.findElement(Company).sendKeys(companyName);	
	}
	//Method to enter address
	public void address(String Address1)
	{
	  driver.findElement(Address).sendKeys(Address1);	
	}
	//Method to enter address2
	public void addressInfo(String Address2)
	{
	  driver.findElement(AddressInfo).sendKeys(Address2);
	}
	//Method to call registered address
	public void Regsitered_Address()
	{
	  String Registered_Address = driver.findElement(By.xpath("//input[@id='address2']")).getText();
	  System.out.println(Registered_Address);
	}			
	//Method to select country
	public void country()
	{
		Select select = new Select(driver.findElement(Country));
		select.selectByVisibleText("India");
	}
	//Method to enter state
	public void state(String statename)
	{
	   driver.findElement(State).sendKeys(statename);	
	}
	//Method to enter city
	public void city(String cityName)
	{
		driver.findElement(City).sendKeys(cityName);
		String Registered_City = driver.findElement(City).getText();
		System.out.println(Registered_City);
	}
	//Method to call registered city
	public void Regsitered_City()
	{
	  String Registered_City = driver.findElement(By.xpath("//input[@id='city']")).getText();
	  System.out.println(Registered_City);
	}						
	//Method to enter zipcode
	public void zipcode(String code)
	{
		driver.findElement(Zipcode).sendKeys(code);
	}
	//Method to enter mobilenumber
	public void mobile(String number)
	{
		driver.findElement(Mobile_Number).sendKeys(number);
	}
	//Method to click on create button
	public void createButton() throws InterruptedException
	{
		try {
		    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.presenceOfElementLocated(Button));
			Thread.sleep(2000);
			driver.findElement(Create_Button).click();
			}
			catch(ElementClickInterceptedException e)
			{
				System.out.println("Unable to click on button. Exception: ElementClickInterceptedException");
			}
	}
	public void verifyAccount() throws InterruptedException
	{
	  Thread.sleep(5000);
	  String Account = driver.findElement(Account_Created).getText();
	  Assert.assertEquals(Account, "ACCOUNT CREATED!");
	}
	public void continueButton() throws InterruptedException
	{	
	  try {
//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 	
//	  wait.until(ExpectedConditions.presenceOfElementLocated(button));
	  Thread.sleep(5000);  
	  driver.findElement(button).click();
	  }
	  catch(TimeoutException e)
	  {
		 System.out.println("Continue button is not working.Exception: TimeoutException");
	  }
	}
	public void verifyLoggedUsername() throws InterruptedException
	{		
		try {
		Thread.sleep(10000);	
		String LoggedName = driver.findElement(Logged_Username).getText();
		System.out.println(LoggedName);
		if(LoggedName.contains("Logged in as Pathange Gaurav"))
		{
			System.out.println("Username is verified");
		}
		else
		{
			System.out.println("Username is not verified");
		}
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
			System.out.println("Exception: TimeoutException");
		}
	} 
	//Method to verify username
	public void verifyUsername() throws InterruptedException
	{
		Thread.sleep(5000);
		String Username = driver.findElement(LoggedIn_Username).getText();
		System.out.println(Username);
		Assert.assertEquals(Username, " Logged in as ");
	}

	//Method for testcase6
	//Method to click on contact
	public void contact()
	{
		driver.findElement(Contact).click();
	}	
	//Method to verify from text
	public void verifyContact()
	{
	  String Form = driver.findElement(form).getText();
	  System.out.println(Form);
	  Assert.assertEquals(Form, "Get In Touch");
	}
	//Method to enter name
	public void name(String Username) throws InterruptedException
	{
		driver.findElement(Name).sendKeys(Username);
	}
	//Method to enter email
	public void email(String EmailId) throws InterruptedException
	{
		driver.findElement(Email).sendKeys(EmailId);
	}
	//Method to enter subject
	public void subject(String value) throws InterruptedException
	{
		driver.findElement(Subject).sendKeys(value);
	}	
	//Method to enter message
	public void message(String message) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(Message).sendKeys(message);
		System.out.println("TestCase6:File upload functionality is not working. File is not uploaded");
	}	
	//Method to upload file
	public void uploadFile() throws InterruptedException, AWTException
	{
		driver.findElement(Upload).click();
		try {
			Thread.sleep(1000);
			fileUpload();
		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println("TestCase6:File upload functionality is not working. File is not uploaded");
		}
	}	
	//Method to click on submit button
	public void contactFormButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		driver.findElement(Submit).click();
		//Thread.sleep(5000);
		//driver.findElement(Submit).click();
	}
	//Method to click on Ok button
	public void alertButton()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	//Method to verify success message
	public void verifySuccessMessage()
	{
	  String SubmittedForm = driver.findElement(details).getText();
	  System.out.println(SubmittedForm);	
	  Assert.assertEquals(SubmittedForm, "Success! Your details have been submitted successfully.");
	}
	//Method to click on home button
	public void homeButton() throws InterruptedException
	{
		try {
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Button));		
		driver.findElement(Button).click();
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
			System.out.println("TestCase6: Unable to click on home button. Exception:TimeoutException");
		}
	}
	//Method to scroll down
	public void contactFormScroll() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//form[@id='contact-us-form']/div[6]/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	//Method to click on test cases
	public void testCase() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Test_Case).click();
	}
	//Method to verify test case page
	public void verifyTestCase() throws InterruptedException
	{
		Thread.sleep(5000);
		String Test_Case_Page = driver.findElement(test_case_page).getText();
		System.out.println(Test_Case_Page);
		Assert.assertEquals(Test_Case_Page, "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
	}
	
	
	
}
