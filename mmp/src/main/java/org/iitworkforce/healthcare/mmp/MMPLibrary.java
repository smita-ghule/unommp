package org.iitworkforce.healthcare.mmp;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPLibrary {
	
	WebDriver driver;
	
	 
	 
	public MMPLibrary(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void navigation(String tabName)
	{
		driver.findElement(By.xpath("//a[contains(.,'"+tabName+"')]")).click();
	
	}
	
	
	
	
	public void launchApplication(String url)
	{
		//driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.get(url);
	}
	
	public String handleAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		alrt.accept();
		return successMsg;
	}
	
}