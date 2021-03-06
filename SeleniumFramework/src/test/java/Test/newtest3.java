package Test;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import Screens.DXHomeAct;

public class newtest3 {


	WebDriver driver =null;
	
	@BeforeTest
	@Parameters("browser")
	
		public void launchDX(String browser) throws Exception {


		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
		}

		else 
		{
			throw new Exception ("incorrect browser");
		}

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.print(driver.getTitle());
	}
	
	
	@Test
	public void flightSearchtest() {

		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
		DXHomeAct homeOBJ=new DXHomeAct(driver);
		try {
			homeOBJ.joureny_Type("oneway");
			homeOBJ.from_City("Bangkok");
			homeOBJ.to_City("SGN");
			homeOBJ.select_Cabin("business"); 
	        homeOBJ.paxCount(1, 1, 0);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest	
	public void closeBrowser() {



		driver.close();
		driver.quit();
		System.out.println("Test Completed");

	}



}
