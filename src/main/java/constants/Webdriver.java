package constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver {
public static WebDriver driver;
	public static WebDriver launch(String browser){
		switch(browser){
		case "chrome":
			System.setProperty("webdriver.chrome.driver","E:\\WorkSpace\\Drivers&API's\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\Narendra\\AppData\\Local\\Google\\Chrome\\User Data");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","E:\\WorkSpace\\Drivers&API's\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  break;
		}
	
			return driver;
		}
	}

