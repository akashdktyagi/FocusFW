package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import config.Config;

public class BrowserManager {
	
	
	public static WebDriver InvokeAndNavigateBrowser(String browser,String url) {
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/akashtyagi/Desktop/chromedriver");
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver = null;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	  
		driver.get(url);
		
		//if Web Driver instance for current thread is already present in the map
		//then remove it and add it afresh
		if (Config.DRIVER_MAP.containsKey(Thread.currentThread().getId())) {
			Config.DRIVER_MAP.remove(Thread.currentThread().getId());
		}
		
		Config.DRIVER_MAP.put(Thread.currentThread().getId(), driver);//assinging the driver to global scope
		Cmn.log("info","Browser Invoked");
		return driver;
	}

}
