package com.medicalapp_tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicalApp.util.Excel_ReadData;
import com.medicalApp.util.RandomPhoneNumberGenerator;
import com.medicalApp_pages.AddCustomerPage;
import com.medicalApp_pages.CustomerDetailsPage;

/**
 * @TestCaseID  : MedicalAppAddCustomer_TC_003
 * @Description : This test case automates the process of adding a new customer 
 *                in the Medical Application, verifying the added customer, 
 *                and logging out.
 * @CreationDate: 01-10-2024
 * @Author      : Shubham
 */
public class TC_003_AddCustomer extends BaseClass {

    /**
     * @DataProvider : Provides test data from an Excel file using the ReadExcelData method.
     * @return 2D Object array containing the test data.
     * @throws IOException If the Excel file is not found or cannot be read.
     */
   
	@DataProvider(name = "ReadExcelData")
	public static Object[][] getDetails() throws IOException {
	    Object[][] data = null;
	    try {
	        // Reading test data from Excel sheet
	        data = Excel_ReadData.ReadData("AddCustomer", "./test-data/MedicalStore_InputValues.xls");
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to read test data from Excel", e);
	    }
	    // Filter out rows where Data_No (first column) is null or empty
	    return Arrays.stream(data).filter(row -> row[0] != null && !row[0].toString().trim().isEmpty()).toArray(Object[][]::new);
	}

    /**
     * @TestCaseID  : MedicalAppAddCustomer_TC_003
     * @Description : Test method to add a customer to the Medical Application using the provided test data.
     * @param Data_No           The test data number identifier.
     * @param MenuItem          The menu item to be clicked.
     * @param MenuSubItem       The submenu item to be clicked.
     * @param CustomerName      The name of the customer to be added.
     * @param ReferenceDoctor   The reference doctor associated with the customer.
     * @param MobileNo          The mobile number of the customer.
     * @param CustomerType      The type of the customer (e.g., Regular, VIP).
     * @throws InterruptedException In case the thread is interrupted during sleep or wait.
     */
    @Test(dataProvider = "ReadExcelData")
    public void MedicalAppAddCustomer_TC_003(String Data_NO,String MenuItem, String MenuSubItem,
                                             String CustomerName, String ReferenceDoctor, String MobileNo, 
                                             String CustomerType) throws InterruptedException {

        // Check if Data_No is provided before executing the test
        if (Data_NO != null) {
            //System.out.println(Data_No);

            // Perform login and validate the dashboard title
            String LoginTest_title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
            Assert.assertEquals(LoginTest_title, "MSS - Dashboard");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Navigate to 'New Customer' page via MenuBar
            String sItem = menuBar.clickOnTheMenuBar(MenuItem, MenuSubItem);
            Assert.assertEquals(sItem, "MSS - New Customer");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Generate a unique mobile number using RandomPhoneNumberGenerator utility
            String sUniqueMobileNo = RandomPhoneNumberGenerator.generateUniquePhoneNumber(MobileNo);

            // Add customer using the AddCustomer page object
            AddCustomerPage customer = new AddCustomerPage(driver);
            String sNewCustomer = customer.enterCustomerDetails(CustomerName, ReferenceDoctor, sUniqueMobileNo, CustomerType);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Navigate to 'All Customer Details' page and verify customer addition
            String sMenuitem = menuBar.clickOnTheMenuBar(MenuItem, "All Customer Details");
            Assert.assertEquals(sMenuitem, "MSS - Customer Details");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Validate if the newly added customer appears in the CustomerDetailsPage
            CustomerDetailsPage newCustDetail = new CustomerDetailsPage(driver);
            String sCustDetail = newCustDetail.checkCustomerDetailsPage(customer.sModifiedCustomerName);
            Assert.assertEquals(sCustDetail, customer.sModifiedCustomerName);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            
            // Log out and verify the logout title
            String Logout_title = logout.logoutApplication();
            Assert.assertEquals(Logout_title, "Medical Application");
                    
        }
    }
}
