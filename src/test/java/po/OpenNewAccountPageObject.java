package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import utils.Cmn;
import utils.Config;

public class OpenNewAccountPageObject {

	//Section 1
	WebDriver driver;
	
	//Section2 : Paramatrized Construcotr
	public OpenNewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//Section 3: Locators
	@FindBy(how=How.ID,using="type") 
	WebElement list_account_type;
	
	@FindBy(how=How.ID,using="fromAccountId") 
	WebElement list_from_account;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']") 
	WebElement btn_open_new_account;
	
	@FindBy(how=How.XPATH,using="//div[@ng-if='showResult']") 
	WebElement segment_show_result;
	
	
	
	//Section 4: Methods
	
	public void SelectAccountType(String arg) {

		Select obj = new Select(list_account_type);
		obj.selectByVisibleText(arg);
		Cmn.log("info", "Account Type Selected: " + arg);
		
	}
	
	public void SelectFromAccount(String arg) {

		Select obj = new Select(list_from_account);
		obj.selectByVisibleText(arg);
		Cmn.log("info", "From Account Selected: " + arg);
	}
	
	public void ClickSubmitButton() {
		btn_open_new_account.click();
		Cmn.log("info", "Submit Button Clicked.");
	}
	
	public void ValidateNewAccountIsCreated() {
		
		String actualText = segment_show_result.getText();
		
		if (actualText.contains("Congratulations, your account is now open")) {
			Cmn.log("pass", "New Account Created.");
			Assert.assertTrue(true);
		}else {
			String path = Cmn.TakeScreenShot(Config.DRIVER);
			Cmn.log("fail", "Account Created could not be created.");
			Assert.assertTrue(false,"Account not Created");
		}
		
		//Fetch the Account Number
		String sNewAccountNumber = segment_show_result.findElement(By.id("newAccountId")).getText();
		Cmn.log("pass", "New Account Created: " + sNewAccountNumber);
	}

}
