package travelPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {

	public static By by = null;
	public String process = new String();
	String[] params = new String[10];
	File myFile;
	public static Integer rowNum = 0;
	boolean opened = false;
	boolean first = true;

	public void readFile(String pathFile) throws IOException, EncryptedDocumentException, InvalidFormatException {
		myFile = new File(pathFile);
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		openWeb();
		opened = true;
		readRows(mySheet);
		System.out.println("All process finished");
		myWorkBook.close();
	}

	public void readRows(XSSFSheet mySheet) throws IOException {
		Iterator<Row> rowIterator = mySheet.iterator();
		rowNum = 0;
		while (rowIterator.hasNext()) {
			if (rowNum == 0) { // Discart first row. Tags info
				rowIterator.next();
				++rowNum;
			}
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			readCells(cellIterator);
			++rowNum;
		}
	}

	public void readCells(Iterator<Cell> cellIterator) throws IOException {
		int j = 0;
		while (cellIterator.hasNext()) {
			if (j == 0) // First iteration. Detect name process
				findProcess(cellIterator);
			readParams(cellIterator, j, params);
			++j;
		}
		System.out.println("Starting process " + process + "...");
		if (checkValuesTours(params[0], params[1], params[2], params[3], params[4], params[5])) {
			if (!first) {
				Admin.mainPage();
			} else
				first = false;
			runProcess(process);
			this.process = "";
		}
	}

	public void findProcess(Iterator<Cell> cellIterator) {
		Cell cell = cellIterator.next();
		this.process = cell.getStringCellValue();
		System.out.println(process);
	}

	public void readParams(Iterator<Cell> cellIterator, int j, String[] params) {
		Cell cell = cellIterator.next();
		String[] split = String.valueOf(cell.toString()).split("\\.");
		params[j] = split[0];
	}

	public void runProcess(String process) throws NumberFormatException, IOException {

		if (process.equals("quickTour")) {
			Processes.quickTour(params[0], params[1], params[2], params[3], params[4], params[5]);
			writeStatus(rowNum, "Success");
		} else {
			writeStatus(rowNum, "INCORRECT PROCESS");
		}
	}

	public void openWeb() {
		SetWebDriver setWebDriver = new SetWebDriver();
		Admin.mainPage();
		Admin.loggin("admin@phptravels.com", "demoadmin");
	}

	public static void writeStatus(int rowNum, String status) throws IOException {
		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\allullam\\git\\selenium\\test.xlsx"));

		XSSFWorkbook yourworkbook = new XSSFWorkbook(file);

		XSSFSheet sheet1 = yourworkbook.getSheetAt(0);

		Row row = sheet1.getRow(rowNum);
		Cell column = row.getCell(7);
		if (column == null)
			column = row.createCell(7);
		System.out.println(status);
		column.setCellValue(status);
		file.close();
		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\allullam\\git\\selenium\\test.xlsx"));
		yourworkbook.write(out);
		out.close();
		yourworkbook.close();
	}

	boolean checkValuesTours(String tax, String tour, String adults, String children, String infants, String pay)
			throws IOException {
		if (Integer.parseInt(tax) < 1 || Integer.parseInt(tax) > 2) {
			writeStatus(rowNum, "ERROR IN TAX VALUE");
			return false;
		}
		if (Integer.parseInt(adults) < 1 || Integer.parseInt(adults) > 6) {
			writeStatus(rowNum, "ERROR IN ADULT VALUE");
			return false;
		}
		if (Integer.parseInt(children) < 0 || Integer.parseInt(children) > 4) {
			writeStatus(rowNum, "ERROR IN CHILDREN VALUE");
			return false;
		}
		if (Integer.parseInt(infants) < 0 || Integer.parseInt(infants) > 2) {
			writeStatus(rowNum, "ERROR IN INFANT VALUE");
			return false;
		}
		if (Integer.parseInt(tour) < 2 || Integer.parseInt(tour) > 11) {
			writeStatus(rowNum, "ERROR IN HOTEL VALUE");
			return false;
		}
		if (Integer.parseInt(pay) < 2 || Integer.parseInt(pay) > 6) {
			writeStatus(rowNum, "ERROR IN PAY VALUE");
			return false;
		}
		return true;
	}

	public static void click(String path) {
		SetWebDriver.driver.findElement(By.xpath(path)).click();
	}

	public static void sendKeys(String path, String key) {
		SetWebDriver.driver.findElement(By.xpath(path)).sendKeys(key);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("asdasd");
	}

	public static void waitUntilPath(WebDriverWait wait, String path) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}

	public static void waitUntilClass(WebDriverWait wait, String className) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}

	public void waitUntilId(WebDriverWait wait, String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public static void waitUntilAlert(WebDriverWait wait) {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void scrollAndClick(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		int elementPosition = element.getLocation().getY();
		String js = String.format("window.scroll(50, %s)", elementPosition);
		((JavascriptExecutor) driver).executeScript(js);
		element.click();
	}

	public static void scroll(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		int elementPosition = element.getLocation().getY();
		String js = String.format("window.scroll(50, %s)", elementPosition);
		((JavascriptExecutor) driver).executeScript(js);
	}

	public void getValuesFromDropDowns(WebDriver driver) {
		List<WebElement> selects = driver.findElements(By.cssSelector("[data-placeholder='Select']"));
		for (WebElement select : selects) {
			List<WebElement> options = new Select(select).getOptions();
			for (WebElement option : options) {
				System.out.println(option.getText());
			}
			System.out.println("-----------------------");
		}
		return;
	}

	public void getAllIdsAndNames(WebDriver driver) {
		List<WebElement> selects = driver.findElements(By.xpath("//*[@id='bookingform']/*"));
		System.out.println("-----------ID-----------");
		for (WebElement select : selects) {
			String id = select.getAttribute("id");
			if (!id.equals(""))
				System.out.println(id);
		}
		System.out.println("----------NAME-----------");
		for (WebElement select : selects) {
			String name = select.getAttribute("name");
			if (name != null && !name.equals(""))
				System.out.println(name);
		}

		return;
	}

}
