package seleniumcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class totol {

public static WebDriver driver;
	
//	static JavascriptExecutor js=(JavascriptExecutor) driver;

	public static void driverin() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies(); 
		
		System.out.println(driver.getTitle());
	}	
	
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
	

	public static void travelins() throws InterruptedException
	{
		
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    
		driver.findElement(By.xpath("(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[1]")).click();
		checkinout("April 2024", "24");
		 
		
		//driver.findElement(By.xpath("(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[2]")).click();
		checkinout("May 2024","30");
		
		driver.findElement(By.xpath("//div[@class=\"pqCtaWrapper\"]/button")).click();  //next
		
		driver.findElement(By.xpath("//div[@class='memSelectRadioWrapper']/div[2]")).click();   //age
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[text()='Select age of traveller 1']")).click();  //selecting ages
		List<WebElement> drpAge1=driver.findElements(By.xpath("//div[@class='options_box_wrapper__option']"));
		for(int i=0;i<drpAge1.size();i++) {
			String str=drpAge1.get(i).getText();
			if(str.equals("22 years")) {
				drpAge1.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//div[text()='Select age of traveller 2']")).click();
		List<WebElement> drpAge2=driver.findElements(By.xpath("//div[@class='options_box_wrapper__option']"));
		for(int i=0;i<drpAge2.size();i++) {
			String str=drpAge2.get(i).getText();
			if(str.equals("21 years")) {
				drpAge2.get(i).click();
				break;
			}
		}
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//*[@id=\"studentTrip\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Traveller 1 (22 yrs)']")).click();
		driver.findElement(By.xpath("//label[text()='Traveller 2 (21 yrs)']")).click();
		
		WebElement plan =driver.findElement(By.id("feet"));
		Select sel=new Select(plan);
		sel.selectByVisibleText("30 Days");
				
		driver.findElement(By.xpath("//button[@class=\"travel_main_cta\"]")).click();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.xpath("//span[@class='exitIntentPopup__box__closePop']")).click();
		
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
	
	public static void carins() throws Exception
	{
		
		driver.findElement(By.xpath("(//div[@class='prd-icon add shadowHandler short'])[4]")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[@id=\"btnGetQuotes\"]")).click();
		
		String errormsg=driver.findElement(By.id("error_car_number")).getText();
		
		System.out.println(errormsg);
		
		driver.findElement(By.id("regNoTextBox")).sendKeys("TN-23-6543");
		
		driver.findElement(By.xpath("//button[@id=\"btnGetQuotes\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> carbrand=driver.findElements(By.xpath("//ul[@class=\"slideInRight animated5 manufact-listcb\"]//li/span"));
		for(WebElement cb:carbrand)
		{
			if(cb.getText().equals("KIA"))
			{
				cb.click();
				System.out.println("CLICKED CB");
				break;
			}
		}
		
		List<WebElement> carmodel=driver.findElements(By.xpath("//ul[@class='slideInRight slideInRightanimated model-list']//li/span"));
		for(WebElement cm:carmodel)
		{
			if(cm.getText().equals("Sonet"))
			{
				cm.click();
				System.out.println("CLICKED CM");
				break;
			}
		}
		
		List<WebElement> carfuel=driver.findElements(By.xpath("//div[@id='dvFuelType']/ul//li//span"));
		for(WebElement cf:carfuel)
		{
			if(cf.getText().equals("Diesel"))
			{
				cf.click();
				System.out.println("CLICKED Cf");
				break;
			}
		}
		
		List<WebElement> carVarient=driver.findElements(By.xpath("//div[@id='variantScroll']/li//span"));
		for(WebElement cv:carVarient)
		{
			if(cv.getText().equals("GTX Plus 1.5 AT (1493 cc)"))
			{
				cv.click();
				System.out.println("CLICKED CV");
				break;
			}
		}
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"dvRegYear\"]/ul/div/li[1]")).click();
		
		List<WebElement> carregyr=driver.findElements(By.xpath("//*[@id='dvRegYear']/ul/div/li"));
		for(WebElement cr:carregyr)
		{
			if(cr.getText().equals("2023"))
			{
				cr.click();
				System.out.println("CLICKED Cr");
				break;
			}
		}
		
		WebElement namebox=driver.findElement(By.xpath("//input[@id=\"name\"]"));
		namebox.sendKeys("abcdefgh");
		WebElement emailbox=driver.findElement(By.xpath("//input[@id=\"email\"]"));
		emailbox.sendKeys("abcd");
		WebElement emailerr=driver.findElement(By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[2]/div[2]"));
		System.out.println(emailerr.getText());
		WebElement mobilenobox=driver.findElement(By.xpath("//input[@id=\"mobileNo\"]"));
		mobilenobox.sendKeys("1234");
		WebElement mobileerr=driver.findElement(By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[2]"));
		System.out.println(mobileerr.getText());
		
		
		emailbox.clear();
		emailbox.sendKeys("abcd@gmail.com");
		mobilenobox.clear();
		mobilenobox.sendKeys("9876345667");
		
		driver.findElement(By.xpath("//button[@id='btnLeadDetails']")).click();
		System.out.println("clicked");
		
		driver.findElement(By.xpath("//a[@class=\"pb-logo\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
		
	}
	
	public static void healthInsurance() throws Exception
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
		
		Actions act=new Actions(driver);
		WebElement insprodbutton=driver.findElement(By.xpath("//li[@class=\"ruby-menu-mega shade mr\"]"));
		act.moveToElement(insprodbutton);
		insprodbutton.click();
		
		WebElement insprodheading=driver.findElement(By.xpath("//div[@class='ruby-row']//div[3]/h3/a"));
		String heading=insprodheading.getText();
		
		System.out.println(heading);
		System.out.println("-------------");
		
		List<WebElement> insprods=driver.findElements(By.xpath("//div[@class=\"ruby-row\"]//div[3]/ul/li//span"));
		for(WebElement prod:insprods)
		{
			String products=prod.getText();
			System.out.println(products);
		}
		
		insprodheading.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println(driver.getTitle());
		
		WebElement moreMembers= driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li[11]/span"));
		js.executeScript("arguments[0].click();", moreMembers);
 
		List<WebElement> members =driver.findElements(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li/input")); 
		for(int i=1;i<=members.size();i++) {
			WebElement memberName=driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li["+i+"]/input"));
			if(memberName.getAttribute("value").toString().equalsIgnoreCase("self")) {
				js.executeScript("arguments[0].click();", memberName);
				break;
				}
		    }
 
		WebElement ContinueButton1 = driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[3]/div"));
		js.executeScript("arguments[0].click();", ContinueButton1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement age=driver.findElement(By.name("member_age"));
		Select sel=new Select(age);
		sel.selectByVisibleText("22 Years");
		
		WebElement ContinueButton2 = driver.findElement(By.xpath("//*[@id=\"step_2\"]/div[2]/div"));
		js.executeScript("arguments[0].click();", ContinueButton2);
 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 
		List<WebElement> popularCities = driver.findElements(By.xpath("//*[@id=\"step_3\"]/div[1]/label/input")); 
		for(int i=1;i<=popularCities.size();i++) {
			WebElement ele= driver.findElement(By.xpath("//*[@id=\"step_3\"]/div[1]/label["+i+"]/input"));
			if(ele.getAttribute("value").toString().equalsIgnoreCase("Hyderabad(Telangana)")) {
				js.executeScript("arguments[0].click();", ele);
				break;
		
			}
		}
		
		WebElement gender=driver.findElement(By.xpath("//input[@id=\"female\"]"));
		js.executeScript("arguments[0].click();", gender);   //gender.click();
		if(gender.isSelected())
		{
		System.out.println("clicked on gender");
		}
		else
		{
			System.out.println("not clicked on gender");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//li[@id=\"person_name\"]/div[@id=\"name_feild\"]/input")).sendKeys("priya");  //name textbox  //input[@class='fullWidht txtName labelshow']
		WebElement mobileno=driver.findElement(By.xpath("//li[@id='registration_check']/div[1]//input[@type='tel']"));
		mobileno.sendKeys("1234567891"); // enter valid number
		
		WebElement errmobileno=driver.findElement(By.xpath("//li[@id='registration_check']/div[2]"));   //error msg mobile number
		String errmsgmobile=errmobileno.getText();
		System.out.println(errmsgmobile);
		
		mobileno.clear();
		mobileno.sendKeys("9876543234");   //invalid no  seems like invalid number
		String invaliderr=errmobileno.getText();
		System.out.println(invaliderr);
		
		mobileno.clear();
		mobileno.sendKeys("9876543453"); //valid
 

		WebElement ContinueButton4 = driver.findElement(By.xpath("//*[@id=\"btnHealthStep4\"]"));
		js.executeScript("arguments[0].click();", ContinueButton4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 
		
		WebElement whatsappbutton= driver.findElement(By.xpath("//*[@id=\"step_5\"]/div[4]/label/input"));
		js.executeScript("arguments[0].click();", whatsappbutton);
 
		WebElement medicalhist = driver.findElement(By.xpath("//*[@id=\"ped_last\"]"));
		js.executeScript("arguments[0].click();", medicalhist);
		
	}	
	
	public static void quit()
	{
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		
		driverin();
		travelins();
		carins();
		healthInsurance();

	}
	
}
