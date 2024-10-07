package com.medicalApp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
* @FunctionName : Browser_Initialization
* @Description : This class implements the browser setup and configuration for test automation.
*                It provides functionality to:
*                1. Load and manage test configuration properties
*                2. Initialize web drivers for different browsers
*                3. Set up browser configurations and timeouts
*                4. Manage browser lifecycle
*
*                Key features:
*                - Supports multiple browsers (Chrome, Firefox)
*                - Configurable through properties file
*                - Handles browser window management
*                - Sets up implicit waits and page load timeouts
*                - Provides cleanup functionality
*
* @CreationDate : October 3, 2024
* @Author : Bhavani Y
* @Version : 1.0
*/
public class Browser_Initialization {
	public static WebDriver driver;
	public static Properties prop;

	/*
	 * Here inside the Testbase constructor we are creating the object for the prop
	 * and fileinputstream by providing the path of the config file
	 */
	public Browser_Initialization() {
		
		try {
			// how to read a property file
			prop = new Properties();
			String configFilePath = System.getProperty("user.dir") + "/Configuration/Config_properties";

			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * In Initialization method we are launching the browser by using if and else if
	 * condition, after launching the browser user is maximizing the window and
	 * waiting for sometime and later providing the required url by providing the config file path
	 */
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
		//***************************************APP STATE ONSTART***************************************
		String browserName = prop.getProperty("browserName");
		if (browserName.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("WebDriver.Fire.Fox", "E:/Bhavani/chromedriver-win64/chromedriver.exe");
			// driver = new GeekoDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtile.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtile.IMPLICIT_WAIT, TimeUnit.SECONDS);

		//driver.manage().timeouts().pageLoadTimeout(TestUtile.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtile.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	}
