package com.travel_Insurance.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.insurance.utils.excelData;
import com.insurance.utils.helperClass;
import com.travel_Insurance.pageObjects.carInsurancePage;
import com.travel_Insurance.pageObjects.healthInsurancePage;
import com.travel_Insurance.pageObjects.travelinsurancePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class smokeAndRegressionStepdefination {

	travelinsurancePage tp;
	carInsurancePage cp;
	healthInsurancePage hp;
	WebDriver driver;
	
	String file=System.getProperty("user.dir")+"/src/test/resources/outputs.xlsx";
	
	@Given("user navigates policy bazaar homepage")
	public void user_navigates_policy_bazaar_homepage() {
		tp= new travelinsurancePage(helperClass.getDriver());
	}

	@When("user clicked on travel insurance link and navigated to destination page")
	public void user_clicked_on_travel_insurance_link_and_navigated_to_destination_page() throws Exception {
	    
		tp.travelInsButton();
		String traveltitle = tp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("PolicyBazaar Travel Insurance", traveltitle);		//verifying the title page
		
		
	}

	@When("user Entered valid destination {string} in text box")
	public void user_entered_valid_destination_in_text_box(String string) {
		
	    tp.destination(string);
	    
	}

	@Then("user selects the place from dropdown and clicks next button1")
	public void user_selects_the_place_from_dropdown_and_clicks_next_button1() {
		//tp.destDpdn();

	}

	@Given("user navigates to trip dates page")
	public void user_navigates_to_trip_dates_page() throws Exception {

		tp= new travelinsurancePage(helperClass.getDriver());
		tp.travelInsButton();
		tp.destination("Italy");
		Thread.sleep(3000);
		
	}

	@When("user selects the start and end dates from the calender {string}{string}{string}{string}")
	public void user_selects_the_start_and_end_dates_from_the_calender(String smonyr, String sdate, String emonyr, String edate) throws Exception {

		tp.tripEnterDates();
	}

	

	@Then("clicks on next button in tripdate page")
	public void clicks_on_next_button_in_tripdate_page(io.cucumber.datatable.DataTable dataTable) {
	    
		tp.navigateTotravellPage();	
	    
	}


	@Given("user navigates to traveller page")
	public void user_navigates_to_traveller_page() throws Exception {
		
		tp= new travelinsurancePage(helperClass.getDriver());
		tp.travelInsButton();
		tp.destination("Italy");
		tp.tripEnterDates();
		tp.navigateTotravellPage();
		
	}

	@When("user selects {string} people")
	public void user_selects_people(String string) {
	    tp.numberOfages();
	}

	@When("selects their respective ages")
	public void selects_their_respective_ages() {
		tp.agesdpdntxtbx("22 years","21 years");
	}

	@Then("clicks on next button in traveller page")
	public void clicks_on_next_button_in_traveller_page() {
		tp.agesnextbtn();
	}


	@Given("user navigates to medical history page")
	public void user_navigates_to_medical_history_page() throws Exception {
		tp= new travelinsurancePage(helperClass.getDriver());
		tp.travelInsButton();
		tp.destination("Italy");
		tp.tripEnterDates();
		tp.navigateTotravellPage();
		tp.numberOfages();
		tp.agesdpdntxtbx("22 years","21 years");
		tp.agesnextbtn();
	}

	@When("user select either of value i.e yes\\/no")
	public void user_select_either_of_value_i_e_yes_no() {
	   
		tp.medicalHistory();
	}

	@Then("clicks on next button in medical history")
	public void clicks_on_next_button_in_medical_history() {
	    
		System.out.println("done");
	}

	@Given("user navigates to contact details page")
	public void user_navigates_to_contact_details_page() throws Exception {
	   
		tp= new travelinsurancePage(helperClass.getDriver());
		tp.travelInsButton();
		tp.destination("Italy");
		tp.tripEnterDates();
		tp.navigateTotravellPage();
		tp.numberOfages();
		tp.agesdpdntxtbx("22 years","21 years");
		tp.agesnextbtn();
		tp.medicalHistory();
	}

	@When("user enters valid phone number in text box")
	public void user_enters_valid_phone_number_in_text_box() {
	  
		tp.contactDetails("9876234567");
	}

	@When("user uncheck on whatsapp button to not get notifications")
	public void user_uncheck_on_whatsapp_button_to_not_get_notifications() {
	    
		tp.whtsapp();
	}

	@Then("user clicks on view plans button and user navigated to results page")
	public void user_clicks_on_view_plans_button_and_user_navigated_to_results_page() { 
	   
		tp.viewplansbutton();
		String listpage=tp.pageTitle();
		Assert.assertEquals("PolicyBazaar Travel Insurance", listpage);
	}
	
	
	@Given("user is in results page of travel insurance")
	public void user_is_in_results_page_of_travel_insurance() throws Exception {
		tp= new travelinsurancePage(helperClass.getDriver());
		tp.travelInsButton();
		tp.destination("Italy");
		tp.tripEnterDates();
		tp.navigateTotravellPage();
		tp.numberOfages();
		tp.agesdpdntxtbx("22 years","21 years");
		tp.agesnextbtn();
		tp.medicalHistory();
		tp.contactDetails("9876234567");
		tp.whtsapp();
		tp.viewplansbutton();
		
	}

	@When("user clicks on policy bazaar logo")
	public void user_clicks_on_policy_bazaar_logo() {
	    tp.backHome();
		
	}

	@Then("user navigattes to home page of policy bazaar")
	public void user_navigattes_to_home_page_of_policy_bazaar() {
		String homepage=tp.pageTitle();
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", homepage);
		
	}
	///car insurance
	@Given("user navigates to car insurance page")
	public void user_navigates_to_car_insurance_page() throws Exception {
		
		cp= new carInsurancePage(helperClass.getDriver());
		cp.carInsButton();
		cp.carNoTxtBx("TN-23-6543");
		cp.viewPriceButton();
	}
	
	@When("user selects a brand from car brands {string}")
	public void user_selects_a_brand_from_car_brands(String carbnd) {
		cp.carBrand("KIA");
	}
	
	
	@When("user navigate to model name page")
	public void user_navigate_to_model_name_page() {
		cp.carBrand("KIA");
		
	}

	@Then("user selects the model name")
	public void user_selects_the_model_name() {
		
	    cp.carModel("Sonet");
	}

	
	@When("user verifies fueltype page")
	public void user_verifies_fueltype_page() {
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
		
	}

	@Then("user selects fueltype name")
	public void user_selects_fueltype_name() {
		cp.carFuelType("Diesel");
	}

	
	@When("user verifies variantType page")
	public void user_verifies_variant_type_page() {
	   
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	}

	@Then("user selects a variantType")
	public void user_selects_a_variant_type() {
	    
		cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	}
	
	@When("user verifies registeredyear page")
	public void user_verifies_registeredyear_page() {
	  
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	    cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	}

	@Then("user selects a registeredyear")
	public void user_selects_a_registeredyear() {
	    
		cp.carRegyear("Brand New Car");
	}
	
	@When("user click on view prices button")
	public void user_click_on_view_prices_button() {
	    
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	    cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	    cp.carRegyear("Brand New Car");
	    cp.viewprices();
	    cp.fullNamereg("a");
	}

	@Then("user capture error messages of all details")             //car insurance
	public void user_capture_error_messages_of_all_details() throws Exception {
	   
		String ermsgname=cp.nameError();
		System.out.println(ermsgname);
		excelData.setCellData(file, "Sheet2", 2, 0, ermsgname);
		
		String ermsgmail=cp.emailerrMsg();
		System.out.println(ermsgmail);
		helperClass.Screenshot("smokecarcontactdetails error");	
		excelData.setCellData(file, "Sheet2", 3, 0, ermsgmail);
		
		String ermsgmob=cp.errMobNo();
		System.out.println(ermsgmob);
		excelData.setCellData(file, "Sheet2", 4, 0, ermsgmob);
		
	}
	
	
	@When("user enters valid fullname, email and invalid phoneno")
	public void user_enters_valid_fullname_email_and_invalid_phoneno() {
	    
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	    cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	    cp.carRegyear("Brand New Car");
	    cp.viewprices();
	    cp.fullNamereg("abcde");
		cp.email("abc@gmail.com");
		cp.mobileNo("");
	    cp.viewprices();
	    
	}

	@Then("user capture error message of invalid phoneno")
	public void user_capture_error_message_of_invalid_phoneno() throws Exception {
	   
		String ermsgmob=cp.errMobNo();
		System.out.println(ermsgmob);
		
		helperClass.Screenshot(" car insurance mobilenumber error ");
		excelData.setCellData(file, "Sheet2", 6, 0, ermsgmob);
		
	}
	
	@When("user enters valid fullname, phone and invalid email")
	public void user_enters_valid_fullname_phone_and_invalid_email() {
	   
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	    cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	    cp.carRegyear("Brand New Car");
	    cp.fullNamereg("abcd");
		cp.email("abc");
		cp.mobileNo("9876545675");
	    cp.viewprices();
	}

	@Then("user capture error message invalid mail")
	public void user_capture_error_message_invalid_mail()  throws Exception {
	  
		String ermsgmail=cp.emailerrMsg();
		System.out.println(ermsgmail);
		
		helperClass.Screenshot("email error ");
		
		excelData.setCellData(file, "Sheet2", 8, 0, ermsgmail);
	}

	@Given("user is in car contact details page")
	public void user_is_in_car_contact_details_page() throws Exception {
	   
		cp= new carInsurancePage(helperClass.getDriver());
		cp.carInsButton();
		cp.carNoTxtBx("TN-23-6543");
		cp.viewPriceButton();
		cp.carBrand("KIA");
	    cp.carModel("Sonet");
	    cp.carFuelType("Diesel");
	    cp.carVariantType("GTX Plus 1.5 AT (1493 cc) ");
	    cp.carRegyear("Brand New Car");
	    cp.fullNamereg("abcd");
		cp.email("abc@gmail.com");
		cp.mobileNo("9876545675");
	    cp.viewprices();
	}

	@When("user clicks on policy bazaar icon")
	public void user_clicks_on_policy_bazaar_icon() {
	    
		cp.backhome();
	}

	@Then("user navigates to home page of policy bazaar")
	public void user_navigates_to_home_page_of_policy_bazaar() {
	    
		String value = cp.pageTitle();		// Calling the pageTitle method in the login page
		Assert.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", value);	
	}
	
	//health insurance
	
	@Given("User should be in health insurance insurance who page")
	public void user_should_be_in_health_insurance_insurance_who_page() {
	   
		hp= new healthInsurancePage(helperClass.getDriver());
		hp.insProddpdn();
		hp.healthinsClick();
		
	}

	@When("user clicks on select self as a member")
	public void user_clicks_on_select_self_as_a_member() {
	    
		hp.insureWho("Self");
	}

	@Then("user clicks on continue button in insurance page")
	public void user_clicks_on_continue_button_in_insurance_page() {
	    
		hp.insureWhoCntnBtn();
	}

	
	@Given("user navigates to age page")
	public void user_navigates_to_age_page() {
	    
		hp= new healthInsurancePage(helperClass.getDriver());
		hp.insProddpdn();
		hp.healthinsClick();
		hp.insureWho("Self");
		hp.insureWhoCntnBtn();
	}

	@When("user selects age from drop down")
	public void user_selects_age_from_drop_down() {
	 
		hp.ageSelect("22 Years");
	}

	@When("user click on continue button in age page")
	public void user_click_on_continue_button_in_age_page() {
	    
		 hp.ageCntnBtn();
	}


	@Given("user navigates to city page")
	public void user_navigates_to_city_page() {
	    
		hp= new healthInsurancePage(helperClass.getDriver());
		hp.insProddpdn();
		hp.healthinsClick();
		hp.insureWho("Self");
		hp.insureWhoCntnBtn();
		hp.ageSelect("22 Years");
		hp.ageCntnBtn();
	}

	@When("user selects city from popular cities and clicks on continue button")
	public void user_selects_city_from_popular_cities_and_clicks_on_continue_button() {
		hp.cities("Hyderabad");
	}

	@When("user enters valid name and phone number in textboxes in contact details")
	public void user_enters_valid_name_and_phone_number_in_textboxes_in_contact_details() {
	    
		hp.cities("Hyderabad");
		hp.genderBtn();
		hp.name("priya");
		hp.validMobNo("9876543453");
		
	}

	@Then("user clicks on continue button in contact page")
	public void user_clicks_on_continue_button_in_contact_page() {
		hp.cntnBtnPrsnDet();
	}

	@When("user unchecks whatsapp button and select noneofthese in medical history")
	public void user_unchecks_whatsapp_button_and_select_noneofthese_in_medical_history() {
	   
		hp.wtsappBtn();
		hp.medicalHist();
	}

	//regression
	
	@When("user enters valid name and invalid phone number in textboxes in health contact details")          //health insurance
	public void user_enters_valid_name_and_invalid_phone_number_in_textboxes_in_health_contact_details() throws Exception {
	    
			hp.cities("Hyderabad");
			hp.genderBtn();
			hp.name("priya");
			hp.mobno("1234567891");
		    String wrngMbnoErr=hp.mobNoErrmsg();
		    Assert.assertEquals("Please enter valid mobile number", wrngMbnoErr);
		    helperClass.Screenshot("hotel insurance wrong number");
		    excelData.setCellData(file, "Sheet2", 10, 0, wrngMbnoErr);
		    hp.mobno("9876543456");
		    String invMbnoErr=hp.mobNoErrmsg();
		    Assert.assertEquals("Seems like you have entered an invalid number", invMbnoErr);
		    helperClass.Screenshot("hotel insurance invalid number");
		    excelData.setCellData(file, "Sheet2", 12, 0, invMbnoErr);
		    
	}
	
	@When("user enters invalid phone number")
	public void user_enters_invalid_phone_number() {
	    
		tp.contactDetails("0987654321");
	}

	@Then("user captures error message displayed")      //travel insurance insurance
	public void user_captures_error_message_displayed() {
	    
		String err=tp.error();
		Assert.assertEquals("Please enter valid Mobile no.", err);
		
	}
	
	
	@When("User click on Student plan Traveller check boxes and select plans")
	public void user_click_on_student_plan_traveller_check_boxes_and_select_plans() throws Exception {
		tp.studentplans();
		tp.studentplanscheckbxs();
		tp.popup();
	}

	@When("User click on Sort by button and selects Premium low to high dropdown in policy bazaar")
	public void user_click_on_sort_by_button_and_selects_premium_low_to_high_dropdown_in_policy_bazaar() {
		tp.sortBy();
	}

	@When("User stores the details insurance provider company name and amount of first {int} insurance plans")
	public void user_stores_the_details_insurance_provider_company_name_and_amount_of_first_insurance_plans(Integer int1) throws Exception {
		tp.insDetails();
	}
}
