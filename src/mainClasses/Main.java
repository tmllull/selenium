package travelPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {

	public static void main(String[] args)
			throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {

		PageClass pClass = new PageClass();
		pClass.readFile("C:\\Users\\allullam\\git\\selenium\\test.xlsx");
	}

}
