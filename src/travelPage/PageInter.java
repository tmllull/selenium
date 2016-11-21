package travelPage;

import org.openqa.selenium.By;

import mainClasses.SetWebDriver;

public interface PageInter {
	
	public static void clickByxPath(String path) {
		SetWebDriver.driver.findElement(By.xpath(path)).click();
	}

}
