package cinepolisTest;

	

	import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageobjectmodules.BookTicketpage;
import pageobjectmodules.FoodBookingpage;
import pageobjectmodules.TicketPlusFoodbookingPage;
import utils.TestProperties;

	public class BaseTest {
		WebDriver driver;
		String prop ;
		
		
	     @BeforeMethod
	   //  @Parameters("browser")
		public void initializer() {
			String browser = "Chrome";
			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}

			else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			else {
				System.out.println("not a valid browser");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			driver.manage().window().maximize();
			picker();
			driver.get("https://cinepolis.com/in");
		}
	     
	     @BeforeSuite
	 	public void presetUp() throws IOException {
	 		 prop = TestProperties.getProperty("String");
	     }
	     public BookTicketpage bookticket;
	     public FoodBookingpage foodbookingpage;
	     public TicketPlusFoodbookingPage ticketplusfoodbooking;
	   /*  public Login lgn;
	     public ItemAdd crt;
	     public RegisterationPage registerPage;
	     public LandingPage landing;
	     public EmailaFriend emailfriends;
	     public Daimond diamond;
	     public WildestSignup wild;*/
	     
	    public void picker() {
	      bookticket = new BookTicketpage(driver);
	      foodbookingpage = new FoodBookingpage(driver);
	      ticketplusfoodbooking= new TicketPlusFoodbookingPage(driver);
	    /*  crt = new ItemAdd(driver);
	      registerPage = new  RegisterationPage(driver);
	      landing = new LandingPage(driver);
	      emailfriends = new EmailaFriend(driver);
	      diamond = new Daimond(driver);
	      wild = new WildestSignup(driver);
	     }*/
	    }
	     
	     @AfterMethod
	     public void tearDown() {
	      driver.quit();
	     }
	     
	     
	}


