package V_tiger;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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

public class CreateOrganization_Health {
public static void main(String[] args) throws AWTException, IOException {
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
	
	//read data from Excel sheet
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organization");
	Row rw = sh.getRow(4);
	Cell cel = rw.getCell(2);
	String ORGNAME = cel.getStringCellValue();
	
	//step-1: launching 
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.get(URL);
    
	//step-2: login to v-tiger
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step-3: navigate to organization
	
    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step-4: create organization with mandatory fields 
	
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
	
	
	//step-5: select industry
	WebElement element=driver.findElement(By.name("industry"));
	Actions act=new Actions(driver);
	act.click(element).perform();
	driver.findElement(By.xpath("//option[@value='Healthcare']")).click();
	
	//step-6 save & logout
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    WebElement element1=	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
      act.moveToElement(element1).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
}
}
