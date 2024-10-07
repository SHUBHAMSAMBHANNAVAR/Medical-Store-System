package com.medicalApp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @FunctionName : Launching the required browser 
 * @Description  : Launching the required browsers by giving the path or extension of the driver.
 * @CreationDate : 26-09-2024
 * @Parameter    : String SP
 * @author       : Bhavani Y
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
	
	//***************************************APP STATE ONFINISH***************************************
		public static void OnFinish(WebDriver driver) throws InterruptedException
		{
			driver.quit();
		}

	}
