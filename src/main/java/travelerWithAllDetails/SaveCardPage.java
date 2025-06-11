package travelerWithAllDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import utilities.QaBrowser;

public class SaveCardPage {
	public static void saveCardDetails(String CardOption, String cardtype, String expiryMonth, String expiryYear,
			String card,String savecards) throws Throwable {
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Saved cards')]")).click();
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'add')]")).click();
		Thread.sleep(1000);
		WebElement cardName = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"cardName\"]"));
		cardName.sendKeys("silver");
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Card Option')]/../..//mat-select")).click();
		List<WebElement> card_Option_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		System.out.println(card_Option_List.size());
		for (WebElement cardoption : card_Option_List) {
			Thread.sleep(500);
			String cardlist = cardoption.getText();
			System.out.println(cardlist);
			if (cardlist.equalsIgnoreCase(cardlist)) {
				cardoption.click();
				break;
			}
		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Card Type')]/../..//mat-select")).click();
		List<WebElement> card_Type_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		System.out.println(card_Type_List.size());
		for (WebElement cardlist1 : card_Type_List) {
			Thread.sleep(500);
			String cardlist = cardlist1.getText();
			System.out.println(cardlist);
			if (cardlist.equalsIgnoreCase(cardtype)) {
				// GenericUtility.clickConfirmButton("//div[contains(@id,'cdk-overlay-')]//mat-option/span");
				cardlist1.click();
				break;
			}
		}
		WebElement card_Holder_Name = QaBrowser.driver
				.findElement(By.xpath("//input[@formcontrolname=\"cardHolderName\"]"));
		card_Holder_Name.click();
		card_Holder_Name.sendKeys("Balkrishna");
		WebElement cardNumber = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"cardNumber\"]"));
		cardNumber.click();
		cardNumber.sendKeys("5678901234098765");
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Expiry Month')]/../..//mat-select"))
				.click();
		List<WebElement> expiryMonthlist = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		System.out.println(expiryMonthlist.size());
		for (WebElement expiryMonthlist1 : expiryMonthlist) {
			Thread.sleep(500);
			String monthlist = expiryMonthlist1.getText();
			System.out.println(monthlist);
			if (monthlist.equalsIgnoreCase(expiryMonth)) {

				expiryMonthlist1.click();
				break;
			}
		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Expiry Year')]/../..//mat-select")).click();
		List<WebElement> expiryYearlist = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		System.out.println(expiryYearlist.size());
		for (WebElement expiryyearlist1 : expiryYearlist) {
			Thread.sleep(500);
			String yearlist = expiryyearlist1.getText();
			System.out.println(yearlist);
			if (yearlist.equalsIgnoreCase(expiryYear)) {

				expiryyearlist1.click();
				break;
			}
		}

		switch (card) {
		case "personal":
			QaBrowser.driver.findElement(By.xpath("//label[contains(text(),'Personal card')]/../..//input")).click();
			break;
		case "corporate":
			QaBrowser.driver.findElement(By.xpath("//label[contains(text(),'Corporate card')]/../..//input")).click();
			break;

		}
		switch (savecards) {
		case "save":
			QaBrowser.driver
					.findElement(By.xpath(
							"//span[contains(text(),'Save ')]/..//span[@class=\"mat-mdc-button-touch-target\"]"))
					.click();
			break;
		case "cancil":
			QaBrowser.driver
			.findElement(By.xpath(
					"//span[contains(text(),'Cancel')]/..//span[@class=\"mat-mdc-button-touch-target\"]"))
			.click();
			break;

		}

	}
}
