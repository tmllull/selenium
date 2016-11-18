package travelPage;

import org.openqa.selenium.By;

public interface PageInter {
	
	public static void clickByxPath(String path) {
		SetWebDriver.driver.findElement(By.xpath(path)).click();
	}

}
