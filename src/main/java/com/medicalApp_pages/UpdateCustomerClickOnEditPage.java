package com.medicalApp_pages;

import java.time.Duration;

/**
 * Page Object class representing the customer update functionality in the web application.
 * This class contains elements and methods to interact with the customer update interface,
 * specifically for searching and editing customer information.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @FunctionName : UpdateCustomer_ClickOnEdit
 * @Description : This class implements the Page Object Model for the customer
 *              update page. It provides functionality to search for a customer
 *              and click the edit button for the found customer. The class uses
 *              Selenium WebDriver to interact with web elements and perform
 *              actions like searching and clicking.
 * @CreationDate : October 3, 2024
 * @Author : Bhavani Y
 * @Version : 1.0
 */

public class UpdateCustomerClickOnEditPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement Search;

	@FindBy(xpath = "//table[@id='customerUpdateTable']//tbody/tr/td[@class='sorting_1']/text()")
	private WebElement Customer_name;

	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement Btn_Edit;

	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement Btn_Delete;

	public UpdateCustomerClickOnEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String clickOnEdit(String CustomerName) {
		try {
			// Wait for search field to be clickable and interact with it
			wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
			Search.clear(); // Clear existing text before sending new keys
			Search.sendKeys(CustomerName);

			// Dynamic XPath for finding the customer in the table
			String customerXPath = String.format("//table[@id='customerUpdateTable']//tr[@class='odd']/td[1]");

			// Wait for customer element to be present and get its text
			WebElement customerElement = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(customerXPath)));
			String foundCustomerName = customerElement.getText();
			System.out.println("Found customer: " + foundCustomerName);

			if (foundCustomerName.equals(CustomerName)) {
				// Wait for Edit button to be clickable before clicking
				wait.until(ExpectedConditions.elementToBeClickable(Btn_Edit)).click();
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





































//    public String clickOnEdit(String CustomerName) throws InterruptedException {
//        try {
//            // Click on search field and enter customer name
//            Search.click();
//            Search.sendKeys(CustomerName);
//            
//            // Wait for the search results to load
//            Thread.sleep(3000);
//
//            // Construct XPath to find the customer in the table
//            String xpath = String.format("//table[@id='customerUpdateTable']//tr[@class='odd']/td[1]");
//            
//            // Get the text of the found customer
//            String sText = driver.findElement(By.xpath(xpath)).getText();
//            System.out.println(sText);
//
//            // If customer is found, click edit and return page title
//            if (sText.equals(CustomerName)) {
//                Thread.sleep(3000);
//                Btn_Edit.click();
//                return driver.getTitle();
//            } else {
//                return "Customer not found";
//            }
//        } catch (Exception e) {
//            // Log the exception and return error message
//            e.printStackTrace();
//            return "An error occurred: " + e.getMessage();
//        }
//    }
//}