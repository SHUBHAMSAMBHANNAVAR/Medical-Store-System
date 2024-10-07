package com.medicalApp_pages; 
 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory; 
 
/** 
 * @FunctionName : Update Stock Verification 
 * @Description  : This class represents the Update Stock Verification page in the Medical Application. 
 *                 It contains methods to verify the details of updated stock items. 
 * @CreationDate : 07-10-2024 
 * @author       : Kamali S
 */ 
 
 
public class Verification_AddNewStock 
{      
     WebDriver driver; 
      
     // Object Repository for Search 
     @FindBy(xpath = "//input[@type='search']") 
     WebElement Txt_Search; 
      
     // Object Repository for Itemname 
     @FindBy(xpath = "//div/table/tbody/tr[1]/td[1]") 
     WebElement Value_ItemName; 
      
     
     // Constructor to initialize the page object with WebDriver 
     public Verification_AddNewStock(WebDriver driver)  
     { 
          this.driver = driver; // Assigning the WebDriver instance 
          PageFactory.initElements(driver, this);  // Initializing the elements in this class 
     } 
      
     /** 
     * Verifies the search field and all stock details. 
     *  
     * @param sItemname Item name to search and verify 
     * @return The title of the page after verification 
     */ 
      
     public String VerificationSearchField(String sItemname) 
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
 
                  if (allFieldsMatch) { 
                      System.out.println("Successfully verified Add Stock details."); 
                  } else { 
                      System.out.println("Failed to verify Add Stock details."); 
                  } 
                   
                  return driver.getTitle(); 
              } catch (Exception e) { 
                  System.out.println("Exceptions Caught " + e.getMessage()); 
              } 
          return null;  // Return null if an exception occurred 
          } 
}  