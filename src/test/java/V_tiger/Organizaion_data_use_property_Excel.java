package V_tiger;

import java.io.FileInputStream;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Organizaion_data_use_property_Excel {
public static void main(String[] args) throws IOException {
	
	WebDriver driver;
	Random r=new Random();
	int RANDOM = r.nextInt(1000);
	//Step-1: getting data from out source
	//----->read the common data OR NECESSARY DATA  from property file
	
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER=pobj.getProperty("browser");
	String URL=pobj.getProperty("url");
	String USERNAME=pobj.getProperty("username");
	String PASSWORD=pobj.getProperty("password");
	
	
	//---->READ test data from Excel sheet
	
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organization");
	Row rw = sh.getRow(1);
	Cell cel = rw.getCell(2);
	String ORGNAME = cel.getStringCellValue();
	
	//step-2: launching browser---->Run time polymorphism
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	
		System.out.println("-----chrome launched sucessfully----");
	}
	else if(BROWSER.equalsIgnoreCase("firefox")){
		driver=new FirefoxDriver();
	
		System.out.println("-----firefox launched sucessfully----");
	}
	else {
		System.out.println("-----invalid browser-----");
		driver=new ChromeDriver();
		System.out.println("----chrome launched sucessfully-----");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(URL);
	
	//step-3: login to V-Tiger 
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();	
	
	//step-4: Navigate to create organization
	driver.findElement(By.linkText("Organizations")).click();
	
	
	//step-5: create organization and save it
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//organization name and random number
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
	//step-6:  save and logout
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act = new Actions(driver);
	act.moveToElement(signout).perform();
    WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(signout));
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	System.out.println("-----Scenario executed suxxessfully------");
	driver.close();
	
}
}
