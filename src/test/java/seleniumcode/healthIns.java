package seleniumcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class healthIns {

	public static WebDriver driver;
	public static void healthInsurance() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize(); 
		
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
		
//		WebElement Age= driver.findElement(By.xpath("//*[@id=\"name_feild\"]/select"));
//		js.executeScript("arguments[0].click();", Age);
//		Select se= new Select(Age);
//		se.selectByValue("22");
		
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
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//Thread.sleep(6000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allfilterBox']")));
		driver.findElement(By.xpath("//div[@class='allfilterBox']")).click();  
		System.out.println("filter clicked");
		
		
		List<WebElement> filter=driver.findElements(By.xpath("//div[@class=\"selectionBoxWrapper\"][1]/div/label/span"));
		for(WebElement f:filter)
		{
			String v=f.getText();
			if(v.equalsIgnoreCase("Premium low to high"))
			{
				f.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[@id=\"ApplyFilter\"]")).click();
		
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='quotes_rvmp_card segmentation_quoteCard ']//div[@class='quotes_rvmp_card__content__plan_header']//span[1]"));
		for(int i=0;i<3;i++)
		{
			String name=list.get(i).getText();
			System.out.println(name);
		}
		
		List<WebElement> amtmon=driver.findElements(By.xpath("//div[@class='quotesRevampCtaWrap']/button"));
		for(int i=0;i<3;i++)
		{
			String amt=amtmon.get(i).getText();
			System.out.println(amt);
		}
		
		driver.quit();
		
		
//     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		
////		System.out.println(driver.getTitle());
////		
//		try 
//		{
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		if(driver.findElement(By.xpath("//div[@class=\"exitIntentInnerNew\"]")).isDisplayed())
//		{
//		driver.findElement(By.xpath("//span[@id='exit-intent-popup-close']")).click();
//		System.out.println("clicked on cross");
//		}
//		}
//		catch(Exception e)
//		{
//			
//		}
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		
//		List<WebElement> inswho=driver.findElements(By.xpath("//div[@class=\"member-for-insurance\"]//li/input"));
//		for(WebElement iw:inswho)
//		{
//			String ele=iw.getAttribute("value").toString();
//			System.out.println(ele);
//			if(ele.equalsIgnoreCase("Self"))
//			{
//				//js.executeScript("arguments[0].click();",iw);
//				iw.click();
//				System.out.println("clicked on self");
//				break;
//			}
//		}
//		
//		
//		Thread.sleep(2000);
//		WebElement cont=driver.findElement(By.xpath("//*[@id=\"health_bu\"]/div[2]/div[3]/div"));
////		js.executeScript("arguments[0].click();",cont);
//		cont.click();
		
		
//		WebElement age=driver.findElement(By.name("member_age"));
//		Select sel=new Select(age);
//		sel.selectByVisibleText("22 Years");
//		
//		driver.findElement(By.xpath("//div[@class=\"button btnHealthStep2\"]")).click();
//		
//		driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();
//		//driver.findElement(By.id("female")).click();
//		driver.findElement(By.xpath("//*[@id='step_4']/div[1]/div[2]/label")).click();
//		
//		driver.findElement(By.xpath("//input[@class='fullWidht txtName labelshow']")).sendKeys("priya");  //name textbox
//		WebElement mobileno=driver.findElement(By.xpath("//li[@id='registration_check']/div[1]//input[@type='tel']"));
//		mobileno.sendKeys("1234567891"); // enter valid number
//		WebElement errmobileno=driver.findElement(By.xpath("//li[@id='registration_check']/div[2]"));   //error msg mobile number
//		String errmsgmobile=errmobileno.getText();
//		System.out.println(errmsgmobile);
//		
//		mobileno.clear();
//		mobileno.sendKeys("9876543234");   //invalid no  seems like invalid number
//		String invaliderr=errmobileno.getText();
//		System.out.println(invaliderr);
//		
//		mobileno.clear();
//		mobileno.sendKeys("9876543453"); //valid
//		
//		driver.findElement(By.xpath("//div[@class=\"button btnHealthStep4\"]")).click();
//		
//		driver.findElement(By.xpath("//label[@for='ped_last']/div")).click();
		
	}
	public static void main(String[] args) throws Exception {
		healthInsurance();

	}

}
