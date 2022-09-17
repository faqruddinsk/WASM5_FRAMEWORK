package V_tiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
public static void main(String[] args) throws IOException {
	//step-1 load the file location into file input stream
	FileInputStream fls=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	
	//step-2  
	Properties pobj=new Properties();
	
	//step-3
	pobj.load(fls);
	
	//step-4
	String s=pobj.getProperty("browser");
	System.out.println(s);
	
	System.out.println(pobj.getProperty("username"));
}
}
