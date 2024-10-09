package com.medicalApp_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medicalApp.util.RandomStringGenerator;

/*
* This class sets all values in AddStock in a medical store application.
*
* @author Kamali S
* @version 4.32.0
* @since 30-09-2024
*/

public class AddNewStockDetailsPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='item_name']|label[text()='Item Name']/following::input")
	WebElement Txt_ItemName;

	@FindBy(xpath = "//b[contains(text(),'Item Description')]/following::input[1]")
	WebElement Txt_ItemDescription;

	@FindBy(xpath = "//b[contains(text(),'HSN Code:')]/following-sibling::input")
	WebElement Txt_HSNcode;

	@FindBy(id = "manufacturer_name")
	WebElement Txt_Manufacturername;

	@FindBy(xpath = "//b[contains(text(),'Type')]/preceding-sibling::input[1]")
	WebElement Txt_BatchNumber;

	@FindBy(id = "medicine_type")
	WebElement Txt_Type;

	@FindBy(id = "unit_price")
	WebElement Txt_UnitPrice;

	@FindBy(id = "quantity")
	WebElement Txt_Quantity;

	@FindBy(id = "supplier_name")
	WebElement Txt_DistributorName;

	@FindBy(id = "location")
	WebElement Txt_Location;

	// @FindBy(xpath ="//b[text()='Purchase Date:']/following-sibling::input[1]")
	// WebElement Txt_PurchaseDate;

	// @FindBy(xpath ="//b[text()='Purchase Date:']/following-sibling::input[2]")
	// WebElement Txt_ExprDate;

	@FindBy(id = "cgst")
	WebElement Txt_CGST;

	@FindBy(id = "sgst")
	WebElement Txt_SGST;

	@FindBy(xpath = "//button[contains(text(),'Add Stock')]")
	WebElement Btn_AddStock;

	// Store the modified customer name for potential future use
	public String sModifieditemName;

	public AddNewStockDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Once the OR is done , user is passing the valid details for the respective
	 * inputs after entering the valid inputs clicking on the enter.
	 */

	public void CreateAddNewStock(String sItemname, String sManufacturername, String sUnitPrice, String sLocation,
			String sCGST, String sItemDescription, String sBatchNumber, String sQuantity, String sSGST, String sHSNcode,
			String sType, String sDistributorName) {
		try {

			// Enter ItemName
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			// Generate a random 3-character string and append it to the customer name
			String sRandomString = RandomStringGenerator.generateRandomString(3);
			sModifieditemName = sItemname + sRandomString;

			wait.until(ExpectedConditions.visibilityOf(Txt_ItemName));
			Txt_ItemName.sendKeys(sModifieditemName);
			//System.out.println(sModifieditemName);
			// Thread.sleep(2000);

			// Enter ItemDescrption
			wait.until(ExpectedConditions.visibilityOf(Txt_ItemDescription));
			Txt_ItemDescription.sendKeys(sItemDescription);
			

			// Enter HSN code
			wait.until(ExpectedConditions.visibilityOf(Txt_HSNcode));
			Txt_HSNcode.sendKeys(sHSNcode);
			// Thread.sleep(2000);

			// Enter Manufacturer name

			wait.until(ExpectedConditions.visibilityOf(Txt_Manufacturername));
			Txt_Manufacturername.sendKeys(sManufacturername);
			// Thread.sleep(2000);

			// Enter Batch Number
			wait.until(ExpectedConditions.visibilityOf(Txt_BatchNumber));
			Txt_BatchNumber.sendKeys(sBatchNumber);
			Thread.sleep(2000);

			// Enter Medicine Type
			wait.until(ExpectedConditions.visibilityOf(Txt_Type));
			Txt_Type.sendKeys(sType);

			// Enter UnitPrice
			wait.until(ExpectedConditions.visibilityOf(Txt_UnitPrice));
			Txt_UnitPrice.sendKeys(sUnitPrice);
			
			// Enter Quantity
			wait.until(ExpectedConditions.visibilityOf(Txt_Quantity));
			Txt_Quantity.sendKeys(sQuantity);
			Thread.sleep(2000);

			// Enter Distributor Name
			wait.until(ExpectedConditions.visibilityOf(Txt_DistributorName));
			Txt_DistributorName.sendKeys(sDistributorName);
		
			// Enter Location
			wait.until(ExpectedConditions.visibilityOf(Txt_Location));
			Txt_Location.sendKeys(sLocation);
			
			// Enter CGST
			wait.until(ExpectedConditions.visibilityOf(Txt_CGST));
			Txt_CGST.sendKeys(sCGST);
			
			// Enter SGST
			wait.until(ExpectedConditions.visibilityOf(Txt_SGST));
			Txt_SGST.sendKeys(sSGST);
	
			wait.until(ExpectedConditions.visibilityOf(Btn_AddStock));
			Btn_AddStock.click();

		} catch (Exception e) {
			System.out.println("Exceptions Caught: " + e.getMessage());
		}
	}

}
