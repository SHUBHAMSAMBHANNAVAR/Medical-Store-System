package com.medicalApp_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @FunctionName : Update Stock Verification
 * @Description  : This class represents the Update Stock Verification page in the Medical Application.
 *                 It contains methods to verify the details of updated stock items.
 * @CreationDate : 01-10-2024
 * @author       : Pragadeeswaran S
 */


public class UpdateStock_VerificationOfStockDetail
{	
	WebDriver driver;
	
	// Object Repository for Search
	@FindBy(xpath = "//input[@type='search']")
	WebElement Txt_Search;
	
	// Object Repository for Itemname
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[1]")
	WebElement Value_ItemName;
	
	// Object Repository for Item Discription
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[2]")
	WebElement Value_ItemDiscription;
	
	// Object Repository for Manufacturer name
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[3]")
	WebElement Value_MfrName;
	
	// Object Repository for Type
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[4]")
	WebElement Value_Type;
	
	// Object Repository for UnitPrice
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[5]")
	WebElement Value_UnitPrice;
	
	// Object Repository for Quantity
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[6]")
	WebElement Value_Quantity;
	
	// Object Repository for DfrName
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[7]")
	WebElement Value_DfrName;
	
	// Object Repository for Location
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[8]")
	WebElement Value_Location;
	
	// Object Repository for Purchase Date
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[9]")
	WebElement Value_PurchDate;
	
	// Object Repository for Expired Date
	@FindBy(xpath = "//div/table/tbody/tr[1]/td[10]")
	WebElement Value_ExpDate;
	

	// Constructor to initialize the page object with WebDriver
	public UpdateStock_VerificationOfStockDetail(WebDriver driver) 
	{
		this.driver = driver; // Assigning the WebDriver instance
		PageFactory.initElements(driver, this);  // Initializing the elements in this class
	}
	
	/**
     * Verifies the search field and all stock details.
     * 
     * @param sItemname Item name to search and verify
     * @param sItemDiscription Expected item description
     * @param sManufacturername Expected manufacturer name
     * @param sType Expected item type
     * @param sUnitPrice Expected unit price
     * @param sQuantity Expected quantity
     * @param sDistributorName Expected distributor name
     * @param sLocation Expected location
     * @param sPurchaseDate Expected purchase date
     * @param sExpDate Expected expiry date
     * @return The title of the page after verification
     */
	
	public String VerificationSearchField(String sItemname,String sItemDiscription,String sManufacturername,String sType,
			                            String sUnitPrice,String sQuantity,String sDistributorName,String sLocation,
			                            String sPurchaseDate,String sExpDate)
	{
		 try {
			    // Check if the item name is provided and perform the search
		        if (sItemname != null && !sItemname.isEmpty())
		        {
		            Txt_Search.sendKeys(sItemname);
		        }

		        boolean allFieldsMatch = true;
		        
		        // Verify each field against expected values
		        if (sItemname != null && !sItemname.isEmpty()) {
		            String ItemName = Value_ItemName.getText();
		            if (!ItemName.equals(sItemname)) {
		                System.out.println("Item Name mismatch. Expected: " + sItemname + ", Actual: " + ItemName);
		                allFieldsMatch = false;
		            }
		        }

		        if (sItemDiscription != null && !sItemDiscription.isEmpty()) {
		            String ItemDiscription = Value_ItemDiscription.getText();
		            if (!ItemDiscription.equals(sItemDiscription)) {
		                System.out.println("Item Description mismatch. Expected: " + sItemDiscription + ", Actual: " + ItemDiscription);
		                allFieldsMatch = false;
		            }
		        }

		        if (sManufacturername != null && !sManufacturername.isEmpty()) {
		            String MfrName = Value_MfrName.getText();
		            if (!MfrName.equals(sManufacturername)) {
		                System.out.println("Manufacturer Name mismatch. Expected: " + sManufacturername + ", Actual: " + MfrName);
		                allFieldsMatch = false;
		            }
		        }

		        if (sType != null && !sType.isEmpty()) {
		            String Type = Value_Type.getText();
		            if (!Type.equals(sType)) {
		                System.out.println("Type mismatch. Expected: " + sType + ", Actual: " + Type);
		                allFieldsMatch = false;
		            }
		        }

		        if (sUnitPrice != null && !sUnitPrice.isEmpty()) {
		            String UnitPrice = Value_UnitPrice.getText();
		            if (!UnitPrice.equals(sUnitPrice)) {
		                System.out.println("Unit Price mismatch. Expected: " + sUnitPrice + ", Actual: " + UnitPrice);
		                allFieldsMatch = false;
		            }
		        }

		        if (sQuantity != null && !sQuantity.isEmpty()) {
		            String Quantity = Value_Quantity.getText();
		            if (!Quantity.equals(sQuantity)) {
		                System.out.println("Quantity mismatch. Expected: " + sQuantity + ", Actual: " + Quantity);
		                allFieldsMatch = false;
		            }
		        }

		        if (sDistributorName != null && !sDistributorName.isEmpty()) {
		            String DfrName = Value_DfrName.getText();
		            if (!DfrName.equals(sDistributorName)) {
		                System.out.println("Distributor Name mismatch. Expected: " + sDistributorName + ", Actual: " + DfrName);
		                allFieldsMatch = false;
		            }
		        }

		        if (sLocation != null && !sLocation.isEmpty()) {
		            String Location = Value_Location.getText();
		            if (!Location.equals(sLocation)) {
		                System.out.println("Location mismatch. Expected: " + sLocation + ", Actual: " + Location);
		                allFieldsMatch = false;
		            }
		        }

		        if (sPurchaseDate != null && !sPurchaseDate.isEmpty()) {
		            String PurchDate = Value_PurchDate.getText();
		            if (!PurchDate.equals(sPurchaseDate)) {
		                System.out.println("Purchase Date mismatch. Expected: " + sPurchaseDate + ", Actual: " + PurchDate);
		                allFieldsMatch = false;
		            }
		        }

		        if (sExpDate != null && !sExpDate.isEmpty()) {
		            String ExpDate = Value_ExpDate.getText();
		            if (!ExpDate.equals(sExpDate)) {
		                System.out.println("Expiry Date mismatch. Expected: " + sExpDate + ", Actual: " + ExpDate);
		                allFieldsMatch = false;
		            }
		        }

		        if (allFieldsMatch) {
		            System.out.println("Successfully verified all Add Stock details.");
		        } else {
		            System.out.println("Failed to verify one or more Add Stock details.");
		        }
		        
		        return driver.getTitle();
		    } catch (Exception e) {
		        System.out.println("Exceptions Caught " + e.getMessage());
		    }
		return null;  // Return null if an exception occurred
		}
}
