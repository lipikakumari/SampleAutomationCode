package com.wordpress.TestNgListnerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("TestCase finished and details are:" + result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) {
		//System.out.println("TestCase started and details are:" + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//System.out.println("TestCase failed and details are:" + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TestCase failed and details are:" + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase skipped and details are:" + result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase started and details are:" + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase passed and details are:" + result.getName());
		
	}

}
