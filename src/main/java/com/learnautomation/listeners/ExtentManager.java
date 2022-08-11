package com.learnautomation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.helper.Utility;

public class ExtentManager {
	public static ExtentReports extent=null;
	
	public static ExtentReports getExtentReportInstance()
	{
		if(extent==null)
		{
			return createExtentReportInstance();
		}
		else
		{
			return extent;
		}
	}
	public static ExtentReports createExtentReportInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports_3/"+Utility.getCurrentDateTime()+"AutomationReports.html");
		reporter.config().setDocumentTitle("Orange HRM report");
		reporter.config().setReportName("Login Application");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	
}
