package travelPage;

import org.openqa.selenium.Alert;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class Admin extends PageClass {

	public static void mainPage() {
		SetWebDriver.driver.get("http://phptravels.net/admin");
	}

	public static void loggin(String user, String pass) {
		waitUntilPath(SetWebDriver.wait, "/html/body/div/form[1]/button");
		sendKeys("/html/body/div/form[1]/div[1]/input[1]", user);
		sendKeys("/html/body/div/form[1]/div[1]/input[2]", pass);
		click("/html/body/div/form[1]/button");
	}

	public static void quickBooking(String tax, String type) {
		waitUntilPath(SetWebDriver.wait, "//*[@id='content']/div[1]/div[1]/button");
		click("//*[@id='content']/div[1]/div[1]/button");
		waitUntilPath(SetWebDriver.wait, "//*[@id='apply']");
		click("//*[@id='apply']");
		click("//*[@id='apply']/option[" + tax + "]");
		click("//*[@id='servicetype']");
		click("//*[@id='servicetype']/option[" + type + "]");
		click("//*[@id='quickbook']/div[2]/div/form/div[3]/button[2]");
	}

	public void deleteAllBookings() {
		waitUntilPath(SetWebDriver.wait, "//*[@id='content']/div/div[2]/div/div/div[1]/div[1]/div[1]/a[1]");
		click("//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[1]/div/ins");
		click("//*[@id='content']/div/div[2]/div/div/div[1]/div[1]/div[1]/a[1]");
		Alert alert = SetWebDriver.driver.switchTo().alert();
		alert.accept();
	}

}
