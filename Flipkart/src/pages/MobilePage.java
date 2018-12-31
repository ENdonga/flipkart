package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class MobilePage extends TestBase{

	// Create an object repository for the mobile page
		WebElement pageHeading = driver.findElement(By.xpath("//h1[@class='_30P0WS']"));
		WebElement ram4GbCheckBox = driver.findElement(By.xpath("//div[@title='4 GB']//label"));
		List<WebElement> filterList = driver.findElements(By.xpath("//div[@class='_3O0U0u']"));
		WebElement brandSearchBox = driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));

		public MobilePage() {

		}

		public String verifyMobilePageTitle() {
			return driver.getTitle();
		}

		public String verifyMobilePageHeading() {
			return pageHeading.getText();
		}

		public boolean verifyCheckBoxPresent() {
			return ram4GbCheckBox.isDisplayed();
		}

		public void clickCheckBox() {
			if (ram4GbCheckBox.isSelected()) {
				System.out.println("Check is already selected");
			} else {
				ram4GbCheckBox.click();
			}
		}

		public void verifyItemDescription() {
			// int count = filterList.size();
			for (WebElement element : filterList) {
				if (element.getText().contains("4 GB RAM | 64 GB ROM | Expandable Upto 256 GB")) {
					System.out.println("Mobile with 4GB found.");
				}
			}
		}

		public boolean verifyBrandSearchBox() {
			return brandSearchBox.isDisplayed();
		}

		public boolean verifyMototolaCheckbox() {
			if (!brandSearchBox.isDisplayed()) {
				System.out.println("Search box is not displayed");
				return false;
			} else {
				// Clear search box before typing
				brandSearchBox.clear();
				brandSearchBox.sendKeys("Moto");
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_1GEhLw'][contains(text(),'Motorola')]")));
				// WebElement checkbox =//
				// driver.findElement(By.xpath("//div[@class='_1GEhLw'][contains(text(),'Motorola')]"));
				// checkbox.click();
				return brandSearchBox.isDisplayed();
			}
		}

		public void clickMotorolaCheckBox() {
			if (!brandSearchBox.isDisplayed()) {
				System.out.println("Check box is not displayed");
			} else {
				// Clear search box before typing
				brandSearchBox.clear();
				brandSearchBox.sendKeys("Moto");
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_1GEhLw'][contains(text(),'Motorola')]")));
				WebElement checkbox = driver.findElement(By.xpath("//div[@class='_1GEhLw'][contains(text(),'Motorola')]"));
				checkbox.click();

				// Get the list items displayed
				List<WebElement> mobileItemTitle = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
				for (int i = 0; i < mobileItemTitle.size() ; i++) {
					if(mobileItemTitle.size() > 0 ) {
						String title = mobileItemTitle.get(i).getText();
						if (title.contains("Moto")) {
							if(i < 2) {
								System.out.println("Title - " + title);
							} else {
								break;
							}
						}
					}
				}
			}
		}

}
