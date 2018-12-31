package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		Assert.assertEquals(homePage.verifyHomePageTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!");
	}
	@Test(priority=2)
	public void validateElectronicsMenuTest() {
		Assert.assertTrue(homePage.verifyElectronicsMenuLink(), "Electronics menu is not displayed");
	}

	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.clickOnLoginButton(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}
}
