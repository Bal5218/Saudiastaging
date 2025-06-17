package CompanyMangement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;

public class DivisionDetails {
	public static void divisionDetails(String DevisionDetails, String STATUS, String DsavCancil, String Division,String CancilConfirm,String DivisionName) {
		switch (DevisionDetails) {
		case "Add":
			QaBrowser.driver.findElement(By.xpath("//div[text()='Division details']")).click();
			QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
			WebElement divisionName = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"divisionName\"]"));
			divisionName.clear();
			divisionName.sendKeys(DivisionName);
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;
			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;

			}
			switch (DsavCancil) {
			case "Save":
				WebElement Abc = QaBrowser.driver
						.findElement(By
								.xpath("//div[@class=\"inner-action\"]/descendant::span[text()=' Save ']"));

				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", Abc);
						
				break;
			case "Cancil":
				WebElement Acb = QaBrowser.driver
						.findElement(
								By.xpath("//div[@class=\"inner-action\"]/descendant::span[text()='Cancel']"));
						
				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", Acb);
				break;

			}

			break;
		case "Edit":
			QaBrowser.driver.findElement(By.xpath("//div[text()='Division details']")).click();
			List<WebElement> list_Of_Division = QaBrowser.driver.findElements(By.xpath("//table//tr/td[1]"));
			for (WebElement division : list_Of_Division) {
				String value = division.getText();
				System.out.println(value);
				if (value.equalsIgnoreCase(Division)) {
					QaBrowser.driver
							.findElement(By.xpath(
									"//table//tbody//tr/td[text()=' " + Division + " ']/..//td[3]/a[text()='Edit']"))
							.click();
					break;
				}

			}
			WebElement divisionField = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"division\"]"));
			divisionField.click();
			divisionField.clear();
			divisionField.sendKeys(DivisionName);
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;
			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;

			}
			WebElement Ab = QaBrowser.driver.findElement(
					By.xpath("//div[@class=\"f-col d-align-right verify-footer\"]/descendant::span[text()='Save']"));

			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", Ab);

			break;
		case "Remove":
			QaBrowser.driver.findElement(By.xpath("//div[text()='Division details']")).click();
			List<WebElement> list_Of_Division1 = QaBrowser.driver.findElements(By.xpath("//table//tr/td[1]"));
			for (WebElement division : list_Of_Division1) {
				String value = division.getText();
				System.out.println(value);
				if (value.equalsIgnoreCase(Division)) {
					QaBrowser.driver
							.findElement(By.xpath(
									"//table//tbody//tr/td[text()=' " + Division + " ']/..//td[3]/a[text()='Remove']"))
							.click();
					break;
				}

			}

			switch (CancilConfirm) {
			case "Cancil":
				WebElement Ab1 = QaBrowser.driver.findElement(
						By.xpath("//div[@class=\"dialog-actions-right\"]/descendant::span[text()='Cancel']"));

				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", Ab1);
				break;

			case "Confirm":
				//div[@class="dialog-actions-right"]/descendant::span[text()='Confirm']
				WebElement Ab12 = QaBrowser.driver.findElement(
						By.xpath("//div[@class=\"dialog-actions-right\"]/descendant::span[text()='Confirm']"));

				JavascriptExecutor js12 = (JavascriptExecutor) QaBrowser.driver;
				js12.executeScript("arguments[0].click()", Ab12);
				break;
			}

			break;

		}

	}
}
