package org.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Parameters;
import org.iitworkforce.healthcare.mmp.AppLibrary;
import org.iitworkforce.healthcare.mmp.BaseClass;
import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import datadriven.Login;

import org.testng.annotations.DataProvider;

public class PAT_003EditProfileTest extends BaseClass {
	

	@Test
	public void validateEditFName()
	{

		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Profile");
		String expected="FName"+AppLibrary.randomString();
		EditProfilePage editprofilepage=new EditProfilePage(driver);
		String actual = editprofilepage.editFirstName(expected);
		String[] actualArry = actual.split("\\,");
		System.out.println(actualArry[0]);
		String expectedSuccessMsg ="Your Profile has been updated.";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedSuccessMsg,actualArry[0]);
		sa.assertEquals(expected,actualArry[1]);
		sa.assertAll();

	}
	
	@Parameters({"username","password"})
	@Test
	public void validateAllFields(String username, String password)
	{

		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		MMPLibrary mmpLib = new MMPLibrary(driver);
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Profile");
		String fName="FName"+AppLibrary.randomString();
		expectedHMap.put("FName",fName);
		String lName="LName"+AppLibrary.randomString();
		expectedHMap.put("LName",lName);
		EditProfilePage editprofilepage=new EditProfilePage(driver);
		editprofilepage.editAllFields(expectedHMap);
		HashMap<String,String> actualHMap = editprofilepage.fetchUpdatedValues();
		Assert.assertEquals(actualHMap, expectedHMap);
	}


	@DataProvider(name = "mmpDP")
	public String[][] feedDP() throws IOException
	{
		 String data[][] = AppLibrary.readXLSX("config//data.xlsx");
		 return data;
	}
	
	@Test(dataProvider="mmpDP")
	public void editProfile2(String param1,String param2,String param3)
	{
		
		System.out.println(param1 + "--" +param2+"--"+param3);
		
	}
}
