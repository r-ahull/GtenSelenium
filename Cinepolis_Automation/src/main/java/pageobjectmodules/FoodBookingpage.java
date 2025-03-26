package pageobjectmodules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.APIRequest;
import utils.PageAction;
import utils.TestProperties;
import utils.UniqueGenerator;

public class FoodBookingpage extends PageAction {
	String testCaseKey = "GC-TC30";
    String testCycle = "GC-C37";
    String iteration = "Iteration 1";
	
	WebDriver driver;
	public FoodBookingpage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath ="(//button[contains(@class,'flex justify-center items-center')])[2]")
	private WebElement foodoption;
	
	@FindBy (xpath ="//*[contains(text(),'Traditional Menu')]")
	private WebElement foodmenu;
	
	@FindBy(xpath="//*[contains(@class,'mf-foods-menu-h-auto')]")
	private WebElement foodoptn;
	
	@FindBy (xpath ="(//*[contains(@class,'stroke-white')])[2]")
	private WebElement plusbtn;
	
	@FindBy(xpath ="(//*[contains(@class,'stroke-white')])[1]")
	private WebElement minusbtn;
	
	@FindBy (xpath ="//*[contains(@class,'flex items-center')] //*[contains(text(),'Add to cart')]")
	private WebElement addTocart;
	@FindBy(xpath="//div[contains(@class,'mf-cart-bg-white mf-cart-cart')] //*[contains(text(),'Continue')]")
	private WebElement continuebtn;
	@FindBy (id = "nombre")
	private WebElement name;
	@FindBy(id="apellido")
	private WebElement lastname;
	@FindBy (id ="correo")
	private WebElement email;
	@FindBy(css = "input[id='phone']")
	private WebElement phone;
	@FindBy(xpath="//div[@id ='InfoPersonal'] //*[contains(text(),'Continue')]")
	private WebElement paycontinuebtn;
	By elementlocator = By.xpath("//*[contains(@class,'mf-foods-menu-h-auto')]");
	@FindBy(xpath="//button[contains(@class, 'mf-locations-minimal-trigger')]")
	private WebElement locationbuttn;

	@FindBy(css ="input[aria-placeholder=\"Search by city or cinema\"]")
	private WebElement serchcity;

	@FindBy(xpath="//*[text() =\"Mumbai\"]")
	private WebElement selectcity;

	@FindBy(xpath = "//li[1]//div[1]//label[1]//div[1]")
	private WebElement selectcinema;

	@FindBy(xpath = "//*[contains(@class,\"Dialog_mf-locations-DialogFooter__N2ceP\")] | //*[contains(text(),'Apply Selection')]")
	private WebElement Applyselection;

	@FindBy (xpath ="(//div[contains(text(),'Accept')])[2]")
	private WebElement Acceptbtn;
	
	@FindBy (xpath ="//*[contains(@class,'text-center font-bold text-dark-blue-grey text')]")
	private WebElement productcount;
	
	@FindBy(xpath = "//*[contains(@class,'mf-foods-menu-leading-5 mf-foods-menu-line-clamp')]")
	private WebElement productname;
	
	@FindBy (xpath = "(//*[contains(@class,'mf-cart-text-cinepolis-blue mf-cart-font-bold')])[1]")
	private WebElement cartproductname;
	
	@FindBy (xpath ="//*[contains(@class,'text-center font-bold text-dark-blue-grey text')]")
	private WebElement cartproductcount;
	
	@FindBy (xpath ="//p[contains(@class,'mf-locations-text-')]")
	private WebElement cinemalocation;
	
	@FindBy(xpath ="(//*[@class=\"mf-locations-text-light-blue\"])[1]")
	private WebElement checksearchoption1;
	 @FindBy(css= "//*[contains(@class,'Dialog_mf-locations-DialogHeaderTitle')]")
	 private WebElement checklocation2;
	 @FindBy(xpath ="//*[contains(text(),'Foods')]")
	 private WebElement checkfoodoptn3;
	 @FindBy(xpath="//*[contains(@class,'mf-foods-menu-h-auto')]")
	 private WebElement checkfoodmenu4;
	 @FindBy(xpath="(//*[contains(@class,'mf-cart-text-lg mf-cart-font-semibold mf-cart-text-white')])[1]")
	 private WebElement checkcartoption5;
	 @FindBy(xpath ="(//*[contains(@class,'cursor-poiner flex justify-center items-center hover:bg-light-blue')])[1]")
	 private WebElement checkminusbtn6;
	 @FindBy (xpath = "(//*[contains(@class,'mf-cart-text-cinepolis-blue mf-cart-font-bold')])[1]")
	private WebElement checkcartproductname7;
	@FindBy(xpath ="//*[contains(text(),'Personal data')]")
	private WebElement checkpersonaldetl8;
	
	@FindBy(xpath="//div[@id ='InfoPersonal'] //*[contains(text(),'Continue')]")
	private WebElement checkpaycontinuebtn9;
	
	By drinkss = By.xpath("(//font[contains(text(),'Drinks')])[2]");
	By continuee = By.xpath("//*[contains(@class,'mf-foods-menu-h-auto')]");
	
	public Map<String, String> moveFoodtoCart() throws IOException {
		Map<String,String> maplist = new HashMap<>();
		IsElementDisplayed(checkfoodoptn3);
		mouseHover(foodoption);
		javaScriptClickElement(foodmenu);
		scrollToCenterView(elementlocator);
		IsElementDisplayed(checkfoodmenu4);
		IsElementDisplayed(checkcartoption5);
		javaScriptClickElement(foodoptn);
		clickelement(plusbtn);
		String productCount =showText(productcount);
		clickelement(addTocart);
		scrollToView(cinemalocation);
		IsElementDisplayed(checkminusbtn6);
		String foodname =showText(productname);
		String cartitemname =showText(cartproductname);
		String cartitemcount =showText(cartproductcount);
		javaScriptClickElement(continuebtn);
		maplist.put("fooditemname", foodname);
		maplist.put("cartfoodname", cartitemname);
		maplist.put("productcount", cartitemcount);
		maplist.put("pcount", productCount);
		return maplist;
	}
	
	public void setpersonalDetails() {
		IsElementDisplayed(checkpersonaldetl8);
		getText(name,UniqueGenerator.setUniquename());
		getText(lastname,UniqueGenerator.setUniquelastname());
		getText(email,UniqueGenerator.getuniqueemail());
		getText(phone,UniqueGenerator.setPhoneNo());
		isElementEnabled(checkpaycontinuebtn9);
		clickelement(paycontinuebtn);
	}
	
	public void selectCinema() throws IOException {
		List<Map<String, Object>> stepResults = new ArrayList<>();
		isElementDisplayed(checksearchoption1,1,"search for city available", testCaseKey, testCycle, iteration, stepResults);
		clickelement(locationbuttn);
		getText(serchcity , TestProperties.getProperty("cityname"));
		clickelement(selectcity);
		shortWait();
		clickelement(selectcinema);
		isElementDisplayed(checklocation2,2,"cinema name is visible",testCaseKey, testCycle, iteration, stepResults);
		clickelement(Applyselection);
		clickelement(Acceptbtn);
		APIRequest.updateTestStepStatus(testCaseKey, testCycle, iteration, stepResults);
	}
	
	
	}
	

