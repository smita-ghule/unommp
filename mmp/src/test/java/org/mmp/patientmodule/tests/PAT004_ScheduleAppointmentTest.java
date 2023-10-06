package org.mmp.patientmodule.tests;



import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.BaseClass;
import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.mmp.patientmodule.pages.HomePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class PAT004_ScheduleAppointmentTest extends BaseClass
{
	@Parameters({"username","password"}) 
	@Test
	public void validateBookAppointment(String username, String password)
	{
		// int i=10;
		MMPLibrary mmpLib = new MMPLibrary(driver);
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"), prop.getProperty("patientPassword"));
		mmpLib.navigation("Schedule Appointment");
		ScheduleAppointmentPage sPage= new ScheduleAppointmentPage(driver);
		HashMap<String, String> expectedHMap = sPage.bookAppointment();
		HomePage hPage=new HomePage(driver);
		HashMap<String, String> actualHMap = hPage.fetchPortalData();
		Assert.assertNotEquals(actualHMap, expectedHMap);
	 
	}
}

	 