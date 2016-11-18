package eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import travelPage.PageClass;

public class eCommerce {
	public static void buy(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");// eCommerce
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"))).perform();
		PageClass.waitUntilPath(wait, "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a");
		action.moveToElement(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")))
				.click().perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")))
				.perform();

		driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[2]/span")).click();
		PageClass.waitUntilPath(wait, "//*[@id='quantity_wanted_p']/a[2]/span/i");
		for (int i = 0; i < 5; ++i) {
			driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]/span/i")).click();
		}
		driver.findElement(By.xpath("//*[@id='group_1']")).click();
		driver.findElement(By.xpath("//*[@id='group_1']/option[2]")).click();
		driver.findElement(By.xpath("//*[@id='group_1']")).click();
		driver.findElement(By.xpath("//*[@id='color_14']")).click();
		driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
		PageClass.waitUntilPath(wait, "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		PageClass.waitUntilPath(wait, "//*[@id='center_column']/p[2]/a[1]/span");
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();

	}

}
