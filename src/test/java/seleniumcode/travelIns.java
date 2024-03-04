package seleniumcode;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class travelIns {
    
	public static WebDriver driver;
	
//	static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public static void checkinout(String monyr,String date)
	{
		try 
		{
		Thread.sleep(2000);
 
		while(true)
		{
			String monyrac=driver.findElement(By.xpath("(//div[@class=\"MuiPickersArrowSwitcher-root MuiPickersDesktopDateRangeCalendar-arrowSwitcher\"]//h6)[1]")).getText();    //path for month and year
			if(monyrac.equals(monyr))
			{
				break;
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")).click();
		}
		
		List<WebElement> alldates=driver.findElements(By.xpath("//span[@class='MuiPickersDay-dayLabel']"));  ///path for all dates
		for(WebElement dt:alldates)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ages(String age1,String age2)
	{ 
	    int n=2;
	    String age = "";
		for(int j=0;j<n;j++)
	    {
			driver.findElement(By.xpath("//div[@id="+j+"]")).click();
			List<WebElement> drpAge=driver.findElements(By.xpath("//div[@class='options_box_wrapper__option']"));
			if(j==0) 
			{
				age=age1;
			}
			else if(j==1)
			{
				age=age2;
			}
			for(int i=0;i<drpAge.size();i++) {
				String str=drpAge.get(i).getText();
				if(str.equals(age))
				{
					drpAge.get(i).click();
					break;
				}
			}
		}
	}
	
	public static void travelins() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//div[@class='prd-icon add shadowHandler short'])[7]")).click();   //travel insurance click
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		String destination="Italy";
		
		WebElement dest=driver.findElement(By.xpath("//input[@id=\"country\"]"));
		
		dest.click();
		dest.sendKeys(destination);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//ul[@class='search-list']/li[1]")).click();
		
		driver.findElement(By.xpath("//button[@class=\"travel_main_cta\"]")).click();
		
		// start date 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		driver.findElement(By.xpath("(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[1]")).click();
		checkinout("April 2024", "24");
		 
		
		//driver.findElement(By.xpath("(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[2]")).click();
		checkinout("May 2024","30");
		
		driver.findElement(By.xpath("//div[@class=\"pqCtaWrapper\"]/button")).click();  //next  calnext
		
		driver.findElement(By.xpath("//div[@class='memSelectRadioWrapper']/div[2]")).click();   //age
		

		ages("22 years","21 years");
		
		driver.findElement(By.xpath("//button[@class='travel_main_cta']")).click();
		//for no radio button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ped_no']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@class='travel_main_cta']")).click();
		
		driver.findElement(By.id("mobileNumber")).sendKeys("9898999654");
		driver.findElement(By.xpath("//div[@class='mobileStepCta']//button")).click();
		

//		
//		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"studentTrip\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"amt-modal\"]//input[@id=\"Traveller_1\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"amt-modal\"]//input[@id=\"Traveller_2\"]")).click();
		
		WebElement plan =driver.findElement(By.id("feet"));
		Select sel=new Select(plan);
		sel.selectByVisibleText("30 Days");
		
//		WebElement plan =driver.findElement(By.xpath("//div[@class='inputRow__input']"));
//		plan.click();
//		driver.findElement(By.xpath("//select/option[text()='30 Days']")).click();
//		
		driver.findElement(By.xpath("//button[@class=\"travel_main_cta\"]")).click(); //apply
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='exitIntentPopup__box__closePop']")).click();
		
		driver.findElement(By.xpath("//section[@class=\"newFilterSection sort\"]")).click();  //sortby click
		List<WebElement> sortby=driver.findElements(By.xpath("//section[@class=\"newFilterSection sort\"]//ul/li"));
		for(WebElement sb:sortby)
		{
			if(sb.getText().equals("Premium low to high"))
			{
				sb.click();
				System.out.println("clicked sortby");
			}
		}
		
		
		List<WebElement> insurname=driver.findElements(By.xpath("//p[@class='quotesCard--insurerName']"));
		List<WebElement> insurAmt=driver.findElements(By.xpath("//span[@class='premiumPlanPrice']"));
		for(int i=1;i<=3;i++) 
		{
				String name=insurname.get(i).getText();
				System.out.print(name);
				
				System.out.print("					");
				
				String amount=insurAmt.get(i).getText();
				System.out.print(amount);
				
				System.out.println();
		}

		driver.findElement(By.xpath("//a[text()=\"Policybazaar\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
	}
	
	
	public static void main(String[] args) throws Exception {
		travelins();
		
	}
	
}


