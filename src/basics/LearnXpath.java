package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnXpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://demowebshop.tricentis.com/");
		
		/**
		 * xpath syntaxes
		 * 
		 * 1.  //tagname[@attribute='value'] or //*[@attribute='value']
		 * 2.  //tagname[@attribute1='value1']////tagname[@attribute2='value2']
		 * 3.  parent/child 
		 * 4. parent[index]/child[index]
		 *
		 */
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys("obsqura24@gmail.com");
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("mypassword");
		driver.findElement(By.xpath("//*[@class='buttons']//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("(//ul[@class='list'])[1]/li[3]/a")).click();

	}

}
