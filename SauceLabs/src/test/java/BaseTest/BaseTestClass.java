package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {
	
	public  WebDriver driver;
	public  Properties prop;
	public Logger logger;
	
	public WebDriver instalizeDriver() throws IOException {
		logger=LogManager.getLogger(this.getClass());
		 Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\prop.properties");
			prop.load(fis);
			String browser=prop.getProperty("browserName");
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("fox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url=prop.getProperty("url");
		driver.get(url);
		return driver;
	}
	@BeforeMethod
	 public void setUp() throws IOException {
	        driver = instalizeDriver();
	    }
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		driver.quit();
		
	}
	
}
	

