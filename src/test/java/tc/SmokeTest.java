package tc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.Config;
import po.CommonPageObjects;
import po.LoginPage;
import po.OpenNewAccountPageObject;
import utils.BrowserManager;
import utils.Cmn;

public class SmokeTest {

	String url = Config.APP_URL;
	WebDriver driver;
	
	@Test(groups = {"login","smoke"})
	@Parameters("browser")
	public void t_01_login_in_to_parabank(String browser) {

		driver = BrowserManager.InvokeAndNavigateBrowser(browser,url);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.LoginInToParaBank("john", "demo");
		driver.quit();

	}
	
	@Test
	@Parameters("browser")
	public void t_02_create_new_account(String browser) {
	
		
		//Step 1: Invoke and Navigate
		driver = BrowserManager.InvokeAndNavigateBrowser(browser,url);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		//Step 2: Login in to the Application
		login.LoginInToParaBank("john", "demo");
		
		//Step 3: Click on Menu Item Create New Account
		CommonPageObjects oCmnPageObject = PageFactory.initElements(driver, CommonPageObjects.class);
		oCmnPageObject.ClickOnNewAccount();
		
		//Step 4: Create New Account
		OpenNewAccountPageObject oNewAccount = PageFactory.initElements(driver, OpenNewAccountPageObject.class);
		oNewAccount.SelectAccountType("SAVINGS");
		oNewAccount.SelectFromAccount("13233");
		oNewAccount.ClickSubmitButton();
		
		//Step 5: Validation: New Account is Created
		oNewAccount.ValidateNewAccountIsCreated();
		
		driver.quit();
		
	}
	
	
	@Test
	@Parameters("browser")
	public void t_04(String browser) {
		
		//Step 1: Invoke and Navigate
		driver = BrowserManager.InvokeAndNavigateBrowser(browser,"http://www.automationfraternity.com");
		Cmn.log("info", "Wow Screen shot");
		driver.quit();

	}
	
	/*	
	@Test
	public void t_01() {
		
		//Step 1: Invoke and Navigate
		WebDriver driver = BrowserManager.InvokeAndNavigateBrowser("http://www.automationfraternity.com");
		Cmn.log("info", "Wow Screen shot");

	}
	

	@Test
	public void t_02() {
		
		//Step 1: Invoke and Navigate
		WebDriver driver = BrowserManager.InvokeAndNavigateBrowser("https://www.guru99.com/using-soapui-selenium.html");
		Cmn.log("info", "Wow Screen shot");
	}
	
	@Test
	public void t_03() {
		
		//Step 1: Invoke and Navigate
		WebDriver driver = BrowserManager.InvokeAndNavigateBrowser("https://github.com/");
		Cmn.log("info", "Wow Screen shot");

	}
	
	@Test
	public void t_03_create_new_account() {
		
		//Step 1: Invoke and Navigate
		WebDriver driver = BrowserManager.InvokeAndNavigateBrowser(url);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		//Step 2: Login in to the Application
		login.LoginInToParaBank("john", "demo");
		
		//Step 3: Click on Menu Item Create New Account
		CommonPageObjects oCmnPageObject = PageFactory.initElements(driver, CommonPageObjects.class);
		oCmnPageObject.ClickOnNewAccount();
		
		//Step 4: Create New Account
		OpenNewAccountPageObject oNewAccount = PageFactory.initElements(driver, OpenNewAccountPageObject.class);
		oNewAccount.SelectAccountType("SAVINGS");
		oNewAccount.SelectFromAccount("13233");
		oNewAccount.ClickSubmitButton();
		
		//Step 5: Validation: New Account is Created
		oNewAccount.ValidateNewAccountIsCreated();
		
		
	}
	*/
	
}

//USER ACTIONS
/*  driver.findElement(By.name("username")).sendKeys("john");
driver.findElement(By.name("passowrd")).sendKeys("demo");
driver.findElement(By.xpath("//input[@value='Log In']")).click();
 */

