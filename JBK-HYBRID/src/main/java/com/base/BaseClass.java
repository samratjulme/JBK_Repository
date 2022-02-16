package com.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("BaseClass");
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static void browserInitialization() {
		
		log.info("Initializing browser from BaseClass");
		
		String brName= PropertiesUtility.readProperty("browser");
		
		if(brName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(brName.equals("firefox")) {
			System.getProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(brName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", "operadriver.exe");
			driver = new OperaDriver();
		}
		
		log.info("maximizing browser window");
	    driver.manage().window().maximize();
	    
	    log.info("deleting all cookies");
	    driver.manage().deleteAllCookies();
	}
	
	public static void urlEntering() {
		log.info("Entering url");
		driver.get(PropertiesUtility.readProperty("url"));
	}
	
	public static void reportInitialization() {
		log.info("Initializing Report");
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
	    report.attachReporter(spark);
	    report.setSystemInfo("Samrat", "JBK Offline Website");
	}
	
	public static String captureScreenshot(String name) {
		log.info("Taking Screenshot");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+name+".jpg";
	    File dest = new File(path);
	    try {
			FileUtils.copyFile(source, dest);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Fail to copy Screenshot from source to dest");
		}
	    log.info("Returning Screenshot path");
	    return path;
	}
}