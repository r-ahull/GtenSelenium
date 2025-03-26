package pageobjectmodules;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PageAction;
import utils.TestProperties;
import utils.UniqueGenerator;

public class TicketPlusFoodbookingPage extends PageAction {
	WebDriver driver;

	public TicketPlusFoodbookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
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

	@FindBy(xpath = " //h2[normalize-space()='SUPERBOYS OF MALEGAON']")
	private WebElement moviename;

	@FindBy(xpath ="(//*[contains(text(),'See detail')])[1]")
	private WebElement seedetails;

	@FindBy(xpath =" (//*[contains(text(),'Buy tickets')])[2]")
	private WebElement buytickets;

	@FindBy(css = "div[class*='mf-schedules-rounded-full mf-schedules']")
	private WebElement timing;

	@FindBy(xpath ="(//*[name()='svg'][@class='mf-seats-h-full mf-seats-w-full'])[9]")
	private WebElement selectseat;

	@FindBy (xpath = "(//p[@class='mf-cart-w-full mf-cart-text-white mf-cart-text-base mf-cart-font-bold'] | //*[contains(text(), 'Select my tickets')])[2]")
	private WebElement Selectticketbtn;

	@FindBy (xpath = "(//*[@class='flex items-center'])[3]")
	private WebElement termsncondition;

	@FindBy (xpath ="(//button[contains(@class,'bg-')])[7]")
	private WebElement foodskip;

	@FindBy (xpath ="(//label[contains(@class,'mf-schedules-cursor-pointer mf-schedules-text-base mf-schedules-leading-[19px] mf-schedules-font-bold mf-schedules-tracking-[-1%] mf-schedules-text-cinepolis-primary-100')])[1]")
	private WebElement todayDate;

	@FindBy (xpath ="//h4[@class='mf-foods-menu-text-h4 mf-foods-menu-text-cinepolis-blue mf-foods-menu-font-bold mf-foods-menu-w-full mf-foods-menu-flex mf-foods-menu-items-center']")
	private WebElement drinkoptn;

	@FindBy (id = "nombre")
	private WebElement name;
	@FindBy(id="apellido")
	private WebElement lastname;
	@FindBy (id ="correo")
	private WebElement email;
	@FindBy(css = "input[id='phone']")
	private WebElement phone;
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	private WebElement continuebtn;
	
	@FindBy(xpath ="//*[contains(@class,'mf-foods-menu-leading-5 mf-foods-menu-line-clamp')]")
	private WebElement FoodText;
	
	@FindBy(xpath ="(//*[contains(@class,'stroke-white')])[2]")
	private WebElement plusbtn;
	
	@FindBy (xpath ="//*[contains(@class,'flex items-center')] //*[contains(text(),'Add to cart')]")
	private WebElement addTocart;
	
	@FindBy(xpath="//div[contains(@class,'mf-cart-bg-white mf-cart-cart')] //*[contains(text(),'Continue')]")
	private WebElement continuecartbtn;
	
	@FindBy (xpath ="//*[contains(@class,'text-center font-bold text-dark-blue-grey text')]")
	private WebElement productcount;
	
	@FindBy (xpath ="//*[@class='mf-cart-text-cinepolis-blue mf-cart-font-bold']")
	private WebElement foodnamefromcart;
	
	@FindBy (xpath ="//*[contains(@class,'text-center font-bold text-dark-blue-grey text')]")
	private WebElement cartproductcount;
	
	@FindBy(xpath ="(//*[@class=\"mf-locations-text-light-blue\"])[1]")
	private WebElement checksearchoption1;
	 @FindBy(css= "h2[id='radix-:rd:']")
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


	public Map<String, String> verifycinemaa() throws IOException {
		
		Map<String, String> resultData = new HashMap<>();
		IsElementDisplayed(checksearchoption1);
		clickelement(locationbuttn);
		getText(serchcity , TestProperties.getProperty("cityname"));
		clickelement(selectcity);
		shortWait();
		clickelement(selectcinema);
		IsElementDisplayed(checklocation2);
		clickelement(Applyselection);
		clickelement(Acceptbtn);
		String datee =showText(todayDate);
		verifyseatselection();
		resultData.put("date", datee);
		return resultData;
	}

	public void verifyseatselection() {
		
		clickelement(seedetails);
		IsElementDisplayed(buytickets);
		clickelement(buytickets);
		IsElementDisplayed(timing);
		clickelement(timing);
		clickelement(selectseat);
		clickelement(Selectticketbtn);
		clickelement(termsncondition);

	}

	public void setpersonalDetails() {
		
		getText(name,UniqueGenerator.setUniquename());
		getText(lastname,UniqueGenerator.setUniquelastname());
		getText(email,UniqueGenerator.getuniqueemail());
		getText(phone,UniqueGenerator.setPhoneNo());
		javaScriptClickElement(continuebtn);
	}

	public Map<String, String> checkforFood() {
		Map<String,String> mapdata = new HashMap<>();
		
		String foodcheck =showText(FoodText);
		System.out.println(foodcheck);
		clickelement(FoodText);
		clickelement(plusbtn);
		String itemcount =showText(productcount);
		clickelement(addTocart);
		String cartfoodname =showText(foodnamefromcart);
		String caartproductcount =showText(cartproductcount);
		clickelement(continuecartbtn);
		mapdata.put("foodText", foodcheck);
		mapdata.put("pcount", itemcount);
		mapdata.put("Cfood", cartfoodname);
		mapdata.put("Citemcount", caartproductcount);
		
		return mapdata;
	}

	
	}

