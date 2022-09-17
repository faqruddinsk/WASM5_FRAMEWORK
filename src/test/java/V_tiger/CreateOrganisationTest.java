package V_tiger;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisationTest {
public static void main(String[] args) throws AWTException {
	
	//step-1: launching the application
	//System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://localhost:8888");
	
	//step-2: login to application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//step-3: Navigation to Organization link
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step-5 : create organization with mandatory fields
	
	driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys("Qspy1");
	
	//step-6 : save the data 
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//step-6 : log out
	WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     Actions act=new Actions(driver);
     act.moveToElement(element).perform();
     
   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
     
     
     
 
}
}
