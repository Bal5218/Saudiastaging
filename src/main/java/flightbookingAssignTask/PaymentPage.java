package flightbookingAssignTask;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.bytebuddy.implementation.InvokeDynamic.WithImplicitArguments;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class PaymentPage {
	public static void paymentPage(String TripType, String PaymentMethod, String CardNumber, String NameOfCardHolder,
			String CVV) throws Throwable {

		Thread.sleep(25000);
		QaExtentReport.extentScreenshot("Payment page");

		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);

		switch (TripType) {
		case "OneWay":

			if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
				QaBrowser.driver.findElement(By.xpath("//div[@class='logo icon-logo ng-star-inserted']/mat-icon"))
						.click();

				QaRobot.PassValue("cardNumber1", CardNumber);
				Thread.sleep(1000);

				QaRobot.clickOnDisableElement("selectMonth1");
				// QaRobot.ClickOnElement("selectMonth1");
				Thread.sleep(500);
				QaRobot.clickOnDisableElement("SelectMonthNumber");
				Thread.sleep(1000);
				// QaRobot.ClickOnElement("SelectMonthNumberForMulticity");
				QaRobot.clickOnDisableElement("selectYear1");
				// QaRobot.ClickOnElement("selectYearArrow");
				Thread.sleep(500);

				QaRobot.clickOnDisableElement("selectYearNumber");
				// QaRobot.ClickOnElement("selectYearNumber");
				Thread.sleep(2000);
				QaRobot.clickOnDisableElementwithpassvalue("NameOfCardholder", NameOfCardHolder);

				// QaRobot.PassValue("NameOfCardholder", NameOfCardholder);
				QaRobot.clickOnDisableElementwithpassvalue("cvv1", CVV);
				// QaRobot.PassValue("cvv", CVV);

			}

			break;

		case "RoundTrip":

			if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
				QaBrowser.driver.findElement(By.xpath("//div[@class='logo icon-logo ng-star-inserted']/mat-icon"))
						.click();

				QaRobot.PassValue("cardNumber1", CardNumber);
				Thread.sleep(1000);

				QaRobot.clickOnDisableElement("selectMonth1");
				// QaRobot.ClickOnElement("selectMonth1");
				Thread.sleep(500);
				QaRobot.clickOnDisableElement("SelectMonthNumber");
				Thread.sleep(1000);
				// QaRobot.ClickOnElement("SelectMonthNumberForMulticity");
				QaRobot.clickOnDisableElement("selectYear1");
				// QaRobot.ClickOnElement("selectYearArrow");
				Thread.sleep(500);

				QaRobot.clickOnDisableElement("selectYearNumber");
				// QaRobot.ClickOnElement("selectYearNumber");
				Thread.sleep(2000);
				QaRobot.clickOnDisableElementwithpassvalue("NameOfCardholder", NameOfCardHolder);

				// QaRobot.PassValue("NameOfCardholder", NameOfCardholder);
				QaRobot.clickOnDisableElementwithpassvalue("cvv1", CVV);
				// QaRobot.PassValue("cvv", CVV);

			}

			break;

		case "MultiCity":
			if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
				QaBrowser.driver.findElement(By.xpath("//div[@class='logo icon-logo ng-star-inserted']/mat-icon"))
						.click();

				QaRobot.PassValue("cardNumber1", CardNumber);
				Thread.sleep(1000);

				QaRobot.clickOnDisableElement("selectMonth1");
				// QaRobot.ClickOnElement("selectMonth1");
				Thread.sleep(500);
				QaRobot.clickOnDisableElement("SelectMonthNumber");
				Thread.sleep(1000);
				// QaRobot.ClickOnElement("SelectMonthNumberForMulticity");
				QaRobot.clickOnDisableElement("selectYear1");
				// QaRobot.ClickOnElement("selectYearArrow");
				Thread.sleep(500);

				QaRobot.clickOnDisableElement("selectYearNumber");
				// QaRobot.ClickOnElement("selectYearNumber");
				Thread.sleep(2000);
				QaRobot.clickOnDisableElementwithpassvalue("NameOfCardholder", NameOfCardHolder);

				// QaRobot.PassValue("NameOfCardholder", NameOfCardholder);
				QaRobot.clickOnDisableElementwithpassvalue("cvv1", CVV);
				// QaRobot.PassValue("cvv", CVV);

			}

			break;
		}
		QaRobot.ClickOnElement("TearmCheck");
		WebElement PayNow = QaBrowser.driver.findElement(By.xpath("//span[text()='Pay Now']"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", PayNow);
//		QaRobot.ClickOnElement("PayNow");
		Thread.sleep(35000);

		WebElement OTP = QaBrowser.driver.findElement(By.xpath("//iframe[@id='Cardinal-CCA-IFrame']"));
		QaBrowser.driver.switchTo().frame(OTP);
		QaRobot.PassValue("OPT", "1234");
		QaRobot.ClickOnElement("Submit");
		Thread.sleep(40000);

		// QaRobot.ClickOnElement("PayNOW");
	}

}
//mat-panel-description[@class='mat-expansion-panel-header-description ng-tns-c2690051721-94']/div/div/mat-icon
//mat-expansion-panel-header[@id='mat-expansion-panel-header-22']/span/mat-panel-description/div/div/mat-icon