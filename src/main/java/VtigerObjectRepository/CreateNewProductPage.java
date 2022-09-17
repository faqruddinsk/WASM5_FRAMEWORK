package VtigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {//create class for every page 
	//declaration 
@FindBy(name="productname")
private WebElement productnameEdt;

@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
private WebElement vendorNameLookUpImg;

@FindBy(id="search_txt")
private WebElement searchBoxEdt;

@FindBy(name="search")
private WebElement searchBtn;

@FindBy(xpath ="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

//initialization
public CreateNewProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getProductnameEdt() {
	return productnameEdt;
}

public WebElement getVendorNameLookUpImg() {
	return vendorNameLookUpImg;
}

public WebElement getSearchBoxEdt() {
	return searchBoxEdt;
}

public WebElement getSearchBtn() {
	return searchBtn;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//business library
public void createNewProduct(String productname) {
	productnameEdt.sendKeys(productname);
	saveBtn.click();
}
public void createNewProduct(String productname,String vendorname,WebDriver driver) {
	productnameEdt.sendKeys(productname);
	vendorNameLookUpImg.click();
	switchToWindow(driver,"Vendors");
	searchBoxEdt.sendKeys(vendorname);
	searchBtn.click();
	driver.findElement(By.xpath("//a[text()='"+vendorname+"']")).click(); //Dynamic xpath
	switchToWindow(driver,"Products");
	saveBtn.click();
}


}
