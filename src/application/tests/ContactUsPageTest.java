package application.tests;

import org.testng.annotations.Test;

import application.pages.ContactUsPage;
import application.pages.HomePage;
import utilities.ReadDataForContactUs;

public class ContactUsPageTest extends BaseClass {
	ContactUsPage contactpage;
	
@Test(priority=6,dataProviderClass = ReadDataForContactUs.class,dataProvider ="verifyContactUsForm")
  public void verifyContactUsForm(String name,String email,String sub,String msg,String path) {
	  homepage=new HomePage(driver);
	  contactpage=new ContactUsPage(driver);
	  	 
		 homepage.clickContactUs();
		 contactpage.verifyGetInTouchIsVisible();
		 contactpage.enterDetails(name,email,sub,msg);
		 contactpage.uploadFile(path);
		 contactpage.clickSubmit();
		 contactpage.clickOKButton();
		 contactpage.verifySuccessMessage();
		 contactpage.clickHomeButton();
		 contactpage.verifyLandedOnHomePage();
		 
  }
}
