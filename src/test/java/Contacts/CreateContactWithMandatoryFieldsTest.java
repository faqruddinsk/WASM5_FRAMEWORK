package Contacts;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Vtiger.GenericUtility.BaseClass;
import Vtiger.GenericUtility.ExcelFileUtility;
	import Vtiger.GenericUtility.JavaUtility;
	import Vtiger.GenericUtility.PropertyFileUtility;
	import Vtiger.GenericUtility.WebDriverUtility;
	import VtigerObjectRepository.ContactsInfoPage;
	import VtigerObjectRepository.ContactsPage;
	import VtigerObjectRepository.CreateNewContactPage;
	import VtigerObjectRepository.HomePage;

	public class CreateContactWithMandatoryFieldsTest extends BaseClass{
		@Test
	public void createconWithMandatoryField() throws Throwable
	{
		
		//create object utilities 
		/*JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
		//read all required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		*/
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2)+jUtil.getRandomNumber();
		
		//launch browser
		/*if(BROWSER.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser Name");
		}
		wUtil.maximiseWin(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);*/
		
		//navigate to contact 
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLink();
		
		//navigate to create contact page
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContImg();
		
		//create contact with mandatory fields 
		 CreateNewContactPage cnp=new  CreateNewContactPage(driver);
		 cnp.createNewContact(LASTNAME);
		
		//validate
		 ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactheader = cip.getContactHeader();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(contactheader.contains(LASTNAME), true);
		/*if(contactheader.contains(LASTNAME)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		//sign out from application
		hp.signOutOfApp(driver);*/
		sa.assertAll();
	}
	}


