package Pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for Signup/Login 
	By Signup = By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a");
	//Locator to verify new user signup! text
	By New_User_Signup_form = By.xpath("//div[@class='signup-form']/h2");
	//Locator for Name
	By Name = By.xpath("//form[@action='/signup']/input[2]");
	//Locator for Email Address
	By Email = By.xpath("//form[@action='/signup']/input[3]");
	//Locator for Signup Button
	By SignupButton = By.xpath("//form[@action='/signup']/button");
	//Locator for Signup error
	By SignupError = By.xpath("//p[text()='Email Address already exist!']");	
	//Locator for Login to your account form text
	By Login_Form = By.xpath("//div[@class='login-form']/h2");
	//Locator for Email Address
	By Email_Address = By.xpath("//form[@action='/login']/input[2]");
	//Locator for Password
	By Password = By.xpath("//form[@action='/login']/input[3]");
	//Locator for Login
	By Login = By.xpath("//form[@action='/login']/button");
	//Locator for error
	By Login_Error = By.xpath("//p[text()='Your email or password is incorrect!']");
	
	
	//Method to click on Signup/Login
	public void signup()
	{
		driver.findElement(Signup).click();
	}	
	//Method to verify new user signup! text
	public void verifySignup()
	{
		String Signuptext = driver.findElement(New_User_Signup_form).getText();
		Assert.assertEquals(Signuptext, "New User Signup!");
	}
	//Method to enter name
	public void name(String username)
	{
		driver.findElement(Name).sendKeys(username);
	}
	//Method to enter email address
	public void email(String EmailAddress)
	{
		driver.findElement(Email).sendKeys(EmailAddress);
	}
	//Method to click on signup button
	public void signupbutton()
	{
		driver.findElement(SignupButton).click();
	}	
	//Method to verify signup error
	public void verifySignupError()
	{
		String Error = driver.findElement(SignupError).getText();
		System.out.println(Error);
		Assert.assertEquals(Error, "Email Address already exist!");
	}	
	//Method to verify login to your account form
	public void verifyForm()
	{
	  String Form_Text = driver.findElement(Login_Form).getText();
	  System.out.println(Form_Text);
	  Assert.assertEquals(Form_Text, "Login to your account");
	}
	//Method to enter email address
	public void loginEmail(String EmailID) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Email_Address).sendKeys(EmailID);
	}
	//Method to enter password
	public void password(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Password).sendKeys(value);
	}
	//Method to click on login button
	public void login() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.presenceOfElementLocated(Login));
		Thread.sleep(5000);
		driver.findElement(Login).click();
	}
	//Method to verify on login error
	public void error()
	{
		String Error = driver.findElement(Login_Error).getText();
		System.out.println(Error);
		Assert.assertEquals(Error, "Your email or password is incorrect!");
	}
}
