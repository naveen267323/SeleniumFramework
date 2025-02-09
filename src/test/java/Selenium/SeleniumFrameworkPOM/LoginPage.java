package Selenium.SeleniumFrameworkPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// Constructors

	WebDriver driver;

	LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators

	By useremail = By.id("userEmail");
	By userpassword = By.id("userPassword");
	By loginbutton = By.id("login");

	// Actions

	public void loginpageusermail(String email) {
		driver.findElement(useremail).sendKeys(email);
	}

	public void loginpageuserpassword(String password) {
		driver.findElement(userpassword).sendKeys(password);
	}

	public void loginpageloginbutton() {
		driver.findElement(loginbutton).click();
	}

}
