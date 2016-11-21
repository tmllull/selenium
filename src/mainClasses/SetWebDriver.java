package mainClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetWebDriver {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public SetWebDriver() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized", "-incognito");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 30);
	}

}
