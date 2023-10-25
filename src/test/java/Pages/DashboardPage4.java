package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage4 {

	WebDriver driver;
	
	public DashboardPage4(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	//Locator for Download Invoice
	By Invoice = By.xpath("//a[@href='/download_invoice/500']");
	//Locator for Continue Button
	By Button = By.xpath("//a[text()='Continue']");
	
	//Method to click on Download Invoice 
	public void invoice()
	{
		driver.findElement(Invoice).click();
	}
	//Method to verify file
	public void verifyFile() throws AWTException
	{
		  Robot robot = new Robot();
		  StringSelection file = new StringSelection("C:\\Users\\Gaurav\\Downloads\\invoice.txt");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER); 
	}
	//Method to click on continue button
	public void continueBtn()
	{
		driver.findElement(Button).click();
	}
}
