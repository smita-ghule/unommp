package org.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iitworkforce.healthcare.mmp.AppLibrary;
import org.iitworkforce.healthcare.mmp.BaseClass;
import org.iitworkforce.healthcare.mmp.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.MessagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessagesE2ETests extends BaseClass {
	

	@Test
	public void validateSendMessages()
	{

		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage patientLogin = new LoginPage(driver);
		 patientLogin.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Messages");
		MessagesPage patientMessages= new MessagesPage(driver);
		String reason="Having Cold";
		String subject="To meet doctor Charlie";
		String actual=patientMessages.sendMessages(reason,subject);
		String expected="Message Successfuly sent";
		
		mmpLib.navigation("Profile");
	
		EditProfilePage editprofilepage=new EditProfilePage(driver);
		//fatch patientfirstname-3
		String patientFirstName= editprofilepage.fetchPatientFirstName();
		//date-2
		String date= AppLibrary.getfutureDate(0,"MM/d/yyyy");
		HashMap <String,String> expectedHMap= new HashMap <String,String>();//2 value
		expectedHMap.put("reason",reason);
		expectedHMap.put("subject",subject);
		expectedHMap.put("fname",patientFirstName);
		expectedHMap.put("date",date);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual,expected);
		
		
		mmpLib.launchApplication(prop.getProperty("adminURL"));
		org.mmp.adminmodule.pages.LoginPage adminLogin = new org.mmp.adminmodule.pages.LoginPage(driver);
		adminLogin.login(prop.getProperty("adminUserName"),prop.getProperty("adminPassword"));
		 org.mmp.patientmodule.pages.MessagesPage adminMessages= new  org.mmp.patientmodule.pages.MessagesPage(driver);
		 HashMap <String,String> actualHMap= adminMessages.fetchMessagesDetails();//4 value
		sa.assertEquals(expectedHMap,actualHMap);
		sa.assertAll();
	}
}
