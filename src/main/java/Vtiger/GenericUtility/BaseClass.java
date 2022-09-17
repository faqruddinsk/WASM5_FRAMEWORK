package Vtiger.GenericUtility;
/*
 * @author shaik
 * This class contains basic configuration annotation for common 
 * functionalities like connecting to data base, launch the browser..etc.
 */
 
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import VtigerObjectRepository.HomePage;
import VtigerObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriverUtility wUtil=new WebDriverUtility();
	public DatabaseUtility dUtil=new DatabaseUtility();
	public JavaUtility jUtil=new JavaUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriver driver=null;
	public static  WebDriver sDriver;
	
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dUtil.connectToDb();
		Reporter.log("---Database Connection successful---",true);
	}
	
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		
	     String BROWSER = pUtil.readDataFromPropertyFile("browser");
		 String URL = pUtil.readDataFromPropertyFile("url");
		 
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("--Browser launched successfully--"+true);
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("--Browser launched successfully--"+true);
		}
		else {
			System.out.println("--invalid browser----");
		}
	sDriver=driver;
	wUtil.maximiseWin(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	}
		
		@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
		public void bmConfig() throws Throwable 
		{
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("--Login successfully--",true);
		}
		
		@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
		public void amConfig() {
			HomePage hp=new HomePage(driver);
			hp.signOutOfApp(driver);
			Reporter.log("--sign out successfully--",true);
		}
		
		@AfterClass (groups= {"SmokeSuite","RegressionSuite"})
		public void acConfig() {
			driver.close();
			Reporter.log("--browser closed --",true);
		}
		@AfterSuite
		public void asConfig() throws SQLException {
			dUtil.closeDB();
			Reporter.log("--Data Base closed--",true);
		}
		
	}

