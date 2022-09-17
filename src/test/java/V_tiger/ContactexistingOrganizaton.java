package V_tiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactexistingOrganizaton {
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver = null;
	Random r=new Random();
	int RANDOM = r.nextInt(1000);
	//read common data from property file 
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("url");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	//getting test data from excel sheet
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Contact");
	Row rw = sh.getRow(4);
	Cell cel = rw.getCell(2);
	String CTNORG = cel.getStringCellValue();
	
	
	//step-1 launching V-Tiger
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
   driver.get(URL);
	
	//step-2 login into application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step-3: create contact with existing organization
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CTNORG+RANDOM);
	
	//step-4: navigation to pop-up 
	String parent=driver.getWindowHandle();
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	System.out.println(parent);
	
	Set<String> handle=driver.getWindowHandles();
	for(String h1:handle) {
		
		System.out.println(h1);
		
		if(!h1.equals(parent)) {
			
			driver.switchTo().window(h1);
			driver.findElement(By.xpath("//a[text()='Qspyider']")).click();
		}
	}
	//step-5: navigate to parent window
	
	driver.switchTo().window(parent);

	//step-6: save and logout
	driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
}
}
