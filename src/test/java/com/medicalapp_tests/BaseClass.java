package com.medicalapp_tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import com.medical.Utilities.BrowserFactory;
import com.medicalApp.util.Browser_Initialization;
import com.medicalapp_reusablesteps.ClickOnMenuBar;
import com.medicalapp_reusablesteps.LoginPage;
import com.medicalapp_reusablesteps.LogOut;
import com.workday.testbase.Testbase;

public class BaseClass extends Browser_Initialization {
	// Declaring the variables
       LoginPage loginpage;
       ClickOnMenuBar menuBar;
       LogOut logout;
	

	/**
	 * This super class will initialize the property and filestreaminput methods and
	 * will create the object of it.
	 */
	public BaseClass() {
	super();
	}

	/**
	 * Inside the base test user is launching the browser through initialize method
	 * and creating the objects for the each methods.
	 * 
	 * @throws InterruptedException
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		// calling the method for launching the browser
		initialization();
		// Creating the object
		loginpage = new LoginPage(driver);
		menuBar = new ClickOnMenuBar(driver);
		logout = new LogOut(driver);
	}
	
	@AfterTest
	public void AppOnFinish() throws InterruptedException {
	    Browser_Initialization.OnFinish(driver); // Use the class name to access static method
	}

	
}