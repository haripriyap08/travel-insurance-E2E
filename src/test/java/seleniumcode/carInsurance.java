package seleniumcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class carInsurance {

	public static WebDriver driver;
//	static JavascriptExecutor js=(JavascriptExecutor) driver;
	public static void carins() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize(); 
		
		driver.findElement(By.xpath("(//div[@class='prd-icon add shadowHandler short'])[4]")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[@id=\"btnGetQuotes\"]")).click();   //viewprices btn
		
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
	
	public static void main(String[] args) throws Exception {
		
		carins();
	}

}
