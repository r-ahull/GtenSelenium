package uiComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnStaticDropdown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/select-input.php");
		
		//Applicable only for static dropdown/ select dropdown
		
		WebElement staticDropdown=driver.findElement(By.xpath("//*[@id='single-input-field']"));
		
		Thread.sleep(1000);
		Select dropdown= new Select(staticDropdown);
		dropdown.selectByVisibleText("Green");
		Thread.sleep(1000);
		dropdown.selectByValue("Yellow");
		Thread.sleep(1000);
		dropdown.selectByIndex(1);
		
		driver.quit();
		
		
	}

}
