package com.medicalApp_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
			
			WebDriver driver =new ChromeDriver();
			
			driver.get("https://10.10.20.182:3000/");
			
			driver.findElement(By.id("user_name")).sendKeys("pradeep");
			
			driver.findElement(By.id("password")).sendKeys("Matryx@22");
			
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			
			
			
			
			
			

		}


	}
