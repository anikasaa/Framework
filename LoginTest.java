package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.Products;

public class LoginTest {
	private WebDriver driver;
    private Login loginPage;
    private Products productPage;
    
    
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new Login(driver);
        productPage = new Products(driver);
        
    }
    //LogIn Test case
    @Test
    public void loginAndAddToCartTest() {
    	loginPage.login("standard_user", "secret_sauce");

    }
    //login without password and verify it shows error
    @Test
    public void loginWithoutPassword() {
    	loginPage.loginwithoutPassword("standard_user");
    	boolean avail = loginPage.errorState();
        Assert.assertTrue(avail);
    }
    
    
    @Test
    public void verifyTitleForLogin() {
        String actual = loginPage.verifyTitle();
        String expected = "Swag Labs";
        Assert.assertEquals(actual, expected);
    }
    
    
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
