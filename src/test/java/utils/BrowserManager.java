package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BrowserManager {
	
	
	public static WebDriver InvokeAndNavigateBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/akashtyagi/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	  
		driver.get(url);
		Config.DRIVER = driver;//assinging the driver to global scope
		Cmn.log("info","Browser Invoked");
		return driver;
	}

}
