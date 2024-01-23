package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutPage {

	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for logout
	By Logout = By.xpath("//a[@href='/logout']");	
	//Locator to verify delete account in username
	By Delete_Account = By.xpath("//a[@href='/delete_account']");
	//Locator to verify account deleted
	By Account_Deleted_Text = By.xpath("//h2[@class='title text-center']/b[text()='Account Deleted!']");
	//Locator to click on continue button
	By ContinueButton = By.linkText("Continue");

	
	
	//Method to click on Logout button
	public void logout() throws InterruptedException
	{
	   //Thread.sleep(5000);
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.presenceOfElementLocated(Logout));
	   driver.findElement(Logout).click();	
	}
	public void deleteAccount() throws InterruptedException
	{
	  Thread.sleep(5000);
	  driver.findElement(Delete_Account).click();
	}
	public void verifyDeletedAccount() throws InterruptedException
	{
		Thread.sleep(5000);
		String Account_Deleted = driver.findElement(Account_Deleted_Text).getText();
		Assert.assertEquals(Account_Deleted, "ACCOUNT DELETED!");
	}
	public void ContinueButton() throws InterruptedException
	{
		driver.findElement(ContinueButton).click();
	}

	
}










