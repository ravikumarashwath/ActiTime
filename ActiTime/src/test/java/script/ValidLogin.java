package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import generic.Iconstant;
import pages.ETTPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest{
	
  @Test(priority=1)
  public void testValidLogin() { 
	  
	LoginPage loginpage = new LoginPage(driver);
	
	String UN = Excel.getData(Iconstant.XL_PATH, "ValidLogin", 1, 0);
	String PWD = Excel.getData(Iconstant.XL_PATH, "ValidLogin", 1, 1);
	String expectedtitle = Excel.getData(Iconstant.XL_PATH, "ValidLogin", 1, 2);
	
	//Enter valid user name
	loginpage.setUserName(UN);
	
	//Enter valid password
	loginpage.setPassword(PWD);
	
	//click login button
	loginpage.clickLogin();
	
	//verify home page title
	ETTPage ettpage = new ETTPage(driver);
	boolean actualtitle = ettpage.VerifyTitle(wait,expectedtitle); //Returns True if title contains Enter Time
	Assert.assertTrue(actualtitle,"Home page is not displayed");//verifying whether actual title is true or not - if true then pass, if false then fail
	 //message will display if there is failure   
  }
}
