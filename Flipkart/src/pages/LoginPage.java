package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class LoginPage extends TestBase {

	// Create an object repository for the login page
	WebElement loginModal = driver.findElement(By.xpath("//div[@class='_32LSmx']"));
	WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login & Signup')]"));
	WebElement emailTextBox = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']"));
	WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
	WebElement loginBtn = driver.findElement(By.xpath("//div[@class='_1avdGP']//button[@type='submit']"));
	WebElement loginWindowCloseBtn = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));

	public LoginPage() {

	}

	public boolean verifyLoginModalIsDisplayed() {
		return loginModal.isDisplayed();
	}

	public HomePage clickOnLoginButton(String username, String password) {
		// Clear text fields before sending data
		emailTextBox.clear();
		emailTextBox.sendKeys(username);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}

	public HomePage closeLoginWindow() {
		loginWindowCloseBtn.click();
		return new HomePage();
	}

	public void verifyUser() {
		if (loginLink.getText().equalsIgnoreCase("Login & Signup")) {
			System.out.println("User is not logged in.");
		} else {
			WebElement usernameLabel = driver.findElement(By.xpath("//div[@class='_2cyQi_']"));
			usernameLabel.getText();
		}
	}
}
