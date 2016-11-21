package travelPage;

import org.openqa.selenium.By;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class SelectRoom extends PageClass {

	public static void selectRoom() {
		by = By.xpath("//*[@id='ROOMS']/div/form[1]/div/div[2]/div[1]/button");
		scroll(SetWebDriver.driver, by);
		click("//*[@id='ROOMS']/div/form[1]/div/div[2]/div[1]/button");
	}

}
