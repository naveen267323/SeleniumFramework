package Selenium.SeleniumFramework;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		String titlepage = driver.getTitle();
		System.out.println(titlepage);

//Entering the credentails Login Page 1

		driver.findElement(By.id("userEmail")).click();
		driver.findElement(By.id("userEmail")).sendKeys("naveendutt2025@gmail.com");
		driver.findElement(By.id("userPassword")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Howareyounaveen-1");
		driver.findElement(By.id("login")).click();
		String afterloginurl = driver.getCurrentUrl();

		System.out.println(afterloginurl);

		driver.manage().window().maximize();
		
//Adding to cart page 2		

		String cart = driver.findElement(By.xpath(".//b[normalize-space()='Banarsi Saree']")).getText();

		if (cart.contains("BANARSI SAREE")) {

			System.out.println(cart);

		}

		Thread.sleep(10);

		List<WebElement> addcarts = driver.findElements(By.cssSelector(".btn.w-10.rounded"));

		// check if there are atleast 3 addcart buttons //list webelements will get
		// the all the addcarts button and store it an array // if there are atleast 3
		// addcart buttons click //get(2) - choosing the 3rd addcart button and pass it
		// on to variable and click the 3rd addcart button

		// if (addcarts.size() >= 3) {
		// WebElement thirdAddCartButton = addcarts.get(2);
		// thirdAddCartButton.click();
		// }

		System.out.println(driver.findElements(By.cssSelector(".card-body")).size());

		Thread.sleep(5);

		List<WebElement> addcart = driver.findElements(By.cssSelector(".card-body"));

		// Once you store all the element in the list - you need to use enhanced for
		// loop and
		// and pass the list to the another webelement to getall the selenium methods so
		// that you will get the gettextmethod
		// and print.

		for (WebElement item : addcart) {
			System.out.println(item.getText());
		}

		// logic to add BANARSI SAREE in the page to the cart.

		// you have identified the card-body element which is common in page and
		// store in the addcart list
		// now after storing all the card-body, find the item called BANARSI SAREE in
		// the list using contains and get textmethod which you wanted to add to
		// cart using for loop and if statment and then add cart click.

		Thread.sleep(5);

		for (WebElement item : addcart) {
			if (item.getText().contains("BANARSI SAREE")) {
				System.out.println("I found Banarsi Saree");

				item.findElement(By.cssSelector(".btn.w-10.rounded")).click();
				break;
			}

		}

// validating and hitting on the cart button

		String carttext = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).getText();

		System.out.println(carttext);

		// Wait for the spinner/overlay to disappear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));

		if (carttext.contains("Cart")) {
			driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		}

		System.out.println(driver.getCurrentUrl());

//validating the cart item in cart page 3

		String carturl = driver.getCurrentUrl();

		if (carturl.contains("https://rahulshettyacademy.com/client/dashboard/cart")) {

			System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Banarsi Saree']")).getText());

			System.out.println(" You are in the cartpage and Banarsi Saree is present in the cart");
		} else {
			System.out.println("You are not in the cartpage or Banarsi Saree is not present in the cart");
		}

//capturing the item id from the cart page:

		String itemid = driver.findElement(By.xpath("//p[@class='itemNumber']")).getText();
		System.out.println(itemid);

//spliting the item ID : #676a631fe2b5443b1f004a20
		String[] itemid1 = itemid.split("#");
		System.out.println(itemid1[1]);

		String itemcart = driver.findElement(By.xpath("//h3[normalize-space()='Banarsi Saree']")).getText();

		System.out.println(itemcart);

		// page needs to scroll down to see the checkout button
		// making use of action class to scroll down the webpage because button is not
		// visible

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // scroll once
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // scroll down 2nd time
		actions.sendKeys(Keys.PAGE_DOWN).build().perform(); // scroll down 3rd time

		driver.findElement(By.xpath("//*[text()='Checkout']")).click();

		// checkoutButton.click();

		Thread.sleep(2000);

//validating the item id from the checkout page.
//order id is present in the url of the check out page

		String checkouturl = driver.getCurrentUrl();
		System.out.println("Checkout page   " + checkouturl);

//spliting the url : https://rahulshettyacademy.com/client/dashboard/order?prop=%5B%22676a631fe2b5443b1f004a20%22%5D

		// Extract the 'prop' parameter value from the URL
		String propValue = checkouturl.split("prop=")[1]; // Get everything after 'prop='

		// Decode the URL-encoded value
		String decodedValue = URLDecoder.decode(propValue, "UTF-8"); // Converts %5B%22...%22%5D to
																		// ["676a631fe2b5443b1f004a20"]

		// Extract the ID (remove brackets and quotes)
		String extractedID = decodedValue.replaceAll("[\\[\\]\"]", "");

		// Print the extracted ID
		System.out.println(extractedID);

		if (itemid1[1].contains(extractedID)) {
			System.out.println("order id of banarsi saree " + extractedID);
		} else {
			System.out.println("issue is in the if statement");
		}

		
//Checkout page 4
//filling the card details in the checkout page and hitting on place order and capturing the order ID

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("United States");

		// country.click();
		// country.sendKeys("United States"); // sending United States and selecting the
		// from the dropdown

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click(); // choosing the country

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("121");

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Naveen");

		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();

		Thread.sleep(2000);

// get the order ID of the order page 5
		System.out.println(driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText());

		Actions actions1 = new Actions(driver);
		actions1.sendKeys(Keys.PAGE_UP).perform(); // scroll once
		actions1.sendKeys(Keys.PAGE_UP).perform(); // scroll down 2nd time
		actions1.sendKeys(Keys.PAGE_UP).build().perform(); // scroll down 3rd time

		String confirm_message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirm_message);

	}

}
