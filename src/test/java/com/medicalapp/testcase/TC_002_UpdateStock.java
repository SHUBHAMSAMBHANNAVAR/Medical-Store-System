package com.medicalapp.testcase;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicalApp.util.ExcelReadData;
import com.medicalApp_pages.UpdateStockAndDeleteStockPage;
import com.medicalApp_pages.UpdateStockAndDeleteStockVerification;
import com.medicalApp_pages.UpdateStockAndEditStockPage;
import com.medicalApp_pages.UpdateStockAndDetailsPage;
import com.medicalApp_pages.UpdateStockVerificationOfStockDetailPage;
import com.medicalappreusablesteps.LogoutPage;

/**
 * @FunctionName : Test case for updating stock details.
 * @Description  : This class contains the test case for updating stock details in the Medical Application.
 *                 It reads data from an Excel file and executes a series of steps to log in, update stock details,
 *                 verify the updates, and log out of the application.
 * @CreationDate : 01-10-2024
 * @author       : Pragadeeswaran S
 */

public class TC_002_UpdateStock extends BaseClass
{
	// Data provider method to read test data from an Excel file.
	@DataProvider(name = "ReadExcelData") 
    public static Object[][] getDetails() throws IOException { 
        Object[][] data = null; 
        try { 
            // Reading test data from Excel sheet 
            data = ExcelReadData.ReadData("UpdateStock","./TestData/MedicalStore_InputValues.xls");
           
        } catch (Exception e) { 
            throw new RuntimeException("Failed to read test data from Excel", e); 
        } 

        // Filter out rows where Data_No (first column) is null or empty 
        return Arrays.stream(data).filter(row -> row[0] != null && !row[0].toString().trim().isEmpty()).toArray(Object[][]::new); 
    }
    /**
     * Test method to execute the update stock process using data provided by the data provider.
     * 
     * @param Data_NO           Identifier for the test data row.
     * @param MenuItem          The main menu item to navigate to.
     * @param SubMenuItem1      The first submenu item to navigate to.
     * @param SubMenuItem2      The second submenu item to navigate to.
     * @param ItemName          The name of the item to update.
     * @param ManufacturerName  The name of the manufacturer.
     * @param UnitPrice         The unit price of the item.
     * @param Location          The location of the item.
     * @param CGST              The Central Goods and Services Tax.
     * @param ItemDescription   A description of the item.
     * @param BatchNumber       The batch number of the item.
     * @param Quantity          The quantity of the item.
     * @param SGST              The State Goods and Services Tax.
     * @param HSNCode           The HSN (Harmonized System of Nomenclature) code.
     * @param Type              The type of the item.
     * @param DistributorName   The name of the distributor.
     * @param ExpiryDate        The expiry date of the item.
     * @throws Exception If any error occurs during the test execution.
     */
	
	@Test(dataProvider = "ReadExcelData")  
	public void PurchaseOrder(String Data_NO,String MenuItem,String SubMenuItem1,String SubMenuItem2,String ItemName,String ManufacturerName,
			String UnitPrice,String Location,String CGST,String ItemDescription,String BatchNumber,String Quantity,
			String SGST,String HSNCode,String Type,String DistributorName,String ExpiryDate) throws Exception
	{ 
     if (Data_NO != null)
      {   
    	//Initialized the object 
     	UpdateStockAndEditStockPage Edit = new UpdateStockAndEditStockPage(driver);
       	UpdateStockAndDetailsPage StockDetails = new UpdateStockAndDetailsPage(driver);
    	UpdateStockVerificationOfStockDetailPage VerificationOfStockDetail = new UpdateStockVerificationOfStockDetailPage(driver);
    	UpdateStockAndDeleteStockPage DeleteStock = new UpdateStockAndDeleteStockPage(driver);
    	UpdateStockAndDeleteStockVerification DeleteStockVerification = new UpdateStockAndDeleteStockVerification(driver);
     	
    	
        // Step 1: Login to the application
        String LoginTest_title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(LoginTest_title, "MSS - Dashboard");

        
        // Step 2: Navigate to the desired menu and submenu
        String MenuItem_title = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem1);
        Assert.assertEquals(MenuItem_title, "MSS - Update Stock");

        
        // Step 3: Search and edit the item
        String EditStockPage_title = Edit.SearchAndEditFields(ItemName);
        Assert.assertEquals(EditStockPage_title, "MSS- Update Stock");
  
        
        // Step 4: Update stock details
        String StockDetailsPage_title = StockDetails.SetAllValuesInAddStock(ItemName, ManufacturerName, UnitPrice, 
                                         Location, CGST, ItemDescription, BatchNumber, Quantity, SGST, 
                                         HSNCode, Type, DistributorName, ExpiryDate);
        Assert.assertEquals(StockDetailsPage_title, "MSS - Update Stock");
   
        
        // Step 5: Navigate back to the menu and submenu
        String MenuItem1_title = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem2);
        Assert.assertEquals(MenuItem1_title, "MSS - Stock Details");
  
        
        // Step 6: Verify the updated stock details
        String VerificationPage_title = VerificationOfStockDetail.VerificationSearchField(ItemName, ItemDescription, 
                                         ManufacturerName, Type, UnitPrice, Quantity, DistributorName, 
                                         Location, "", ExpiryDate);
        Assert.assertEquals(VerificationPage_title, "MSS - Stock Details");
    
        // Step 7: Navigate back to the menu and submenu
        menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem1);
        Assert.assertEquals(MenuItem_title, "MSS - Update Stock");
  
        
        // Step 8: Delete the updated stock details
        String DeleteStock_title = DeleteStock.SearchAndDeleteAction(ItemName);
        Assert.assertEquals(DeleteStock_title, "MSS - Update Stock");
   
        
        // Step 9: Navigate back to the menu and submenu
        menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem2);
        Assert.assertEquals(MenuItem1_title, "MSS - Stock Details");
    
        
        // Step 10: Verify deletion of stock details
        String DeleteStockVerification_title = DeleteStockVerification.searchAndDeleteVerification(ItemName);
        Assert.assertEquals(DeleteStockVerification_title, "MSS - Stock Details");
 
        
        // Step 11: Logout from the application
        String Logout_title = logout.logoutApplication();
        Assert.assertEquals(Logout_title, "Medical Application");
    }   
  }
}
