package Flight_Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.B2cExceptionClass;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Extra_Page {

	public static void flightExtrasPage(String TripType, String AQty, String CQty, String IQty, String ISQty,
			String NoExtras, String SelectExtras, String SeatD, String SeatR, String Bags) throws Exception {
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Extra page");
		int E = Integer.parseInt(NoExtras);
		for (int i = 1; i <= E; i++) {
			String[] tN = SelectExtras.split(",");
			String b = tN[i - 1];

			if (b.equalsIgnoreCase("Seat")) {
				boolean a = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Seat selection ')]"))
						.isDisplayed();
				System.out.println(a);
				if (a == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Seat selection is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Seat selection Page");
					Thread.sleep(2000);
				} else {
					QaRobot.ClickOnElement("SelectSeat");
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("Seat Page");
					String SelectSeat[] = SeatD.split(" ");
					String Row = SelectSeat[0];
					String ASeat = SelectSeat[1];
					int a1 = Integer.parseInt(Row);
					int count = 0;
					for (int j = 30; j <= 57; j++) {
						count++;
						if (j == a1) {
							WebElement Seat1 = QaBrowser.driver
									.findElement(By.xpath("(//p[text()='" + ASeat + "'])[" + count + "]"));
							JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
							js2.executeScript("arguments[0].click()", Seat1);
							Thread.sleep(5000);
							break;
						}
					}
					QaExtentReport.extentScreenshot("Selected Seat");
					WebElement SeatC = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
					JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
					js3.executeScript("arguments[0].click()", SeatC);
//					QaRobot.ClickOnElement("SeatC");
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("Seat Page");
					Thread.sleep(2000);
					if (TripType.equalsIgnoreCase("RoundTrip")) {
						WebElement NextFlight = QaBrowser.driver.findElement(By.xpath("//span[text()='Next Flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", NextFlight);
//						QaRobot.ClickOnElement("NextFlight");
						Thread.sleep(2000);
						String SelectSeatR[] = SeatR.split(" ");
						String RowR = SelectSeatR[0];
						String ASeatR = SelectSeatR[1];
						int a1R = Integer.parseInt(RowR);
						int countR = 0;
						for (int j = 30; j <= 61; j++) {
							countR++;
							if (j == a1R) {
								WebElement Seat1 = QaBrowser.driver
										.findElement(By.xpath("(//p[text()='" + ASeatR + "'])[" + countR + "]"));
								JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
								js2.executeScript("arguments[0].click()", Seat1);
								Thread.sleep(5000);
								break;
							}
						}
						QaExtentReport.extentScreenshot("Selected Seat");
						WebElement SeatC1 = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
						JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
						js5.executeScript("arguments[0].click()", SeatC1);
//						QaRobot.ClickOnElement("SeatC");
						Thread.sleep(5000);
						QaExtentReport.extentScreenshot("Seat Page");
					}
					QaRobot.ClickOnElement("SeatConfirm");
					Thread.sleep(8000);
				}
			} else if (b.equalsIgnoreCase("Baggage")) {
				boolean a = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Add & upgrade baggage ')]"))
						.isDisplayed();
				System.out.println(a);
				if (a == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Upgrade Baggage is not available on this flight</i></ b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Page");
					Thread.sleep(2000);
				} else {
					QaRobot.ClickOnElement("Baggage");
					Thread.sleep(5000);
					int pAS = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty)
							+ Integer.parseInt(ISQty);
					for (int q = 1; q <= pAS; q++) {
						QaBrowser.driver
								.findElement(By.xpath("(//div[@class='ebag-desc ng-star-inserted' and contains(.,' "
										+ Bags + " Bag ')]//mat-icon)[" + q + "]"))
								.click();
						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("Baggage Page");
						Thread.sleep(2000);
						if (TripType.equalsIgnoreCase("RoundTrip")) {
							WebElement NextBaggage = QaBrowser.driver
									.findElement(By.xpath("//span[text()='Next Flight']"));
							JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
							js4.executeScript("arguments[0].click()", NextBaggage);
//						QaRobot.ClickOnElement("NextFlight");
							Thread.sleep(2000);
							QaBrowser.driver
									.findElement(By.xpath("(//div[@class='ebag-desc ng-star-inserted' and contains(.,' "
											+ Bags + " Bag ')]//mat-icon)[" + q + "]"))
									.click();
							Thread.sleep(3000);
							QaExtentReport.extentScreenshot("Baggage Page");
							Thread.sleep(2000);
						}
					}
					WebElement BaggageC = QaBrowser.driver.findElement(By.xpath("//span[@class='mdc-button__label']"));
					JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
					js3.executeScript("arguments[0].click()", BaggageC);
//					QaRobot.ClickOnElement("BaggageC");
					Thread.sleep(8000);
				}
			} else if (b.equalsIgnoreCase("FastTrack")) {
//				boolean a = QaBrowser.driver
//						.findElement(By.xpath("//span[contains(text(),'Add & upgrade baggage ')]"))
//						.isDisplayed();
//				System.out.println(a);
//				if (a == true) {
//					QaExtentReport.test.log(Status.INFO,
//							"<b><i>Upgrade Baggage is not available on this flight</i></b>");
//					Thread.sleep(3000);
//					QaExtentReport.extentScreenshot("Baggage Page");
//					Thread.sleep(2000);
//				} else {
				QaRobot.ClickOnElement("FastTrack");
				Thread.sleep(5000);
				QaRobot.ClickOnElement("FastTrackAdd");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("FastTrack Page");
				Thread.sleep(2000);
				if (TripType.equalsIgnoreCase("RoundTrip")) {
					WebElement NextFastTrack = QaBrowser.driver.findElement(By.xpath("//span[text()='Next flight']"));
					JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
					js4.executeScript("arguments[0].click()", NextFastTrack);
//					QaRobot.ClickOnElement("NextFlight");
					Thread.sleep(2000);
					boolean a = QaBrowser.driver
							.findElement(By.xpath("//div[text()='Fast track is not available on this flight']"))
							.isDisplayed();
					System.out.println(a);
					if (a == true) {
						QaExtentReport.test.log(Status.INFO,
								"<b><i>Fast track is not available on this flight</i></b>");
						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("FastTrack Page");
						Thread.sleep(2000);
					} else {
						QaRobot.ClickOnElement("FastTrackAdd");
						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("FastTrack Page");
						Thread.sleep(2000);
					}
				}
				WebElement FastTrackC = QaBrowser.driver.findElement(By.xpath("//span[@class='mdc-button__label']"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", FastTrackC);
//				QaRobot.ClickOnElement("FastTrackC");
				Thread.sleep(8000);
			} else if (b.equalsIgnoreCase("MeetAndGreet")) {
				boolean a = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),' Meet & Greet ')]"))
						.isDisplayed();
				System.out.println(a);
				if (a == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Upgrade Baggage is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Page");
					Thread.sleep(2000);
				} else {
					QaRobot.ClickOnElement("MeetAndGreet");
					Thread.sleep(5000);
					WebElement MeetAndGreetS = QaBrowser.driver.findElement(By.xpath(
							"//button[@class='button--secondary-small logo mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base ng-star-inserted']/span/following-sibling::span[text()='Select']"));
					JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
					js5.executeScript("arguments[0].click()", MeetAndGreetS);
//				QaRobot.ClickOnElement("MeetAndGreetS");
					WebElement MeetAndGreetEmpC = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
					JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
					js6.executeScript("arguments[0].click()", MeetAndGreetEmpC);
//				QaRobot.ClickOnElement("MeetAndGreetEmpC");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("MeetAndGreet");
					Thread.sleep(2000);
					if (TripType.equalsIgnoreCase("RoundTrip")) {
						WebElement NextMeetAndGreet = QaBrowser.driver
								.findElement(By.xpath("//span[text()='Next Flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", NextMeetAndGreet);
//					QaRobot.ClickOnElement("NextFlight");
						Thread.sleep(2000);
						WebElement MeetAndGreetSR = QaBrowser.driver.findElement(By.xpath(
								"//button[@class='button--secondary-small logo mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base ng-star-inserted']/span/following-sibling::span[text()='Select']"));
						JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
						js7.executeScript("arguments[0].click()", MeetAndGreetSR);
						WebElement MeetAndGreetEmpCR = QaBrowser.driver
								.findElement(By.xpath("//span[text()='Confirm']"));
						JavascriptExecutor js8 = (JavascriptExecutor) QaBrowser.driver;
						js8.executeScript("arguments[0].click()", MeetAndGreetEmpCR);
						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("FastTrack Page");
						Thread.sleep(2000);
					}
					WebElement MeetAndGreetC = QaBrowser.driver.findElement(By.xpath("(//span[text()=' Confirm'])"));
					JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
					js7.executeScript("arguments[0].click()", MeetAndGreetC);
//				QaRobot.ClickOnElement("MeetAndGreetC");
					Thread.sleep(8000);
				}
			}
		}
		QaRobot.ClickOnElement("SkipToPayment1");

	}
}
