package com.medicalApp_pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
* @FunctionName : Search_Delete_Customer
* @Description : This class implements functionality to search for and delete customers in a web application.
*                It utilizes Selenium WebDriver for web element interactions and follows the Page Object Model
*                design pattern. The class provides methods to:
*                1. Search for a customer by name
*                2. Delete the customer if found
*                3. Handle various scenarios such as customer not found
*                4. Manage confirmation dialogs
*                5. Verify successful deletion
* @CreationDate : October 3, 2024
* @Author :Bhavani Y
* @Version : 1.0
*/


/**
 * Page Object class representing the customer search and delete functionality.
 * This class provides methods to search for a customer and delete them from the system.
 */
public class Search_Delete_Customer {
    /** The WebDriver instance to interact with the browser */
    private final WebDriver driver;
    
    /** WebDriverWait instance for explicit waits */
    private final WebDriverWait wait;

    /** Search input field WebElement */
    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;

    /** "No results found" message WebElement */
    @FindBy(xpath = "//td[@valign='top' and @colspan='5' and contains(@class, 'dataTables_empty')]")
    private WebElement notFound;

    /** Logout link WebElement */
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    /** Delete button WebElement */
    @FindBy(xpath = "//button[contains(@class, 'delete-btn')]")
    private WebElement deleteButton;

    /**
     * Constructor for the Search_Delete_Customer page object.
     * Initializes the WebDriver, WebDriverWait, and Page Factory elements.
     *
     * @param driver The WebDriver instance to be used
     */
    public Search_Delete_Customer(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Searches for a customer by name and attempts to delete them if found.
     *
     * @param customerName The name of the customer to search for and delete
     * @return A string indicating the result of the operation:
     *         - Browser title if customer not found and logged out
     *         - "Customer successfully deleted" if deletion successful
     *         - "Customer deletion failed" if deletion unsuccessful
     *         - Error message if an exception occurs
     * @throws InterruptedException if the thread sleep is interrupted
     */
    public String delete_customer(String customerName) throws InterruptedException {
        try {
            // Clear previous search and enter new customer name
            search.clear();
            search.sendKeys(customerName);
            
            // Wait for either "not found" message or customer entry to appear
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(notFound),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + customerName + "')]"))
            ));

            // If customer not found, log out and return browser title
            if (notFound.isDisplayed()) {
                System.out.println("Customer not found: " + customerName);
               // logout.click();
                return driver.getTitle();
            } else {
                // Customer found, proceed with deletion
                deleteButton.click();
                deleteButton.sendKeys(Keys.ENTER);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Wait for deletion process to initiate

                // Handle confirmation dialog
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();

                // Verify deletion by searching for the customer again
                search.clear();
                search.sendKeys(customerName);
                wait.until(ExpectedConditions.visibilityOf(notFound));
                
                if (notFound.isDisplayed()) {
                    System.out.println("Customer successfully deleted: " + customerName);
                    return driver.getTitle();
                } else {
                    return "Customer deletion failed";
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("An error occurred while searching/deleting the customer: " + e.getMessage());
            return "An error occurred: " + e.getMessage();
        }
    }
}