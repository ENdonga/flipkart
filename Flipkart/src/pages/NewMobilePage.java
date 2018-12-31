package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class NewMobilePage extends TestBase {

	// Create an object repository for the new mobile page
	WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));

	public NewMobilePage() {

	}

	public boolean verifySearchBoxIsDisplayed() {
		return searchBox.isDisplayed();
	}

	public SearchResultsPage performSearch(String searchText) {
		// clear search text box
		searchBox.clear();
		searchBox.sendKeys(searchText);
		searchButton.click();
		return new SearchResultsPage();
	}
}
