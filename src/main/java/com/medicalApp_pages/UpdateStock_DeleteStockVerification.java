package com.medicalApp_pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateStock_DeleteStockVerification {

    private WebDriver driver; // WebDriver instance to interact with the browser
    private WebDriverWait wait; // WebDriverWait instance for handling wait conditions

    // Object Repository for Search
    @FindBy(xpath = "//input[@type='search']")
    private WebElement txtSearch;

    // Object Repository for Data not found
    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElement noDataFoundMessage;

    /**
     * Constructor to initialize the UpdateStock_DeleteStockVerification object with WebDriver.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public UpdateStock_DeleteStockVerification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements in this class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
    }

    /**
     * Searches for a stock item and verifies the deletion result.
     *
     * @param search The name of the stock item to search for.
     * @return The title of the page after the delete action, or null if an error occurs.
     */
    public String searchAndDeleteVerification(String search) {
        try {
            // Wait for the search input to be clickable and input the search term
            wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
            txtSearch.sendKeys(search);

            // Wait for the data not found message to be visible
            boolean isDataNotFound = wait.until(ExpectedConditions.visibilityOf(noDataFoundMessage)).isDisplayed();

            // Check if the message is displayed
            if (isDataNotFound) {
                System.out.println("Passed: No matching records found.");
            } else {
                System.out.println("Failed: Records were found.");
            }

            // Return the title of the current page
            return driver.getTitle();
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage()); // Handle exceptions with error output
        }
        return null; // Return null if an exception occurred
    }
}
