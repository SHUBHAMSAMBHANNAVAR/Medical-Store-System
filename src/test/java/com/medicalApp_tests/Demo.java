package com.medicalApp_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo extends BaseClass
{
    @Test	
	public void Demo1() throws InterruptedException
    {
	
		String LoginTest_title = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    Assert.assertEquals(LoginTest_title, "MSS - Dashboard");

    	String item= menuBar.clickOnTheMenuBar("Sales","Sales Details");
	   //System.out.println(item);
    	//logout.logoutApplication();
	
}
}