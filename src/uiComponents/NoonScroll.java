package javaDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoonScroll {
	static WebDriver driver;

	
		

		public static void main(String [] org) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Open the website
			driver.get("https://www.noon.com/uae-en/");

			// Define the XPath for the target element
			String targetXPath = "//h2[text()='Bestsellers in beauty']";

			// Loop until the target element is found
			while (!checkExistence(targetXPath, 2)) {
			    // Scroll down the page
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,1000)", "");
			}

			// If the target element is displayed, print its text
			if (driver.findElement(By.xpath(targetXPath)).isDisplayed()) {
			    System.out.println(driver.findElement(By.xpath(targetXPath)).getText());
			}
			driver.quit();
			}

			// Function to scroll to a specific element
			/*public static void scroll(WebElement element) {
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].scrollIntoView(true);", element);
			}*/

			// Function to check if an element exists
			public static boolean checkExistence(String xpath, long timeOutInSeconds) {
			    boolean exists = !driver.findElements(By.xpath(xpath)).isEmpty();
			    return exists;
			}

	}


