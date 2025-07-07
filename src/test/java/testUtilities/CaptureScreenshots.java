package testUtilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import pageTest.BaseClass;

import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshots extends BaseClass{
	
	public static String getScreenshots(String tname)
	{
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		
		
		File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp;
		File targetFile=new File(targetFilepath);
		
		
		try {
			FileUtils.copyFile(sourceFile,  targetFile);
			
		}catch (IOException e)
		{
			System.out.println("capture Failed "+e.getMessage());
		}
		return targetFilepath;
		
	}

	

}
