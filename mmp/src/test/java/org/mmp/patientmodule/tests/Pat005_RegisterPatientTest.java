package org.mmp.patientmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.AppLibrary;
import org.iitworkforce.healthcare.mmp.BaseClass;
import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.RegistrationPage;
import org.openqa.selenium.By;


public class Pat005_RegisterPatientTest extends BaseClass {
	
	@Test
	public void validateRegisterPatient() throws Exception
	{
		MMPLibrary mmplib = new MMPLibrary(driver);
		LoginPage loginpg = new LoginPage(driver);
		EditProfilePage epp = new EditProfilePage(driver);
		mmplib.launchApplication(prop.getProperty("patientURL"));
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		RegistrationPage rp = new RegistrationPage(driver);
		HashMap<String,String> expHashMAP = new HashMap<String,String>();
		String fnameRandomstr ="Fname"+AppLibrary.randomString(); 
		expHashMAP.put("FirstName", fnameRandomstr);
		String lnameRandomstr = "Lname"+AppLibrary.randomString();
		expHashMAP.put("LastName", lnameRandomstr);
		String addressRandomstr = "123 Address"+AppLibrary.randomString();
		expHashMAP.put("Address", addressRandomstr);
		String cityRandomstr = "City"+AppLibrary.randomString();
		expHashMAP.put("City", cityRandomstr);
		String stateRandomstr = AppLibrary.randomString();
		expHashMAP.put("State", stateRandomstr);
		String pharmRandomstr = "walgre"+AppLibrary.randomString();
		expHashMAP.put("Pharmacy", pharmRandomstr);
		String pharmAddr = "123 walgre"+AppLibrary.randomString();
		expHashMAP.put("PharmacyAdress", pharmAddr);
		String email = AppLibrary.randomString()+"@yahoo.com";
		expHashMAP.put("Email", email);
		String licenceRandomint = "213456"+AppLibrary.randomInteger();
		expHashMAP.put("Licence", licenceRandomint);
		String ssnRandomint = "3124567"+AppLibrary.randomInteger();
		expHashMAP.put("SSN", ssnRandomint);
		String ageRandomint = AppLibrary.randomInteger();
		expHashMAP.put("Age", ageRandomint);
		String weightRandomint = "1"+AppLibrary.randomInteger();
		expHashMAP.put("Weight", weightRandomint);
		String heightRandomint = "2"+AppLibrary.randomInteger();
		expHashMAP.put("Height", heightRandomint);
		String zipCodeRandomint = "2"+AppLibrary.randomInteger()+AppLibrary.randomInteger();
		expHashMAP.put("ZipCode", zipCodeRandomint);
		String username = AppLibrary.randomString()+AppLibrary.randomString()+AppLibrary.randomInteger();
		expHashMAP.put("Username", username);
		String pswd = AppLibrary.randomString()+AppLibrary.randomString()+AppLibrary.randomString()+AppLibrary.randomInteger();
		expHashMAP.put("Password", pswd);
		expHashMAP.put("ConfirmPassword",pswd);
		String ssq = "what is your pet name";
		expHashMAP.put("SecurityQns", ssq );
		System.out.println(expHashMAP);
		String expsuccmsg = "Thank you for registering with MMP. " ;
		String actsuccmsg = rp.personalDetails(expHashMAP);
		Assert.assertEquals(actsuccmsg, expsuccmsg);
}
	}


