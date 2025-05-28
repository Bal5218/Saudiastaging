package multicity_Flight_Booking;

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
import Flight_Booking.ExceptionClass;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class TripTypeSearchPagemulticity {

	public static void flightTriptype(String TripType, String OriginCityCode, String OriginCityCode2,
			String OriginCityCode3, String OriginLocation, String OriginLocation2, String OriginLocation3,

			String DestinationCityCode, String DestinationCityCode2, String DestinationCityCode3,
			String DestinationLocation, String DestinationLocation2, String DestinationLocation3, String DepartureDate,
			String DepartureDate2, String DepartureDate3, String ReturnDate, String BookAs, String TCategory,
			String AQty, String CQty, String IQty, String ISQty) throws Throwable {

		String[] DateSelection = DepartureDate.split("-");
		String expDate = DateSelection[0];
		String month = DateSelection[1];
		String year = DateSelection[2];

		String[] DateSelectionD2 = DepartureDate2.split("-");
		String expDateD2 = DateSelectionD2[0];
		String monthD2 = DateSelectionD2[1];
		String yearD2 = DateSelectionD2[2];

		String[] DateSelectionD3 = DepartureDate3.split("-");
		String expDateD3 = DateSelectionD3[0];
		String monthD3 = DateSelectionD3[1];
		String yearD3 = DateSelectionD3[2];

		String[] DateSelection1 = ReturnDate.split("-");
		String expDate1 = DateSelection1[0];
		String month1 = DateSelection1[1];
		String year1 = DateSelection1[2];
		int aQty = Integer.parseInt(AQty);

		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("onewayRadioButton");

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl']"));
			// i need origin city code and origin location in extent reports
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure City : </i></b>" + OriginCityCode + " - " + OriginLocation);

			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					DestinationCityCode, DestinationLocation, By.xpath("//input[@id='toLocationControl']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival City : </i></b>" + DestinationCityCode + " - " + DestinationLocation);

			QaBrowser.driver.findElement(By.xpath("//input[@id='mat-input-4']")).click();
			Thread.sleep(2000);

			selectDateInCalendarOneWay(expDate, month, year);
			WebElement CalContinue = QaBrowser.driver.findElement(By.xpath(
					"//button[@class='button--primary-small mat-button btn mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", CalContinue);

		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("roundTripRadioButton");
			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure City : </i></b>" + OriginCityCode + " - " + OriginLocation);

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					DestinationCityCode, DestinationLocation, By.xpath("//input[@placeholder=\"Where to?\"]"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival City : </i></b>" + DestinationCityCode + " - " + DestinationLocation);

			QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'mat-input-')])[1]"));

			Thread.sleep(2000);
			QaBrowser.driver.findElement(By.xpath("//input[@id='mat-input-4']")).click();
			Thread.sleep(3000);

			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);

			WebElement CalContinue = QaBrowser.driver.findElement(By.xpath(
					"//button[@class='button--primary-small mat-button btn mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", CalContinue);

		} else if (TripType.equalsIgnoreCase("MultiCity")) {
			QaRobot.clickOnDisableElement("MulticityRadioButton");
			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl0']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure City1 : </i></b>" + OriginCityCode + " - " + OriginLocation);

			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					DestinationCityCode, DestinationLocation, By.xpath("//input[@id='toLocationControl0']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival City1 : </i></b>" + DestinationCityCode + " - " + DestinationLocation);

			QaBrowser.driver.findElement(By.xpath("//input[@id='departureDateControl0']")).click();

			Thread.sleep(3000);

			selectDateInCalendarMulticity(expDate, month, year);
			Thread.sleep(2000);

			QaRobot.clickOnDisableElement("CalenderContinueButton");

			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					OriginCityCode2, OriginLocation2, By.xpath("//input[@id='fromLocationControl1']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure City2 : </i></b>" + OriginCityCode2 + " - " + OriginLocation2);

			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					DestinationCityCode2, DestinationLocation2, By.xpath("//input[@id='toLocationControl1']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival City2 : </i></b>" + DestinationCityCode2 + " - " + DestinationLocation2);

			QaBrowser.driver.findElement(By.xpath("//input[@id='departureDateControl1']")).click();

			Thread.sleep(3000);

			selectDateInCalendarMulticity(expDateD2, monthD2, yearD2);
			Thread.sleep(2000);

			QaRobot.clickOnDisableElement("CalenderContinueButton");
			Thread.sleep(2000);

			QaRobot.clickOnDisableElement("AddFlightButton");
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					OriginCityCode3, OriginLocation3, By.xpath("//input[@id='fromLocationControl2']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure City3 : </i></b>" + OriginCityCode3 + " - " + OriginLocation3);

			TestBase.listofautosuggestion(By.xpath(
					"//mat-option[@class='mat-mdc-option mdc-list-item custom-combobox__options f-col ng-star-inserted mat-option-country-code-machted']/span/div/div[1]"),
					DestinationCityCode3, DestinationLocation3, By.xpath("//input[@id='toLocationControl2']"));

			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival City3 : </i></b>" + DestinationCityCode3 + " - " + DestinationLocation3);

			QaBrowser.driver.findElement(By.xpath("//input[@id='departureDateControl2']")).click();

			Thread.sleep(2000);

			selectDateInCalendarMulticity(expDateD3, monthD3, yearD2);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Search flight sector");
			QaRobot.clickOnDisableElement("CalenderContinueButton");

		}
		System.out.println(BookAs);

		switch (BookAs) {
		case "Employee":
			//input[@placeholder='Book as and trip category']/../../../../..//mat-icon
			//mat-label[contains(text(),'Book ')]/ancestor::div[@class='f-col booking-row-fields bookingrow-section']//mat-icon
			QaBrowser.driver.findElement(By.xpath(
					"//input[@placeholder='Book as and trip category']/../../../../..//mat-icon"))
					.click();
			break;
		case "Guest":
			QaBrowser.driver.findElement(By.xpath(
					"//input[@placeholder='Book as and trip category']/../../../../..//mat-icon"))
					.click();
			QaBrowser.driver.findElement(By.xpath("//mat-radio-button[ starts-with(@value,'Guest ')]")).click();
			//QaRobot.ClickOnElement("Guest");
			break;
		case "MultiPassenger":
			QaBrowser.driver.findElement(By.xpath(
					"//input[@placeholder='Book as and trip category']/../../../../..//mat-icon"))
					.click();
			QaBrowser.driver.findElement(By.xpath("//label[text()='Multiple passengers']")).click();
		//	QaRobot.ClickOnElement("MultiPassenger");
			break;

		}
		if (BookAs.equalsIgnoreCase("Employee")) {
			switch (TCategory) {
			case "BusinessT":
				Thread.sleep(2000);
				QaRobot.ClickOnElement("BusinessTrip");
				break;
			case "FamilyT":
				Thread.sleep(2000);
				QaRobot.ClickOnElement("FamilyTrip");
				break;
			case "PersonalT":
				Thread.sleep(2000);
				QaRobot.ClickOnElement("PersonalTrip");
				break;
			}
		}
		WebElement BookAsConfirm = QaBrowser.driver.findElement(By.xpath(
				"//button[@class='button--primary-small mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']/span[2]"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", BookAsConfirm);

//		if (BookAs.equalsIgnoreCase("Employee")) {
//			switch (TripType) {
//			case "OneWay":
//				QaRobot.ClickOnElement("EmpDetails1");
//				break;
//			case "RoundTrip":
//				QaRobot.ClickOnElement("EmpDetails2");
//				break;
//			case "MultiCity":
//
//				QaRobot.clickOnDisableElement("EmployeeDetails3");
//
//				break;
//			}
//			QaRobot.ClickOnElement("SelectEmpDetails");
//			Thread.sleep(3000);
//		}

		if (TCategory.equalsIgnoreCase("BusinessT")) {
			
		//	if(BookAs.equalsIgnoreCase("MultiPassenger")) {
			if (aQty > 2) {
				Thread.sleep(3000);
				QaBrowser.driver.findElement(By.xpath("(//input[starts-with(@id,'mat-input-')]/../../../../..//mat-icon)[2]")).click();
				//QaRobot.ClickOnElement("SPassenger");
				QaRobot.addMultiPassenger(AQty);
				WebElement SPassengerC = QaBrowser.driver.findElement(By.xpath("//span[text()='Continue']"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", SPassengerC);
			}
	//	}

		} else {
			if (TripType.equalsIgnoreCase("OneWay")) {
				QaRobot.ClickOnElement("SPassenger");
				QaRobot.addPassenger(AQty, CQty, IQty, ISQty);
				WebElement SPassengerC = QaBrowser.driver.findElement(By.xpath("//span[text()='Continue']"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", SPassengerC);
//			QaRobot.ClickOnElement("SPassengerC");
			} else if (TripType.equalsIgnoreCase("RoundTrip")) {
				QaRobot.ClickOnElement("SPassenger");
				QaRobot.addPassenger(AQty, CQty, IQty, ISQty);
				WebElement SPassengerC = QaBrowser.driver.findElement(By.xpath("//span[text()='Continue']"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", SPassengerC);
			} else if (TripType.equalsIgnoreCase("MultiCity")) {
				//(//input[contains(@id,'mat-input-')])[3]
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'mat-input-')])[2]")).click();
				QaRobot.addPassenger(AQty, CQty, IQty, ISQty);
				WebElement SPassengerC = QaBrowser.driver.findElement(By.xpath("//span[text()='Continue']"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", SPassengerC);
			}
		}

		try {

			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.clickOnDisableElement("SearchFlight1");

	//		Thread.sleep(7000);

		} catch (Exception e) {
			throw (e);
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
		if (Month1.equalsIgnoreCase("January")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("February")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("March")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("April")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("June")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("July")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("August")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("September")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("October")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("November")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("December")) {
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
				"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
				.getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

//		if (date2.before(date1)) {
//			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
//			QaExtentReport.test.log(Status.FAIL,
//					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
////			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
//		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("//button[contains(@class,'calendar-available next')]")).click();
				monthYear = QaBrowser.driver.findElement(By.xpath(
						"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
						.getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			// QaBrowser.driver.findElement(By.xpath("//span[text()='"+ Day+"'] ")).click();
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
					"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					Thread.sleep(3000);
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath(
					"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

//			if (date3.before(date2)) {
//				QaExtentReport.test.log(Status.FAIL,
//						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("//button[contains(@class,'calendar-available next')]"))
							.click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath(
							"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span[1]"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				Thread.sleep(3000);
				QaBrowser.driver.findElement(By.xpath("//span[text()='" + Day1 + "']  ")).click();
//				List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath(
//						"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
//				for (WebElement ele1 : allDates1) {
//					String dt1 = ele1.getText();
//					if (dt1.equalsIgnoreCase(Day1)) {
//						ele1.click();
//						break;
//					}
//				}
			}
	//	}
//	}

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

			// QaBrowser.driver.findElement(By.xpath("//span[text()='"+ Day+"'] ")).click();
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

	public static void selectDateInCalendarOneWay1(String Day, String Month, String Year)
			throws ParseException, InterruptedException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("JAN")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("FEB")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("MAR")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("APR")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("MAY")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("JUN")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("JUL")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("AUG")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("SEP")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("OCT")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("NOV")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("DEC")) {
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
		String monthYear = QaBrowser.driver.findElement(By.xpath("//div[@class='f-col custom-calendar-value']"))
				.getText();
		String month = monthYear.split(" ")[0];// APR
		String year = monthYear.split(" ")[1];// 1991
//
//		if (date2.before(date1)) {
//			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
//			QaExtentReport.test.log(Status.FAIL,
//					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new ExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
//		} else {
		while (!(month.equals(Month) && year.equals(Year))) {
			WebElement Next = QaBrowser.driver.findElement(By.xpath("(//div[@class='calendar-header']//button)[2]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", Next);
//				QaBrowser.driver
//						.findElement(By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"))
//						.click();
			// b[text()='MAR 1991']
			monthYear = QaBrowser.driver.findElement(By.xpath("//div[@class='f-col custom-calendar-value']")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		QaBrowser.driver.findElement(By.xpath("//div[text()='" + Day + "']  ")).click();
//			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
//					"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-one-way-calendar/div/div/div[3]/table/tbody/tr/td/div/span[2]"));
//			for (WebElement ele : allDates) {
//				String dt = ele.getText();
//				if (dt.equalsIgnoreCase(Day)) {
//					ele.click();
//					break;
//				}
//			}
	}
//	}

	public static void selectDateInCalendarMulticity(String Day, String Month, String Year)
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
		} else if (Month.equalsIgnoreCase("Apr")) {
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
//	QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();

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
		String monthYear = QaBrowser.driver.findElement(By.xpath("//div[@class='calendar-navigation']/span")).getText();
		System.out.println(monthYear);
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
//			QaBrowser.driver
//					.findElement(By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"))
//					.click();
				monthYear = QaBrowser.driver.findElement(By.xpath("//span[@class='month']")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			QaBrowser.driver.findElement(By.xpath("//span[text()='" + Day + "']  ")).click();
//		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
//				"//mat-tab-body[@id='mat-tab-content-0-0']/div/div/app-booking-trip/form/div/section/div/div[2]/div[1]/app-one-way-calendar/div/div/div[3]/table/tbody/tr/td/div/span[2]"));
//		for (WebElement ele : allDates) {
//			String dt = ele.getText();
//			if (dt.equalsIgnoreCase(Day)) {
//				ele.click();
//				break;
//			}
//		}
		}
	}

}
