package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/");

		// to Grab text of web element
		WebElement heading = driver.findElement(By.xpath("//*[@class='main-heading']"));
		String text = heading.getText();

		System.out.println(text);

		// to grab attribute value of any attribute
		String titleVal = driver.findElement(By.xpath("//*[@class='selc-flight-options']/li[2]/a"))
				.getAttribute("title");

		System.out.println(titleVal);
		
		System.out.println(heading.getCssValue("font-size"));
		driver.quit();

	}

}
