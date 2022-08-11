package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import net.bytebuddy.implementation.bytecode.Throw;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By UserNameTextBox=By.id("txtUsername");
	By PasswordTextBox=By.id("txtPassword");
	By LoginButton=By.id("btnLogin");
	
	
	public void loginToApplication(String Uname, String Pwd)
	{
		if(Uname!=null)
		{
			if(Pwd!=null)
			{
				driver.findElement(UserNameTextBox).sendKeys(Uname);
				driver.findElement(PasswordTextBox).sendKeys(Pwd);
				driver.findElement(LoginButton).click();
			}
			
		}
		else {
			throw new SkipException("Null Login data");
		}
		
	}
	
}
