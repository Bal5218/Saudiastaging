package Flight_Booking;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Passenger_Page {

	public static void flightPassengerPage(String TripType, String TCategory, String AQty, String CQty, String IQty,
			String ISQty, String ChooseOption) throws Exception {

		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Cart");
		Thread.sleep(8000);
		switch (TripType) {
		case "OneWay":
			WebElement ContinueToPassenger1 = QaBrowser.driver
					.findElement(By.xpath("(//span[@class='mdc-button__label'])[4]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", ContinueToPassenger1);
//			QaRobot.ClickOnElement("ContinueToPassenger1");
			break;
		case "RoundTrip":
			WebElement ContinueToPassenger2 = QaBrowser.driver
					.findElement(By.xpath("(//span[@class='mdc-button__label'])[5]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", ContinueToPassenger2);
//			QaRobot.ClickOnElement("ContinueToPassenger2");
			break;
		}
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Passenger page");
		Thread.sleep(5000);

		if (TCategory.equalsIgnoreCase("BusinessT")) {
		} else {
			QaRobot.ClickOnElement("Associate");
			Thread.sleep(3000);
			String ParentWindow = QaBrowser.driver.getWindowHandle();
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) {
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			QaRobot.addDependent(AQty, CQty, IQty, ISQty);
			Thread.sleep(3000);
			WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
					"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", ReviewPassenegers);
//			QaRobot.ClickOnElement("ReviewPassenegers");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Passenger List");
			Thread.sleep(3000);
			WebElement ReviewAddPassenegers = QaBrowser.driver.findElement(By.xpath(
					"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", ReviewAddPassenegers);
//			QaRobot.ClickOnElement("ReviewAddPassenegers");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Added Passengers");
			Thread.sleep(3000);
		}

		switch (ChooseOption) {
		case "SelectExtras":
			WebElement SelectExtras = QaBrowser.driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[2]/span[2]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", SelectExtras);
//			QaRobot.ClickOnElement("SelectExtras");
			break;
		case "SkipToPayment":
			QaRobot.ClickOnElement("SkipToPayment");
			break;
		}
		Thread.sleep(5000);
	}
}
