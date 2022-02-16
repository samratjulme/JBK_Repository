package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		    test = report.createTest(result.getName());
		    log.info("Start Testcase with name as ==>"+result.getName());
	}

	     
	public void onTestSuccess(ITestResult result) {
		    test.log(Status.PASS, "Testcase passed with name ==>"+result.getName());
		    log.info("Passed Testcase name ==>"+result.getName());
	}

	     
	public void onTestFailure(ITestResult result) {
		    test.log(Status.FAIL, "Testcase failed with name ==>"+result.getName());
		    log.info("Failed Testcase name ==>"+result.getName());
		    test.addScreenCaptureFromPath(captureScreenshot(result.getName()));
	}

	     
	public void onTestSkipped(ITestResult result) {
		    test.log(Status.SKIP, "Testcase skip with name as ==>"+result.getName());
		    log.info("Skipped Testcase name ==>"+result.getName());
	}

	     
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	     
	public void onStart(ITestContext context) {
	}

	     
	public void onFinish(ITestContext context) {
	}

}
