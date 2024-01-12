package utilities;


import org.apache.commons.configuration2.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesUtils {
    
	public static String GetBaseURL() {
		Properties prop = new Properties();
		FileInputStream file = null;
		{
			try {
				file = new FileInputStream("./src/test/resources/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String baseURL = prop.getProperty("baseURL");
		return baseURL;
	}
	
	public static String GetToken() {
		Properties prop = new Properties();
		FileInputStream file = null;
		{
			try {
				file = new FileInputStream("./src/test/resources/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String token = "Token token=" + prop.getProperty("token");
		return token;
	}
	
	public static Properties GetUserLoginInfo() {
		Properties prop = new Properties();
		FileInputStream file = null;
		{
			try {
				file = new FileInputStream("./src/test/resources/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}