package com.medicalApp_pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* This class sets all values in AddStock in a medical store application.
*
* @author Kamali S
* @version 4.32.0
* @since 30-09-2024
*/

public class AddNewStockDetails {

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
    
    
    public AddNewStockDetails(WebDriver driver) { 
    	this.driver=driver;
        PageFactory.initElements(driver, this); 
   } 
    

    /** 
     * Once the OR is done , user is passing the valid details for the respective 
     * inputs after entering the valid inputs clicking on the enter. 
     */ 

    public void CreateAddNewStock(String Itemname, String Manufacturername, String UnitPrice, String Location, 
                                        String CGST, String ItemDescription, String BatchNumber, String Quantity, 
                                        String SGST, String HSNcode, String Type, String DistributorName) {
        try {
        	
        	//Enter ItemName 
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));   
        	
        	wait.until(ExpectedConditions.visibilityOf(Txt_ItemName)); 
            Txt_ItemName.sendKeys(Itemname);
           // Thread.sleep(2000); 
            
            //Enter ItemDescrption
            wait.until(ExpectedConditions.visibilityOf(Txt_ItemDescription)); 
            Txt_ItemDescription.sendKeys(ItemDescription);
           // Thread.sleep(2000);
            
            //Enter HSN code
            wait.until(ExpectedConditions.visibilityOf(Txt_HSNcode)); 
            Txt_HSNcode.sendKeys(HSNcode);
           // Thread.sleep(2000);
            
            //Enter Manufacturer name
            
            wait.until(ExpectedConditions.visibilityOf(Txt_Manufacturername)); 
            Txt_Manufacturername.sendKeys(Manufacturername);
           // Thread.sleep(2000);
            
            //Enter Batch Number
            
            wait.until(ExpectedConditions.visibilityOf(Txt_BatchNumber)); 
            Txt_BatchNumber.sendKeys(BatchNumber);
            Thread.sleep(2000);
            
          //Enter Medicine Type
            
            wait.until(ExpectedConditions.visibilityOf(Txt_Type)); 
            Txt_Type.sendKeys(Type);
           // Thread.sleep(2000);
            
          //Enter UnitPrice
            
            wait.until(ExpectedConditions.visibilityOf(Txt_UnitPrice)); 
            Txt_UnitPrice.sendKeys(UnitPrice);
            //Thread.sleep(2000);
            
          //Enter Quantity
            
            wait.until(ExpectedConditions.visibilityOf(Txt_Quantity)); 
            Txt_Quantity.sendKeys(Quantity);
            Thread.sleep(2000);
            
          //Enter Distributor Name
            
            wait.until(ExpectedConditions.visibilityOf(Txt_DistributorName)); 
            Txt_DistributorName.sendKeys(DistributorName);
           // Thread.sleep(2000);
            
          //Enter Location
            
            wait.until(ExpectedConditions.visibilityOf(Txt_Location)); 
            Txt_Location.sendKeys(Location);
           // Thread.sleep(2000);
            
          //Enter PurchaseDate
            
           // wait.until(ExpectedConditions.visibilityOf(Txt_PurchaseDate)); 
           // Txt_PurchaseDate.sendKeys(PurchaseDate);
           // Thread.sleep(2000);
            
          //Enter ExpirationDate
            
           // wait.until(ExpectedConditions.visibilityOf(Txt_ExprDate)); 
           // Txt_ExprDate.sendKeys(ExpirationDate);
           // Thread.sleep(2000);
            
          //Enter CGST
            
            wait.until(ExpectedConditions.visibilityOf(Txt_CGST)); 
            Txt_CGST.sendKeys(CGST);
           // Thread.sleep(2000);
            
          //Enter SGST
            
            wait.until(ExpectedConditions.visibilityOf(Txt_SGST)); 
            Txt_SGST.sendKeys(SGST);
           // Thread.sleep(2000);
            
            // Click on add stock
            
            wait.until(ExpectedConditions.visibilityOf(Btn_AddStock)); 
            Btn_AddStock.click();
           
        } catch (Exception e) {
            System.out.println("Exceptions Caught: " + e.getMessage());
        }
    }

    
}          



