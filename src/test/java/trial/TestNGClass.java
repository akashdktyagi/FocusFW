package trial;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGClass {


	@Test
	public void t_01(ITestResult rs) {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	@Test
	public void t_02() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	@Test
	public void t_03(ITestContext cntx) {
		
		System.out.print(cntx.getAttribute("NAME"));
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	@Test
	public void t_04() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	
	@Test(groups= {"search","add_to_basket","e2e"})
	public void t_05() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	@Test(groups= {"search"})
	public void t_06() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	@Test(groups= {"search","e2e"})
	public void t_07() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	


}
