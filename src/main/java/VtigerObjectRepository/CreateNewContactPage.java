package VtigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {//step-1: create new class for every page
	//declaration
	@FindBy(name="lastname")
	private WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchBoxEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);	
	}
	
    //utilization
	public WebElement getContactEdt() {
		return contactNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadDropDown() {
		return leadSourceDropDown;
		
	}
	public WebElement getSignOutBtn() {
		return saveBtn;
	}
	
//business library
	/*
	 * This method is to create contact with mandatory only
	 */
	public void createNewContact(String lastname) {
		contactNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	/*
	 * This method is to create contact with lead source type
	 */
	public void createNewContact(String lastname,String leadsourceType) {
		contactNameEdt.sendKeys(lastname);
		 handleDropDown(leadsourceType,leadSourceDropDown);
		saveBtn.click();	
	}
	/*
	 * This method will create contact with last name and organization
	 */
	public void createNewContact(String lastname,String orgName,WebDriver driver) {
		contactNameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
		switchToWindow(driver,"Accounts");
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();//dynamic xpath
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
	}
}

