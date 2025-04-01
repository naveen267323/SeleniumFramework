package Selenium.SeleniumFrameworkPOM;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExecutionOrder  {
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: Runs once before the entire test suite.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: Runs once after the entire test suite.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: Runs once before all test methods in the <test> tag.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: Runs once after all test methods in the <test> tag.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: Runs once before the first test method in this class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: Runs once after all test methods in this class.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Runs before each @Test method.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Runs after each @Test method.");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test Method 1: Executing the test.");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2: Executing the test.");
  }
}
