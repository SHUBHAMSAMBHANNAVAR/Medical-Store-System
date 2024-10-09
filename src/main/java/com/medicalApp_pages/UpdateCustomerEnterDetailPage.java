package com.medicalApp_pages;

/**
 * Page Object class representing the customer details update form in the web application.
 * This class provides functionality to interact with and update customer information,
 * specifically focusing on updating the customer's mobile number.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * @FunctionName : UpdateCustomer_EnterDetail
 * @Description : This class implements the Page Object Model for updating
 *              customer details. It provides functionality to: 1. Update
 *              customer mobile number 2. Submit the update form 3. Verify page
 *              loading state The class uses explicit waits to ensure reliable
 *              interaction with web elements.
 *
 * @CreationDate : October 3, 2024
 * @Author : Bhavani Y
 * @Version : 1.0
 */

public class UpdateCustomerEnterDetailPage {
	/** WebDriver instance to interact with the browser */
	private WebDriver driver;

	/** WebDriverWait instance for explicit waits */
	private WebDriverWait wait;

	/** Element for customer mobile number input field */
	@FindBy(id = "customer_mobile_number")
	private WebElement customerMobNum;

	/** Element for update button */
	@FindBy(xpath = "//button[text()='Update Customer']")
	private WebElement btnUpdate;

	public UpdateCustomerEnterDetailPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @param sCustomerMobNum The new mobile number to be updated
	 * @return String - The page title after update or an error message
	 * @throws InterruptedException if the thread sleep is interrupted
	 */
	public String enterDetail(String sCustomerMobNum) {
		try {
			// Wait for and clear the mobile number field
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement mobileField = wait.until(ExpectedConditions.elementToBeClickable(customerMobNum));
			mobileField.clear();

			// Enter new mobile number
			mobileField.sendKeys(sCustomerMobNum);

			// Click update button
			WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(btnUpdate));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			updateButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			return driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred: " + e.getMessage();
		}
	}

	private void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean isPageLoaded() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(customerMobNum)) != null;
		} catch (Exception e) {
			return false;
		}
	}
}










































//import java.time.Duration;
//
//import org.openqa.selenium.ElementClickInterceptedException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//
//public class UpdateCustomer_EnterDetail {
//	private final WebDriver driver;
//	private final Wait<WebDriver> wait;
//
//	@FindBy(id = "customer_mobile_number")
//	private WebElement customerMobNum;
//
//	@FindBy(xpath = "//button[text()='Update Customer']")
//	private WebElement btnUpdate;
//
//	public UpdateCustomer_EnterDetail(WebDriver driver) {
//		this.driver = driver;
//
//		// Using FluentWait for more flexible waiting conditions
//		this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) // Increased timeout
//				.pollingEvery(Duration.ofMillis(500)) // Check every 500ms
//				.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class); // Ignore common
//																										// exceptions
//
//		PageFactory.initElements(driver, this);
//	}
//
//	public String enterDetail(String sCustomerMobNum) {
//		try {
//			// Scroll the page to ensure elements are in view
//			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
//
//			// Wait for and interact with the mobile number field
//			WebElement mobileField = waitAndGetElement(customerMobNum);
//			clearAndType(mobileField, sCustomerMobNum);
//
//			// Wait for and click the update button
//			WebElement updateButton = waitAndGetElement(btnUpdate);
//			clickElement(updateButton);
//
//			// Wait for page change (adjust timeout as needed)
//			String initialTitle = driver.getTitle();
//			wait.until(driver -> !driver.getTitle().equals(initialTitle));
//
//			return driver.getTitle();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "An error occurred: " + e.getMessage();
//		}
//	}
//
//	private WebElement waitAndGetElement(WebElement element) {
//		return wait.until(driver -> {
//			try {
//				return element.isDisplayed() ? element : null;
//			} catch (StaleElementReferenceException e) {
//				return null;
//			}
//		});
//	}
//
//	private void clearAndType(WebElement element, String text) {
//		wait.until(driver -> {
//			try {
//				element.clear();
//				element.sendKeys(text);
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
//		});
//	}
//
//	private void clickElement(WebElement element) {
//		wait.until(driver -> {
//			try {
//				if (element.isDisplayed() && element.isEnabled()) {
//					try {
//						element.click();
//					} catch (ElementClickInterceptedException e) {
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//					}
//					return true;
//				}
//				return false;
//			} catch (StaleElementReferenceException e) {
//				return false;
//			}
//		});
//	}
//
//	public boolean isPageLoaded() {
//		try {
//			return waitAndGetElement(customerMobNum) != null;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//}
//

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class UpdateCustomer_EnterDetail {
//     WebDriver driver;
//     WebDriverWait wait;
//
//    @FindBy(id = "customer_mobile_number")
//     WebElement customerMobNum;
//
////    @FindBy(xpath = "//button[@type='submit']")
////     WebElement btnUpdate;
//// 
//    @FindBy(xpath = "//button[text()='Update Customer']")
//    WebElement btnUpdate;
//    
//    
//    // Initializing the page object
//    public UpdateCustomer_EnterDetail(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
//        PageFactory.initElements(driver, this);
//    }
//
//    public String enterDetail(String sCustomerMobNum) {
//        try {
//            // Wait for the mobile number field to be clickable and clear it
//            WebElement mobileField = wait.until(ExpectedConditions.elementToBeClickable(customerMobNum));
//            mobileField.clear();
//            
//            // Instead of waiting for textToBe, just wait a brief moment
//            // (consider using Thread.sleep for a very short wait if necessary)
//            // This can be avoided with good practices, but sometimes it may be needed
//            Thread.sleep(100); // Add a brief wait (optional)
//
//            // Send the mobile number
//            mobileField.sendKeys(sCustomerMobNum);
//            
//            // Wait for the update button to be clickable and click it
//            WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(btnUpdate));
//            updateButton.click();
//            
//            // Wait for the page title to change (if applicable)
//            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(driver.getTitle())));
//            
//            return driver.getTitle();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "An error occurred: " + e.getMessage();
//        }
//    }
//    
//    // Helper method to wait for an element to be ready
//    private void waitForElement(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//    
//    // Optional: Method to check if the page is loaded
//    public boolean isPageLoaded() {
//        try {
//            return wait.until(ExpectedConditions.elementToBeClickable(customerMobNum)) != null;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}