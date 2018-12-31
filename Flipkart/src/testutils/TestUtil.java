package testutils;

import java.util.ArrayList;

import base.TestBase;

public class TestUtil extends TestBase{

	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOAD_TIMEOUT = 120;

	// switch windows
	public static void switchToWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		// Get the list of all windows
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String window : windowHandles) {
			if (window != currentWindowHandle) {
				driver.switchTo().window(window);
			}
			
		}
		//driver.switchTo().window(arg0)
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	public static void waitForPageLoad() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
