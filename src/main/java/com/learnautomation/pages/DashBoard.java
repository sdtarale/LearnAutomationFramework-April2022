package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class DashBoard {
	
	WebDriver driver;
	 public DashBoard(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 By Welcome=By.xpath("//a[@id='welcome']");
	 By logoutButton=By.xpath("//a[text()='Logout']");
	 
	 public void LogoutFromApp()
	 {
		 Utility.waitForWebElement(driver, 5, Welcome).click();
		 try
		 {
		 Utility.waitForWebElement(driver, 5, logoutButton).click();
		 }
		 catch (Exception e) 
		 {
			System.out.println("Failed to click Logout button");
			System.out.println("Trying Again");
			 Utility.waitForWebElement(driver, 5, logoutButton).click();
		 }
	 }
}
