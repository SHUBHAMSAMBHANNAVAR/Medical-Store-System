package com.medicalApp_pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Page Object class representing the customer deletion functionality in the web application.
 * This class contains elements and methods to search for a customer and delete them from the system.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medicalApp.util.TestUtile;

/**
 * @FunctionName : Delete_UpdateCustomer
 * @Description : This class implements the Page Object Model for customer
 *              deletion. It provides functionality to: 1. Search for a customer
 *              by their number 2. Verify the customer details 3. Delete the
 *              customer from the system The class uses Selenium WebDriver to
 *              interact with web elements.
 *
 * @CreationDate : October 3, 2024
 * @Author :Bhavani Y
 * @Version : 1.0
 */

public class DeleteUpdatedCustomerPage {
	/** WebDriver instance to interact with the browser */
	private WebDriver driver;

	/** Object Repository for Customer Deletion elements */

	/** Search input field element */
	@FindBy(xpath = "//input[@type='search']")
	private WebElement Search;

	/** Element representing dynamic customer information in table */
	@FindBy(xpath = "//td[contains(@class, 'sorting_1')]/following-sibling::td[2]")
	private WebElement Customer_Num;

	/** Delete button element */
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement Btn_Delete;

	private WebDriverWait wait;

	public DeleteUpdatedCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout to 10 seconds
	}

	public String DeleteUpdateCustomer(String sCustomerNum) {
		try {
			// Enter customer number in search field
			Search.click();
			Search.sendKeys(sCustomerNum);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[contains(@class, 'sorting_1')]/following-sibling::td[2]")));

			// Construct XPath to find customer in table (third column)
			String xpath = String.format("//td[contains(@class, 'sorting_1')]/following-sibling::td[2]");
			String sText = driver.findElement(By.xpath(xpath)).getText();
			

			// Verify customer and perform deletion
			if (sText.equals(sCustomerNum)) {
				wait.until(ExpectedConditions.elementToBeClickable(Btn_Delete));
				driver.manage().timeouts().implicitlyWait(TestUtile.IMPLICIT_WAIT, TimeUnit.SECONDS);
				Btn_Delete.click(); // Click delete button

				// Wait for confirmation dialog to be visible
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();// Confirm deletion

				return driver.getTitle();
			} else {
				return "Customer not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred: " + e.getMessage();
		}
	}
}









































//public class Delete_UpdateCustomer {
//    /** WebDriver instance to interact with the browser */
//    private WebDriver driver;
//
//    // Object Repository for Customer Deletion elements
//    
//    /** Search input field element */
//    @FindBy(xpath = "//input[@type='search']")
//    private WebElement Search;
//    
//    /** Element representing dynamic customer information in table */
//    @FindBy(xpath = "//tr[contains(@class, 'sorting_1')]/td[position() = num]")
//    private WebElement Customer_name;
//    
//    /** Delete button element */
//    @FindBy(xpath = "//a[text()='Delete']")
//    private WebElement Btn_Delete;
//
//    
//    public Delete_UpdateCustomer(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//   
//    public String DeleteUpdateCustomer(String sCustomerNum) throws InterruptedException {
//        try {
//            // Enter customer number in search field
//            Search.click();
//            Search.sendKeys(sCustomerNum);
//            Thread.sleep(3000);  // Wait for search results
//
//            // Construct XPath to find customer in table (third column)
//            String xpath = String.format("//tr[contains(@class, 'sorting_1')]/td[position() = %d]", 3);
//            String sText = driver.findElement(By.xpath(xpath)).getText();
//            System.out.println(sText);
//
//            // Verify customer and perform deletion
//            if (sText.equals(sCustomerNum)) {
//                Thread.sleep(3000);  // Wait for UI to stabilize
//                Btn_Delete.click();  // Click delete button
//                Thread.sleep(3000);  // Wait for confirmation dialog
//                Btn_Delete.sendKeys(Keys.ENTER);  // Confirm deletion
//                Thread.sleep(3000);  // Wait for deletion to complete
//                return driver.getTitle();
//            } else {
//                return "Customer not found";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "An error occurred: " + e.getMessage();
//        }
//    }
//}