package com.medicalapp_reusablesteps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @FunctionName : Login into the application.
 * @Description  : Identifying the objects using page factory framework
 *                 Login into the application using valid credentials (i.e.., Username = pradeep , Password = Matryx@22)
 * @CreationDate : 26-09-2024
 * @author       : Pragadeeswaran S
 */

public class LoginPage 
{
    WebDriver driver;
    
    // Object Repository for Username
    @FindBy(id = "user_name")
    WebElement username;

    // Object Repository for Password
    @FindBy(id = "password")
    WebElement password;

    // Object Repository for Sign In
    @FindBy(xpath = "//button[@type= 'submit']")
    WebElement SignIn;

    // Initializing the page object
    public LoginPage(WebDriver driver) 
    {
        this.driver = driver; // Assign the driver to the instance variable
        PageFactory.initElements(driver, this);
    }
    
    // Actions
    public String login(String un, String pw) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.visibilityOf(username)); // Wait for username field to be visible
            username.sendKeys(un); // Entering the username 

            wait.until(ExpectedConditions.visibilityOf(password)); // Wait for password field to be visible
            password.sendKeys(pw); // Entering the password 

            wait.until(ExpectedConditions.elementToBeClickable(SignIn)); // Wait for Sign In button to be clickable
            SignIn.click();
    
            // Return the current title after clicking Sign In
            return driver.getTitle();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if there's an exception
        }
    }
}
