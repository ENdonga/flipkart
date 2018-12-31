package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@Test(priority = 1)
	public void validateLoginWindowTest() {
		Assert.assertTrue(loginPage.verifyLoginModalIsDisplayed(), "Login Window is not shown");
	}

	@Test(priority = 2)
	public void validateLoginTest() {
		homePage = loginPage.clickOnLoginButton(properties.getProperty("username"), properties.getProperty("password"));
		// Assert.assertEquals(homePage.verifyUser(), "gaurav");
	}

	@Test(priority = 3)
	public void validateCloseLoginWindowTest() {
		homePage = loginPage.closeLoginWindow();
		Assert.assertEquals(homePage.verifyHomePageTitle(),
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!");
	}

	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}
}
