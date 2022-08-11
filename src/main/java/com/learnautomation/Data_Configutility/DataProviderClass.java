package com.learnautomation.Data_Configutility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="Login")
	public Object[][] LoginCredentials() throws IOException
	{
		return ExcelUitilty.readDataFromExcel("Login_Data");
	}
	@DataProvider(name="UserDetails")
	public Object[][] UseDetails() throws IOException
	{
		return ExcelUitilty.readDataFromExcel("User");
	}
}
