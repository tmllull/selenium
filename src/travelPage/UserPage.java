package travelPage;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class UserPage extends PageClass {

	public static void userPage() throws InterruptedException {
		SetWebDriver.driver.get("http://phptravels.net");
		waitUntilPath(SetWebDriver.wait, "//*[@id='HOTELS']/div/form/button");
		click("//*[@id='HOTELS']/div/form/button");
	}

	public void travelUser() throws InterruptedException {
		UserPage.userPage();
		Hotels.SelectHotel();
		SelectRoom.selectRoom();
		Loggin.logginUser("user@phptravels.com", "demouser");
		Confirm.confirm();
	}

}
