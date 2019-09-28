package utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Cmn {

	/*
	 * info, pass,fail,warn
	 */
	public static void log(String logType,String msg) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy:hh-mm-ss");
		String timeStamp = sdf.format(d);

		String path = TakeScreenShot(Config.DRIVER);
		//Reporter.log("fail", "<a href =\"" + path + "\">Click Here</a>");
		Reporter.log(timeStamp + " | " + logType + " | " + msg + " <a href =\"" + path + "\">Click Here</a>"+ "<br>",true);



		//Reporter.log(timeStamp + " | " + logType + " | " + msg + "<br>",true);
	}


	public static String TakeScreenShot(WebDriver driver)  {

		try {
			//Get the random number for the file
			Random rand = new Random();
			long random = (int )(Math.random() * 999999999 + 1000000);
			String result = Long.toString(random);

			String path = System.getProperty("user.dir") + "//" +"ScreenShots";
			String nameFileName = result + ".png";
			String filePathName = path + "//" + nameFileName;

			//to create new folder
			new File(path).mkdirs();

			// TODO Auto-generated method stub
			TakesScreenshot  scrShot = (TakesScreenshot)driver;
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File destFile  = new File(filePathName);
			Files.copy(
					srcFile.toPath(), destFile.toPath());
			//Cmn.log("info", "ScreenShot Taken.");
			return filePathName;


		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}
}



