package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utility {
	
		WebDriver driver;
		
		//Method to upload file using Robot Class
		public void fileUpload() throws AWTException
		{ 
			  Robot robot = new Robot();
			  StringSelection file = new StringSelection("C:\\Users\\Gaurav\\Desktop\\Photo\\Photo.jpg");
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
			  robot.delay(1000);
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_V);
			  robot.keyRelease(KeyEvent.VK_CONTROL);
			  robot.keyRelease(KeyEvent.VK_V);
			          
			  robot.delay(1000);
			  robot.keyPress(KeyEvent.VK_ENTER);
			  robot.keyRelease(KeyEvent.VK_ENTER);
		}	
		//Method to call registered address
		public void Regsitered_Address()
		{
		  String Registered_Address = driver.findElement(By.xpath("//input[@id='address2']")).getText();
		  System.out.println(Registered_Address);
		}		
		//Method to call registered city
		public void Regsitered_City()
		{
		  String Registered_City = driver.findElement(By.xpath("//input[@id='city']")).getText();
		  System.out.println(Registered_City);
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
}
