package org.mmp.patientmodule.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {
	WebDriver driver;
	public ScheduleAppointmentPage  (WebDriver driver)
	{
		this.driver= driver;
	}
	
	public HashMap<String, String> bookAppointment()
	{
		HashMap<String,String> expectedHMap= new HashMap<String,String>();
		String doctorName="Charlie";
		
		expectedHMap.put("doctor",doctorName);
		
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
				
		driver.switchTo().frame("myframe");
		
		//driver.findElement(By.id("datepicker")).sendKeys("09/01/2024");
		//driver.findElement(By.linkText("1")).click();
		driver.findElement(By.id("datepicker")).click();
		
		String expectedDate=AppLibrary.getfutureDate(5,"MMMM/d/yyyy");
		
		expectedHMap.put("date",AppLibrary.getfutureDate(5,"MM/d/yyyy"));
		
		String expectedYear=expectedDate.split("/")[2];  //2024
		String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();//2023
		
		while(!(actualYear.equals(expectedYear)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		String expectedMonth=expectedDate.split("/")[0];
		String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();//2023
		
		while(!(actualMonth.equals(expectedMonth)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		
		String expectedDay=expectedDate.split("/")[1] ;
		driver.findElement(By.linkText(expectedDay)).click();
		
		
		Select timeSelect = new Select(	driver.findElement(By.id("time")));
		expectedHMap.put("time","10Am");
		timeSelect.selectByVisibleText("10Am");
		
		String okStatus = driver.findElement(By.id("status")).getText();
		System.out.println("Date and Time is selected and the status ::: " + okStatus);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName")));
		continueButton.click();
		
		driver.switchTo().defaultContent();
		expectedHMap.put("sym","Fever");
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys("Fever");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		System.out.println(expectedHMap);
		return expectedHMap;
		 
	}
}
