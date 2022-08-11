package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.Data_Configutility.ConfigUtility;
import com.learnautomation.factory.BrowserFactory;

public class BaseClass {

	public WebDriver driver;
	
	public WebDriver getUpDriver()
	{
		return driver;
	}
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.StartBrowser(ConfigUtility.getConfigData("Browser"));
		driver.get(ConfigUtility.getConfigData("QA_URL"));
	}
	@AfterClass(description=" Tear Down")
	public void tearDown()
	{
		driver.quit();
	}
	
}
