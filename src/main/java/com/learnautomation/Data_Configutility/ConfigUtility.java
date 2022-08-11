package com.learnautomation.Data_Configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
	public static Properties pro;
	
	public static String getConfigData(String value)
	{
		creatConfigInstace();
		return pro.getProperty(value);
	}
	
	public static void creatConfigInstace()
	{
		if(pro==null)
		{
			pro=new Properties();
			try {
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration_3/Config.properties")));
			} catch (FileNotFoundException e) {
				System.out.println("Could not find the file " +e.getMessage());
			} catch (IOException e) {
				System.out.println("Could not open the file " +e.getMessage());
			}
		}
		else
		{
			System.out.println("Propery file is already loaded. Using the same");
		}
		
	}
	
}
