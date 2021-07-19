package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Utils {

    //if the class is not accessing any non static members by default method should be static
	//we can call static method by using class name
	public static String getPPTValue(String key) {
		String v="";	
		Properties p = new Properties();

		try {
			p.load(new FileInputStream(Iconstant.PPT_PATH)); //calling path from Iconstant Interface
			v = p.getProperty(key);
		} 
		catch (Exception e) {
		}
		return v;

	}

}
