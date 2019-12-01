package trial;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGClass2 {


	@Test
	public void t_01(ITestContext cntx) {
		cntx.setAttribute("NAME", "Akash");

		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	@Test
	public void t_02() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	@Test
	public void t_03() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	@Test
	public void t_04() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	
	@Test
	public void t_05() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	
	@Test
	public void t_06() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	@Test
	public void t_07() {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log(name, true);
	}
	
	


}
