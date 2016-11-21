package travelPage;

import java.io.IOException;

import mainClasses.PageClass;

public class Processes extends PageClass {

	public static void quickTour(String tax, String tour, String adults, String children, String infants, String pay) throws NumberFormatException, IOException {
		Admin.quickBooking(tax, "4");
		InfoToursPage.fillInfoTours(tour, adults, String.valueOf((Integer.parseInt(children) + 1)),
				String.valueOf((Integer.parseInt(infants) + 1)), pay);
	}

}
