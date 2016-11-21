package travelPage;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class Loggin extends PageClass {

	public static void logginUser(String user, String pass) {
		click("//*[@id='signintab']");
		waitUntilPath(SetWebDriver.wait, "//*[@id='username']");
		sendKeys("//*[@id='username']", user);
		sendKeys("//*[@id='password']", pass);
	}

	public void newUser() {
		waitUntilPath(SetWebDriver.wait, "//*[@id='guestform']/div[1]/div/input");
		sendKeys("//*[@id='guestform']/div[1]/div/input", "aaa");
		sendKeys("//*[@id='guestform']/div[2]/div/input", "aaa");
		sendKeys("//*[@id='guestform']/div[3]/div/input", "a@a.com");
		sendKeys("//*[@id='guestform']/div[4]/div/input", "a@a.com");

	}

}
