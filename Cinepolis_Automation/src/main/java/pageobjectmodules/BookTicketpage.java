package pageobjectmodules;

import java.io.IOException;
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

public class BookTicketpage extends PageAction{
	WebDriver driver;
public BookTicketpage(WebDriver driver) {
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

@FindBy(xpath ="(//span[contains(@class,'mf-seats-flex mf-seats-h-full mf-seats-w-full mf-seats-items-center')])[25]")
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

@FindBy(xpath ="//*[contains(@class,'mf-movie-detail-font-extrabold mf-movie-detail-text')]")
private WebElement movienametext;

@FindBy (xpath ="//*[contains(@class,'mf-cart-font-bold mf-cart-leading')]")
private WebElement cartmoviename;

@FindBy(xpath ="(//*[contains(@class,'mf-cart-text-primary')])[1]")
private WebElement cartseatname;

@FindBy (xpath = "//*[contains(@class,'mf-schedules-cursor-pointer mf-schedules-text-base')]")
private  List<WebElement> futuredate;


public String verifycinema() throws IOException {
	
	clickelement(locationbuttn);
	getText(serchcity , TestProperties.getProperty("cityname"));
	clickelement(selectcity);
	shortWait();
	clickelement(selectcinema);
	clickelement(Applyselection);
	clickelement(Acceptbtn);
	String date =showText(todayDate);
	return date;
}

public Map<String, String> verifyseatselection() {
	Map<String,String> map = new HashMap<>();
	clickelement(seedetails);
	String moiveText =showText(movienametext);
	clickelement(buytickets);
	String dateText =clickRandomElementExceptFirst(futuredate);
	System.out.println(dateText);
	clickelement(timing);
	clickelement(selectseat);
	String seatText=showText(selectseat);
	clickelement(Selectticketbtn);
	clickelement(termsncondition);
	map.put("moviename", moiveText);
	map.put("seatname", seatText);
	map.put("fDate", dateText);
	
	return map;
}

public void setpersonalDetails() {
	
	getText(name,UniqueGenerator.setUniquename());
	getText(lastname,UniqueGenerator.setUniquelastname());
	getText(email,UniqueGenerator.getuniqueemail());
	getText(phone,UniqueGenerator.setPhoneNo());
	javaScriptClickElement(continuebtn);
}

public Map<String, String> verifymoviename() {
	Map<String , String> mapcartlist = new HashMap<>();
	//String foodcheck =showText(drinkoptn);
	String cartmovienametext =showText(cartmoviename);
	String Cartseatname =showText(cartseatname);
	System.out.println(Cartseatname);
	String [] splitedseat =Cartseatname.split("B");
	String cartseatnumber =splitedseat[1];
	//System.out.println(foodcheck);
	//clickelement(foodskip);
	//mapcartlist.put("FoodOption", foodcheck);
	mapcartlist.put("cartmoviename", cartmovienametext);
	mapcartlist.put("cartseatname", cartseatnumber);
	
	return mapcartlist;
}

}
