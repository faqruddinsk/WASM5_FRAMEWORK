package VtigerObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{//step-1: create class for home page

	//step-2: identify the elements using @findBy,@FindBys,@findAll
	//Declaration 
	@FindBy(linkText = "Organizations")
	private WebElement  Organizationslink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText ="Opportunities")
	private WebElement Opportunitieslink;
	
	@FindBy( linkText = "Products")
	private WebElement Productslink;
	
	@FindBy(linkText ="Leads")
	private WebElement Leadslink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement Morelink;
	
	@FindBy(xpath="//a[text()='Vendors']")
    private WebElement Vendorlink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	@FindAll({@FindBy(linkText= "Sign Out"), @FindBy(xpath= "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signOutLink;
	
	
	//step-3: initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//step-4: utilization
	public WebElement getOrganizationslink() {
		return Organizationslink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getLeadslink() {
		return Leadslink;
	}
	
	public WebElement getMorelink() {
		return Morelink;
	}

	public WebElement getVendorlink() {
		return Vendorlink;
	}

	public WebElement getAdminstatorImg() {
		return adminstatorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business Library
	/*
	 * This method will do sign out operation
	 */
	public void signOutOfApp(WebDriver driver) {
	
		mouseHover(driver,adminstatorImg);
		signOutLink.click();
	}
	/*
	 * This method will click on organization link
	 */
	public void clickOnOrgLink() {
		Organizationslink.click();
	}
	/*
	 * This method will click on contacts link
	 */
	public void clickOnContactLink() {
		Contactslink.click();
	}
	/*
	 * This method will click on Opportunities link
	 */
	public void clickOnOppLink() {
		Opportunitieslink.click();
	}
	/*
	 * This method will click on Products link
	 */
	public void clickOnProductLink() {
		Productslink.click();
	}
	/*
	 * this method is used for click on more link
	 */
   public void clickOnMoreLink() {
	   Morelink.click();
   }
   /*
    * This method is used to click on vendor link
    */
	   public void clickOnVendorLink() {
		   Vendorlink.click();  
   }
}
