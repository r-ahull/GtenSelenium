package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.util.Constants;

	
	
	public class TestProperties {

	/*	public static String getProperties() throws IOException {
			Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Manish\\eclipse-workspace\\Cinepolis_Automation\\config.properties");
			prop.load(fis);
			String cityname ="Mumbai";
			return cityname;
		}*/

    private static final String CONFIG_PATH = "C:\\Users\\Manish\\eclipse-workspace\\Cinepolis_Automation\\config.properties";
    
    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            prop.load(fis);
        }
        return prop.getProperty(key);
    }
}
		
	

