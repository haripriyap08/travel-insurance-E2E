package com.travel_Insurance.pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.insurance.utils.excelData;

public class travelinsurancePage extends basePage {

	public travelinsurancePage(WebDriver driver) {
		super(driver);

	}

	int j;

	By tvlInsBtn = By.xpath("(//div[@class='prd-icon add shadowHandler short'])[7]");
	By destBox = By.xpath("//input[@id=\"country\"]");
	By destSuggbox = By.xpath("//ul[@class='search-list']/li[1]");
	By destnextBtn = By.xpath("//button[@class=\"travel_main_cta\"]");
	By StartBox = By.xpath("(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[1]");
	By calNext = By.xpath("//div[@class=\"pqCtaWrapper\"]/button");
	By monyrAcStr = By.xpath(
			"(//div[@class=\"MuiPickersArrowSwitcher-root MuiPickersDesktopDateRangeCalendar-arrowSwitcher\"]//h6)[1]");
	By calArrow = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]");
	By alldatescal = By.xpath("//span[@class='MuiPickersDay-dayLabel']"); /// path for all dates
	By noofAges = By.xpath("//div[@class='memSelectRadioWrapper']/div[2]");
	By ageSelectBox = By.xpath("//div[@id=" + j + "]");
	By dpdnAge = By.xpath("//div[@class='options_box_wrapper__option']");// all ages in dpdn
	By ageContinueBtn = By.xpath("//button[@class='travel_main_cta']");
	By noCheckBox = By.xpath("//*[@id='ped_no']");
	By mobileTxtBox = By.id("mobileNumber");
	By errMsg = By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/p");
	By wtsappBtn = By.xpath("//label[@class='switch slBtn']/span");
	By viewPlansbtn = By.xpath("//div[@class='mobileStepCta']//button");
	By studentplanBtn = By.xpath("//*[@id=\"studentTrip\"]");
	By travellerCkBx1 = By.xpath("//div[@id=\"amt-modal\"]//input[@id=\"Traveller_1\"]");
	By travellerCkBx2 = By.xpath("//div[@id=\"amt-modal\"]//input[@id=\"Traveller_2\"]");
	By stdplanSelectdpdn = By.id("feet");
	By aplyBtn = By.xpath("//button[@class=\"travel_main_cta\"]");
	By popUpBtn = By.xpath("//span[@class='exitIntentPopup__box__closePop']");
	By sortByBtn = By.xpath("//section[@class=\"newFilterSection sort\"]");
	By sortBydpdn = By.xpath("//section[@class=\"newFilterSection sort\"]//ul/li");
	By insNameDet = By.xpath("//p[@class='quotesCard--insurerName']");
	By insAmtDet = By.xpath("//span[@class='premiumPlanPrice']");
	By plcyicon = By.xpath("//a[text()=\"Policybazaar\"]");

	String file = System.getProperty("user.dir") + "/src/test/resources/outputs.xlsx";
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "(//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl\"])[1]/input")
	WebElement fromd;

	// from month and year head
	@FindBy(xpath = "//div[1]/div[1]/h6")
	WebElement fromMonthHead;

	// list of all start dates
	@FindBy(xpath = "//div[1]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]")
	List<WebElement> fromdatelists;

	// End month and year head
	@FindBy(xpath = "//div[2]/div[1]/h6")
	WebElement toMonthHead;

	// list of all end dates
	@FindBy(xpath = "//div[2]/div/div/div/div/div/button[@data-mui-test=\"DateRangeDay\"]/span[1]")
	List<WebElement> todatelists;

	// proceed to traveller page next button
	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement ProceedToTravellers;

	//for clicking on travel insurance button in policy bazaar home page
	public void travelInsButton() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(tvlInsBtn).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);

	}

	//for getting page title
	public String pageTitle() {
		return (driver.getTitle()); // Return the title of the page
	}

	//for selecting destination
	public void destination(String dest) {
		
		WebElement destin = driver.findElement(destBox);
		destin.click();
		destin.sendKeys(dest);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(destSuggbox).click();
		driver.findElement(destnextBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}
	
   // for dates selection in calender
	public void checkinout(String monyr, String date) {
		
		try {
			while (true) {
				String monyrac = driver.findElement(monyrAcStr).getText(); // path for month and year
				if (monyrac.equals(monyr)) {
					break;
				}
				Thread.sleep(2000);
				driver.findElement(calArrow).click();
			}

			List<WebElement> alldates = driver.findElements(alldatescal); /// path for all dates
			for (WebElement dt : alldates) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				if (dt.getText().equals(date)) {
					dt.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//calender start and end date
	public void calender(String smonyr, String sdate, String emonyr, String edate) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(StartBox).click();
		checkinout(smonyr, sdate);
		checkinout(emonyr, edate);
		driver.findElement(calNext).click(); // next calnext

	}

	//selecting dates in trip
	public void tripEnterDates() throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		fromd.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		Calendar fromDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("d");
		String fromMonthYear = formatter.format(fromDate.getTime());
		String from_Date = formatter1.format(fromDate.getTime());
		if (fromMonthHead.getText().toString().equals(fromMonthYear)) {
			for (WebElement ele : fromdatelists) {
				if (ele.getText().toString().equals(from_Date)) {
					ele.click();
					break;
				}
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		fromDate.add(Calendar.DAY_OF_MONTH, 30);
		String toMonthYear = formatter.format(fromDate.getTime());
		String to_Date = formatter1.format(fromDate.getTime());
		WebElement toMonthHead = driver.findElement(By.xpath("//div[2]/div[1]/h6"));
		if (toMonthHead.getText().toString().equals(toMonthYear)) {
			for (WebElement ele : todatelists) {
				if (ele.getText().toString().equals(to_Date)) {
					ele.click();
					break;
				}
			}
		}
	}

	//next button in destination page
	public void navigateTotravellPage() {
		ProceedToTravellers.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	//how many persons ages to be selected
	public void numberOfages() {
		driver.findElement(noofAges).click();
	}

	//selecting ages from dropdowns
	public void agesdpdntxtbx(String age1, String age2) {
		int n = 2;
		String age = "";
		for (int j = 0; j < n; j++) {
			driver.findElement(By.xpath("//div[@id=" + j + "]")).click();
			List<WebElement> drpAge = driver.findElements(dpdnAge);
			if (j == 0) {
				age = age1;
			} else if (j == 1) {
				age = age2;
			}
			for (int i = 0; i < drpAge.size(); i++) {
				String str = drpAge.get(i).getText();
				if (str.equals(age)) {
					drpAge.get(i).click();
					break;
				}
			}
		}

	}

	//next button in age page
	public void agesnextbtn() {

		driver.findElement(ageContinueBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	//medical history
	public void medicalHistory() {
		driver.findElement(noCheckBox).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	//entering mobile number in textbox
	public void contactDetails(String mobileno) {
		WebElement mobilebox = driver.findElement(mobileTxtBox);
		mobilebox.sendKeys(mobileno);

	}

	//error message
	public String error() {

		String err = driver.findElement(errMsg).getText();
		return err;
	}

	//whatsapp button uncheck
	public void whtsapp() {

		driver.findElement(wtsappBtn).click();

	}

	//view plans button
	public void viewplansbutton() {
		driver.findElement(viewPlansbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	//clicking on student plans in filter plan
	public void studentplans() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.findElement(studentplanBtn).click();
	}

	//for selecting options and plans for student in student plans
	public void studentplanscheckbxs() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement t1 = driver.findElement(travellerCkBx1);
		js.executeScript("arguments[0].click();", t1);
		WebElement t2 = driver.findElement(travellerCkBx2);
		js.executeScript("arguments[0].click();", t2);

		WebElement plan = driver.findElement(stdplanSelectdpdn);
		Select sel = new Select(plan);
		sel.selectByVisibleText("30 Days");

		driver.findElement(aplyBtn).click(); // apply
	}

	//pop up
	public void popup() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(popUpBtn).click();
		} catch (Exception e) {

		}
	}

	//for sorting premium low to high
	public void sortBy() {
		driver.findElement(sortByBtn).click(); // sortby click
		List<WebElement> sortby = driver.findElements(sortBydpdn);
		for (WebElement sb : sortby) {
			if (sb.getText().equals("Premium low to high")) {
				sb.click();
				System.out.println("clicked sortby");
			}
		}
	}

	//for storing insurance plans and details of providers
	public void insDetails() throws Exception {
		List<WebElement> insurname = driver.findElements(insNameDet);
		List<WebElement> insurAmt = driver.findElements(insAmtDet);
		for (int i = 1; i <= 3; i++) {

			String name = insurname.get(i).getText();
			System.out.print(name);
			excelData.setCellData(file, "Sheet1", i + 1, 0, name);
			System.out.print("			");
			String amount = insurAmt.get(i).getText();
			System.out.print(amount);
			excelData.setCellData(file, "Sheet1", i + 1, 1, amount);
			System.out.println();
		}
	}

	//clicking on policy bazaar icon
	public void backHome() {
		driver.findElement(plcyicon).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
