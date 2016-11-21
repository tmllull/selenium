package travelPage;

import org.openqa.selenium.By;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class InfoCarsPage extends PageClass {

	public void fillInfoCars() {
		sendKeys("//*[@id='cars']", "22/12/2016");
		click("//*[@id='bookingform']/div[3]/div[2]/div[1]");
		click("//*[@id='s2id_autogen3']/a/span[2]/b");
		click("//*[@id='bookingform']/div[3]/div[2]/div[3]/div/select/option[5]");
		waitUntilPath(SetWebDriver.wait, "//*[@id='extras_13']");
		by = By.xpath("//*[@id='extras_13']");
		scroll(SetWebDriver.driver, by);
		click("//*[@id='extras_13']");
		click("//*[@id='extras_11']");
		click("//*[@id='bookingform']/div[5]/div[2]/div/select");
		click("//*[@id='bookingform']/div[5]/div[2]/div/select/option[4]");
		click("//*[@id='bookingform']/div[5]/div[2]/div/select");
		click("//*[@id='bookingform']/div[6]/div/input[2]");
	}

	public void newCostumer() {
		click("//*[@id='selusertype']");
		click("//*[@id='selusertype']/option[2]");
		click("//*[@id='selusertype']");
		sendKeys("//*[@id='fname']", "I'm a new user");
		sendKeys("//*[@id='lname']", "And this is may Lastname");
		sendKeys("//*[@id='mobile']", "123456789");
		sendKeys("//*[@id='email']", "hi@me.com");
	}

}
