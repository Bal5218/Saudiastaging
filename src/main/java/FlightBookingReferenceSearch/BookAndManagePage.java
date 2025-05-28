package FlightBookingReferenceSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;

public class BookAndManagePage {

	public static void bookAndManage(String SearchBy, String NoOFExtra, String BookingReference, String Lastname,
			String triptype) throws Throwable {
		int loop = Integer.parseInt(NoOFExtra);
		Thread.sleep(10000);
		QaExtentReport.captureScreenshot("BookandManagePage");
		switch (SearchBy) {
		case "BookingReference":
			for (int i = 1; i <= loop; i++) {
				String[] Extra = BookingReference.split(",");
				String a = Extra[i - 1];
				switch (a) {
				case "LTTGDZ":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("ReferencebookingPage");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "LT822X":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("ReferencebookingPage");
//					WebElement managebutton1 = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
//					js1.executeScript("arguments[0].click()", managebutton1);
					break;
				case "LT3RIP":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("ReferencebookingPage");
//					WebElement managebutton2 = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js21 = (JavascriptExecutor) QaBrowser.driver;
//					js21.executeScript("arguments[0].click()", managebutton2);
					break;
				case "LSS3SW":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("ReferencebookingPage");
//					WebElement managebutton5 = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js25 = (JavascriptExecutor) QaBrowser.driver;
//					js25.executeScript("arguments[0].click()", managebutton5);
					break;

				}
			}

			break;
		case "LastName":
			for (int i = 1; i <= loop; i++) {
				String[] Extra = Lastname.split(",");
				String a = Extra[i - 1];
				switch (a) {
				case "Chauhan":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBylastname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "Singh":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBylastname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);

					break;
				case "Maurya":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBylastname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "Kumar":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBylastname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				}

			}
			break;
		case "tripname":
			for (int i = 1; i <= loop; i++) {
				String[] Extra = triptype.split(",");
				String a = Extra[i - 1];
				switch (a) {
				case "Riyadh":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBytripname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "Dubai":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBytripname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "Jeddah":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBytripname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				case "London":
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).click();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).clear();
					QaBrowser.driver.findElement(By.xpath("//input[@name='Search']")).sendKeys(a);
					QaBrowser.driver.findElement(By.xpath("//span[@class='f-row']/mat-icon")).click();
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SearchBytripname");
//					WebElement managebutton = QaBrowser.driver.findElement(By.xpath("//span[text()='Manage']"));
//					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//					js2.executeScript("arguments[0].click()", managebutton);
					break;
				}

			}
			break;

		}
	}
}
