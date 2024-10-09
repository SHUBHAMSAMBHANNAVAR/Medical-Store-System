package com.medicalapp_tests;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicalApp.util.Excel_ReadData;
import com.medicalApp_pages.AddNewStockDetails;
import com.medicalApp_pages.Verification_AddNewStock;

public class TC_001_AddNewStockDetails extends BaseClass {
	
	// Data provider method to read test data from an Excel file. 
    @DataProvider(name = "ReadExcelData")  
   public static Object[][] getDetails() throws IOException {  
       Object[][] data = null;  
       try {  
           // Reading test data from Excel sheet  
           data = Excel_ReadData.ReadData("AddStock", "./test-data/MedicalStore_InputValues.xls");  
       } catch (Exception e) {  
           throw new RuntimeException("Failed to read test data from Excel", e);  
       }

	  // Filter out rows where Data_No (first column) is null or empty
    return Arrays.stream(data).filter(row -> row[0] != null && !row[0].toString().trim().isEmpty()).toArray(Object[][]::new);
}

	@Test(dataProvider = "ReadExcelData")
	public void AddStockTestcase(String Data_NO, String MenuItem, String SubMenuItem1, String SubMenuItem2,
			String ItemName, String ManufacturerName, String UnitPrice, String Location, String CGST,
			String ItemDescription, String BatchNumber, String Quantity, String SGST, String HSNCode, String Type,
			String DistributorName, String ExpiryDate) throws InterruptedException {
		if (Data_NO != null) {
			// Step 1: Login to the application
			String LoginTest_title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			Assert.assertEquals(LoginTest_title, "MSS - Dashboard");

			// Step 2: Navigate to the add new stock
			String MenuItem_title = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem1);
			Assert.assertEquals(MenuItem_title, "MSS - New Stock");

			AddNewStockDetails AddStock = new AddNewStockDetails(driver);
			AddStock.CreateAddNewStock(ItemName, ManufacturerName, UnitPrice, Location, CGST, ItemDescription,
					BatchNumber, Quantity, SGST, HSNCode, Type, DistributorName);

			// Step 3: Navigate to the stock details menu String MenuItem_titleVerf =
			String MenuItem_titleVerf = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem2);
			Assert.assertEquals(MenuItem_titleVerf, "MSS - Stock Details");

			// Step 4: Verification of newly added stock
			Verification_AddNewStock AddStockVerf = new Verification_AddNewStock(driver);
			AddStockVerf.VerificationSearchField(AddStock.sModifieditemName);
			System.out.println(AddStock.sModifieditemName);

			// Step 5: Logout from the application
			String Logout_title = logout.logoutApplication();
			Assert.assertEquals(Logout_title, "Medical Application");
		}

	}
}
