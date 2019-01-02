package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewMobilePage;
import pages.SearchResultsPage;
import pages.ViewDetailsPage;
import testutils.TestUtil;

public class ViewDetailsPageTest extends TestBase{
	HomePage homePage;
	NewMobilePage newMobilePage;
	LoginPage loginPage;
	SearchResultsPage searchResultsPage;
	ViewDetailsPage viewDetailsPage;
	
	public ViewDetailsPageTest() {
		super();
	}
	
	@Test(priority = 1)
	public void verifyDetailsPageHeadingTest() {
		Assert.assertEquals(viewDetailsPage.getPhoneName(),viewDetailsPage.getPhoneName());
	}

	@Test(priority = 2)
	public void verifyCartDetailsPagesTest() {
		Assert.assertEquals(viewDetailsPage.clickAddToCart(), "MY CART (1)");
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.closeLoginWindow();
		newMobilePage = homePage.clickMobileMenu();
		searchResultsPage = newMobilePage.performSearch(properties.getProperty("text"));
		//viewDetailsPage = searchResultsPage.viewPhoneDetails();
		searchResultsPage.clickPhoneListDiv();
		TestUtil.switchToWindow();
		viewDetailsPage = new ViewDetailsPage();
		
	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
