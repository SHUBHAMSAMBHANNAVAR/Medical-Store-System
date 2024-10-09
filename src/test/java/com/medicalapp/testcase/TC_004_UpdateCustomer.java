package com.medicalapp.testcase;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicalApp.util.ExcelReadData;


public class TC_004_UpdateCustomer extends BaseClass {
    
	/*
    * Data provider which reads and writes the data from the excel sheet to
    * application.
    */
   @DataProvider(name = "ReadDatas")
   public static Object[][] getDetails() throws IOException {
       Object data[][] = null;
       try {
    	   data = ExcelReadData.ReadData("UpdateCustomer", "./TestData/MedicalStore_InputValues.xls");
       } catch (Exception e) {
    	   throw new RuntimeException("Failed to read test data from Excel", e);
	    }
	    // Filter out rows where Data_No (first column) is null or empty
	    return Arrays.stream(data).filter(row -> row[0] != null && !row[0].toString().trim().isEmpty()).toArray(Object[][]::new);
	}
   
   @Test(dataProvider = "ReadDatas")
   public void UpdateCustomer_Test(String MenuItem, String SubMenuItem, String CustomerName, String MobileNo)
           throws InterruptedException {
       if (MenuItem != null) {
           System.out.println(MenuItem);
           String sLogin_Title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
           System.out.println("The title for the login page:" + sLogin_Title);
           Assert.assertEquals(sLogin_Title, "MSS - Dashboard");
           
           String sMenu_Title = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem);
           System.out.println("The title for the menubar page:" + sMenu_Title);
           Assert.assertEquals(sMenu_Title, "MSS - Update Customer");
           
           String sClickEdit = ClickOnEdit.clickOnEdit(CustomerName);
           System.out.println("The title for the clickOnEdit page:" + sClickEdit);
           Assert.assertEquals(sClickEdit, "MSS - Update Client");
           
           String sDetail = EnterDetail.enterDetail(MobileNo);
           System.out.println("The title for the enterDetail page:" + sDetail);
           Assert.assertEquals(sDetail, "MSS - Update Customer");
           
           String sDelete_Edited = Delete.DeleteUpdateCustomer(MobileNo);
           System.out.println("The title for the DeleteCustomer page:" + sDelete_Edited);
           Assert.assertEquals(sDelete_Edited, "MSS - Update Customer");
           
           String sSearch_Delete = notFound.delete_customer(CustomerName);
           System.out.println("The title for the notFound page:" + sSearch_Delete);
           Assert.assertEquals(sSearch_Delete, "MSS - Update Customer");
           
           String log_Out = logout.logoutApplication();
           System.out.println("The title for the  logOutpage:" + log_Out);
           Assert.assertEquals(log_Out, "Medical Application");
           // Closing the application
           driver.quit();
       }
   }
}