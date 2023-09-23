package application.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.SignupPage;
import utilities.ReadDataForLogin;

public class LoginPageTests extends BaseClass{
	LoginPage loginpage;
	SignupPage signup;
  
@Test(priority=2,dataProviderClass = ReadDataForLogin.class,dataProvider = "validemailandpassword")
  public void verifyWithValidEmailAndPassword(String email,String password){
	  loginpage=new LoginPage(driver);
	  homepage=new HomePage(driver);
		
	  homepage.signinOrLogin();
	  loginpage.verifyLoginToYourAccountIsVisible();
	  loginpage.loginUser(email,password);
	  homepage.verifyloggedAsUsername();
	  homepage.deleteAccount();
	  homepage.verifyAccountDeletedIsVisible();
  }
@Test(priority=3,dataProviderClass = ReadDataForLogin.class,dataProvider = "invalidemailandpassword")
public void verifyWithInvalidEmailAndPassword(String email,String password ) {
	  loginpage=new LoginPage(driver);
	  homepage=new HomePage(driver);
	  
	  homepage.signinOrLogin();
	  loginpage.verifyLoginToYourAccountIsVisible();
	  loginpage.loginUser(email,password);
	  loginpage.verifyErrorMessage();
	  }
@Test(priority=4,dataProviderClass = ReadDataForLogin.class,dataProvider ="logoutUser")
public void logoutUser(String email,String pwd) {
	loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	
	homepage.signinOrLogin();
	loginpage.verifyLoginToYourAccountIsVisible();
	loginpage.loginUser(email,pwd);
	homepage.verifyloggedAsUsername();
	homepage.clickLogout();
	loginpage.verifyUserIsNavigatedToLoginPage();
	}
@Test(priority = 5,dataProviderClass = ReadDataForLogin.class,dataProvider ="registeruserwithexistingemail")
public void verifyRegisterUserWithExistingEmail(String name,String email) {
	loginpage=new LoginPage(driver);
	
	homepage.signinOrLogin();
	loginpage.enterNameAndEmailID(name,email);
	loginpage.verifySecondErrorMessage();
}

}

