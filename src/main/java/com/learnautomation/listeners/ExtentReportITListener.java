package com.learnautomation.listeners;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.helper.Utility;

public class ExtentReportITListener implements ITestListener{
	ExtentReports extent=ExtentManager.getExtentReportInstance();
	ThreadLocal<ExtentTest> parent=new ThreadLocal<ExtentTest>();
	
	 
	
		public synchronized void onFinish(ITestContext context) {
			extent.flush();
		}
		
	
		public synchronized void onTestStart(ITestResult result) {
			System.out.println("Log INFO: Test Started");
			ExtentTest child=extent.createTest(result.getMethod().getMethodName());
			parent.set(child);
	 
		}

		public synchronized void onTestSuccess(ITestResult result) {
		parent.get().pass("Test passed");
		}

		public synchronized void onTestFailure(ITestResult result) {
			WebDriver driver=null;
		
			try {
				//driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
				IClass cl1=result.getTestClass();
				Class cl2=cl1.getRealClass();
				Field f1=cl2.getDeclaredField("driver");
				Object ob1=f1.get(result.getInstance());
				driver=(WebDriver) ob1;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
				
			
		
			
			parent.get().fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreeshotBase64(driver)).build());
		}

	
		public synchronized void onTestSkipped(ITestResult result) {
		parent.get().skip(result.getThrowable().getMessage());
		}

	
			

}
