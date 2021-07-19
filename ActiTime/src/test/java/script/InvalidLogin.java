package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import generic.Iconstant;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException {

		LoginPage loginpage = new LoginPage(driver);

		int rowcnt = Excel.getRowCount(Iconstant.XL_PATH, "InvalidLogin");
		
		for (int i=1;i<=rowcnt;i++) {
		
		String UN = Excel.getData(Iconstant.XL_PATH, "InvalidLogin", i, 0);
		String PWD = Excel.getData(Iconstant.XL_PATH, "InvalidLogin", i, 1);
		
		//enter invalid user name
		loginpage.setUserName(UN);
		
		//enter invalid password
		loginpage.setPassword(PWD);
		
		//click login button
		loginpage.clickLogin();
		
		//verify if error message is displayed
		boolean errMsgDisplayed = loginpage.VerifyErrorMsg(wait); //returns true if error message is displayed
		Assert.assertTrue(errMsgDisplayed,"Error Message not displayed");
		Thread.sleep(1000);
		}
	}
}
