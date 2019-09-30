package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import utils.Cmn;

public class CommonPageObjects {

	//Section 1
	WebDriver driver;
	
	//Section2 : Paramatrized Construcotr
	public CommonPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Section 3: Locators
	@FindBy(how=How.LINK_TEXT,using="Open New Account") 
	WebElement link_open_new_account;
	
	@FindBy(how=How.LINK_TEXT,using="Transfer Funds") 
	WebElement link_transfer_funds;
	
	@FindBy(how=How.LINK_TEXT,using="Accounts Overview") 
	WebElement link_account_overview;
	
	
	
	//Section 4: Methods
	public void ClickOnNewAccount() {
		link_open_new_account.click();
		
		Assert.assertEquals(driver.getTitle(), "ParaBank | Open Account");
		Cmn.log("info", "Open new Account page opened");
	}
	
	public void ClickOnTransferFunds() {
		link_transfer_funds.click();
		Assert.assertEquals(driver.getTitle(), "ParaBank | Transfer Funds");
		Cmn.log("info", "Transfer Funds page opened");
	}
	
	public void ClickOnAccountOverview() {
		link_account_overview.click();
		
		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
		Cmn.log("info", "Account Overview Page opened");
	}
	
	
	
	
	

	
}
