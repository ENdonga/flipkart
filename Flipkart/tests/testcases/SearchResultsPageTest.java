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

public class SearchResultsPageTest extends TestBase{
	HomePage homePage;
	NewMobilePage newMobilePage;
	LoginPage loginPage;
	SearchResultsPage searchResultsPage;

	public SearchResultsPageTest() {
		super();
	}

	@Test(priority = 1)
	public void verifySearchResultsPageHeadingTest() {
		String searchHeadingDescription = searchResultsPage.validateSearchResultsHeading();
		Assert.assertEquals(searchResultsPage.validateSearchResultsHeading(),searchHeadingDescription);
	}

	@Test(priority =2)
	public void validateMotorolaCheckBoxTest() {
		Assert.assertTrue(searchResultsPage.verifyMotorolaCheckBox(), "Check box is not displayed");
	}
	
	@Test(priority = 3)
	public void verifyMotorolaCheckedTest() {
		Assert.assertTrue(searchResultsPage.clickMotorolaCheckBox(), "Checkbox is not selected");
	}
	
	@Test(priority = 4)
	public void verifyMotorolaProductTitleTest() {
		searchResultsPage.verifyMotorolaProductTitle();
	}
	
	@Test(priority = 5)
	public void verify4GbRamCheckBoxTest() {
		Assert.assertTrue(searchResultsPage.validate4GbRamCheckBox(), "4GB ram is not displayed");
	}
	
	@Test(priority = 6)
	public void validate4GbProductDescriptionTest() {
		searchResultsPage.clickOn4GbRamCheckBox();
	}
	
	@Test(priority = 7)
	public void verifyFirstItemInListTest() {
		String title = searchResultsPage.getFirstEntryInList();
		Assert.assertEquals(title, searchResultsPage.getFirstEntryInList());
		System.out.println(title);
	}
	
	@Test(priority = 8)
	public void clickPhoneDetailsLinkTest() {
		searchResultsPage.clickPhoneListDiv();
	}
	
	@Test(priority = 9)
	public void clearBrandFiltersTest() {
		searchResultsPage.clearAllBrandFilters();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.closeLoginWindow();
		newMobilePage = homePage.clickMobileMenu();
		searchResultsPage = newMobilePage.performSearch(properties.getProperty("text"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
