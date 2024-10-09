package com.medicalApp_pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medicalApp.util.RandomStringGenerator;


/**
 * Page class for adding a new customer in the medical application.
 * This class encapsulates the functionality to enter customer details 
 * into the form fields and submit the form.
 */
public class AddCustomerPage {
    private WebDriver driver; // WebDriver instance for controlling the browser
    private WebDriverWait wait; // WebDriverWait instance for handling wait conditions

    // Object Repository: Web elements on the Add Customer page
    @FindBy(xpath = "//input[@id='customer_name']") 
    WebElement txt_CustomerName;
    
    @FindBy(xpath = "//input[@id='reference_doctor']")
    WebElement txt_ReferenceDoctor;

    @FindBy(xpath = "//input[@id='customer_mobile_number']")
    WebElement txt_CustomerMobileNumber;

    @FindBy(xpath = "//input[@id='customer_type']")
    WebElement txt_CustomerType;

    @FindBy(xpath = "//button[text()='Add Customer']")
    WebElement btn_AddCustomer;

    @FindBy(xpath="//h4[contains(text(), 'Add Customer')]")
    WebElement Lnk_AddCustomer;
    
    // Store the modified customer name for potential future use
    public String sModifiedCustomerName;

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize WebDriverWait with a 20-second timeout
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    /**
     * Enters customer details into the form and submits it.
     *
     * @param sCustomerName The name of the customer.
     * @param sReferenceDoctor The reference doctor for the customer.
     * @param sCustomerMobileNumber The mobile number of the customer.
     * @param sCustomerType The type of the customer.
     * @return The modified customer name (customer name with a random string appended).
     */
    public String enterCustomerDetails(String sCustomerName, String sReferenceDoctor, String sCustomerMobileNumber, String sCustomerType) {
        try {
        	if (Lnk_AddCustomer.isDisplayed()) {
        	    System.out.println("Navigated to Add Customer page successfully ");
        	} else {
        	    throw new IllegalStateException("Failed to navigate to Add New Customer page.");
        	}
        	
            // Generate a random 3-character string and append it to the customer name
            String sRandomString = RandomStringGenerator.generateRandomString(3);
            sModifiedCustomerName = sCustomerName + sRandomString;

            // Enter the modified customer name
            wait.until(ExpectedConditions.visibilityOf(txt_CustomerName));
            txt_CustomerName.sendKeys(sModifiedCustomerName);
           //System.out.println("Customer Name entered: " + modifiedCustomerName);

            // Enter the reference doctor
            wait.until(ExpectedConditions.visibilityOf(txt_ReferenceDoctor));
            txt_ReferenceDoctor.sendKeys(sReferenceDoctor);

            // Enter the customer mobile number
            wait.until(ExpectedConditions.visibilityOf(txt_CustomerMobileNumber));
            txt_CustomerMobileNumber.sendKeys(sCustomerMobileNumber);

            // Enter the customer type
            wait.until(ExpectedConditions.visibilityOf(txt_CustomerType));
            txt_CustomerType.sendKeys(sCustomerType);

            // Click the Add Customer button to submit the form
            wait.until(ExpectedConditions.elementToBeClickable(btn_AddCustomer));
            btn_AddCustomer.click();

        } catch (Exception e) {
            // Log any errors that occur during the entry process
            System.out.println("Error while entering customer details: " + e.getMessage());
            e.printStackTrace();
        }
        
        return sModifiedCustomerName; // Return the modified customer name for potential use in test verification
    }
}