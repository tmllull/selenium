package travelPage;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class Hotels extends PageClass{

	public static void SelectHotel() {
		waitUntilPath(SetWebDriver.wait, "//*[@id='top']/div[9]/div[3]/div/div[1]/div[2]/div/div[1]/a/button");
		click("//*[@id='top']/div[9]/div[3]/div/div[1]/div[2]/div/div[1]/a/button");
	}
	
}
