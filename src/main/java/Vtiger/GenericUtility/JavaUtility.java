package Vtiger.GenericUtility;

	import java.util.Date;
import java.util.Random;
	/**
	 * This class contains all java specific methods 
	 * @author shaik
	 *
	 */
	public class JavaUtility {
		/**
		 * This method will generate random number for every execution
		 * @ return
		 */
		public int getRandomNumber()
		{
			Random r = new Random();
			int num = r.nextInt(1000);
			return num;
		}
		/**
		 * This method will generate system date and it will return the value
		 * @return
		 */
		public String getSystemDate() {
			Date date=new Date();
			String d = date.toString();
			return d;
		}
		public String getSystemDateInFormat() {
			Date date=new Date();
		String[] dArr=date.toString().split(" ");
		String day=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		String currentDateAndTime=day+"-"+month+"-"+year+"-"+time;
		return currentDateAndTime;
		}
	}

