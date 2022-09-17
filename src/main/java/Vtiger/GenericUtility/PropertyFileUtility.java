package Vtiger.GenericUtility;
/**
 * This class contains generic methods to read data from property file 
 * @author shaik
 */
	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

	public class PropertyFileUtility
	/**
	 * This method will return the specific key value from the property file
	 * @author shaik
	 * @throws IOException
	 */
	{
		public String readDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream(ConstantsUtility.PropertyFilePath);
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
			
//						OR
//			return pObj.getProperty(key);
		}

		
	}

