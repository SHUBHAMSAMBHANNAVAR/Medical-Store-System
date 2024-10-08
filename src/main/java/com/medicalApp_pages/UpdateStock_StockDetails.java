package com.medicalApp_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @FunctionName : Update Stock Details page.
 * @Description  : This class represents the Update Stock Details page in the Medical Application.
 *                 It provides methods to fill in and submit the stock item details.
 * @CreationDate : 01-10-2024
 * @author       : Pragadeeswaran S
 */

public class UpdateStock_StockDetails {
	
	WebDriver driver;
	// Object Repository for Itemname
	@FindBy(id = "item_name")
	WebElement Txt_Itemname;
	
	// Object Repository for Manufacturername
	@FindBy(id = "manufacturer_name")
	WebElement Txt_Manufacturername;
	
	// Object Repository for UnitPrice
	@FindBy(id = "unit_price")
	WebElement Txt_UnitPrice;
	
	// Object Repository for Location
	@FindBy(id = "location")
	WebElement Txt_Location;
	
	// Object Repository for CGST
	@FindBy(id = "cgst")
	WebElement Txt_CGST;
	
	// Object Repository for ItemDiscription
	@FindBy(id = "item_detail")
	WebElement Txt_ItemDiscription;
	
	// Object Repository for BatchNumber
	@FindBy(id = "batch_number")
	WebElement Txt_BatchNumber;
	
	// Object Repository for Quantity
	@FindBy(id = "quantity")
	WebElement Txt_Quantity;
	
	// Object Repository for SGST
	@FindBy(id = "sgst")
	WebElement Txt_SGST;
	
	// Object Repository for HSNcode
	@FindBy(id = "hsn_code")
	WebElement Txt_HSNcode;
	
	// Object Repository for Type
	@FindBy(id = "medicine_type")
	WebElement Txt_Type;
	
	// Object Repository for SupplierName
	@FindBy(id = "supplier_name")
	WebElement Txt_SupplierName;
	
	// Object Repository for Date
	@FindBy(id = "Date")
	WebElement Dt_Date;
		
    // Object Repository for UpdateStock
 	@FindBy(xpath = "//button[text()='Update Stock']")
 	WebElement Btn_UpdateStock;
 	
 	/**
	 * Constructor to initialize the UpdateStockDetails object with WebDriver.
	 * 
	 * @param driver The WebDriver instance used to interact with the browser.
	 */
	public UpdateStock_StockDetails(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize elements in this class
	}

    /**
     * Fills in all the fields on the Update Stock page with the provided values 
     * and submits the form.
     * 
     * @param sItemname          The name of the item to be updated.
     * @param sManufacturername  The name of the manufacturer.
     * @param sUnitPrice         The unit price of the item.
     * @param sLocation          The location of the item.
     * @param sCGST              The Central Goods and Services Tax amount.
     * @param sItemDiscription   The description of the item.
     * @param sBatchNumber       The batch number of the item.
     * @param sQuantity          The quantity of the item.
     * @param sSGST              The State Goods and Services Tax amount.
     * @param sHSNcode           The HSN code for the item.
     * @param sType              The type of the item.
     * @param sDistributorName   The name of the supplier.
     * @param sDate              The date associated with the item.
     * @return The title of the page after the update action, or null if an error occurs.
     */
	
    public String SetAllValuesInAddStock(String sItemname, String sManufacturername, String sUnitPrice, String sLocation, String sCGST,
    		String sItemDiscription, String sBatchNumber, String sQuantity, String sSGST, String sHSNcode, String sType, String sDistributorName,
    		String sDate) {
    	try {
            // Fill in the item name if provided
            if (sItemname != null && !sItemname.isEmpty()) {
                Txt_Itemname.clear();    
                Txt_Itemname.sendKeys(sItemname);
            }
            
            // Fill in the manufacturer name if provided
            if (sManufacturername != null && !sManufacturername.isEmpty()) {
                Txt_Manufacturername.clear();
                Txt_Manufacturername.sendKeys(sManufacturername);
            }
            
            // Fill in the unit price if provided
            if (sUnitPrice != null && !sUnitPrice.isEmpty()) {
                Txt_UnitPrice.clear();
                Txt_UnitPrice.sendKeys(sUnitPrice);
            }
            
            // Fill in the location if provided
            if (sLocation != null && !sLocation.isEmpty()) {
                Txt_Location.clear();
                Txt_Location.sendKeys(sLocation);
            }
            
            // Fill in the CGST if provided
            if (sCGST != null && !sCGST.isEmpty()) {
                Txt_CGST.clear();
                Txt_CGST.sendKeys(sCGST);
            }
            
            // Fill in the item description if provided
            if (sItemDiscription != null && !sItemDiscription.isEmpty()) {
                Txt_ItemDiscription.clear();
                Txt_ItemDiscription.sendKeys(sItemDiscription);
            }
            
            // Fill in the batch number if provided
            if (sBatchNumber != null && !sBatchNumber.isEmpty()) {
                Txt_BatchNumber.clear();
                Txt_BatchNumber.sendKeys(sBatchNumber);
            }
            
            // Fill in the quantity if provided
            if (sQuantity != null && !sQuantity.isEmpty()) {
                Txt_Quantity.clear();
                Txt_Quantity.sendKeys(sQuantity);
            }
            
            // Fill in the SGST if provided
            if (sSGST != null && !sSGST.isEmpty()) {
                Txt_SGST.clear();
                Txt_SGST.sendKeys(sSGST);
            }
            
            // Fill in the HSN code if provided
            if (sHSNcode != null && !sHSNcode.isEmpty()) {
                Txt_HSNcode.clear();
                Txt_HSNcode.sendKeys(sHSNcode);
            }
            
            // Fill in the type if provided
            if (sType != null && !sType.isEmpty()) {
                Txt_Type.clear();
                Txt_Type.sendKeys(sType);
            }
            
            // Fill in the distributor name if provided
            if (sDistributorName != null && !sDistributorName.isEmpty()) {
                Txt_SupplierName.clear();
                Txt_SupplierName.sendKeys(sDistributorName);
            }
            
            // Fill in the date if provided
            if (sDate != null && !sDate.isEmpty()) {
                Dt_Date.clear();
                Dt_Date.sendKeys(sDate);
            }
    	
        	Btn_UpdateStock.click(); // Click the Update Stock button
        	return driver.getTitle(); // Return the title of the page after the update
        } catch (Exception e) {
            System.out.println("Exceptions Caught " + e.getMessage()); // Handle exceptions
        }
        return null; // Return null if an exception occurred
	}
}