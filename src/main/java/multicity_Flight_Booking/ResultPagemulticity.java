package multicity_Flight_Booking;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class ResultPagemulticity {

	public static void resultPageForFlight(String TripType, String FareType, String SelectFlight,
			String SelectFlightMulticity, String SubfareType, String BusinessFareType, String FareTypeR,
			String SFlightR, String GFareR, String BFareR

	) throws Throwable {

		Thread.sleep(30000);

		QaExtentReport.extentScreenshot("Result Page");

		if (TripType.equalsIgnoreCase("OneWay")) {
			JavascriptExecutor je = (JavascriptExecutor) QaBrowser.driver;
			je.executeScript("window.scrollBy(0,1000)", "");
			QaRobot.ClickOnElement("Flightdetails1");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Flight Details");
			QaRobot.ClickOnElement("FlightDetailsClose");
			Thread.sleep(3000);

			if (FareType.equalsIgnoreCase("Guest")) {

				QaBrowser.driver.findElement(By.xpath(
						"(//div[@class='flight-class-wrap mat-card guest_card two-tier ng-star-inserted' and contains(.,'Guest')])["
								+ SelectFlight + "]"))
						.click();

				Thread.sleep(5000);
				switch (SubfareType) {
				case "Guest Saver":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[1]")).click();
					break;
				case "Guest Basic":
					QaRobot.clickOnDisableElement("GuestBasic");
					// QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[2]")).click();
					break;
				case "Guest Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();

					break;
				case "Guest Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[4]")).click();
					break;

				}

			} else if (FareType.equalsIgnoreCase("Business")) {
				QaBrowser.driver.findElement(By.xpath(
						"(//div[@class='flight-class-wrap mat-card guest_card two-tier ng-star-inserted' and contains(.,'Business')])["
								+ SelectFlight + "]"))
						.click();

				Thread.sleep(5000);
				switch (BusinessFareType) {
				case "Business Basic":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[1]")).click();
					break;
				case "Business Semi Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[2]")).click();
					break;
				case "Business Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[3]")).click();
					break;
				}
			}
		}

		if (TripType.equalsIgnoreCase("RoundTrip")) {
			Thread.sleep(3000);
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("Flighdetails2");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("FlightDetail");

			QaRobot.ClickOnElement("FlightDetailCloseButton");
			Thread.sleep(2000);

			if (FareType.equalsIgnoreCase("Guest")) {

				QaBrowser.driver.findElement(By.xpath(
						"(//div[@class='flight-class-wrap mat-card guest_card two-tier ng-star-inserted' and contains(.,'Guest')])["
								+ SelectFlight + "]"))
						.click();

				Thread.sleep(5000);
				switch (SubfareType) {
				case "Guest Saver":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[1]")).click();
					break;
				case "Guest Basic":
					QaRobot.clickOnDisableElement("GuestBasic");
					// QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[2]")).click();
					break;
				case "Guest Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();

					break;
				case "Guest Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[4]")).click();
					break;

				}

			} else if (FareType.equalsIgnoreCase("Business")) {
				QaBrowser.driver.findElement(By.xpath(
						"(//div[@class='flight-class-wrap mat-card guest_card two-tier ng-star-inserted' and contains(.,'Business')])["
								+ SelectFlight + "]"))
						.click();

				Thread.sleep(5000);
				switch (BusinessFareType) {
				case "Business Basic":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[1]")).click();
					break;
				case "Business Semi Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[2]")).click();
					break;
				case "Business Flex":
					QaBrowser.driver.findElement(By.xpath("(//span[text()='Select'])[3]")).click();
					break;
				}
			}
			if (FareTypeR.equalsIgnoreCase("Guest")) {
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("(//div[@class='flight-class-wrap mat-card guest_card one-tier ng-star-inserted' and contains(.,'Guest')])["+SFlightR+"]")).click();
//				QaBrowser.driver.findElement(By.xpath(
//						"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button[1])["
//								+ SFlightR + "]"))
//						.click();
				Thread.sleep(5000);

				switch (GFareR) {
				case "Saver":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
							.click();
					break;
				case "Basic":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
							.click();
					break;
				case "Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();
					break;
				case "Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[4]"))
							.click();
					break;
				}

			} else if (FareTypeR.equalsIgnoreCase("Business")) {
				QaBrowser.driver.findElement(By.xpath(
						"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[2]/div[2]/div[2]/div[2]/button)["
								+ SFlightR + "]"))
						.click();
				Thread.sleep(5000);
				switch (BFareR) {
				case "Basic":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
							.click();
					break;
				case "Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
							.click();
					break;
				case "Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();
					break;
				}
			}
		}
		

		if (TripType.equalsIgnoreCase("MultiCity")) {
			Thread.sleep(3000);

			WebElement selectFlight1 = QaBrowser.driver
					.findElement(By.xpath("(//span[text()='Select trip'])[" + SelectFlightMulticity + "]"));

			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", selectFlight1);

			// QaRobot.clickOnDisableElement("SelectFligtMulticity");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("FlightDetailPage");

			QaRobot.clickOnDisableElement("SelectAndContinueButton");

		}



	}
}
