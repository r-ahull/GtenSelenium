package javaDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Staticdropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/select-input.php");
		Thread.sleep(3000);
		WebElement drop = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select s = new Select(drop);
	    s.selectByIndex(0);
	    System.out.println(s.getFirstSelectedOption().getText());
	    s.selectByVisibleText("Yellow");
	    System.out.println(s.getFirstSelectedOption().getText());

	    s.selectByValue("Green");
	    System.out.println(s.getFirstSelectedOption().getText());

	    
		
	}

}
