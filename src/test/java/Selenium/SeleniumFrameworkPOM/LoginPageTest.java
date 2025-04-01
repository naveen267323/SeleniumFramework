package Selenium.SeleniumFrameworkPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {

	public WebDriver driver;

	@BeforeClass
	void startbrowser() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();

	}

	@Test
	void Login() {

		LoginPage lp = new LoginPage(driver);
		lp.loginpageusermail("naveendutt2025@gmail.com");
		lp.loginpageuserpassword("Howareyounaveen-1");
		lp.loginpageloginbutton();

	}

	@AfterClass
	void teardown() {
		if (driver != null)
			driver.quit();
	}

}
