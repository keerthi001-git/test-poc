package pageTest;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import testUtilities.CaptureScreenshots;
import testUtilities.ConfigReader;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; // log4j
	public Properties p;
	// public ConfigReader config;

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(String br) throws IOException {
		// loading config.properties file

		FileReader file = new FileReader("configs//Configuration.properties");
		p = new Properties();
		p.load(file);

		 logger=LogManager.getLogger(this.getClass()); //log4j2

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser name.....");
			return;

		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("base_Url")); // Reading URL from properties file.
		// driver.get(configReader.getBaseUrl());
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

		/*
		 * if(result.getStatus()==ITestResult.FAILURE)
		 * 
		 * { String temp=CaptureScreenshots.getScreenshots(driver);
		 * //logger.fail(result.getThrowable().getMessage(),
		 * MediaEntityBuilder.CreateScreenshotCaptureFromPath(temp).build()); }
		 * 
		 * //extent.flush();
		 */

	}

	public static String RandamString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public static String randamNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public static String randamAlphaNumber() {
		String generatedString = RandomStringUtils.randomAlphabetic(3); // String
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		String alphanumaric = (generatedString + "@" + generatedNumber);
		return alphanumaric;

	}

	public static String generateRandomEmail(String domain, int length) {
		// Generates a random string of specified length containing letters and numbers
		String username = RandomStringUtils.randomAlphanumeric(length);
		String email = username + "@" + domain;
		return email;
	}

	public static String generateRandomdimention() {
		// Generates a random string of specified length containing letters and numbers

		int minWidth = 10;
		int maxWidth = 100;
		int minHeight = 5;
		int maxHeight = 75;
		Random random = new Random();
		int randomWidth = random.nextInt(maxWidth - minWidth + 1) + minWidth;
		int randomHeight = random.nextInt(maxHeight - minHeight + 1) + minHeight;
		String randomWidth1 = String.valueOf(randomWidth);
		String randomHeight1 = String.valueOf(randomHeight);
		String dimention = randomWidth1 + "X" + randomHeight1;
		return dimention;
	}

	public static String randamPrice() {
		String generatedPrice = RandomStringUtils.randomNumeric(3);
		return generatedPrice;
	}

	public static String RandomMedium() {

		String[] medium = { "Oil", "Canvas" };
		Random random = new Random();

		// Generate a random index within the array's bounds
		int randomIndex = random.nextInt(medium.length);

		// Retrieve the string at the random index
		String selectedMedium = medium[randomIndex];
		return selectedMedium;

	}

	
	public static String RandomYearGenerator() {
		
		int startYear = 1800;
		int EndYear = 2025;
		Random random = new Random();
		String randamYearGenerator = String.valueOf(random.nextInt(EndYear - startYear + 1) + startYear);
		return randamYearGenerator;
		
	}
}
