package com.travel_Insurance.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.insurance.utils.excelData;
import com.insurance.utils.helperClass;
import com.travel_Insurance.pageObjects.carInsurancePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class carInsuranceStepDefination {

	carInsurancePage cp;
	WebDriver driver;
	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";
	
	@Given("User should be in Policy bazaar home page")
	public void user_should_be_in_policy_bazaar_home_page() {
		
		cp= new carInsurancePage(helperClass.getDriver());
	}

	@When("User clicks on Car Insurance in policy bazaar home page")
	public void user_clicks_on_car_insurance_in_policy_bazaar_home_page() throws Exception {
	    
		cp.carInsButton();
		
	}

	@Then("User verifies title of Car insurance page")
	public void user_verifies_title_of_car_insurance_page() throws Exception {
		

		String cartitle = cp.pageTitle();		// Calling the pageTitle method 
		Assert.assertEquals("PolicyBazaar Car Insurance: Insure Your Car Today", cartitle);		//verifying the title page
	}

	@When("User clicks on View prices button without giving car number in box")
	public void user_clicks_on_view_prices_button_without_giving_car_number_in_box() {
	    
		cp.viewPriceButton();
		
	}

	@Then("capture the error message displayed")
	public void capture_the_error_message_displayed() throws Exception {
		
	    String err=cp.invalidCarNoErr();
	    Assert.assertEquals("Please enter a valid car number", err);
	    helperClass.Screenshot("carnumberError");
	    excelData.setCellData(file, "Sheet1", 9, 0, err);
	    
	}

	@When("User clicks on View prices button by giving valid {string} in box")
	public void user_clicks_on_view_prices_button_by_giving_valid_in_box(String carNo) {
	    
		cp.carNoTxtBx(carNo);
		cp.viewPriceButton();
	}

	@When("User selects car details {string},{string},{string},{string},{string} in car insurance")
	public void user_selects_car_details_in_car_insurance(String carbnd, String crmdl, String crfuel, String crvariant, String cryear) throws Exception {
	   
		cp.carBrand(carbnd);
		cp.carModel(cryear);
		cp.carFuelType(crfuel);
		cp.carVariantType(cryear);
		cp.carRegyear(cryear);
	}
	
	@When("User enters valid {string} in fullname box {string} in email box and {string} in mobileno box")
	public void user_enters_valid_in_fullname_box_in_email_box_and_in_mobileno_box(String fname, String mail, String mobno) {
	    
		cp.fullNamereg(fname);
		cp.email(mail);
		cp.mobileNo(mobno);
		
	}

	@Then("User captures error message if email is invalid")
	public void user_captures_error_message_if_email_is_invalid() {
		try 
		{	
		String ermsg=cp.emailerrMsg();
		Assert.assertEquals("Please enter a valid e-mail ID.", ermsg);
		helperClass.Screenshot("emailaddressErrorSS");
		excelData.setCellData(file, "Sheet1", 11, 0, ermsg);
		
		}
		catch(Exception e)
		{
			
		}
	}

	@Then("User captures error message if mobile number is invalid")
	public void user_captures_error_message_if_mobile_number_is_invalid() {
		try
		{
		String ermsg=cp.errMobNo();
		Assert.assertEquals("Please enter a valid 10-digit mobile number.", ermsg);
		System.out.println(ermsg);
		}
		catch(Exception e)
		{
			
		}
		
	}

	@Then("User validate if all details valid details and click on next")
	public void user_validate_if_all_details_valid_details_and_click_on_next() {
	   
		 cp.viewprices();
		
		
	}

	@When("User clicks on policy bazaar to go back home")
	public void user_clicks_on_policy_bazaar_to_go_back_home() {
	  
		cp.backhome();
		
	}

	@Then("User verifies title of policy bazaar again after redirection")
	public void user_verifies_title_of_policy_bazaar_again_after_redirection() {
		String value = cp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", value);	
		
	}
}
