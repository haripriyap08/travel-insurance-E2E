package com.travel_Insurance.pageObjects;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.insurance.utils.excelData;

public class healthInsurancePage extends basePage{

	public healthInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	By insprodBtn=By.xpath("//li[@class=\"ruby-menu-mega shade mr\"]");
	By insHeading=By.xpath("//div[@class='ruby-row']//div[3]/h3/a");
	By insProdList=By.xpath("//div[@class=\"ruby-row\"]//div[3]/ul/li//span");
	By insHeadingClick=By.xpath("//div[@class='ruby-row']//div[3]/h3/a");
	By moreMemBtn=By.xpath("//*[@id=\"health_bu\"]/div[2]/div[1]/li[11]/span");
	By whoList=By.xpath("//div[@class=\"member-for-insurance\"]//li/input");
	By cntnwho=By.xpath("//*[@id=\"health_bu\"]/div[2]/div[3]/div");
	By selAge=By.name("member_age");
	By cntnAge=By.xpath("//*[@id=\"step_2\"]/div[2]/div");
	By cities=By.xpath("//div[@class='radio_pills dis_popular_city']/label/span");
	By genderBtn=By.xpath("//input[@id=\"female\"]");
	By nameTxtbox=By.xpath("//li[@id=\"person_name\"]/div[@id=\"name_feild\"]/input");
	By mobileNoTxtbx=By.xpath("//li[@id='registration_check']/div[1]//input[@type='tel']");
	By errMobNoMsg=By.xpath("//li[@id='registration_check']/div[2]");
	By prsnlDetCntnBtn=By.xpath("//*[@id=\"btnHealthStep4\"]");
	By wtsapp=By.xpath("//*[@id=\"step_5\"]/div[4]/label/input");
	By mdclHist=By.xpath("//*[@id=\"ped_last\"]");

	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";	
	List<String> elements=new ArrayList<String>();
	 
	//clicking on insurance products in header of policy bazaar
	public void insProddpdn()
	{
		Actions act=new Actions(driver);
		WebElement insprodbutton=driver.findElement(insprodBtn);
		act.moveToElement(insprodbutton);
		insprodbutton.click();
	}
	
	//getting health insurance details
	public List<String> getList()
	{
		WebElement insprodheading=driver.findElement(insHeading);
		String heading=insprodheading.getText();
		elements.add(heading);
		System.out.println(heading);
		System.out.println("-------------");
		List<WebElement> insprods=driver.findElements(insProdList);
		for(WebElement prod:insprods)
		{
			String products=prod.getText();
			System.out.println(products);
			elements.add(products);
			
		}
		return elements;
	}
	
	//clicking on health insurance heading 
	public void healthinsClick()
	{
		driver.findElement(insHeadingClick).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	//for page title
	public String pageTitle() {
		
		return(driver.getTitle());		// Return the title of the page
		
	}
	
	//selecting for whom the insurance is for
	public void insureWho(String mem)
	{
		
		WebElement moreMembers= driver.findElement(moreMemBtn);
		js.executeScript("arguments[0].click();", moreMembers);
		List<WebElement> inswho=driver.findElements(By.xpath("//div[@class=\"member-for-insurance\"]//li/input"));
		for(WebElement iw:inswho)
		{
			String ele=iw.getAttribute("value").toString();
			if(ele.equalsIgnoreCase(mem))
			{
				js.executeScript("arguments[0].click();",iw);
				//iw.click();
				break;
			}
		}
	}
	
	//continue button 
	public void insureWhoCntnBtn()
	{
		WebElement ContinueButton1 = driver.findElement(cntnwho);
		js.executeScript("arguments[0].click();", ContinueButton1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	//selecting age in dropdown
	public void ageSelect(String year)
	{
		WebElement age=driver.findElement(selAge);
		Select sel=new Select(age);
		sel.selectByVisibleText(year);
	}
	
	//continue button
	public void ageCntnBtn()
	{
		WebElement ContinueButton2 = driver.findElement(cntnAge);
		js.executeScript("arguments[0].click();", ContinueButton2);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	//selecting cities
	public void cities(String cty)
	{
		List<WebElement> popularCities = driver.findElements(cities); 
		for(WebElement city:popularCities)
		{
			String place=city.getText();
			if(place.equalsIgnoreCase(cty))
			{
				js.executeScript("arguments[0].click();", city);
				break;
			}
		}

	}
	
	//selecting which gender
	public void genderBtn()
	{
		WebElement gender=driver.findElement(genderBtn);
		js.executeScript("arguments[0].click();", gender);   //gender.click();
		if(gender.isSelected())
		{
		System.out.println("clicked on gender");
		}
		else
		{
			System.out.println("not clicked on gender");
		}
		
	}
	
	//entering name in textbox
	public void name(String fname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(nameTxtbox).sendKeys(fname);
	}
	
	public void wrngMobNo(String wrngMobNo)
	{
		
		WebElement mobileno=driver.findElement(mobileNoTxtbx);
		mobileno.clear();
		mobileno.sendKeys(wrngMobNo);
	}
	
	//mobile number error message
	public String mobNoErrmsg()
	{
		WebElement errmobileno=driver.findElement(errMobNoMsg);   //error msg mobile number
		String errmsgmobile=errmobileno.getText();
		System.out.println(errmsgmobile);
		return errmsgmobile;
		
	}
	
	public void invalidMobNo(String invmobNo)
	{
		WebElement mobileno=driver.findElement(mobileNoTxtbx);
		mobileno.clear();
		mobileno.sendKeys(invmobNo);

		
	}
	
	public void validMobNo(String validMobNo)
	{
		WebElement mobileno=driver.findElement(mobileNoTxtbx);
		mobileno.clear();
		mobileno.sendKeys(validMobNo);
	}
	
	//entering mobile number in mobile text box
	public void mobno(String mob)
	{
		WebElement mobileno=driver.findElement(mobileNoTxtbx);
		mobileno.clear();
		mobileno.sendKeys(mob);
	}
	
	//continue button
	public void cntnBtnPrsnDet()
	{
		WebElement ContinueButton4 = driver.findElement(prsnlDetCntnBtn);
		js.executeScript("arguments[0].click();", ContinueButton4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	//unchecking whatsapp button
	public void wtsappBtn()
	{
		WebElement whatsappbutton= driver.findElement(wtsapp);
		js.executeScript("arguments[0].click();", whatsappbutton);
	}
	
	//clicking medical history 
	public void medicalHist()
	{
		WebElement medicalhist = driver.findElement(mdclHist);
		js.executeScript("arguments[0].click();", medicalhist);
	}
	
	//selecting filter sortby
	public void filters()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
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
	}
	
	//storing names of the health provider names
	public void listname() throws Exception
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='quotes_rvmp_card segmentation_quoteCard ']//div[@class='quotes_rvmp_card__content__plan_header']//span[1]"));
		for(int i=0;i<3;i++)
		{
			String name=list.get(i).getText();
			System.out.println(name);
			excelData.setCellData(file, "Sheet1", i+15, 0, name);
			
		}

	}
	//storing plans amount of the health providers 
	public void planslist() throws Exception
	{
		List<WebElement> amtmon=driver.findElements(By.xpath("//div[@class='quotesRevampCtaWrap']/button"));
		for(int i=0;i<3;i++)
		{
			String amt=amtmon.get(i).getText();
			System.out.println(amt);
			excelData.setCellData(file, "Sheet1", i+15, 1, amt);
		}
	}

}
