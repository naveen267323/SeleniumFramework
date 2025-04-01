package Selenium.SeleniumFrameworkPOM;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Class implements ITestListener {

	public void onStart(ITestContext arg0) {
		System.out.println("Test Execution Started");
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult arg0) {
			System.out.println("Test Success ");
	}

	public void onTestFailure(ITestResult arg0) {
			System.out.println("There is a failure");
	}

	public void onTestFinish(ITestResult arg0) {
		System.out.println("Test Finish");
	}

}
