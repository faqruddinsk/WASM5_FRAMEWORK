package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {//step-1: create separate class for 
	
	//step-2 declaration
	@FindBy(name ="accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(name ="industry")
	private WebElement industryDropDown;
	
	@FindBy(name ="accounttype")
	private WebElement accountDropdown;
	
	
	//@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	//private WebElement 
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAccountDropdown() {
		return accountDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

	//business library
	/*
	 * This method create organization 
	 */
	public void craeteNewOrg(String orgname) {
		OrgnameEdt.sendKeys(orgname);	
		saveBtn.click();
	}
	/*
	 * This method will create the organization with industry drop down 
	 */
	public void craeteNewOrg(String orgname,String IndustryType) {
		OrgnameEdt.sendKeys(orgname);
		handleDropDown(IndustryType,industryDropDown);
		saveBtn.click();
	}
	/*
	 * this method will create organization with type and industry drop down
	 */
	public void craeteNewOrg(String orgname,String IndustryType,String type) {
		OrgnameEdt.sendKeys(orgname);
		handleDropDown(IndustryType,industryDropDown);
		handleDropDown(type,accountDropdown);
		saveBtn.click();
		
	}

}
