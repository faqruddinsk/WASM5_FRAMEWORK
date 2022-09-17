package Vtiger.GenericUtility;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.openqa.selenium.firefox.GeckoDriverInfo;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.google.common.io.Files;

	public class WebDriverUtility {
		
		public void openBrowserWithoutNotification(String browser)
		{
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				ChromeOptions co = new ChromeOptions();
				co.addArguments("-----Disable-Notifications-----");
				ChromeDriver driver = new ChromeDriver(co);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("-----Disable-Notifications-----");
				FirefoxDriver driver = new FirefoxDriver(fo);
			}
			else
			{
				System.out.println("Please Enter Proper Browser Name");
			}
		}
		
		public void handleDropDown(String vistext, WebElement element)
		{
			Select s = new Select(element);
			s.selectByVisibleText(vistext);
		}
		
		public void selectByValue(WebElement element, String value)
		{
			Select s = new Select(element);
			s.selectByValue(value);
		}
		
		public void selectByIndex(WebElement element, int num)
		{
			Select s = new Select(element);
			s.selectByIndex(num);
		}
		
		/**
		 * This method wait implicitly for 20 seconds for the entire DOM structure to load
		 * @param driver
		 */
		public void waitForPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		
		/**
		 * This method will wait explicitly for particular element to visible 
		 * @param driver
		 * @param element
		 */
		public void waitForElementtobeVisible(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * This method will wait for particular element to perform click operation 
		 * if the element is not interactive it will wait for 1 second 
		 */
		public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
			int count=0;
			while(count<10) {
				try {
					element.click();
					break;
				}
				catch(Exception e) {
					//too handle exception 
					Thread.sleep(1000);
					count++;
				}
			}	
		}
		
		
		/**
		 * This method is use for mouse hover action at particular element
		 * @param driver
		 * @param element
		 */
		public void mouseHover(WebDriver driver, WebElement element)
	    {
	    	Actions act = new Actions(driver);
	    	act.moveToElement(element).perform();
	    }
		
         /**
          * This method will perform right click action at particular element
          * @param driver
          * @param element
          */
	    public void rightClick(WebDriver driver, WebElement element)
	    {
	    	Actions act = new Actions(driver);
	    	act.contextClick(element).perform();
	    }
	    
	    /**
	     * This method will perform for double clicking on particular web element 
	     * @param driver
	     * @param element
	     */
	    public void doubleClick(WebDriver driver,WebElement element)
	    {
	    	Actions act =new Actions(driver);
	    	act.doubleClick(element).perform();  	
	    }
	    
	    /**
	     * This method will perform the mouse hover action over the offset
	     * @param driver
	     * @param x
	     * @param y
	     */
	    public void mouseHover(WebDriver driver ,int x, int y) {
	    	Actions act=new Actions(driver);
	    	act.moveByOffset(x, y).perform();
	    }
	    
	    /**
	     * This method will perform the Drag and Drop actions from source element to target element 
	     * @param driver
	     * @param srcelement
	     * @param trgelement
	     */
	    public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement trgelement ) {
	    	Actions act=new Actions(driver);
	    	act.dragAndDrop(srcelement, trgelement).perform();
	    }
	    
	    /**
	     * This method will use for maximize window
	     * @param driver
	     */
	    public void maximiseWin(WebDriver driver)
	    {
	    	driver.manage().window().maximize();
	    }
	    
	    
	    public void switchToWindow(WebDriver driver, String partialWinTitle)
	    {  
	    	//step:1 get all window handles
	    	Set<String> windowId = driver.getWindowHandles();
	    	
	    	//step-2 iterate through all windows
	    	Iterator<String> it = windowId.iterator();
	    	
	    	//step-3 navigate inside the windows
	    	while(it.hasNext())
	    	{
	    		//capture all window id's
	    		String winID=it.next();
	    		
	    		//switch to window and capture the title
	    		String title = driver.switchTo().window(winID).getTitle();
	    		if(title.contains(partialWinTitle))
	    		{
	    			break;
	    		}
	    	}
	    }

	    
	    public void acceptAlert(WebDriver driver)
	    {
	    	driver.switchTo().alert().accept();
	    }

	    public void dissmisAlert(WebDriver driver)
	    {
	    	driver.switchTo().alert().dismiss();
	    }
	    
	    public String getTextAlert(WebDriver driver)
	    {
	    	String alertText = driver.switchTo().alert().getText();
	    	return alertText;
	    }
	    
	    public void switchToFrame(WebDriver driver, WebElement element)
	    {
	    	driver.switchTo().frame(element);
	    }

	    public void switchToFrame(WebDriver driver, int index)
	    {
	    	driver.switchTo().frame(index);
	    }

	    public void switchToFrame(WebDriver driver, String idOrName)
	    {
	    	driver.switchTo().frame(idOrName);
	    }
/**
 * This method will take screen shots and return the destination path 
 * @param driver
 * @param screenshotName
 * @return
 * @throws Throwable
 */
	   public String takeScreenShot(WebDriver driver, String screenshotName) throws Throwable
	    {
	    	String screenshotpath=".\\ScreenShots\\"+screenshotName+".PNG";
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File src = ts.getScreenshotAs(OutputType.FILE);
	    
	    	File dst = new File(screenshotpath);
	    	FileUtils.copyFile(src, dst);
	    	
	    	return dst.getAbsolutePath();  //used for reporting in listeners
	    }

	   
	    /**
	     * This method will scroll until the particular element 
	     * @param driver
	     * @param element
	     */
	    public void scrollToWebElement(WebDriver driver, WebElement element)
	    {
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	
	    	int y = element.getLocation().getY();
	    	js.executeScript("window.scrollBy(0,"+y+")", element);
	    	      //or
	    	//js.executeScript("argument[0].scrollIntoView()", element);
	    }
	  
	    public void pressEnter() throws AWTException
	    {
	    	Robot rc = new Robot();
	    	rc.keyPress(KeyEvent.VK_ENTER);
	    	rc.keyRelease(KeyEvent.VK_ENTER);
	    }
	    
	    public void sendKeys(WebElement textBox, String value, WebDriver driver, String script)
	    {
	    	if(textBox.isEnabled())
	    	{
	    		textBox.sendKeys(value);
	    	}
	    	else
	    	{
	    		JavascriptExecutor jse=(JavascriptExecutor)driver;
	    		jse.executeScript(script);
	    	}
	    }
	    
	    
	    
	}

