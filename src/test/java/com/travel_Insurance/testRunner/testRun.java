package com.travel_Insurance.testRunner;

//import org.junit.runner.RunWith;
//import org.testng.annotations.Test;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/featureFile/"},																// Specifying the location of the feature file(s) that contain Gherkin syntax
				 glue= {"com.travel_Insurance.stepDefinitions"} ,																				// Specifying the package containing step definitions
				 plugin={"pretty","html:Cucumberreport/myreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // Plugins for generating different types of reports
				dryRun=false,
				monochrome=true,
				publish=true
		)

//The class extending AbstractTestNGCucumberTests to run Cucumber with TestNG
public class testRun extends AbstractTestNGCucumberTests{

}

