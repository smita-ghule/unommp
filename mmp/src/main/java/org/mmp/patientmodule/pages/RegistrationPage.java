package org.mmp.patientmodule.pages;
import java.util.HashMap;
import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String personalDetails(HashMap<String,String> pd ) throws Exception {

		driver.findElement(By.id("firstname")).sendKeys(pd.get("FirstName"));
		driver.findElement(By.id("lastname")).sendKeys(pd.get("LastName"));
		driver.findElement(By.id("datepicker")).sendKeys(pd.get("Address"));
		driver.findElement(By.id("license")).sendKeys(pd.get("Licence"));
		driver.findElement(By.id("ssn")).sendKeys(pd.get("SSN"));
		driver.findElement(By.id("state")).sendKeys(pd.get("State"));
		driver.findElement(By.id("city")).sendKeys(pd.get("City"));
		driver.findElement(By.id("address")).sendKeys(pd.get("Address"));
		driver.findElement(By.id("zipcode")).sendKeys(pd.get("ZipCode"));
		driver.findElement(By.id("age")).sendKeys(pd.get("Age"));
		driver.findElement(By.id("height")).sendKeys(pd.get("Height"));
		driver.findElement(By.id("weight")).sendKeys(pd.get("Weight"));
		driver.findElement(By.id("pharmacy")).sendKeys(pd.get("Pharmacy"));
		driver.findElement(By.id("pharma_adress")).sendKeys(pd.get("PharmacyAdress"));
		driver.findElement(By.id("email")).sendKeys(pd.get("Email"));
		driver.findElement(By.id("password")).sendKeys(pd.get("Password"));
		driver.findElement(By.id("username")).sendKeys(pd.get("Username"));
		driver.findElement(By.id("confirmpassword")).sendKeys(pd.get("ConfirmPassword"));
		driver.findElement(By.id("answer")).sendKeys(pd.get("LastName"));
		String securityQ = pd.get("SecurityQns");
		WebElement secdd = driver.findElement(By.id("security"));
		Select secddbox = new Select(secdd) ;
		secddbox.selectByVisibleText(securityQ);
		driver.findElement(By.name("register")).click();
		MMPLibrary mmpl = new MMPLibrary(driver);
		String succmsg = mmpl.handleAlert();
		return succmsg;
	}

}
