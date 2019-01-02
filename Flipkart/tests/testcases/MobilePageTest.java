package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MobilePage;

public class MobilePageTest extends TestBase{
	HomePage homePage;
	MobilePage mobilePage;
	LoginPage loginPage;

	public MobilePageTest() {
		super();
	}

	@Test(priority = 1)
	public void verifyMobilePageTitleTest() {
		Assert.assertEquals(mobilePage.verifyMobilePageTitle(),	"Mobile Phones: Buy Mobiles (मोबाइल) Online at Best Prices in India");
	}

	@Test(priority = 2)
	public void verifyMobilePageHeadingTest() {
		Assert.assertEquals(mobilePage.verifyMobilePageHeading(), "Mobile phones");
	}

	@Test(priority = 3)
	public void validateCheckBoxIsDisplayedTest() {
		Assert.assertTrue(mobilePage.verifyCheckBoxPresent(), "Checkbox is not displayed");
	}

	@Test(priority = 4)
	public void validateCheckBoxCheckedTest() {
		mobilePage.clickCheckBox();
	}

	@Test(priority = 5)
	public void validateBrandSearchBoxTest() {
		Assert.assertTrue(mobilePage.verifyBrandSearchBox(), "Search box is not displayed");
	}

	@Test(priority = 6)
	public void verifyMotorolaCheckboxTest() {
		Assert.assertTrue(mobilePage.verifyMototolaCheckbox(), "Check box is not displayed");
	}

//	@Test(priority = 7)
//	public void verifyMotorolaCheckBoxTest() {
//		mobilePage.clickMotorolaCheckBox();
//	}

	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.closeLoginWindow();
		mobilePage = homePage.clickOnMobileMenu();
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}

}
