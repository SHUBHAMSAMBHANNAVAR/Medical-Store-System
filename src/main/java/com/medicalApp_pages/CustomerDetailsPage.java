package com.medicalApp_pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page class for interacting with the Customer Details section of the medical application.
 * This class encapsulates the functionality to verify navigation to the Customer Details page
 * and retrieve customer information based on search criteria.
 */
public class CustomerDetailsPage {
    private WebDriver driver; 
    private WebDriverWait wait; // WebDriverWait for synchronization

    // WebElement for customer details search input
    @FindBy(xpath = "//input[@aria-controls='customerDetailsTable']")
    WebElement Txt_customerDetailssearch;

    // WebElement for the customer name in the details table
    @FindBy(xpath = "//table[@id='customerDetailsTable']/tbody/tr[1]/td[1]")
    WebElement txt_CustName;

    // WebElement for the Customer Details header link
    @FindBy(xpath = "//h4[contains(text(),'Customer Details')]")
    WebElement Lnk_CustDetails;

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public CustomerDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    /**
     * Method to check navigation to the Customer Details page and retrieve customer details.
     *
     * @param sCustomername The name of the customer to search for.
     * @return The name of the customer retrieved from the details table.
     */
    public String checkCustomerDetailsPage(String sCustomername) { 
        String sCustname = ""; // Variable to hold the customer name

        try {
            // Wait for the link to be visible before checking
            wait.until(ExpectedConditions.visibilityOf(Lnk_CustDetails));

            if (Lnk_CustDetails.isDisplayed()) {
                System.out.println("Navigated to customer details page successfully.");
                
                // Enter the customer name to search
                Txt_customerDetailssearch.sendKeys(sCustomername); 

                // Wait for the customer name element to be visible and get its text
                sCustname = txt_CustName.getText(); 
            } else {
                System.out.println("Failed to navigate to customer details page.");
            }

        } catch (Exception e) {
            // Log any exceptions that occur during the process
            System.err.println("An error occurred while checking the customer details page: " + e.getMessage());
            e.printStackTrace();
        }

        return sCustname; // Return the customer name retrieved from the details table
    }
}
