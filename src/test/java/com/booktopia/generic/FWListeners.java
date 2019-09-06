package com.booktopia.generic;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class FWListeners implements ITestListener,ITestConstants{

	@Override
	public void onFinish(ITestContext arg0) {
		Date date= new Date();
		Reporter.log("Test execution finished at: "+date,true);

	}

	@Override
	public void onStart(ITestContext arg0) {
		Date date= new Date();
		Reporter.log("Test execution started at: "+date,true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		String name= UtilitiyLib.now();
		String path=SCREENSHOT_PATH+name+".png";
		UtilitiyLib.captureScreenShot(path);
		Reporter.log("Test case is failed, screenshot is captured",true);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
