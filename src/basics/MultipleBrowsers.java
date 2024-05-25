package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowsers {

	public static void main(String[] args) {

		String browserName = "chrome";
		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("msedge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("not a valid browser");
		}

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.quit();
	}

}
