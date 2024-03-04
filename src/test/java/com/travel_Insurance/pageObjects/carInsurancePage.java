package com.travel_Insurance.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class carInsurancePage extends basePage{

	public carInsurancePage(WebDriver driver) 
	{
		super(driver);
	}
	
	By carInsBtn=By.xpath("(//div[@class='prd-icon add shadowHandler short'])[4]");    		
	By viewPriceBtn=By.xpath("//button[@id=\"btnGetQuotes\"]");								
	By carNoErrMsg=By.id("error_car_number");												
	By carNoTxtBox=By.id("regNoTextBox");													
	
	By carBrandnames=By.xpath("//ul[@class=\"slideInRight animated5 manufact-listcb\"]//li/span"); 
	By carModelnames=By.xpath("//ul[@class='slideInRight slideInRightanimated model-list']//li/span"); 
	By carfuelType=By.xpath("//div[@id='dvFuelType']/ul//li//span");								
	By carvarients=By.xpath("//div[@id='variantScroll']/li//span");									
	By caryearreg=By.xpath("//*[@id='dvRegYear']/ul/div/li");										
	By carmodels=By.xpath("//ul[1]/div[@id=\"modelScroll\"]/li");									
	By varientsofcar=By.xpath("//ul[1]/div[@id=\"variantScroll\"]/li");
	
	By fullname=By.xpath("//input[@id=\"name\"]");
	By nameErrmsg=By.xpath("//*[@id='dvVariant']/div[2]/div[1]/div[1]/div[1]");
	By emailaddr=By.xpath("//input[@id=\"email\"]");
	By emailErrmessage=By.xpath("//div[@class=\" customer-detail\"]/div[2]/div[@class=\"msg-error show\"]");
	By phnNoBox=By.xpath("//input[@id=\"mobileNo\"]");
	By errMsgmob=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[1]");
	By viewPriceBtn1=By.xpath("//button[@id='btnLeadDetails']");
	By plcbzIcon=By.xpath("//a[@class=\"pb-logo\"]");
	
	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public void carInsButton() throws Exception
	{
		driver.findElement(carInsBtn).click();														//clicking car insurance button in homepage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	Thread.sleep(2000);		
	}
	
	public String pageTitle() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return(driver.getTitle());												// Returns the title of the page
	}
	
	public void viewPriceButton()
	{
		driver.findElement(viewPriceBtn).click();  				 //view prices button in car insurance page
	
	}
	
	public String invalidCarNoErr()
	{
		String errormsg=driver.findElement(carNoErrMsg).getText();				//getting error message for car number 
		System.out.println(errormsg);
		return errormsg;
		
	}
	
	public void carNoTxtBx(String carnumber)
	{
		driver.findElement(By.id("regNoTextBox")).sendKeys(carnumber);         //entering car number into car number textbox
		
	}
	

	
	public void carBrand(String brandname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> carbrand=driver.findElements(carBrandnames);			 //list of brand names
		for(WebElement cb:carbrand)
		{
			if(cb.getText().equals(brandname))
			{
				cb.click();														//clicking on particular brand name from list
				break;
			}
		}
	}
	
	//selecting car model name
	public void carModel(String modelname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//*[@id=\"modelScroll\"]/li[5]/span")).click();  //clicking on car model in car insurance page

	}
	
	//selecting car fuel type name
	public void carFuelType(String fuelType)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> carfuel=driver.findElements(carfuelType);				//list of car fuel types
		for(WebElement cf:carfuel)
		{
			if(cf.getText().equals(fuelType))
			{
				cf.click();														//clicking on car fuel type 
				break;
			}
		}
		
	}
	
	//selecting car variant page in car insurance page
	public void carVariantType(String varienttype)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"variantScroll\"]/li[2]/span")).click();	//clicking on car variant types in car insurance page
		
	}
	
	//selecting car registered year
	public void carRegyear(String year)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> carregyr=driver.findElements(caryearreg);          //list for car registered years
		for(WebElement cr:carregyr)
		{
			if(cr.getText().equals(year))
			{
				cr.click();													//clicking on car registered year
				break;
			}
		}
	}
	
	//entering name in name text box in car insurance page
	public void fullNamereg(String name)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement namebox=driver.findElement(fullname);					//name textbox 
		namebox.sendKeys(name);												//enters name in the textbox
		namebox.sendKeys(Keys.BACK_SPACE);
	}

	//name error message in car insurance contact page
	public String nameError()
	{
		WebElement nameerr=driver.findElement(nameErrmsg);					
		return (nameerr.getText());  
	}
	
	//sending email address to email text box in car insurance contact page
	public void email(String mail)
	{
		WebElement emailbox=driver.findElement(emailaddr);
		emailbox.sendKeys(mail);
	}
	
	// getting email error message in car insurance contact page
	public String emailerrMsg() throws Exception
	{
		Thread.sleep(1000);
		WebElement emailerr=driver.findElement(emailErrmessage);
		return (emailerr.getText());  
		
	}
	
	//entering mobile number in mobile text box
	public void mobileNo(String phnNo)
	{
		WebElement mobilenobox=driver.findElement(By.xpath("//input[@id=\"mobileNo\"]"));
		mobilenobox.sendKeys(phnNo);
		mobilenobox.sendKeys(Keys.BACK_SPACE);
	}
	
	//getting mobile number error in car insurance contact page 
	public String errMobNo()
	{
		
		WebElement mobileerr=driver.findElement(errMsgmob);
		return (mobileerr.getText());
	}
	
	//clicking on view price button in contact page
	public void viewprices()
	{
		driver.findElement(viewPriceBtn1).click();

	}
	
	//clicking on policy bazaar icon
	public void backhome()
	{
		driver.findElement(plcbzIcon).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
