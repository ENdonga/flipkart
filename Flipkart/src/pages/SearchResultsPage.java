package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import testutils.TestUtil;

public class SearchResultsPage extends TestBase {

	// create object repository for search results page
	WebElement resultsPageHeading = driver.findElement(By.xpath("//span[@class='_2yAnYN']"));
	WebElement motorolaCheckBox = driver.findElement(By.xpath("//div[@class='_1GEhLw'][contains(text(),'Motorola')]"));
	WebElement ramCheckBox = driver.findElement(By.xpath("//div[@class='_1GEhLw'][contains(text(),'4 GB')]"));
	List<WebElement> descriptionTitles = driver.findElements(By.xpath("//div[@class='_3wU53n']"));

	public SearchResultsPage() {
		// TODO Auto-generated constructor stub
	}

	// Get the description text after search i.e showing 1 - 24 of ...
	public String validateSearchResultsHeading() {
		return resultsPageHeading.getText();
	}

	// Verify if the motorola check box is displayed
	public boolean verifyMotorolaCheckBox() {
		return motorolaCheckBox.isDisplayed();
	}

	// verify the 4GB ram check box is displayed
	public boolean validate4GbRamCheckBox() {
		return ramCheckBox.isDisplayed();
	}

	// click the motorola check box
	public boolean clickMotorolaCheckBox() {
		if (!verifyMotorolaCheckBox()) {
			System.out.println("Check box is not displayed.");
			return false;
		} else if (motorolaCheckBox.isSelected()) {
			// uncheck the check box if selected
			motorolaCheckBox.click();
			return false;
		} else {
			// click on the checkbox
			motorolaCheckBox.click();
			return true;
		}
	}

	// select 4GB ram in the ram filter subsection
	public void clickOn4GbRamCheckBox() {
		// check to see if check box is selected
		if (ramCheckBox.isSelected()) {
			// click the check box
			ramCheckBox.click();
			// get a list of webelements having 4GB ram in the product description
			List<WebElement> description = driver
					.findElements(By.xpath("//li[@class='tVe95H'][contains(text(),'4 GB RAM')]"));
			for (int i = 0; i < description.size(); i++) {
				if (description.size() > 0) {
					String productDescription = description.get(i).getText();
					if (productDescription.contains("4 GB")) {
						if (i < 2) {
							// System.out.println("Description: " + productDescription);
						} else {
							break;
						}
					}
				}
			}
		} else {
			// click the check box
			ramCheckBox.click();
			// get a list of webelements having 4GB ram in the product description
			List<WebElement> description = driver
					.findElements(By.xpath("//li[@class='tVe95H'][contains(text(),'4 GB RAM')]"));
			for (int i = 0; i < description.size(); i++) {
				if (description.size() > 0) {
					String productDescription = description.get(i).getText();
					if (productDescription.contains("4 GB")) {
						if (i < 2) {
							// System.out.println("Description: " + productDescription);
						} else {
							break;
						}
					}
				}
			}
		}
	}

	public boolean clickRamCheckBox() {
		// locate the ram section and click the 4GB ram checkbox
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='_1GEhLw'][contains(text(),'4 GB')]")));
		WebElement ramCheckBox = driver.findElement(By.xpath("//div[@class='_1GEhLw'][contains(text(),'4 GB')]"));
		if (ramCheckBox.isDisplayed()) {
			if (ramCheckBox.isSelected()) {
				// first uncheck and check it again
				ramCheckBox.click();
				ramCheckBox.click();
			} else {
				ramCheckBox.click();
			}
		} else {
			System.out.println("4GB ram check box is not displayed");
		}
		return true;
	}

	// Verify item description
	public void verifyMotorolaProductTitle() {
		if (!clickMotorolaCheckBox()) {
			System.out.println("sorry motorola checkbox is not checked");
		} else {
			// get the list for the product title when motorola check box is selected
			List<WebElement> productTitleText = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
			for (int i = 0; i < productTitleText.size(); i++) {
				if (productTitleText.size() > 0) {
					String title = productTitleText.get(i).getText();
					if (title.contains("Moto")) {
						if (i < 2) {
							// System.out.println("Title - " + title);
						} else {
							break;
						}
					}
				}
			}
		}
	}

	// view phone details
	// public void viewPhoneDetails() {
	// String URL = newTabURL();
	// driver.get(URL);
	// //return new ViewDetailsPage();
	// }

	// public String newTabURL() {
	// WebElement anchor = driver.findElement(By.xpath("//div[contains(text(),'" +
	// getFirstEntryInList() +"')]"));
	// System.out.println("XPath: " + anchor);
	// String parentWindow = driver.getWindowHandle();
	// System.out.println("Parent Window: " + parentWindow);
	// //String tabURL = anchor.getAttribute("href");
	// //System.out.println("URL " + tabURL);
	// anchor.click();
	// TestUtil.switchToWindow();
	// String url = driver.getCurrentUrl();
	//
	// System.out.println("URL: " + url);
	// //driver.navigate().to(url);
	// return url;
	// }

	public String verifyPhoneDetailsPage() {
		return driver.getTitle();
	}

	// Get the first phone in the search results window
	public String getFirstEntryInList() {
		if (descriptionTitles.isEmpty()) {
			return "";
		} else {
			for(WebElement title : descriptionTitles) {
				if(descriptionTitles.size()>0) {
					String searchResultTitle = descriptionTitles.get(0).getText();
					//System.out.println("Title :" + searchResultTitle);
					return searchResultTitle;
				}
				return title.getText();
			}
			return null;
		}
	}
	
//	public String acquireFirstTitleInSearchResultsPage() {
//	
//		// get the total number of phone titles names returned in the search results per page
//		for(WebElement title : descriptionTitles) {
//			if(descriptionTitles.size()>0) {
//				String searchResultTitle = descriptionTitles.get(0).getText();
//				System.out.println("Title :" + searchResultTitle);
//				return searchResultTitle;
//			}
//			return title.getText();
//		}
//		return null;
//	}
	
	

	// click the phone name text div for the the first returned phone in the results
	// list
	public void clickPhoneListDiv() {
		// create a custom Xpath
		String beforeXpath = "//div[contains(text(),'";
		String phoneName = getFirstEntryInList();
		String afterXpath = "')]";
		String actualXpath = beforeXpath + phoneName + afterXpath;
		// System.out.println("Xpath: " + actualXpath);
		WebElement phoneDetailsLink = driver.findElement(By.xpath(actualXpath));
		// Click the Xpath to open the phone details
		phoneDetailsLink.click();
	}

	public void uncheckMotorolaCheckBox() {
		// System.out.println("Check box already selected");
		WebElement uncheckBox = driver.findElement(By.xpath("//div[@title='Motorola']//div[@class='_2kFyHg _2mtkou']"));
		uncheckBox.click();
	}

	public void clearAllBrandFilters() {
		clickRamCheckBox();
		// Wait for the page to reload and select brand checkbox
		TestUtil.waitForPageLoad();
		clickMotorolaCheckBox();
		TestUtil.waitForPageLoad();
		// Clear the brand filter
		uncheckMotorolaCheckBox();
		// TestUtil.waitForPageLoad();
		// Verify the product title
		// get the list for the product title when motorola check box is selected
		List<WebElement> productTitleText = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		for (int i = 0; i < productTitleText.size(); i++) {
			if (productTitleText.size() > 0) {
				String title = productTitleText.get(i).getText();
				if (title.contains("Moto")) {
					if (i < 2) {
						// System.out.println("Title - " + title);
					} else {
						break;
					}
				}
			}
		}
	}
}
