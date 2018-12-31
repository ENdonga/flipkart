package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ViewDetailsPage extends TestBase {

	// create object repository for the details page
	WebElement nameOfPhone = driver.findElement(By.xpath("//div[@class='bhgxx2 col-12-12']/div[@class='_29OxBi']/div[1]"));
//		@FindBy(xpath = "//span[@class='_35KyD6']")
//		WebElement nameOfPhone;
	WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));

	public ViewDetailsPage() {

	}

	public String getPhoneName() {
		String phoneName = nameOfPhone.getText();
		// System.out.println("Phone: " + phoneName);
		return phoneName;
	}

	public String clickAddToCart() {
		addToCartBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_1WMqsr']")));
		WebElement cartLabel = driver.findElement(By.xpath("//span[@class='_1WMqsr']"));
		return cartLabel.getText();
	}
}
