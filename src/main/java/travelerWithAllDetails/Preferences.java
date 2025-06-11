package travelerWithAllDetails;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Flight_Booking.TripType_Page;
import addTraveler.GenericUtility;
import flightbookingAssignTask.TripTypeSearchPage;
import utilities.QaBrowser;
import utilities.QaRobot;

public class Preferences {

	public static void preferences(String preferences, String selectlonghaulmealpreference, String stop,
			String maxLayover, String classprefere, String preferredonline, String otherpre, String loyalityExpirtdate,
			String savecancilpre) throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Preferences')]")).click();

		switch (preferences) {
		case "domestic":
			QaBrowser.driver
					.findElement(
							By.xpath("//div[@class=\"mat-mdc-tab-labels\"]/div//span[contains(text(),'Domestic')]"))
					.click();
			Thread.sleep(1500);
			WebElement a = QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Select Long-haul Seat Preference (>4 Hrs)')]/../..//mat-select"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			Thread.sleep(1000);
			js.executeScript("arguments[0].click()", a);
			List<WebElement> seat_preferences_list = QaBrowser.driver
					.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
			System.out.println(seat_preferences_list.size());
			for (WebElement seatarrangement : seat_preferences_list) {
				String seatpreferences = seatarrangement.getText();
				System.out.println(seatpreferences);
				if (seatpreferences.equalsIgnoreCase(selectlonghaulmealpreference)) {
					seatarrangement.click();
					break;
				}
			}
			Thread.sleep(1000);
			// mat-label[contains(text(),'Select Short-haul Seat Preference (4
			// Hrs)')]/../..//mat-select
			WebElement b = QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Select Short-haul Seat Preference (4 Hrs)')]/../..//mat-select"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			Thread.sleep(1000);
			js1.executeScript("arguments[0].click()", b);
			List<WebElement> seat_preferences_list1 = QaBrowser.driver
					.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
			System.out.println(seat_preferences_list1.size());
			for (WebElement seatarrangement1 : seat_preferences_list1) {
				String seatpreferences1 = seatarrangement1.getText();
				System.out.println(seatpreferences1);
				if (seatpreferences1.equalsIgnoreCase(selectlonghaulmealpreference)) {
					seatarrangement1.click();
				}
			}
			/**
			 * 
			 * select meal preferences
			 */
			/**
			 * 
			 * redress preferences
			 */
			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Stop Preference')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", stop);
			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Max Layover')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					maxLayover);
			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Class Preference')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					classprefere);
			WebElement travelerNumber = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"travelerNumber\"]"));
			travelerNumber.sendKeys("9876543210");
			QaBrowser.driver.findElement(By.xpath("//div[text()='Select Preferred Airline']/../..//input")).click();
			Thread.sleep(1000);
			GenericUtility.handleMultipleSuggestation("//div[@class=\"ng-dropdown-panel-items scroll-host\"]//div/span",
					preferredonline);

