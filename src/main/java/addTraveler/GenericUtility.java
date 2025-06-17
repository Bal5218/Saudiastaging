package addTraveler;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;

public class GenericUtility {

	public static void autoSuggestation() {

	}

	public static int getRandomNumber() {
		Random random = new Random();
		int radnum = random.nextInt(5000);
		return radnum;
	}

	public static void clickConfirmButton(String locator) throws InterruptedException {
		int attempts = 0;
		int maxAttempts = 3; // Retry up to 3 times

		while (attempts < maxAttempts) {
			try {
				QaBrowser.driver.findElement(By.xpath(locator)).click();
				System.out.println("Clicked Confirm button successfully.");
				break; // Exit loop if click is successful
			} catch (ElementClickInterceptedException e) {
				attempts++;
				System.out.println("Attempt " + attempts + " failed: ElementClickInterceptedException caught.");
				e.printStackTrace();
				Thread.sleep(2000); // wait 2 seconds before retrying
				if (attempts == maxAttempts) {
					System.out.println("Max attempts reached. Could not click the Confirm button.");
					throw e; // rethrow exception after max attempts
				}
			}
		}
	}

	public static void clickConfirmButtonwithpassingvalue(String locator, String value) throws InterruptedException {
		int attempts = 0;
		int maxAttempts = 3; // Retry up to 3 times

		while (attempts < maxAttempts) {
			try {
				WebElement A = QaBrowser.driver.findElement(By.xpath(locator));

				A.click();
				A.clear();
				A.sendKeys(value);
				System.out.println("Clicked Confirm button successfully.");
				break; // Exit loop if click is successful
			} catch (ElementClickInterceptedException e) {
				WebElement A = QaBrowser.driver.findElement(By.xpath(locator));
				A.click();
				A.clear();
				A.sendKeys(value);
			}
		}
	}

	public static void handleMultipleSuggestation(String locator, String value) throws Throwable {
		List<WebElement> list_Of_Suggesation = QaBrowser.driver.findElements(By.xpath(locator));
		Thread.sleep(2000);
		for (WebElement suggestation : list_Of_Suggesation) {
			String suggest = suggestation.getText();
			System.out.println(suggest);
			if (suggest.equalsIgnoreCase(value)) {
				Thread.sleep(3000);
				suggestation.click();
				break;
			}
		}

	}

}
