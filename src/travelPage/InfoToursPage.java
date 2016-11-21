package travelPage;

import java.io.IOException;

import org.openqa.selenium.By;

import mainClasses.PageClass;
import mainClasses.SetWebDriver;

public class InfoToursPage extends PageClass {

	public static void fillInfoTours(String tour, String adults, String children, String infants, String pay) throws IOException {
		//waitUntilPath(SetWebDriver.wait, "//*[@id='tours']");
		//System.out.println("Choosing date...");
		writeStatus(rowNum, "Choosing date...");
		//sendKeys("//*[@id='tours']", "24/11/2016");
		click("//*[@id='bookingform']/div[3]/div[2]/div[1]");
		click("//*[@id='s2id_autogen3']/a/span[1]");
		click("//*[@id='bookingform']/div[3]/div[2]/div[3]/div/select/option[" + tour + "]");
		waitUntilPath(SetWebDriver.wait, "//*[@id='adults']");
		//System.out.println("Adding people...");
		writeStatus(rowNum, "Adding people...");
		click("//*[@id='adults']");
		click("//*[@id='adults']/option[" + adults + "]");
		click("//*[@id='children']");
		click("//*[@id='children']/option[" + children + "]");
		click("//*[@id='infants']");
		click("//*[@id='infants']/option[" + infants + "]");
		waitUntilPath(SetWebDriver.wait, "//*[@id='extras_9']");
		//System.out.println("Selecting extras...");
		writeStatus(rowNum, "Selecting extras...");
		by = By.xpath("//*[@id='extras_9']");
		scrollAndClick(SetWebDriver.driver, by);
		click("//*[@id='extras_8']");
		click("//*[@id='extras_7']");
		click("//*[@id='extras_6']");
		//System.out.println("Paying...");
		writeStatus(rowNum, "Paying...");
		click("//*[@id='bookingform']/div[5]/div[2]/div/select");
		click("//*[@id='bookingform']/div[5]/div[2]/div/select/option[" + pay + "]");
		click("//*[@id='bookingform']/div[6]/div/input[2]");
	}

}