//			WebDriverWait wait = new WebDriverWait(QaBrowser.driver, Duration.ofSeconds(10));
//			WebElement myElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname=\"otherPref\"]")));
//			myElement.click();
			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"otherPref\"]")).click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", otherpre);

			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"airlineCode\"]")).click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					preferredonline);
			WebElement loyaltyNuber = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"loyaltyNumber\"]"));
			loyaltyNuber.sendKeys("1800 22 8888");
			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"loyaltyExpiryDate\"]")).click();
			String[] DateSelection = loyalityExpirtdate.split("-");
			String expDate = DateSelection[0];// 20
			String month = DateSelection[1];// AUG
			String year = DateSelection[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate, month, year);
			Thread.sleep(200);

			WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
			JavascriptExecutor js12 = (JavascriptExecutor) QaBrowser.driver;
			js12.executeScript("arguments[0].click()", A);
			switch (savecancilpre) {
			case "save":
				WebElement save = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
				JavascriptExecutor js121 = (JavascriptExecutor) QaBrowser.driver;
				js121.executeScript("arguments[0].click()", save);
				break;
			case "cancil":
				WebElement cancil = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				JavascriptExecutor js1211 = (JavascriptExecutor) QaBrowser.driver;
				js1211.executeScript("arguments[0].click()", cancil);
				break;

			}

			break;
		case "international":
			QaBrowser.driver
					.findElement(By
							.xpath("//div[@class=\"mat-mdc-tab-labels\"]/div//span[contains(text(),'International')]"))
					.click();

			Thread.sleep(1500);
			WebElement a1 = QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Select Long-haul Seat Preference (>4 Hrs)')]/../..//mat-select"));
			JavascriptExecutor js123 = (JavascriptExecutor) QaBrowser.driver;
			Thread.sleep(1000);
			js123.executeScript("arguments[0].click()", a1);
			List<WebElement> seat_preferences_list12 = QaBrowser.driver
					.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
			System.out.println(seat_preferences_list12.size());
			for (WebElement seatarrangement : seat_preferences_list12) {
				String seatpreferences = seatarrangement.getText();
				System.out.println(seatpreferences);
				if (seatpreferences.equalsIgnoreCase(selectlonghaulmealpreference)) {
					seatarrangement.click();
					break;
				}
			}
			Thread.sleep(1000);
			// mat-label[contains(text(),'Select Short-haul Seat Preference (4
			// Hrs)')]/../..//mat-select
			WebElement b1 = QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Select Long-haul Seat Preference (4 Hrs)')]/../..//mat-select"));
			JavascriptExecutor js111 = (JavascriptExecutor) QaBrowser.driver;
			Thread.sleep(1000);
			js111.executeScript("arguments[0].click()", b1);
			List<WebElement> seat_preferences_list11 = QaBrowser.driver
					.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
			System.out.println(seat_preferences_list11.size());
			for (WebElement seatarrangement1 : seat_preferences_list11) {
				String seatpreferences1 = seatarrangement1.getText();
				System.out.println(seatpreferences1);
				if (seatpreferences1.equalsIgnoreCase(selectlonghaulmealpreference)) {
					seatarrangement1.click();
					break;
				}
			}
			/**
			 * redress preperences
			 */

			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Stop Preference')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", stop);
			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Max Layover')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					maxLayover);
			QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'Select Class Preference')]/../..//mat-select"))
					.click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					classprefere);
			WebElement travelerNumber1 = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"travelerNumber\"]"));
			travelerNumber1.sendKeys("9876543210");
			QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Select Preferred Airline')]/../..//input")).click();
			Thread.sleep(1000);
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					preferredonline);
//			QaBrowser.driver.findElement(By.xpath("//div[text()='Select Preferred Airline']/../..//input")).click();
//			Thread.sleep(1000);
//			GenericUtility.handleMultipleSuggestation("//div[@class=\"ng-dropdown-panel-items scroll-host\"]//div/span",
//					preferredonline);

//			WebDriverWait wait = new WebDriverWait(QaBrowser.driver, Duration.ofSeconds(10));
//			WebElement myElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname=\"otherPref\"]")));
//			myElement.click();
//			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"otherPref\"]")).click();
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", otherpre);

			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"airlineCode\"]")).click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
					preferredonline);
			WebElement loyaltyNuber12 = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"loyaltyNumber\"]"));
			loyaltyNuber12.sendKeys("1800 22 8888");
			QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"loyaltyExpiryDate\"]")).click();
			String[] DateSelection1 = loyalityExpirtdate.split("-");
			String expDate1 = DateSelection1[0];// 20
			String month1 = DateSelection1[1];// AUG
			String year1 = DateSelection1[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate1, month1, year1);
			Thread.sleep(200);

			WebElement A1 = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
			JavascriptExecutor js125 = (JavascriptExecutor) QaBrowser.driver;
			js125.executeScript("arguments[0].click()", A1);
			switch (savecancilpre) {
			case "save":
				WebElement save = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
				JavascriptExecutor js121 = (JavascriptExecutor) QaBrowser.driver;
				js121.executeScript("arguments[0].click()", save);
				break;
			case "cancil":
				WebElement cancil = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				JavascriptExecutor js1211 = (JavascriptExecutor) QaBrowser.driver;
				js1211.executeScript("arguments[0].click()", cancil);
				break;
			
			}
			
			break;

		}
	}
}
