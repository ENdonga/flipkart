package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.TestBase;

public class HomePage extends TestBase {

	// Create an object repository for the home page
	WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login & Signup')]"));
	WebElement electronicsMenuLink = driver.findElement(By.xpath("//ul[@class='_114Zhd']/li[1]/span[1]/*[1]"));
	// locate sub menus under electronics menu
	// WebElement navBar = driver.findElement(By.xpath("//ul[@class='_114Zhd']"));
	WebElement mobileMenuLink = driver.findElement(By.xpath("//a[@title='Mobiles']"));
	// WebElement usernameLabel =
	// driver.findElement(By.xpath("//div[@class='_2cyQi_']"));

	public HomePage() {

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyElectronicsMenuLink() {
		return electronicsMenuLink.isDisplayed();
	}

	public MobilePage clickOnMobileMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(electronicsMenuLink).build().perform();
		mobileMenuLink.click();
		return new MobilePage();
	}

	public NewMobilePage clickMobileMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(electronicsMenuLink).build().perform();
		mobileMenuLink.click();
		return new NewMobilePage();
	}
//		public String verifyUser() {
//			return usernameLabel.getText();
//		}
}
