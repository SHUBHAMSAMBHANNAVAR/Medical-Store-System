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
 * @Description  : Identifying the objects using page factory framework
 *                 Clicking on the logout button.
 * @CreationDate : 26-09-2024
 * @author       : Bhavani
 */

public class LogOut 
{
	WebDriver driver;
	
	// Object Repository for Logout
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	
	 // Constructor
    public LogOut(WebDriver driver) 
    	{
    		PageFactory.initElements(driver, this);
    	}
    	
	public void logoutApplication()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(logout)); // Wait for username field to be visible
		    logout.click();  // Click on logout button

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}