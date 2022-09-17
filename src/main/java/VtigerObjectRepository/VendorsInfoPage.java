package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInfoPage {//create class for every page 
	//declaration
	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderText;
	
  //initialization
	public VendorsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getVendorHeaderText() {
		return vendorHeaderText;
	}
	
	//business library
	public String getVendorHeadText() {
	return	vendorHeaderText.getText();
	}
}
