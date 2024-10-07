package com.medicalApp_tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicalApp_pages.Medical_readData;

/**
 * @FunctionName : Testcase for UpdateCustomer
 * @Description  : This class implements the Page Object Model for updating
 *                 customer details. It provides functionality to: 
 *                 1. Update customer mobile number
 *                 2. Submit the update form
 *                 3. Verify page loading state The class uses explicit waits to ensure reliable
 *                 interaction with web elements
 * @CreationDate : October 3, 2024
 * @Author : Bhavani Y
 * @Version : 1.0
 */


public class MedicalApp_UpdateCustomer_Test extends BaseClass {

	/**
	 * Data provider which reads and writes the data from the excel sheet to
	 * application.
	 */
	@DataProvider(name = "ReadDatas")
	public static Object[][] getDetails() throws IOException {
		Object data[][] = null;
		try {
			data = Medical_readData.ReadData("UpdateCustomer");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "ReadDatas")
	public void UpdateCustomer_Test(String MenuItem, String SubMenuItem, String CustomerName, String MobileNo)
			throws InterruptedException {

		if (MenuItem != null) {
			System.out.println(MenuItem);

			String Login_Title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			System.out.println("The title for the login page:" + Login_Title);
			Assert.assertEquals(Login_Title, "MSS - Dashboard");

			String Menu_Title = menuBar.clickOnTheMenuBar(MenuItem, SubMenuItem);
			System.out.println("The title for the menubar page:" + Menu_Title);
			Assert.assertEquals(Menu_Title, "MSS - Update Customer");

			String ClickEdit = ClickOnEdit.clickOnEdit(CustomerName);
			System.out.println("The title for the clickOnEdit page:" + ClickEdit);
			Assert.assertEquals(ClickEdit, "MSS - Update Client");

			String Detail = EnterDetail.enterDetail(MobileNo);
			System.out.println("The title for the enterDetail page:" + Detail);
			Assert.assertEquals(Detail, "MSS - Update Customer");

			String Delete_Edited = Delete.DeleteUpdateCustomer(MobileNo);
			System.out.println("The title for the DeleteCustomer page:" + Delete_Edited);
			Assert.assertEquals(Delete_Edited, "MSS - Update Customer");

			String Search_Delete = notFound.delete_customer(CustomerName);
			System.out.println("The title for the notFound page:" + Search_Delete);
			Assert.assertEquals(Search_Delete, "MSS - Update Customer");

			String log_Out = logout.logoutApplication();
			System.out.println("The title for the  logOutpage:" + log_Out);
			Assert.assertEquals(log_Out, "Medical Application");

			// Closing the application
			driver.quit();
		}
	}
}
