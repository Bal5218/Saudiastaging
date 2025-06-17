package CompanyMangement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import addTraveler.GenericUtility;
import utilities.QaBrowser;

public class CostCentreOverview {
	public static void costCentreOverview(String DevisionDetails, String STATUS,String CancilConfirm, String BranchName,
			String CostCenterName, String costcentercode, String Scostsavcancil, String CostCenterNamea,
			String costcentercodea) throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[text()='Cost center overview']")).click();

		switch (DevisionDetails) {
		case "Add":
			QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Cost Center Name']/../..//input",
					CostCenterName);
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Cost Center Code']//../..//input",
					costcentercode);
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;

			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;
			}

			GenericUtility.clickConfirmButton("//mat-label[text()='Associate with Branch']");

			QaBrowser.driver
					.findElement(By.xpath(
							"//div[contains(@id,'cdk-overlay-')]//mat-option/span/div[text()=' " + BranchName + " ']"))
					.click();

			switch (Scostsavcancil) {

			case "save":

				WebElement saveButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Save']"));
				Actions action = new Actions(QaBrowser.driver);

				action.doubleClick().perform();
				action.moveToElement(saveButton).click().perform();
				break;

			case "cancil":
				WebElement cancilButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				Actions action1 = new Actions(QaBrowser.driver);

				action1.doubleClick().perform();
				action1.moveToElement(cancilButton).click().perform();

				break;
			}
			break;
		case "Edit":
			QaBrowser.driver
					.findElement(By.xpath("//table//tbody//tr//td[text()=' " + CostCenterName + " ']/..//td[4]/a[1]"))
					.click();
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Cost Center Name']/../..//input",
					CostCenterNamea);
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Cost Center Code']//../..//input",
					costcentercodea);
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;

			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;
			}

			GenericUtility.clickConfirmButton("//mat-label[text()='Associate with Branch']");

			QaBrowser.driver
					.findElement(By.xpath(
							"//div[contains(@id,'cdk-overlay-')]//mat-option/span/div[text()=' " + BranchName + " ']"))
					.click();
			switch (Scostsavcancil) {

			case "save":

				WebElement saveButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Save']"));
				Actions action = new Actions(QaBrowser.driver);

				action.doubleClick().perform();
				action.moveToElement(saveButton).click().perform();
				break;

			case "cancil":
				WebElement cancilButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				Actions action1 = new Actions(QaBrowser.driver);

				action1.doubleClick().perform();
				action1.moveToElement(cancilButton).click().perform();

				break;
			}

			break;

		case "Remove":
			QaBrowser.driver
					.findElement(By.xpath("//table//tbody//tr//td[text()=' " + CostCenterName + " ']/..//td[4]/a[2]"))
					.click();
			switch (CancilConfirm) {
			case "Cancil":
				WebElement Ab1 = QaBrowser.driver.findElement(
						By.xpath("//span[text()='Cancel']"));
				Actions action =new Actions(QaBrowser.driver);
				action.moveToElement(Ab1).click().perform();

				break;

			case "Confirm":
				WebElement Ab12 = QaBrowser.driver.findElement(
						By.xpath("//span[text()='Confirm']"));
				Actions actiona =new Actions(QaBrowser.driver);
				actiona.moveToElement(Ab12).click().perform();

				break;
			}

			break;

		}

	}
}
