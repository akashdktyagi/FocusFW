package tc;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass {

	//WEbDriver driver
	@Test(priority=1)
	public void LoginTest() {
		Reporter.log("in test1",true);
	}
	
	@Test(priority=2,dependsOnMethods="t1")
	public void NormalSearch() {
		Reporter.log("in test2",true);
	}
	@Test(priority=2,dependsOnMethods="t1")
	public void TestSearchWithFilters() {
		Reporter.log("in test2",true);
	}
	
	@Test(priority=3,dependsOnMethods= {"NormalSearch","",""})
	public void AddToCart() {
		Reporter.log("in test2",true);
	}
}
