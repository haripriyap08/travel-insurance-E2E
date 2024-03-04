package com.insurance.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.util.Properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class helperClass {
	static WebDriver driver; // declaring the Webdriver to driver variable
	static Scanner sc = new Scanner(System.in); // taking input from the user
	static Properties p; // declaring the properties to props variable
	static FileReader reader; // declaring the FileReader to reader variable
	public static WebDriver initializeBrowser() throws MalformedURLException {
			if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS..");
			}
			// browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static WebDriver getDriver() {
		return driver; // return driver instance
	}
	public static Properties getProperties() {
		try {
			reader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			p = new Properties(); // setting properties to props variable
			p.load(reader); // loading the properties file
		} catch (Exception e) { // catch exception if properties file not found
		}
		return p; // return properties
	}
	 public static void Screenshot(String name) throws Exception
	    {
	    	TakesScreenshot ts = (TakesScreenshot) driver;		// Taking a screenshot using the WebDriver
			File source = ts.getScreenshotAs(OutputType.FILE);
		    String dest = System.getProperty("user.dir") +"/Screenshots/"+name+".png"; 		// Setting destination path for the screenshot
		    File destination = new File(dest);
		    FileUtils.copyFile(source, destination); 
	    }
}


/*
public class helperClass {

	static WebDriver driver;
	static Properties p;
	static int val;

	// Method to initialize a WebDriver instance based on the browser specified in
	// the configuration file.
	public static WebDriver initilizeBrowser() throws IOException {

		switch (getProperties().getProperty("browser").toLowerCase()) // Switch statement to determine the browser to
																		// initialize.
		{
		case "chrome":
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--disable-blink-features=AutomationControlled");
			options1.addArguments("--disable-notifications");
			driver = new ChromeDriver(); // Initialize ChromeDriver if browser is Chrome.
			break;
		case "edge":
			driver = new EdgeDriver(); // Initialize EdgeDriver if browser is Edge.
			break;
		case "firefox":
			driver = new FirefoxDriver(); // Initialize FirefoxDriver if browser is Firefox.
			break;
		default:
			System.out.println("No matching browser"); // Print message if no matching browser is found.
			driver = null;
		}
		driver.manage().deleteAllCookies(); // Delete all cookies before starting the browser session.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait time for WebDriver.

		return driver; // Return the initialized WebDriver instance.

	}

	// Method to get the current WebDriver instance.
	public static WebDriver getDriver() {
		return driver;
	}

	// Method to load properties from the configuration file.
	public static Properties getProperties() {
		try {
			FileReader file = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"); // Read configuration
																									// file.

			p = new Properties(); // Initialize Properties instance.
			p.load(file); // Load properties from the file.

		} catch (Exception e) {
			// Handle any exceptions that might occur while loading properties.
		}
		return p; // Return the loaded Properties instance.
	}

	public static void Screenshot(String name) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver; // Taking a screenshot using the WebDriver
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Screenshots/" + name + ".png"; // Setting destination path for
																						// the screenshot
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
	}

	// Method to decode a Base64 encoded string.
	public static String Decoder(String str) {
		Base64.Decoder decoder = Base64.getUrlDecoder(); // Initialize Base64 decoder.
		String dStr = new String(decoder.decode(str)); // Decode the input string.
		return dStr; // Return the decoded string.
	}

}
*/