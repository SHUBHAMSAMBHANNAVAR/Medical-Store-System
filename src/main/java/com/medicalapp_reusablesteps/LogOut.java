package com.medicalapp_reusablesteps;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medicalApp.util.Browser_Initialization;

/**
 * @FunctionName : Logout application.
 * @Description : Identifying the objects using page factory framework Clicking
 *              on the logout button.
 * @CreationDate : 26-09-2024
 * @author : Bhavani Y
 */

public class LogOut {
    private WebDriver driver;  // Changed to private for better encapsulation

    // Object Repository for Logout
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    // Constructor
    public LogOut(WebDriver driver) {
        this.driver = driver;  // Add this line to assign the driver
        PageFactory.initElements(driver, this);
    }

    public String logoutApplication() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(logout));
            logout.click();
            return driver.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}