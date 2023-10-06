package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
	WebDriver driver;
	HashMap<String,String> actualEditInfo = new HashMap<String,String>();
	MMPLibrary mmplib;
	public EditProfilePage  (WebDriver driver)
	{
		this.driver= driver;
		mmplib= new MMPLibrary(driver);
	}
	public String editFirstName(String expected)
	{
		clickEditButton();
		updateFirstName(expected);
		clickSaveButton();
		String successMsg=mmplib.handleAlert();
		String actual = driver.findElement(By.id("fname")).getAttribute("value");
		return successMsg+","+actual;
	}
	public void editAllFields(HashMap<String,String> expectedHMap)
	{
		clickEditButton();
		updateFirstName(expectedHMap.get("FName"));
		updateLastName(expectedHMap.get("LName"));
		clickSaveButton();
		mmplib.handleAlert();
	}
	public void updateFirstName(String fName)
	{
		WebElement fNameWE = driver.findElement(By.id("fname"));
		fNameWE.clear();
		fNameWE.sendKeys(fName);
	}
	public void updateLastName(String lName)
	{
		WebElement lNameWE = driver.findElement(By.id("lname"));
		lNameWE.clear();
		lNameWE.sendKeys(lName);
	}
	public void clickSaveButton()
	{
		driver.findElement(By.id("Sbtn")).click();
		
	}

	public void clickEditButton()
	{
		driver.findElement(By.id("Ebtn")).click();
	}
	public HashMap<String, String> fetchUpdatedValues()
	{
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		actualEditInfo.put("FName",fName);
		String lName = driver.findElement(By.id("lname")).getAttribute("value");
		actualEditInfo.put("LName",lName);
		return actualEditInfo;
	}
	public String fetchPatientFirstName()
	{
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		return fName;
	}

}
