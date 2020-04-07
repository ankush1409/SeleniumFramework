package Test;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Screens.DXHomeAct;

public class ExtentReport_TestNG {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;;
	ExtentTest test;

	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extentTestNG.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("DXFlight Search", "Test Search");

		// creates a toggle for the given test, adds all log events under it    


	}


	@BeforeTest
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
		//	System.out.print(driver.getTitle());

		test.log(Status.INFO, "Launch DX)");


		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("Test1.png");
		Thread.sleep(5000);
	}


	@Test

	public void flightSearchtest() {

		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
		DXHomeAct homeOBJ=new DXHomeAct(driver);
		try {
			homeOBJ.joureny_Type("return");
			homeOBJ.from_City("Bangkok");
			homeOBJ.to_City("SGN");
			homeOBJ.select_Cabin("business"); 
			homeOBJ.paxCount(1, 1, 0);
			homeOBJ.depDate("10", "May");
			homeOBJ.retDate("10", "June");

			test.log(Status.INFO, "Search Flight)");
			// log with snapshot
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
			// test with snapshot
			test.addScreenCaptureFromPath("Test2.png");

			homeOBJ.clickSubmit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test		
	public void flightlist() {
		boolean present;
		try {
			present=driver.findElement(By.xpath("//button[contains(text(),'more results')]")).isDisplayed();
		
		} catch (NoSuchElementException e) {
			present = false;
			throw new SkipException("more results not available");
		}

		if (present) 
		{

			driver.findElement(By.xpath("//button[contains(text(),'more results')]")).click();
			//driver.findElement(By.xpath("//*[@id=\"dxp-flight-table-section\"]/div[12]/button")).click();
		}
		
		List<WebElement> flightrow = driver.findElements(By.className("itinerary-part-offer-header"));
		System.out.print("\n Flight Rows");
		List<WebElement> fltbutton = flightrow.get(0).findElements(By.xpath("//div[@class='itinerary-part-offer-prices']/div/div/button"));
				
		System.out.print("\n");
		
		System.out.print(flightrow.size() + "\n" + "\n buttoncount" + fltbutton.size() + "\n" + fltbutton.get(0).getText());
		

	}



	@AfterTest
	public void closeBrowser() throws Exception {

		driver.close();
		driver.quit();
		//System.out.println("Test Completed");
		test.log(Status.INFO, "closebrowser");
		// log with snapshot
		test.pass("Browser Closed");
		// test with snapshot
		//test.addScreenCaptureFromPath("Test3.png");

	}


	@AfterSuite	
	public void tearDown() {

		extent.flush();

	}

}
