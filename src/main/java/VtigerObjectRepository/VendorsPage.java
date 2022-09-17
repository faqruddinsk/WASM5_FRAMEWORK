package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {//create class for every page
	//declaration
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createNewVendorLookUpimg;

//initialization
public VendorsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//utilization

public WebElement getCreateNewVendorLookUpimg() {
	return createNewVendorLookUpimg;
}
//business library
public void clickOnNewVendorImg() {
	createNewVendorLookUpimg.click();
}

}
