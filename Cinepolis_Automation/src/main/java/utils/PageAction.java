package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageAction {

	WebDriver driver;
	WebDriverWait wait;
	
	public PageAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@FindBy(css = ".ico-register")
	WebElement register;

	public void waituntildisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waituntilclick(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickelement(WebElement element) {
		waituntildisplayed(element);
		waituntilclick(element);
		element.click();

	}

	public void getText(WebElement element, String value) {
		waituntildisplayed(element);
		waituntilclick(element);
		element.sendKeys(value);

	}

	public void enterLongText(WebElement element, long value) {
		waituntildisplayed(element);
		element.sendKeys(String.valueOf(value));
	}

	public String showText(WebElement element) {
		waituntildisplayed(element);
		return element.getText();
	}

	public boolean IsElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public List<String> getlisteditems(List<WebElement> element) {
		List<String> Actuallist = new ArrayList<String>();
		for (WebElement item : element) {
			Actuallist.add(item.getText().toLowerCase());

		}
		return Actuallist;
	}

	public void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void dropdown(WebElement element) {
		Select s = new Select(element);

		s.selectByVisibleText("Name: A to Z");

	}

	public void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(0,100)");
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollUntilElementVisible(By locator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		while (!element.isDisplayed()) {
			// Scroll down the page
			jsExecutor.executeScript("window.scrollBy(0,100)");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickElement(WebElement... elements) {
		for (WebElement element : elements) {
			waituntildisplayed(element);
			waituntilclick(element);
			element.click();
		}
	}

	public void longWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void mouseHover(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover over element: " + e.getMessage());
        }
    
}
	
	public void javaScriptClickElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	
	public void scrollToCenterView(By locator) {
		WebElement element = driver.findElement(locator);
		int elementHeight = element.getSize().getHeight();
		Point location = element.getLocation();
		int windowHeight = driver.manage().window().getSize().getHeight();
		int scrollOffset = (location.getY() + elementHeight / 2) - (windowHeight / 2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + scrollOffset + ");");
	}

	public static String clickRandomElementExceptFirst(List<WebElement> elements) {
        if (elements == null || elements.size() <= 1) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size() - 1) + 1;
        String elementText = elements.get(randomIndex).getText();
        elements.get(randomIndex).click();
		return elementText;
    }
	
	public static boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            System.out.println("Element not enabled: " + e.getMessage());
            return false;
        }
    }
	
	public boolean isElementDisplayed(WebElement element, int stepNumber, String stepDescription, String testCaseKey, String testCycle, String iteration, List<Map<String, Object>> stepResults) {
	    boolean isDisplayed = false;
	    String stepStatus = "Fail"; // Default to Fail
	    String actualResult = "Element not found";

	    try {
	        isDisplayed = element.isDisplayed();
	        stepStatus = "Pass";
	        //= isDisplayed ? "Pass" : "Fail";
	        actualResult = isDisplayed ? "Element displayed successfully" : "Element not visible";
	    } catch (Exception e) {
	        System.out.println("Element not found: " + stepDescription);
	    }

	    // 🔹 Store step result for API update
	    Map<String, Object> stepData = new HashMap<>();
	    stepData.put("sNo", stepNumber);
	    stepData.put("status", stepStatus);
	    stepData.put("actualResult", actualResult);
	    stepResults.add(stepData);

	    return isDisplayed;
	}
	
}
