package application.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import application.pages.CartPage;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.ProductsPage;
import application.pages.SignupPage;
import utilities.ReadDataForHomePage;

public class HomePageTests extends BaseClass {
	LoginPage loginpage;
	SignupPage signup;
	ProductsPage productpage;
	CartPage cartpage;
	
  @Test(priority = 1,dataProviderClass = ReadDataForHomePage.class,dataProvider ="RegisterUser")
  public void RegisterUser(String name,String email,String uname,String pwd,String day,String month,String year,String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo) throws Exception{
	 loginpage=new LoginPage(driver);
	 signup=new SignupPage(driver);
	 homepage=new HomePage(driver);
	 
	 	 homepage.signinOrLogin();
		 loginpage.enterNameAndEmailID(name,email);
		 homepage.verifyEnterAccountInformationIsVisible();
		 signup.clickMrradioButton();
		 signup.accountInformation(uname, pwd,day,month,year);
		 signup.addressInformation(fname,lname,company,add1,add2,country,state,city,zipcode,mobileNo);
		 signup.createAccount();
		 homepage.verifyAccountCreatedIsVisible();
		 signup.clickContinue();
		 signup.adClose();
		 homepage.verifyloggedAsUsername();
		 homepage.deleteAccount();
		 homepage.verifyAccountDeletedIsVisible();
		 signup.clickContinue();
	  }
  @Test(priority = 7)
  public void verifyTestCasesPage() {
	  homepage=new HomePage(driver);
	  
		 homepage.clickTestCaseButton();
		 homepage.verifyUserNavigatedToTestcasePage();
  }
  @Test(priority = 10,dataProviderClass = ReadDataForHomePage.class,dataProvider="verifySubscriptionInHomePage")
  public void verifySubscriptionInHomePage(String subID) {
	  homepage=new HomePage(driver);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(1349,294.59)");
	  homepage.verifySubscriptionTag();
	  homepage.enterSubscriptionID(subID);
	  homepage.clickSubscribeButton();
	  homepage.verifySuccessMessage();
  }
 @Test(priority = 22)
  public void addToCartFromRecommendedItems() {
	  productpage=new ProductsPage(driver);
	  cartpage=new CartPage(driver);
	  homepage=new HomePage(driver);
	  
	  homepage.scrollDownToBottom();
	  homepage.verifyRecommendedItemsAreVisible();
	  homepage.addRecommendedItemToCart();
	  productpage.clickViewCartbutton();
	  cartpage.verifyProductIsDisplayedInCart();
  }
 @Test(priority = 23,dataProviderClass = ReadDataForHomePage.class,dataProvider="verifyAddressDetailsInCheckoutPage")
 public void verifyAddressDetailsInCheckoutPage(String name,String email,String uname,String pwd,String day,String month,String year,String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo) throws Exception {
	 productpage=new ProductsPage(driver);
	 cartpage=new CartPage(driver);
	 loginpage=new LoginPage(driver);
	 signup=new SignupPage(driver);
	 homepage=new HomePage(driver);
		 	 
	 homepage.signinOrLogin();
	 loginpage.enterNameAndEmailID(name,email);
	 signup.clickMrradioButton();
	 signup.accountInformation(uname, pwd,day,month,year);
	 signup.addressInformation(fname,lname,company,add1,add2,country,state,city,zipcode,mobileNo);
	 signup.createAccount();
	 signup.clickContinue();
	 homepage.verifyloggedAsUsername();
	 homepage.scrollDown();
	 homepage.hoverOnFirstProduct();
	 productpage.clickContinueShoppingButton();
	 homepage.hoverOnSecondProduct();
	 productpage.clickViewCartbutton();
	 homepage.clickCartButton();
	 cartpage.verifyCartPageIsDisplayed();
	 cartpage.clickProceedToCheckout();
	 cartpage.compareDeliveryAddressWithRegisteredAddress();
	 cartpage.compareBillingAddressWithRegisteredAddress();
	 homepage.deleteAccount();
	 homepage.verifyAccountDeletedIsVisible();
	 signup.clickContinue();
 }
@Test(priority = 25)
 public void verifyScrollUpWithArrowAndScrollDown(){
	 homepage=new HomePage(driver);
	 
	 homepage.scrollDownToBottom();
	 homepage.verifyTextSubscription();
	 homepage.clickScrollUpArrow();
	 homepage.verifyPageISScrolledUp();
	 homepage.verifyText();
	 }
 @Test(priority = 26)
 public void verifyScrollUpWithoutArrow() {
	 homepage=new HomePage(driver);
	 
	 homepage.scrollDownToBottom();
	 homepage.verifyTextSubscription();
	 homepage.scrollUpWithoutArrow();
	 homepage.verifyPageISScrolledUp();
	 homepage.verifyText();
 }
}
