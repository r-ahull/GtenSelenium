package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCommands {

	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Ctrl+shift+o -> bring appropriate imports
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//opens a url
		driver.get("https:amazon.com/");
		
		// grab a title
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		
		 System.out.println( driver.getCurrentUrl());
		 
		 Thread.sleep(2000);
		
		 //will always close the current window/ tab
		 driver.close();
		 
		//will close entire browser
		driver.quit();
		
		
	}
}
