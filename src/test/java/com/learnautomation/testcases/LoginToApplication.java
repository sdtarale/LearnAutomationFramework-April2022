package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.Data_Configutility.DataProviderClass;
import com.learnautomation.base.BaseClass;
import com.learnautomation.pages.DashBoard;
import com.learnautomation.pages.LoginPage;

public class LoginToApplication extends BaseClass{
	LoginPage login;
	DashBoard dash;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUpDriver()
	{
		driver=getUpDriver();
	}

	
		@Test(description="Login", priority=1, dataProvider = "Login", dataProviderClass = DataProviderClass.class)
		public void Login(String un, String pwd)
		{
			login=new LoginPage(driver);
			login.loginToApplication(un, pwd);
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Failed");
			logout();
			
		}
		
	//	@Test(description="Logout", priority=2)
		public void logout()
		{
			dash=new DashBoard(driver);
			dash.LogoutFromApp();
			Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Logout Failed");

		}
		}
