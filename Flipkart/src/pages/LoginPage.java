package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		try {
			// Clear text fields before sending data
			emailTextBox.clear();
			emailTextBox.sendKeys(username);
			passwordTextBox.clear();
			passwordTextBox.sendKeys(password);
			loginBtn.click();
			return new HomePage();
		} catch (Exception e) {
			loginWindowCloseBtn.click();
			driver.navigate().refresh();
			return new HomePage();
		}
	}

	public String verifyUserIsLoggedIn() {
		WebElement usernameLabel = driver.findElement(By.xpath("//div[@class='_2cyQi_']"));
		return usernameLabel.getText();
	}
	
	public String verifySuccessfulLogout() {
		WebElement usernameLabel = driver.findElement(By.xpath("//div[@class='_2cyQi_']"));
		Actions logout = new Actions(driver);
		logout.moveToElement(usernameLabel).build().perform();
		WebElement logoutLink = driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Logout')]")));
		logoutLink.click();
		// Locate login text in login modal window
		WebElement loginText = driver.findElement(By.xpath("//span[@class='_1hgiYz']//span[contains(text(),'Login')]"));
		return loginText.getText();
	}
	
	public HomePage closeLoginWindow() {
		loginWindowCloseBtn.click();
		return new HomePage();
	}
}
