package com.travel_Insurance.stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.insurance.utils.helperClass;
import com.travel_Insurance.pageObjects.travelinsurancePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class travelInsuranceStepDefination {
	
	travelinsurancePage tp;
	WebDriver driver;
	@Given("User navigate to policy bazaar website")
	public void user_navigate_to_policy_bazaar_website() throws IOException {
		
	    tp= new travelinsurancePage(helperClass.getDriver());
	}

	@Then("User verifies title of policy bazaar page")
	public void user_verifies_title_of_policy_bazaar_page() {
		
		String value = tp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", value);		//verifying the title page
	}

	@When("User clicks on Travel Insurance button in policy bazaar home page")
	public void user_clicks_on_travel_insurance_button_in_policy_bazaar_home_page() throws Exception {
		
		tp.travelInsButton();
	   
	}

	@Then("User Verifies title of Travel Insurance page")
	public void user_verifies_title_of_travel_insurance_page() {
		
		String traveltitle = tp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("PolicyBazaar Travel Insurance", traveltitle);		//verifying the title page
		
	}

	@When("User enters {string} of European countries in destination box and click on next  in travel page")
	public void user_enters_of_european_countries_in_destination_box_and_click_on_next_in_travel_page(String destname) {
	  
		tp.destination(destname);	
	}

	@When("User selects dates from calender for start and end in Travel Insurance page Trip {string}{string}{string}{string}")
	public void user_selects_dates_from_calender_for_start_and_end_in_travel_insurance_page_trip(String smonyr, String sdate, String emonyr, String edate) throws Exception {
		
		
		tp.calender(smonyr, sdate, emonyr, edate);
		
	}
	

	@When("User selects number of people travelling")
	public void user_selects_number_of_people_travelling() {
	    
		tp.numberOfages();
	    
	}

	@When("User accordingly select ages of people in respective age dropdowns shown when clicked on age boxes")
	public void user_accordingly_select_ages_of_people_in_respective_age_dropdowns_shown_when_clicked_on_age_boxes() {
	   
		tp.agesdpdntxtbx("22 years","21 years");
		
	}

	@When("User clicks on Proceed to medical history after selecting age of people")
	public void user_clicks_on_proceed_to_medical_history_after_selecting_age_of_people() {
		tp.agesnextbtn();
		
	}

	@When("User clicks no radio button  in medical history part")
	public void user_clicks_no_radio_button_in_medical_history_part() {
	   tp.medicalHistory();
	}

	@When("User enters valid {string} in mobilenumber box and click viewplans in contact details")
	public void user_enters_valid_in_mobilenumber_box_and_click_viewplans_in_contact_details(String mobileno) {
	    tp.contactDetails(mobileno);
	    tp.viewplansbutton();
	    
	}


	@When("User clicks on Student plan Traveller check boxes and select plans")
	public void user_clicks_on_student_plan_traveller_check_boxes_and_select_plans() throws Exception {
	    
		tp.studentplans();
		tp.studentplanscheckbxs();
		tp.popup();
		
	}

	@When("User clicks on Sort by button and selects Premium low to high dropdown in policy bazaar")
	public void user_clicks_on_sort_by_button_and_selects_premium_low_to_high_dropdown_in_policy_bazaar() {
	   tp.sortBy();
	}

	@When("User store the details insurance provider company name and amount of first {int} insurance plans")
	public void user_store_the_details_insurance_provider_company_name_and_amount_of_first_insurance_plans(Integer int1) throws Exception {
	   tp.insDetails();
	}

	@When("User clicks on policy bazaar icon")
	public void user_clicks_on_policy_bazaar_icon() {
		tp.backHome();
	}

	@Then("User verifies title of redirected page")
	public void user_verifies_title_of_redirected_page() {
		
		String value = tp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", value);		//verifying the title page
	}
	

}
