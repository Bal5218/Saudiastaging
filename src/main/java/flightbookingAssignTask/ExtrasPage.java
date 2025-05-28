package flightbookingAssignTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class ExtrasPage {

	public static void SelectExtras(String TripType, String AQty, String CQty, String IQty, String ISQty,
			String NextFlight, String NextFlightBaggage, String NoExtra, String SelectExtras, String MulticityFasttrack,
			String SeatD, String SeatR, String SeatNo, String ReturnSeatNumber, String DepartureSeat2,
			String DepartureSeat3, String Baggageradiobutton) throws Throwable {

		Thread.sleep(15000);
		QaExtentReport.extentScreenshot("Extra page");

		String SeatRowNumber = SeatNo.split(" ")[0];// 34
		int row = Integer.parseInt(SeatRowNumber);
		String SeatNumber = SeatNo.split(" ")[1];// C

		int noOfExtra = Integer.parseInt(NoExtra);

		int BagRadio = Integer.parseInt(Baggageradiobutton);

		// int nextflightbuttonBag =Integer.parseInt(NextFlightBaggage);
		for (int i = 1; i <= noOfExtra; i++) {
			String[] Extra = SelectExtras.split(",");
			String a = Extra[i - 1];
			switch (a) {
			case "Seat":

				boolean presentelement = QaBrowser.driver
						.findElement(By.xpath("//span[contains(text(),'Seat selection ')]")).isDisplayed();
				System.out.println(a);
				if (presentelement == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Seat selection is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Seat selection Page");
					Thread.sleep(2000);
				} else {

					QaBrowser.driver.findElement(By.xpath("//a[contains(text(),'Select')]")).click();
					Thread.sleep(9000);
					QaExtentReport.extentScreenshot("Seat Page");
//			SoftAssert softAssert = new SoftAssert();
//			try {
					// we have to remove if one way statement for one way and round trip
				//	if (TripType.equalsIgnoreCase("OneWay")) {

						int pAS = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
						int pI = Integer.parseInt(ISQty);
//				int pAS = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
						for (int q = 1; q <= pAS; q++) {
							if (q > 1 && pI >= 1) {
								QaBrowser.driver
										.findElement(By.xpath("//div[@class='passengerListDiv']//li[" + q + "]"))
										.click();
							}
							String SelectSeat1[] = SeatD.split(",");
							String SelectSeat2 = SelectSeat1[q - 1];
							String SelectSeat[] = SelectSeat2.split(" ");
							String Row = SelectSeat[0];
							String ASeat = SelectSeat[1];
							int a1 = Integer.parseInt(Row);
							int count = 0;
							for (int j = 30; j <= 57; j++) {
								count++;
//					try {
								if (j == a1) {
//						try {
									WebElement Seat1 = QaBrowser.driver
											.findElement(By.xpath("(//p[text()='" + ASeat + "'])[" + count + "]"));
//							} catch (Exception e) {
//								softAssert.assertTrue(false, "Seat is not showing");
//							}
									JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
									js2.executeScript("arguments[0].click()", Seat1);
									Thread.sleep(5000);
									break;
//						} catch (Exception e) {
//							softAssert.assertTrue(false, "Seat is not showing");
//						}
								}
//					} catch (Exception e) {
//						softAssert.assertTrue(false, "Seat is not showing");
//					}
							}
							QaExtentReport.extentScreenshot("Selected Seat  ");
							WebElement SeatC = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
							JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
							js3.executeScript("arguments[0].click()", SeatC);
//			
							Thread.sleep(9000);
							QaExtentReport.extentScreenshot("Seat Page");
							Thread.sleep(2000);
						}
						if (TripType.equalsIgnoreCase("OneWay")) {
							QaRobot.clickOnDisableElement("seatconfirmbuttonfinal");
						}
					//}
					// }when we not run multicity then we to enable curly brases
//			} catch (Exception e) {
//				softAssert.assertTrue(false, "Seat is not showing");
//			}		

					if (TripType.equalsIgnoreCase("RoundTrip")) {
						Thread.sleep(2000);
						QaRobot.clickOnDisableElement("NextFlight");

						Thread.sleep(2000);

						int pAS1 = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
						int pI1 = Integer.parseInt(ISQty);

						for (int q = 1; q <= pAS1; q++) {
							if (q > 1 && pI1 >= 1) {
								QaBrowser.driver
										.findElement(By.xpath("//div[@class='passengerListDiv']//li[" + q + "]"))
										.click();
							}
							String SelectSeat1[] = SeatR.split(",");
							String SelectSeat2 = SelectSeat1[q - 1];
							String SelectSeat[] = SelectSeat2.split(" ");
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
							QaExtentReport.extentScreenshot("Selected Seat  ");
							WebElement SeatC = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
							JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
							js3.executeScript("arguments[0].click()", SeatC);

							Thread.sleep(9000);
							QaExtentReport.extentScreenshot("Seat Page");
							Thread.sleep(2000);
						}

						QaRobot.clickOnDisableElement("seatconfirmbuttonfinal");

					}

//					else if (TripType.equalsIgnoreCase("MultiCity")) {
//						int pAS = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
//						int pI = Integer.parseInt(ISQty);
////				int pAS = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
//						for (int q = 1; q <= pAS; q++) {
//							if (q > 1 && pI >= 1) {
//								QaBrowser.driver
//										.findElement(By.xpath("//div[@class='passengerListDiv']//li[" + q + "]"))
//										.click();
//							}
//							String SelectSeat1[] = DepartureSeat2.split(",");
//							String SelectSeat2 = SelectSeat1[q - 1];
//							String SelectSeat[] = SelectSeat2.split(" ");
//							String Row = SelectSeat[0];
//							String ASeat = SelectSeat[1];
//							int a1 = Integer.parseInt(Row);
//							int count = 0;
//							for (int j = 30; j <= 57; j++) {
//								count++;
////					try {
//								if (j == a1) {
////						try {
//									WebElement Seat1 = QaBrowser.driver
//											.findElement(By.xpath("(//p[text()='" + ASeat + "'])[" + count + "]"));
////							} catch (Exception e) {
////								softAssert.assertTrue(false, "Seat is not showing");
////							}
//									JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//									js2.executeScript("arguments[0].click()", Seat1);
//									Thread.sleep(5000);
//									break;
////						} catch (Exception e) {
////							softAssert.assertTrue(false, "Seat is not showing");
////						}
//								}
////					} catch (Exception e) {
////						softAssert.assertTrue(false, "Seat is not showing");
////					}
//							}
//							QaExtentReport.extentScreenshot("Selected Seat  ");
//							WebElement SeatC = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
//							JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
//							js3.executeScript("arguments[0].click()", SeatC);
////			
//							// Thread.sleep(9000);
//							QaExtentReport.extentScreenshot("Seat Page");
//
//						}
//
//						int z = Integer.parseInt(NextFlight);
//
//						Thread.sleep(2000);
//
//						int pAS1 = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty);
//						int pI1 = Integer.parseInt(ISQty);
////int q=1;q<=pAS+1;q++  for individual multicity booking flow
//
//						for (int c = 1; c <= z; c++) {
//							QaRobot.clickOnDisableElement("NextFlight");
//							for (int s = 1; s <= pAS1; s++) {
//								Thread.sleep(2000);
//
//								if (s > 1 && pI1 >= 1) {
//									QaBrowser.driver
//											.findElement(By.xpath("//div[@class='passengerListDiv']//li[" + s + "]"))
//											.click();
//								}
//								String SelectSeat12[] = DepartureSeat2.split(",");
//								String SelectSeat21 = SelectSeat12[s - 1];
//								String SelectSeat121[] = SelectSeat21.split(" ");
//								String Row1 = SelectSeat121[0];
//								String ASeat1 = SelectSeat121[1];
//								int a11 = Integer.parseInt(Row1);
//								int count1 = 0;
//								for (int j = 30; j <= 57; j++) {
//									count1++;
//									if (j == a11) {
//										WebElement Seat1 = QaBrowser.driver.findElement(
//												By.xpath("(//p[text()='" + ASeat1 + "'])[" + count1 + "]"));
//										JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//										js2.executeScript("arguments[0].click()", Seat1);
//										Thread.sleep(5000);
//										break;
//
//									}
//								}
//								QaExtentReport.extentScreenshot("Selected Seat  ");
//								WebElement SeatC1 = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
//								JavascriptExecutor js31 = (JavascriptExecutor) QaBrowser.driver;
//								js31.executeScript("arguments[0].click()", SeatC1);
//
//								// Thread.sleep(9000);
//								QaExtentReport.extentScreenshot("Seat Page");
//								Thread.sleep(2000);
//							}
//
//						}
//
//						QaRobot.clickOnDisableElement("seatconfirmbuttonfinal");
//
//						Thread.sleep(8000);
//					}

				} // we have to disble this curly brases when we run one way and round trip
				break;

			case "Baggage":

				int a1 = Integer.parseInt(NextFlightBaggage);

				boolean BaggegeText = QaBrowser.driver.findElement(By.xpath("//span[text()='Add & upgrade baggage ']"))
						.isDisplayed();
				System.out.println(BaggegeText);

				if (BaggegeText == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Upgrade Baggage is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Page");
					Thread.sleep(2000);

				} else {

					QaRobot.ClickOnElement("AddBaggageButton");
					Thread.sleep(6000);
					int b11 = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty)
							+ Integer.parseInt(ISQty);
					// int i1 = 1; i1 <= b11 - 1; i1++)
					for (int i1 = 1; i1 <= b11 - 1; i1++) {

						QaBrowser.driver.findElement(By.xpath("(//div[@class='ebag-container' and contains(.,' "
								+ BagRadio + " Bag ')]//mat-icon)[" + i1 + "]")).click();

						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("Baggage Page");
					}

					Thread.sleep(2000);

					if (TripType.equalsIgnoreCase("RoundTrip")) {

						Thread.sleep(6000);
						WebElement NextBaggage = QaBrowser.driver.findElement(By.xpath("//span[text()='Next Flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", NextBaggage);
						int b12 = Integer.parseInt(AQty) + Integer.parseInt(CQty) + Integer.parseInt(IQty)
								+ Integer.parseInt(ISQty);
						for (int i1 = 1; i1 <= b12 - 1; i1++) {
							Thread.sleep(2000);
							QaBrowser.driver.findElement(By.xpath("(//div[@class='ebag-container' and contains(.,' "
									+ BagRadio + " Bag ')]//mat-icon)[" + i1 + "]")).click();
							Thread.sleep(2000);

							QaExtentReport.extentScreenshot("Baggage Page for returning");
						}
						Thread.sleep(2000);
					}

					else if (TripType.equalsIgnoreCase("MultiCity")) {

						for (int i1 = 1; i1 <= a1; i1++) {
							WebElement NextBaggage = QaBrowser.driver
									.findElement(By.xpath("//span[text()='Next Flight']"));
							JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
							js4.executeScript("arguments[0].click()", NextBaggage);

							Thread.sleep(2000);

							QaBrowser.driver
									.findElement(By.xpath("//div[@class='ebag-desc ng-star-inserted' and contains(.,' "
											+ BagRadio + " Bag ')]//mat-icon"))
									.click();

							QaExtentReport.extentScreenshot("Baggage Page");

						}
					}

				}

				QaRobot.clickOnDisableElement("UpgradeBaggageConfirmButton");
				Thread.sleep(8000);

				break;
			case "FastTrack":
				boolean Fastrack = QaBrowser.driver
						.findElement(
								By.xpath("//div[@class='service-content ng-star-inserted']/span[text()='Fast Track']"))
						.isDisplayed();
				System.out.println(Fastrack);

				if (Fastrack == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Upgrade Fastrack is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fastrack Page");
					Thread.sleep(2000);

				} else {
					WebElement fastrackaddextra = QaBrowser.driver
							.findElement(By.xpath("//div[@class=\"service-btn\"]/span/a"));
					JavascriptExecutor js10 = (JavascriptExecutor) QaBrowser.driver;
					js10.executeScript("arguments[0].click()", fastrackaddextra);
				//	if (TripType.equalsIgnoreCase("OneWay")) {
						QaExtentReport.test.log(Status.INFO,
								"<b><i>Upgrade Fastrack is not available on this flight</i></b>");
						Thread.sleep(5000);
						QaExtentReport.extentScreenshot("Fastrack Page");
		//			}
					if (TripType.equalsIgnoreCase("RoundTrip")) {
						WebElement nextFlight = QaBrowser.driver.findElement(By.xpath("//span[text()='Next flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", nextFlight);
						int noOffasttrack = Integer.parseInt(MulticityFasttrack);
						for (int j = 1; j <= noOffasttrack; j++) {

							WebElement addbutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Add']"));
							JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
							js6.executeScript("arguments[0].click()", addbutton);
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						QaExtentReport.extentScreenshot("Fastrack Page");

					} else if (TripType.equalsIgnoreCase("MultiCity")) {

						int noOffasttrack = Integer.parseInt(MulticityFasttrack);
						for (int j = 1; j <= noOffasttrack; j++) {

							WebElement addbutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Add']"));
							JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
							js6.executeScript("arguments[0].click()", addbutton);
							Thread.sleep(1000);
						}
//						QaBrowser.driver
//								.findElement(By.xpath("//div[@class='service-btn']/span//a[contains(text(),'Add')]"))
//								.click();
						Thread.sleep(3000);

						// QaBrowser.driver.findElement(By.xpath("//div[@class='add-fast-track']//span[2]")).click();
						// QaRobot.clickOnDisableElement("FasttrackAddButton");

						// Thread.sleep(1000);
						QaExtentReport.extentScreenshot("Fast track page");
						WebElement nextFlight = QaBrowser.driver.findElement(By.xpath("//span[text()='Next flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", nextFlight);
						Thread.sleep(3000);
						QaExtentReport.extentScreenshot("Upgrade fast track is not available on this flight");
						QaExtentReport.test.log(Status.INFO,
								"<b><i>Upgrade fast track is not available on this flight</i></b>");
						QaExtentReport.extentScreenshot("Fastrack page");
						Thread.sleep(3000);

						WebElement nextFlight1 = QaBrowser.driver.findElement(By.xpath("//span[text()='Next flight']"));
						JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
						js5.executeScript("arguments[0].click()", nextFlight1);
						for (int j = 1; j <= noOffasttrack; j++) {

							WebElement addbutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Add']"));
							JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
							js6.executeScript("arguments[0].click()", addbutton);
							Thread.sleep(1000);
						}

						// QaRobot.clickOnDisableElement("FasttrackAddButton");

						Thread.sleep(1000);
						QaExtentReport.extentScreenshot("Fast track page");

					}

				}
//				Thread.sleep(5000);
//				QaRobot.ClickOnElement("FastrackAddInternalButton");
//				Thread.sleep(1000);
//				QaExtentReport.extentScreenshot("fasttrack priority page");

				QaRobot.clickOnDisableElement("FastrackConfirmButton");

				break;
			case "MeetAndGreet":
				boolean meetandgreet = QaBrowser.driver.findElement(By.xpath("//span[text()=' Meet & Greet ']"))
						.isDisplayed();
				System.out.println(meetandgreet);

				if (meetandgreet == false) {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>meet and greet  is not available on this flight</i></b>");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Page");
					Thread.sleep(2000);

				} else {
					// we have to remember that i have taken multicity meat and greet alone.
				//	if (TripType.equalsIgnoreCase("OneWay")) {

						QaRobot.clickOnDisableElement("meetandgreetaddbutton");
						Thread.sleep(2000);
						QaRobot.clickOnDisableElement("dependentmeetonewayselect");
						QaRobot.clickOnDisableElement("dependetmeetonewayinnerconfirm");
						Thread.sleep(3000);

						QaExtentReport.extentScreenshot("meet and greet page ");
						if (TripType.equalsIgnoreCase("OneWay")) {
							QaBrowser.driver.findElement(By.xpath("//button[contains(@class,'button--primary')]"))
									.click();
							// }
						}

			//		}

					else if (TripType.equalsIgnoreCase("RoundTrip")) {

						WebElement nextFlight = QaBrowser.driver.findElement(By.xpath("//span[text()='Next Flight']"));
						JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
						js4.executeScript("arguments[0].click()", nextFlight);
						Thread.sleep(3000);
						QaRobot.clickOnDisableElement("meetgreetdependentroundtrip");
						Thread.sleep(5000);
						WebElement internalconfirm = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
						JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
						js5.executeScript("arguments[0].click()", internalconfirm);

						// span[text()='Confirm']
						// QaRobot.clickOnDisableElement("dependentmeetonewayselect");
						// QaRobot.clickOnDisableElement("dependetmeetonewayinnerconfirm");
						// Thread.sleep(3000);

						QaExtentReport.extentScreenshot("meet and greet page ");
						WebElement confirm = QaBrowser.driver.findElement(By.xpath("//span[text()=' Confirm']"));
						JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
						js6.executeScript("arguments[0].click()", confirm);

						// QaRobot.clickOnDisableElement("meetandgreetaddbutton");
						Thread.sleep(5000);

						// }

					}

					else if (TripType.equalsIgnoreCase("MultiCity")) {

						QaRobot.clickOnDisableElement("meetandgreetaddbutton");
						Thread.sleep(1000);

						QaRobot.clickOnDisableElement("meetmulticity1");
						Thread.sleep(1000);
						QaRobot.clickOnDisableElement("meetmulticityconfirm1");

						QaExtentReport.extentScreenshot("meetandgreetpage");

						Thread.sleep(1000);

						QaRobot.clickOnDisableElement("meetmultinextfligtbuuton");
						Thread.sleep(1000);

						QaRobot.clickOnDisableElement("meetmulticity2");
						Thread.sleep(1000);
						QaRobot.clickOnDisableElement("meetconfirm2");
						Thread.sleep(1000);
						QaExtentReport.extentScreenshot("meet and greet page");
						Thread.sleep(500);
						QaRobot.clickOnDisableElement("meetmultinextfligtbuuton");
						Thread.sleep(1000);

						// for (int s = 1; s <= 1; s++) {

						QaRobot.clickOnDisableElement("meetmulticity1");
						Thread.sleep(1000);
						QaRobot.clickOnDisableElement("meetmulticityconfirm1");

						QaExtentReport.extentScreenshot("meetandgreetpage");

						// }

					}
				

				}
		//		QaRobot.clickOnDisableElement("meetmultifinalconfirmbutton");

				Thread.sleep(8000);
				break;
			}

		}
//Thread.sleep(10000);
		QaRobot.clickOnDisableElement("ProccedToPayment");

		Thread.sleep(20000);
	}
}
