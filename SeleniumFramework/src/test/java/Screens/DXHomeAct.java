package Screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DXHomeAct {

	WebDriver driver;		

	By DX_journeyOnewaytype=By.id("tab-one-way");
	By DX_multiDestination=By.id("tab-multi-city");
	By DX_journeyReturntype=By.id("tab-round-trip");
	By DX_fromCity =By.id("airport-selection-origin");
	By DX_toCity=By.id("airport-selection-destination");
	By DX_paxCount=By.className("passenger-selection-button");
	By DX_paxCountBTN=By.className("btn-increment");
	By DX_depDate=By.id("dxp-flight-search-dates-outbound");
	By DX_retDate=By.id("dxp-flight-search-dates-inbound");
	By DX_cabinClass=By.xpath("//div[@class='class-selection']");
	By DX_econonmy=By.xpath("//div[contains(text(),'Economy')]");
	By DX_business=By.xpath("//div[contains(text(),'Business')]");
	By DX_premiumEconomy=By.xpath("//div[contains(text(),'Premium Economy')]");
	By DX_buttonSubmit=By.id("searchSubmit");

	public  void joureny_Type(String journeyType) throws Exception {

		if (journeyType.equalsIgnoreCase("oneway")) {

			driver.findElement(DX_journeyOnewaytype).click();
		}

		else if (journeyType.equalsIgnoreCase("return")) {

			driver.findElement(DX_journeyReturntype).click();
		}

		else if (journeyType.equalsIgnoreCase("multi")) {

			driver.findElement(DX_journeyReturntype).click();
		}

		else 
		{
			throw new Exception ("incorrect journey type");
		}

	}

	public void select_Cabin(String cabin) throws Exception {

		driver.findElement(DX_cabinClass).click();
		if (cabin.equalsIgnoreCase("Economy")) {

			driver.findElement(DX_econonmy).click();
		}

		else if (cabin.equalsIgnoreCase("business")) {

			driver.findElement(DX_business).click();
		}

		else if (cabin.equalsIgnoreCase("premium economy")) {

			driver.findElement(DX_premiumEconomy).click();
		}

		else 
		{
			throw new Exception ("incorrect journey type");
		}

	}



	public void from_City(String Fcity) {

		driver.findElement(DX_fromCity).sendKeys(Fcity);
		driver.findElement(DX_fromCity).sendKeys(Keys.ENTER);
	}

	public void to_City(String Tcity) {
		driver.findElement(DX_toCity).sendKeys(Tcity);
		driver.findElement(DX_toCity).sendKeys(Keys.ENTER);

	}

	public void paxCount(int adt, int chd, int inf)
	{

		driver.findElement(DX_paxCount).click();
		List<WebElement> DX_paxType=driver.findElements(DX_paxCountBTN);
		if (adt>0) 
		{
			for (int i = 1; i < adt; i++) 
			{
				DX_paxType.get(0).click();
			}
		}

		if (chd>0) 
		{
			for (int i = 1; i <= adt; i++) 
			{
				DX_paxType.get(1).click();
			}
		}

		if (inf>0) 
		{
			for (int i = 1; i <= adt; i++) 
			{
				DX_paxType.get(2).click();
			}
		}
		driver.findElement(DX_paxCount).click();
	}

	public void depDate(String dd, String Month) throws InterruptedException
	{

		driver.findElement(DX_depDate).click();
		WebElement month= driver.findElement(By.xpath("//button[@class='dp-nav-view dp-cell']//span[2]"));
		
		while (!month.getText().contains(Month))
		{
			driver.findElement(By.xpath("//button[@class='dp-next-nav dp-nav-cell dp-cell']")).click();	
		}

		WebElement dateWidgetFrom = driver.findElement(By.className("dp-table-body"));
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));	
		//System.out.print(columns.size());	
		Thread.sleep(2000);

		for (WebElement cell: columns) {

			if (cell.getText().equals(dd) && cell.isEnabled()) {
				cell.click();
				//cell.
				break;
			}
		}	
	}
	
	
	
	public void retDate(String dd, String Month) throws InterruptedException
	{

		driver.findElement(DX_retDate).click();
		WebElement month= driver.findElement(By.xpath("//button[@class='dp-nav-view dp-cell']//span[2]"));
		
		while (!month.getText().contains(Month))
		{
			driver.findElement(By.xpath("//button[@class='dp-next-nav dp-nav-cell dp-cell']")).click();	
		}

		WebElement dateWidgetFrom = driver.findElement(By.className("dp-table-body"));
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));	
		//System.out.print(columns.size());	
		Thread.sleep(2000);

		for (WebElement cell: columns) {

			if (cell.getText().equals(dd) && cell.isEnabled()) {
				cell.click();
				//cell.
				break;
			}
		}	
	}
	
	
	
	public void clickSubmit()

	{
		driver.findElement(DX_buttonSubmit).click();
	}


	public DXHomeAct(WebDriver driver)
	{
		this.driver=driver;
	}

}
