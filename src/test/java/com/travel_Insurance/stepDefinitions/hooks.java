package com.travel_Insurance.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.insurance.utils.helperClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	

	static WebDriver driver;
	static Properties p;
	
	// Method executed once before all scenarios
	@Before
	public static void setup() throws IOException
    { 
    	driver=helperClass.initializeBrowser();		// Initialize the WebDriver  
     	p=helperClass.getProperties();		// Initializing the Properties object
    	driver.get(p.getProperty("appURL"));		// Navigating to the application URL specified in the properties file
    	driver.manage().window().maximize();		// Maximizing the browser window	
	}
	
	
	// Method executed once after all scenarios
    @After
    public static void tearDown() {
        		
       driver.quit();		// Closing the WebDriver instance
       
    }
    
    
    //Method executed after each step in a scenario
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if(!scenario.isFailed()) {
        	TakesScreenshot ts=(TakesScreenshot) driver;		// Taking a screenshot using the WebDriver
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);		// Getting the screenshot as bytes
        	scenario.attach(screenshot, "image/png",scenario.getName());		// Attaching the screenshot to the scenario
        	            
        }
    }

}
