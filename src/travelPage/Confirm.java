package travelPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Confirm extends PageClass{

	public static void confirm() {
		by = By.xpath("//*[@id='top']/div[7]/div/div/div[1]/div/div[2]/div[5]/button");
		scrollAndClick(SetWebDriver.driver, by);
		waitUntilClass(SetWebDriver.wait, "arrivalpay");
		SetWebDriver.driver.findElement(By.className("arrivalpay")).click();
		waitUntilAlert(SetWebDriver.wait);
		Alert alert = SetWebDriver.driver.switchTo().alert();
		alert.accept();
	}

}
