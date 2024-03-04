package com.travel_Insurance.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.insurance.utils.excelData;
import com.insurance.utils.helperClass;
import com.travel_Insurance.pageObjects.healthInsurancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class healthInsuranceStepdefination {

	healthInsurancePage hp;
	WebDriver driver;
	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";
	 
	@Given("User should be in policy bazaar home page for health insurance")
	public void user_should_be_in_policy_bazaar_home_page_for_health_insurance() {
		hp= new healthInsurancePage(helperClass.getDriver());
	}

	@When("User clicked on Insurance Products dropdown")
	public void user_clicked_on_insurance_products_dropdown() {
	    hp.insProddpdn();
	}

	@Then("User store all the health insurance menu in dropdown displayed")
	public void user_store_all_the_health_insurance_menu_in_dropdown_displayed() throws Exception {
	    
		List<String> list=hp.getList();
		int i=0;
		for(String s:list)
		{
			excelData.setCellData(file, "Sheet1", i+19, 0, s);
			i=i+1;
		}
	    
	    
	}

	@When("User clicked on health insurance  and navigated to health insurance page")
	public void user_clicked_on_health_insurance_and_navigated_to_health_insurance_page() {
	    hp.healthinsClick();
	}

	@Then("User verify title of health insurance page")
	public void user_verify_title_of_health_insurance_page() {
	    String title=hp.pageTitle();
	    Assert.assertEquals("Health Insurance: Compare & Buy Medical Insurance Plans @ ₹8/Day*", title);
	}
	
	@Then("user  provided valid data with {string},{string},{string},{string},{string},{string},{string}")
	public void user_provided_valid_data_with(String mem, String age, String cty, String fname, String wrngMobNo, String invmobNo, String validMobNo) {
	    
		hp.insureWho(mem);
	    hp.insureWhoCntnBtn();
	    hp.ageSelect(age);
	    hp.ageCntnBtn();
	    hp.cities(cty);
	    hp.genderBtn();
	    hp.name(fname);
	   
	    hp.mobno(wrngMobNo);
	    String wrngMbnoErr=hp.mobNoErrmsg();
	    Assert.assertEquals("Please enter valid mobile number", wrngMbnoErr);  

	    hp.mobno(invmobNo);
	    String invMbnoErr=hp.mobNoErrmsg();
	    Assert.assertEquals("Seems like you have entered an invalid number", invMbnoErr);
	    hp.mobno(validMobNo);
	    
	}

	@Then("click on continue")
	public void click_on_continue() {
	    
		hp.cntnBtnPrsnDet();
		hp.wtsappBtn();
		hp.medicalHist();
	}


	@Then("sort results as low to high and capture the first three insurance packages and providers")
	public void sort_results_as_low_to_high_and_capture_the_first_three_insurance_packages_and_providers() throws Exception {
	   hp.filters();
	   hp.listname();
	   hp.planslist();
	}


	@Given("user navigates to health insurances details page")
	public void user_navigates_to_health_insurances_details_page() {
		hp= new healthInsurancePage(helperClass.getDriver());
		hp.insProddpdn();
		hp.healthinsClick();
		hp.insureWho("Self");
		hp.insureWhoCntnBtn();
		hp.ageSelect("22 Years");
		hp.ageCntnBtn();
		hp.cities("Hyderabad");
		hp.genderBtn();
		hp.name("priya");
		hp.validMobNo("9876543453");
		hp.cntnBtnPrsnDet();
		hp.wtsappBtn();
		hp.medicalHist();
		
	}
	

}
