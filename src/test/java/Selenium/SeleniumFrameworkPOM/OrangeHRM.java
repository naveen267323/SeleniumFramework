package Selenium.SeleniumFrameworkPOM;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

//Priority is an annotation which can be used to make sure to run the testcase/testmethod based on the order whichever we want

	WebDriver driver;

	@BeforeClass
	public void LaunchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority = 2)
	public void Failtest() {

		driver.findElement(By.xpath("button[normalize-space()='Login']")).click();
		System.out.println("Failing this test cases by passing invalid xpath to understand the listeners");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterClass
	public void teardown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();

	}

}
