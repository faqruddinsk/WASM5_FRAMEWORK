package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {//create class for every page
	//declaration
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement CreateProductImg;
		
		//Initialization
     public ProductsPage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);	
     }
     //utilization
	public WebElement getCreateProductImg() {
		return CreateProductImg;
	}
     
	//business library
	public void ClickOnCreateProductImg() {
		CreateProductImg.click();
	}
     
}
