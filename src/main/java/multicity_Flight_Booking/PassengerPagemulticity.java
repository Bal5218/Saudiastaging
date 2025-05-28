package multicity_Flight_Booking;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class PassengerPagemulticity {
	public static void flightPassengerPage(String Triptype, String BookAs, String TCategory, String AQty,
			String firstName, String lastName, String DateOfbirth, String DateOfbirth1, String DateOfbirth2,
			String CQty, String IQty, String ISQty, String SelectOption) throws Throwable {

		Thread.sleep(20000);

		switch (Triptype) {
		case "OneWay":

			WebElement ContinueToPassenger1 = QaBrowser.driver
					.findElement(By.xpath("(//span[@class='mdc-button__label'])[4]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", ContinueToPassenger1);

			Thread.sleep(20000);

			QaExtentReport.extentScreenshot("Passenger page");

			Thread.sleep(2000);

			if (TCategory.equalsIgnoreCase("BusinessT")) {

				int aQTy = Integer.parseInt(AQty);
				if (BookAs.equalsIgnoreCase("Guest")) {
					if (aQTy > 2) {
						QaRobot.passDataPassengerTextfield(AQty, firstName, lastName, DateOfbirth, DateOfbirth1,
								DateOfbirth2);
					}
				} else if (BookAs.equalsIgnoreCase("MultiPassenger")) {
					QaRobot.ClickOnElement("Associates");
//					Thread.sleep(3000);
					QaRobot.addmultipasseengerDependent(AQty);
					Thread.sleep(3000);
				
					
					WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
							"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
					JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
					js4.executeScript("arguments[0].click()", ReviewPassenegers);
				}

				QaExtentReport.extentScreenshot("Passenger List");

			} else {

				QaRobot.ClickOnElement("Associates");
				Thread.sleep(3000);
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				System.out.println(ParentWindow);
				Set<String> handles = QaBrowser.driver.getWindowHandles();

				System.out.println(handles.size());

				for (String childWindow : handles) {
					System.out.println(childWindow);
					if (!childWindow.equals(ParentWindow))

						QaBrowser.driver.switchTo().window(childWindow);

				}
				QaRobot.addDependent(AQty, CQty, IQty, ISQty);
				Thread.sleep(3000);
				WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
				js4.executeScript("arguments[0].click()", ReviewPassenegers);
//				QaRobot.ClickOnElement("ReviewPassenegers");
				Thread.sleep(10000);
				QaExtentReport.extentScreenshot("Passenger List");
				Thread.sleep(3000);
				WebElement ReviewAddPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
				js5.executeScript("arguments[0].click()", ReviewAddPassenegers);
//				QaRobot.ClickOnElement("ReviewAddPassenegers");
				Thread.sleep(12000);
				QaExtentReport.extentScreenshot("Added Passengers");
				Thread.sleep(3000);
			}

			if (SelectOption.equalsIgnoreCase("SkipToPayment")) {
				QaBrowser.driver.findElement(By.xpath(
						"/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[1]/span[2]"))
						.click();

			} else if (SelectOption.equalsIgnoreCase("SelectExtras")) {
				Thread.sleep(4000);
				QaRobot.clickOnDisableElement("SelectExtras2");

			}
			break;
		case "RoundTrip":

			WebElement ContinueToPassenger2 = QaBrowser.driver
					.findElement(By.xpath("(//span[@class='mdc-button__label'])[5]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", ContinueToPassenger2);

			Thread.sleep(20000);

			QaExtentReport.extentScreenshot("Passenger page");

			Thread.sleep(2000);

			if (TCategory.equalsIgnoreCase("BusinessT")) {

				int aQTy = Integer.parseInt(AQty);
				if (BookAs.equalsIgnoreCase("Guest")) {
					if (aQTy > 2) {
						QaRobot.passDataPassengerTextfield(AQty, firstName, lastName, DateOfbirth, DateOfbirth1,
								DateOfbirth2);
					}
				} else if (BookAs.equalsIgnoreCase("MultiPassenger")) {
					QaRobot.ClickOnElement("Associates");
//					Thread.sleep(3000);
					QaRobot.addmultipasseengerDependent(AQty);
					Thread.sleep(3000);
					WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
							"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
					JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
					js4.executeScript("arguments[0].click()", ReviewPassenegers);
				}

				QaExtentReport.extentScreenshot("Passenger List");

			} else {

				QaRobot.ClickOnElement("Associates");
				Thread.sleep(3000);
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				System.out.println(ParentWindow);
				Set<String> handles = QaBrowser.driver.getWindowHandles();

				System.out.println(handles.size());

				for (String childWindow : handles) {
					System.out.println(childWindow);
					if (!childWindow.equals(ParentWindow))

						QaBrowser.driver.switchTo().window(childWindow);

				}
				QaRobot.addDependent(AQty, CQty, IQty, ISQty);
				Thread.sleep(3000);
				WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
				js4.executeScript("arguments[0].click()", ReviewPassenegers);
//				QaRobot.ClickOnElement("ReviewPassenegers");
				Thread.sleep(10000);
				QaExtentReport.extentScreenshot("Passenger List");
				Thread.sleep(3000);
				WebElement ReviewAddPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
				js5.executeScript("arguments[0].click()", ReviewAddPassenegers);
//				QaRobot.ClickOnElement("ReviewAddPassenegers");
				Thread.sleep(12000);
				QaExtentReport.extentScreenshot("Added Passengers");
				Thread.sleep(3000);
			}

			if (SelectOption.equalsIgnoreCase("SkipToPayment")) {

				QaRobot.clickOnDisableElement("SkipToPayment1");

			} else if (SelectOption.equalsIgnoreCase("SelectExtras")) {
				QaRobot.clickOnDisableElement("SelectExtras2");

			}
			break;

		case "MultiCity":

			Thread.sleep(20000);

			QaExtentReport.extentScreenshot("Passenger page");

			Thread.sleep(2000);

			if (TCategory.equalsIgnoreCase("BusinessT")) {

				int aQTy = Integer.parseInt(AQty);
				if (BookAs.equalsIgnoreCase("Guest")) {
					if (aQTy > 2) {
						QaRobot.passDataPassengerTextfield(AQty, firstName, lastName, DateOfbirth, DateOfbirth1,
								DateOfbirth2);
					}
				} else if (BookAs.equalsIgnoreCase("MultiPassenger")) {
					QaRobot.ClickOnElement("Associates");
//					Thread.sleep(3000);
					QaRobot.addmultipasseengerDependent(AQty);
					Thread.sleep(3000);
					WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
							"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
					JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
					js4.executeScript("arguments[0].click()", ReviewPassenegers);
				}

				QaExtentReport.extentScreenshot("Passenger List");

			} else {
				Thread.sleep(3000);
				QaRobot.ClickOnElement("Associates");
				Thread.sleep(3000);
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				System.out.println(ParentWindow);
				Set<String> handles = QaBrowser.driver.getWindowHandles();

				System.out.println(handles.size());

				for (String childWindow : handles) {
					System.out.println(childWindow);
					if (!childWindow.equals(ParentWindow))

						QaBrowser.driver.switchTo().window(childWindow);

				}
				QaRobot.addDependent(AQty, CQty, IQty, ISQty);
				Thread.sleep(3000);
				WebElement ReviewPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
				js4.executeScript("arguments[0].click()", ReviewPassenegers);
//		QaRobot.ClickOnElement("ReviewPassenegers");
				Thread.sleep(10000);
				QaExtentReport.extentScreenshot("Passenger List");
				Thread.sleep(3000);
				WebElement ReviewAddPassenegers = QaBrowser.driver.findElement(By.xpath(
						"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
				JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
				js5.executeScript("arguments[0].click()", ReviewAddPassenegers);
//		QaRobot.ClickOnElement("ReviewAddPassenegers");
				Thread.sleep(13000);
				QaExtentReport.extentScreenshot("Added Passengers");
				Thread.sleep(3000);
			}

			if (SelectOption.equalsIgnoreCase("SkipToPayment")) {
				QaBrowser.driver.findElement(By.xpath(
						"/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[1]/span[2]"))
						.click();

			} else if (SelectOption.equalsIgnoreCase("SelectExtras")) {
				Thread.sleep(6000);
				QaRobot.clickOnDisableElement("SelectExtras2");
				// QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[2]/span[2]")).click();
			}
			break;

		}

	}

}
