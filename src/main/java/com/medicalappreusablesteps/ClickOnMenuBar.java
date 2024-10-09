package com.medicalapp_reusablesteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicalApp.util.TestUtile;

/**
 * @FunctionName : Click on the menu Item and then subItem
 * @Description  : Identifying the objects using page factory framework
 *                 Click on the Menu item and sub item with respective values.
 * @CreationDate : 27-09-2024
 * @author       : Shubham
 */

public class ClickOnMenuBar 
{
    private WebDriver driver;

    // Object Repository for menuBars
    @FindBy(xpath = "//ul[@class='nav_menu_link']/li/a")
    List<WebElement> menuBars;

    // Initializing the page object
    public ClickOnMenuBar(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Clicks on a specified menu item.
     * @param itemName The name of the menu item to click.
     */
    public void clickOnMenuItem(String itemName) { 
        for (WebElement item : menuBars) { 
            if (item.getText().equals(itemName)) { 
                item.click(); 
                //System.out.println("Clicked on " + itemName); 
                return; 
            } 
        } 
        System.out.println("Menu item not found: " + itemName); 
    } 

    /**
     * Clicks on a menu item and then a sub-item, returning the page title.
     * @param sItemName The main menu item to click.
     * @param sSubItem The sub-item to click.
     * @return The title of the page after clicking the items.
     */
    public String clickOnTheMenuBar(String sItemName, String sSubItem) {
        try {
            clickOnMenuItem(sItemName); 
            // Allow some time for the page to load after clicking the main menu item
            driver.manage().timeouts().implicitlyWait(TestUtile.IMPLICIT_WAIT, TimeUnit.SECONDS);
            clickOnMenuItem(sSubItem);
            
            return driver.getTitle(); // Return the page title after clicking the sub-item
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Return null if an exception occurred
    }
}
