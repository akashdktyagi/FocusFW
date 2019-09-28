package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import utils.Cmn;

public class LoginPage {

	//Section 1
	WebDriver driver;
	
	//Section2 : Paramatrized Construcotr
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Section 3: Locators
	@FindBy(how=How.NAME,using="username") 
	WebElement txtbx_username;
	
	@FindBy(how=How.NAME,using="password") 
	WebElement txtbx_password;
	
	@FindBy(how=How.XPATH,using="//input[@value='Log In']") 
	WebElement btn_submit;
	
	//Section 4: Methods
	
	public void SetUserName(String arg) {
		txtbx_username.sendKeys(arg);
		Cmn.log("info","User Name set: " + arg);
	}
	
	public void SetPassword(String arg) {
		txtbx_password.sendKeys(arg);
		Cmn.log("info","Password set: " + arg);
	}
	
	public void ClickSubmitButton() {
		btn_submit.click();
		Cmn.log("info","Button Clicked ");
	}
	
	public void LoginInToParaBank(String u, String p) {
		SetUserName(u);
		SetPassword(p);
		ClickSubmitButton();
		
		String actual = driver.getTitle();
		String expected = "ParaBank | Accounts Overview";
		
		if(actual.equals(expected) ){
			Cmn.log("info","Login In to ParaBank is successfull.");
			Assert.assertTrue(true);
		}else {
			Cmn.log("fail","Login In to ParaBank failed.");
			Assert.assertTrue(false);
		}

	}
	
	
	
	/*
	 * 
	 * 	  driver.findElement(By.name("username")).sendKeys("john");
	  driver.findElement(By.name("passowrd")).sendKeys("demo");
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();

	 */

}
