package Selenium.SeleniumFrameworkPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider {

	WebDriver driver;

	@Test(dataProvider ="dp")
	void login(String userid, String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userid);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@DataProvider(name = "dp")
	Object[][] data() {

		Object data[][] = { 
				{ "Admin", "a" },
				{ "Admin", "a1" }, 
				{ "Admin", "adm" },
				{ "Admin", "admi" },
				{ "Admin", "admin123" },
				};

		return data;
	}

}
