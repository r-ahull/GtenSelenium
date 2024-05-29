package javaDriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	    driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("rahulsharma145@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("rahul123");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//a[@href=\"/apparel-shoes\"]")).click();
		List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-title']"));
		for (WebElement items : products) {
		System.out.println(items.getText());

			if (items.getText().equals("Blue Jeans")) {
		driver.findElement(By.xpath("(//input[contains(@class,'product-box-add-to')])[3]")).click();
		Thread.sleep(2000);
				
				
			}
			
			

		}
		
		driver.close();

	}
}


