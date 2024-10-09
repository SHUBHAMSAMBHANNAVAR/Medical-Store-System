package com.medicalapp.testcase;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.medicalApp.util.BrowserInitialization;
import com.medicalApp_pages.DeleteUpdatedCustomerPage;
import com.medicalApp_pages.SearchDeleteCustomerPage;
import com.medicalApp_pages.UpdateCustomerClickOnEditPage;
import com.medicalApp_pages.UpdateCustomerEnterDetailPage;
import com.medicalappreusablesteps.ClickOnMenuBar;
import com.medicalappreusablesteps.LoginPage;
import com.medicalappreusablesteps.LogoutPage;

/**
* @FunctionName : BaseClass
* @Description : This class implements the foundational test setup for the Medical App 
*                automation framework. It provides functionality to:
*                1. Initialize browser settings and test environment
*                2. Create instances of all required page objects
*                3. Set up preconditions for test execution
*                The class uses the Page Object Model pattern and extends 
*                Browser_Initialization for browser setup capabilities.
*                
*                Key components initialized:
*                - Login functionality
*                - Menu navigation
*                - Customer update operations
*                - Customer deletion features
*                - Search functionality
*                - Logout process
*
* @CreationDate : October 3, 2024
* @Author : Bhavani Y
* @Version : 1.0
*/

public class BaseClass extends BrowserInitialization {
// Declaring page objects for different functionalities
	LoginPage loginpage;                      // Handles login functionality
	ClickOnMenuBar menuBar;                   // Manages menu navigation
	UpdateCustomerClickOnEditPage ClickOnEdit;   // Handles clicking edit for customer update
	UpdateCustomerEnterDetailPage EnterDetail;   // Manages entering customer details
	DeleteUpdatedCustomerPage Delete;             // Handles customer deletion
	SearchDeleteCustomerPage notFound;          // Manages customer search and not found scenarios
	LogoutPage logout;                            // Handles logout functionality

	/**
	 * Constructor for BaseClass Calls the parent class constructor to initialize
	 * properties and file streaming input methods
	 */
	public BaseClass() {
		super();
	}

	/**
	 * Setup method that runs before test execution Initializes the browser and
	 * creates instances of all page objects
	 * 
	 * @throws InterruptedException if thread is interrupted during setup
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		// Initialize the browser using method from parent class
		initialization();

		// Create instances of all page objects with the initialized WebDriver
		loginpage = new LoginPage(driver);
		menuBar = new ClickOnMenuBar(driver);
		ClickOnEdit = new UpdateCustomerClickOnEditPage(driver);
		EnterDetail = new UpdateCustomerEnterDetailPage(driver);
		Delete = new DeleteUpdatedCustomerPage(driver);
		notFound = new SearchDeleteCustomerPage(driver);
		logout = new LogoutPage(driver);
	}

	
	@AfterTest
	public void AppOnFinish() throws InterruptedException {
	    BrowserInitialization.OnFinish(driver); // Use the class name to access static method
	}

	

}