package com.medicalappreusablesteps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
<<<<<<< HEAD
 * @FunctionName : logoutApplication
 * @Description  : This class handles the logout functionality of the medical application.
 *                 It identifies the logout button using PageFactory and performs the logout action.
 * @CreationDate : 26-09-2024
 * @Author       : Bhavani

 */
public class LogoutPage {
    WebDriver driver;  // WebDriver instance for interacting with the browser

    // Object Repository for Logout button
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * 
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public LogoutPage(WebDriver driver) {
        this.driver = driver;  // Initialize the driver
        PageFactory.initElements(driver, this);  // Initialize WebElements using PageFactory
    }

    /**
     * Logs out from the medical application.
     * 
     * @return The title of the page after logging out, or null if an exception occurs.
     */
    public String logoutApplication() {
        try {
            // WebDriverWait to wait until the logout button is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(logout));  // Wait for the logout button to be visible

            logout.click();  // Click on the logout button

            // Return the page title after logout
            return driver.getTitle();
        } catch (Exception e) {
            // Log the exception if any error occurs during the logout process
            e.printStackTrace();
            return null;  // Return null if an error occurs
        }
    }
}

