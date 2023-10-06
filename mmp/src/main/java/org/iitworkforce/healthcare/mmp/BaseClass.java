package org.iitworkforce.healthcare.mmp;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	protected Properties prop;
	@BeforeClass
	public void instantiateDriver() throws IOException
	{

		ProjectConfiguration pConfig = new ProjectConfiguration();
		prop = pConfig.loadProperties("config/mmp.properties");
		String browserType = prop.getProperty("browserType");
		if(browserType.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		
	}
}

