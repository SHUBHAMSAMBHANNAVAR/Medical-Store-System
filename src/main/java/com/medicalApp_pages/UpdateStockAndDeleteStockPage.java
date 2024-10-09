package com.medicalApp_pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @FunctionName : Search and Delete functionality on the Update Stock page.
 * @Description  : This class represents the Search and Delte functionality on the Update Stock page of the Medical Application.
 *                 It provides methods to search for stock items and delete their details.
 * @CreationDate : 01-10-2024
 * @author       : Pragadeeswaran S
 */

public class UpdateStockAndDeleteStockPage
{
    WebDriver driver; // WebDriver instance to interact with the browser
    WebDriverWait wait; // WebDriverWait instance for handling wait conditions

    // Object Repository for Search
    @FindBy(xpath = "//input[@type='search']")
    WebElement Txt_Search;

    // Object Repository for Delete
    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    WebElement Btn_Delete;

    /**
     * Constructor to initialize the UpdateStock_DeleteDetails object with WebDriver.
     * 
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public UpdateStockAndDeleteStockPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements in this class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
    }

    /**
     * Searches for a stock item and navigates to the delete page for that item.
     * 
     * @param Search The name of the stock item to search for.
     * @return The title of the page after the delete action, or null if an error occurs.
     */
    
    public String SearchAndDeleteAction(String Search) {
        try {
            // Wait for the search input to be clickable and Input the search term
            wait.until(ExpectedConditions.elementToBeClickable(Txt_Search));
            Txt_Search.sendKeys(Search); 

            // Wait for the Delete button to be clickable and Click the Delete button
            wait.until(ExpectedConditions.elementToBeClickable(Btn_Delete));
            Btn_Delete.click(); 
            
            // Handle alert dismissal
            Alert alert = driver.switchTo().alert();
            alert.accept();

            // Wait for the page title to change
            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            
            // Return the title of the current page
            return driver.getTitle(); 
           } 
            catch (Exception e) {
            System.out.println("Exceptions Caught " + e.getMessage()); // Handle exceptions
        }
        return null; // Return null if an exception occurred
    }
}

