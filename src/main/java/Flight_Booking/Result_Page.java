package Flight_Booking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Result_Page {

	public static void ResultPageForFlight(String TripType, String FareType, String SFlight, String GFare, String BFare,
			String FareTypeR, String SFlightR, String GFareR, String BFareR, String ModifySearch, String ChangeTrip,
			String TripTypeM, String MarketTypeM, String OriginCityCodeM, String OriginLocationM,
			String DestinationCityCodeM, String DestinationLocationM, String ChangeTripDate, String DepartureDateM,
			String ReturnDateM, String ChangeTravellers, String adultM, String childM, String infantM,
			String ChangeClass, String ClassM
//			String ShowDirectFlightM
//			String AdvanceOptions, String CurrencyM, String PANumberM,
//			String PreferredAirlineSelectM, String Applyfilter, String FareType, String AirLine, String Trip
	) throws Exception {
		Thread.sleep(20000);

//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		System.out.println(url);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);

		String DateSelection[] = DepartureDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (ModifySearch.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("SModifySearchF");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");

			if (ChangeTrip.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("OneWay")) {
					QaRobot.ClickOnElement("OneWayMF");

					TestBase.listofautosuggestion4(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
							OriginCityCodeM, OriginLocationM, By.xpath("//input[@id='fromLocationControl']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
					Thread.sleep(2000);

					TestBase.listofautosuggestion4(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
							DestinationCityCodeM, DestinationLocationM, By.xpath("//input[@id='toLocationControl']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
							+ " - " + DestinationLocationM);
					Thread.sleep(2000);

				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					QaRobot.ClickOnElement("RoundTripMF");

					TestBase.listofautosuggestion4(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
							OriginCityCodeM, OriginLocationM, By.xpath("//input[@id='fromLocationControl']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
					Thread.sleep(2000);

					TestBase.listofautosuggestion4(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
							DestinationCityCodeM, DestinationLocationM, By.xpath("//input[@id='toLocationControl']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
							+ " - " + DestinationLocationM);
					Thread.sleep(2000);

				} else if (TripTypeM.equalsIgnoreCase("MultiCity")) {

				}
			}

			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("OneWay")) {
					QaRobot.ClickOnElement("OneWayMF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified OneWay</i></b>");

					QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'today')]")).click();
					Thread.sleep(2000);

					selectDateInCalendarOneWay(expDate, month, year);
					WebElement CalContinue = QaBrowser.driver.findElement(By.xpath(
							"//button[@class='button--primary-small mat-button btn mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", CalContinue);
				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					QaRobot.ClickOnElement("RoundTripMF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified RoundTrip</i></b>");

					QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'today')]")).click();
					Thread.sleep(2000);

					selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
					WebElement CalContinue = QaBrowser.driver
							.findElement(By.xpath("//span[contains(text(),'Continue')]"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", CalContinue);
				} else if (TripTypeM.equalsIgnoreCase("MultiCity")) {

				}
			}

//			if (ChangeTravellers.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ChangeTravellersF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Travellers</i></b>");
//
//				QaRobot.selectValueFromDropdown("v12AdultMF", adultM,
//						"<b><i>Select Modified adult for booking</i></b>" + " - " + adultM);
//				Thread.sleep(2000);
//
//				QaRobot.selectValueFromDropdown("v12ChildMF", childM,
//						"<b><i>Select Modified child for booking</i></b>" + " - " + childM);
//				Thread.sleep(2000);
//
//				QaRobot.selectValueFromDropdown("v12InfantMF", infantM,
//						"<b><i>Select Modified infant for booking</i></b>" + " - " + infantM);
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("ChangeTravellersF");
//			}
//
//			if (ChangeClass.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ChangeTravellersF");
//
//				QaRobot.selectTextByLocator("//select[@id='ddlClass']", ClassM,
//						"<b><i>Select Modified Class for booking</i></b>");
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("ChangeTravellersF");
//			}

//			if (ShowDirectFlightM.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ShowDirectFlightMF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Show Direct Flight</i></b>");
//			}
//
//			if (AdvanceOptions.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("AdvanceOptionMF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified AdvanceOption</i></b>");
//
//				QaRobot.selectValueFromDropdown("CurrencyMF", CurrencyM,
//						"<b><i>Select Modified Currency for booking</i></b>");
//				Thread.sleep(2000);
//
//			QaRobot.ClickOnElement("PreferredAirlineMF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified PreferredAirline</i></b>");
//			Thread.sleep(2000);
//
//			int pAS = Integer.parseInt(PANumberM);
//			for (int i = 1; i <= pAS; i++) {
//				String[] tN = PreferredAirlineSelectM.split(",");
//				String b = tN[i - 1];
//				TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b,
//						By.xpath("//input[@placeholder='Search']"));
//			}
//
//			QaRobot.ClickOnElement("PreferredAirlineMF");
//			}

			QaRobot.ClickOnElement("ModifySearchMF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
			Thread.sleep(10000);
		}
//
//		if (Applyfilter.equalsIgnoreCase("Yes")) {
//			if (FareType.equalsIgnoreCase("All")) {
//				QaRobot.ClickOnElement("Refundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
//				Thread.sleep(3000);
//
//				QaRobot.ClickOnElement("NonRefundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
//				Thread.sleep(3000);
//			} else if (FareType.equalsIgnoreCase("Refundable")) {
//				QaRobot.ClickOnElement("Refundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
//				Thread.sleep(3000);
//			} else if (FareType.equalsIgnoreCase("Non-Refundable")) {
//				QaRobot.ClickOnElement("NonRefundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
//				Thread.sleep(3000);
//			}
//			List<WebElement> listOfAirLine = QaBrowser.driver
//					.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
//			for (WebElement autoAirline : listOfAirLine) {
//				if (autoAirline.getText().equalsIgnoreCase(AirLine)) {
//					autoAirline.click();
//					break;
//				}
//			}
//		}
		QaExtentReport.extentScreenshot("Result Page");

//		if (TripType.equalsIgnoreCase("OneWay")) {
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,1000)", "");
		QaRobot.ClickOnElement("FlightDetails");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Flight Details");
		QaRobot.ClickOnElement("FlightDetailsClose");
		Thread.sleep(3000);
		if (FareType.equalsIgnoreCase("Guest")) {
			QaBrowser.driver.findElement(By.xpath(
					"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[3]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button)["
							+ SFlight + "]"))
					.click();
			Thread.sleep(5000);
			switch (GFare) {
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
		} else if (FareType.equalsIgnoreCase("Business")) {
			QaBrowser.driver.findElement(By.xpath(
					"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[3]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[2]/div[2]/div[2]/div[2]/button)["
							+ SFlight + "]"))
					.click();
			Thread.sleep(5000);
			switch (BFare) {
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
		if (TripType.equalsIgnoreCase("RoundTrip")) {
			Thread.sleep(3000);
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("FlightDetailsR");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Flight Details");
			QaRobot.ClickOnElement("FlightDetailsClose");
			Thread.sleep(3000);
			if (FareTypeR.equalsIgnoreCase("Guest")) {
				QaBrowser.driver.findElement(By.xpath(
						"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button[1])["
								+ SFlightR + "]"))
						.click();
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
		if (ModifySearch.equalsIgnoreCase("Yes")) {
			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					Thread.sleep(3000);
					JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
					mo1.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("FlightDetailsR");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Flight Details");
					QaRobot.ClickOnElement("FlightDetailsClose");
					Thread.sleep(3000);
					if (FareTypeR.equalsIgnoreCase("Guest")) {
						QaBrowser.driver.findElement(By.xpath(
								"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button[1])["
										+ SFlightR + "]"))
								.click();
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
			}
		}
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year)
			throws ParseException, InterruptedException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("June")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);
//		QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}
		Thread.sleep(5000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("//span[@class='month']")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				WebElement Next = QaBrowser.driver.findElement(
						By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", Next);
//				QaBrowser.driver
//						.findElement(By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"))
//						.click();
				monthYear = QaBrowser.driver.findElement(By.xpath("//span[@class='month']")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
					"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-one-way-calendar/div/div/div[3]/table/tbody/tr/td/div/span[2]"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("June")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}
		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber1 = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber1 = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber1 = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber1 = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month.equalsIgnoreCase("June")) {
			currentMonthNumber1 = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber1 = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber1 = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber1 = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber1 = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber1 = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
				.getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath(
						"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/button[2]/span[4]"))
						.click();
				monthYear = QaBrowser.driver.findElement(By.xpath(
						"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
						.getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath(
					"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath(
							"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/button[2]/span[4]"))
							.click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath(
							"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();
					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}
}
