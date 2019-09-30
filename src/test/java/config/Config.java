package config;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import utils.BrowserManager;

public class Config {
	public static String APP_URL = "http://parabank.parasoft.com";
	public static Map<Long,WebDriver> DRIVER_MAP = new HashMap<Long,WebDriver>();
}
