package com.medicalApp_tests;

import org.testng.annotations.BeforeTest;

import com.medicalApp.util.Browser_Initialization;
import com.medicalApp_pages.Delete_UpdateCustomer;
import com.medicalApp_pages.Search_Delete_Customer;
import com.medicalApp_pages.UpdateCustomer_ClickOnEdit;
import com.medicalApp_pages.UpdateCustomer_EnterDetail;
import com.medicalapp_reusablesteps.ClickOnMenuBar;
import com.medicalapp_reusablesteps.LogOut;
import com.medicalapp_reusablesteps.LoginPage;

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

public class BaseClass extends Browser_Initialization {
// Declaring page objects for different functionalities
	LoginPage loginpage;                      // Handles login functionality
	ClickOnMenuBar menuBar;                   // Manages menu navigation
	UpdateCustomer_ClickOnEdit ClickOnEdit;   // Handles clicking edit for customer update
	UpdateCustomer_EnterDetail EnterDetail;   // Manages entering customer details
	Delete_UpdateCustomer Delete;             // Handles customer deletion
	Search_Delete_Customer notFound;          // Manages customer search and not found scenarios
	LogOut logout;                            // Handles logout functionality

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
		ClickOnEdit = new UpdateCustomer_ClickOnEdit(driver);
		EnterDetail = new UpdateCustomer_EnterDetail(driver);
		Delete = new Delete_UpdateCustomer(driver);
		notFound = new Search_Delete_Customer(driver);
		logout = new LogOut(driver);
	}
}