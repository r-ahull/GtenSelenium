package javaDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
	
	public static void main(String[] args) {
	    WebDriver driver = null;

		String browser = "Edge";
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}
		
		driver.close();

	}

}
