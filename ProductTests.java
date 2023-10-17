package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.Products;
import utilities.Utils;

public class ProductTests {
	private WebDriver driver;
	private Login loginPage;
	private Products productPage;
	private Utils utils;
	


	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		loginPage = new Login(driver);
		productPage = new Products(driver);
		loginPage.login("standard_user", "secret_sauce");
		

	}
	
	 @Test
	 public void VerifyTitleforProduct() {
		 boolean result = utils.verifyTitle(driver, "Swag Labs");
		 Assert.assertTrue(result);
	 }
}
