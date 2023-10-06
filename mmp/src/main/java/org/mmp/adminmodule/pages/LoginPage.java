package org.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage  (WebDriver driver)
	{
		this.driver= driver;
	}

	public void login(String uname,String pword)
	{
		 
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(uname);
		WebElement password =     driver.findElement(By.id("password"));
		password.sendKeys(pword);
		driver.findElement(By.name("admin")).click();
	}
}
