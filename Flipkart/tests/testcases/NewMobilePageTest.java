package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewMobilePage;

public class NewMobilePageTest extends TestBase{
	HomePage homePage;
	NewMobilePage newMobilePage;
	LoginPage loginPage;
	
	public NewMobilePageTest() {
		super();
	}
	
	
	@Test(priority=1)
	public void verifySearchBoxTest(){
		Assert.assertTrue(newMobilePage.verifySearchBoxIsDisplayed(), "Search box is not displayed");
	}
	
//	@Test(priority=2)
//	public void verifySearchTest() {
//		newMobilePage.performSearch(properties.getProperty("text"));
//	}

	@BeforeMethod
	public void setup() {
		//open browser
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.closeLoginWindow();
		newMobilePage = homePage.clickMobileMenu();
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}
}
