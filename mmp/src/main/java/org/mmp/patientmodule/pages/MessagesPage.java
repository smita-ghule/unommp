package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {

	WebDriver driver;
	public MessagesPage (WebDriver driver)
	{
		this.driver= driver;
	}

	public String sendMessages(String reason,String subject)
	{
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		MMPLibrary mmplibrary = new MMPLibrary(driver);
		String text= mmplibrary.handleAlert();
		
		return text;
		
	}

	public HashMap<String, String> fetchMessagesDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
