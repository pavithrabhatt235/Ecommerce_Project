package application.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import application.pages.CartPage;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.ProductsPage;
import application.pages.SignupPage;
import utilities.ReadDataForCartPage;

public class CartPageTests extends BaseClass{
	ProductsPage productpage;
	CartPage cartpage;
	LoginPage loginpage;
	SignupPage signup;
	
		
@Test(priority = 11,dataProviderClass = ReadDataForCartPage.class,dataProvider ="subscriptionincartpage")
  public void verifyScriptionInCartPage(String email){
		  homepage=new HomePage(driver);
		  homepage.clickCartButton();
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(1349,294.59)");
		  homepage.verifyTextSubscription();
		  homepage.enterSubscriptionID(email);
		  homepage.clickSubscribeButton();
		  homepage.verifySuccessMessage();
	}
	@Test(priority = 12)
	public void addProductsInCart() throws Exception {
		 productpage=new ProductsPage(driver);
		 cartpage=new CartPage(driver);
		 homepage=new HomePage(driver);
		 
		 homepage.clickProductsButton();
		 productpage.hoverFirstProduct();
		 productpage.clickAddToCartOne();
		 productpage.clickContinueShoppingButton();
		 productpage.hoverSecondProduct();
		 productpage.clickAddToCartTwo();
		 productpage.clickViewCartbutton();
		 productpage.productName();
		 cartpage.secondProductName();
		 productpage.price();
		 cartpage.firstQuantity();
		 cartpage.totalFirst();
		 cartpage.priceSecond();
		 cartpage.secondQuantity();
		 cartpage.total();
	}
	@Test(priority = 13,dataProviderClass = ReadDataForCartPage.class,dataProvider="verifyProductQuantityInCart")
	public void verifyProductQuantityInCart(String quantity) throws Exception {
		 productpage=new ProductsPage(driver);
		 cartpage=new CartPage(driver);
		 homepage=new HomePage(driver);
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(600,800)");
		 homepage.hoverOnHomePageProductOne();
		 productpage.productName();
		 productpage.category();
		 productpage.price();
		 productpage.available();
		 productpage.condition();
		 productpage.condition();
		 productpage.Quantity(quantity);
		 productpage.addToCart();
		 productpage.clickViewCartbutton();
		 cartpage.finalQuantity();
	}
	@Test(priority=14,dataProviderClass = ReadDataForCartPage.class,dataProvider="registerWhileCheckout")
	public void registerWhileCheckout(String name,String email,String uname,String pwd,String day,String month,String year,String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo,String description,String ename,String num,String cvc,String emonth,String eyear)throws Exception {
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		signup=new SignupPage(driver);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		 
			homepage.scrollDown();
			homepage.hoverOnFirstProduct();
			productpage.clickContinueShoppingButton();
			homepage.hoverOnSecondProduct();
			productpage.clickViewCartbutton();
			homepage.clickCartButton();
			cartpage.verifyCartPageIsDisplayed();
			cartpage.clickProceedToCheckout();
			cartpage.clickRegisterButton();
			loginpage.enterNameAndEmailID(name,email);
			signup.clickMrradioButton();
			signup.accountInformation(uname, pwd,day,month,year);
			signup.addressInformation(fname,lname,company,add1,add2,country,state,city,zipcode,mobileNo);
			signup.createAccount();
			signup.verifyAccountCreated();
			signup.clickContinue();
			homepage.verifyloggedAsUsername();
			homepage.clickCartButton();
			cartpage.clickProceedToCheckout();
			cartpage.verifyAddressDetails();
			cartpage.reviewOrder();
			cartpage.placeOrder();
			cartpage.enterDescription(description);
			cartpage.enterPaymentDetails(ename,num,cvc,emonth,eyear);
			cartpage.clickPayAndConfirm();
			cartpage.verifysuccessMessage();
			homepage.deleteAccount();
			homepage.verifyAccountDeletedIsVisible();
			signup.clickContinue();
	}	 
@Test(priority = 15,dataProviderClass = ReadDataForCartPage.class,dataProvider="registerBeforeCheckout")
	public void registerBeforeCheckout(String name,String email,String uname,String pwd,String day,String month,String year,String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo,String description,String ename,String num,String cvc,String emonth,String eyear) throws Exception {
		loginpage=new LoginPage(driver);
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
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
		 homepage.hoverOnFirstProduct();
		 productpage.clickContinueShoppingButton();
		 homepage.hoverOnSecondProduct();
		 productpage.clickViewCartbutton();
		 homepage.clickCartButton();
		 cartpage.verifyCartPageIsDisplayed();
		 cartpage.clickProceedToCheckout();
		 cartpage.verifyAddressDetails();
		 cartpage.reviewOrder();
		 cartpage.placeOrder();
		 cartpage.enterDescription(description);
		 cartpage.enterPaymentDetails(ename,num,cvc,emonth,eyear);
		 cartpage.clickPayAndConfirm();
		 cartpage.verifysuccessMessage();
		 homepage.deleteAccount();
		 homepage.verifyAccountDeletedIsVisible();
		 signup.clickContinue();
	}
	@Test(priority = 16,dataProviderClass = ReadDataForCartPage.class,dataProvider="loginBeforeCheckout")
	public void loginBeforeCheckout(String email,String pwd,String description,String ename,String num,String cvc,String emonth,String eyear)  {
		loginpage=new LoginPage(driver);
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		signup=new SignupPage(driver);
		homepage=new HomePage(driver);
				
		 homepage.signinOrLogin();
		 loginpage.loginUser(email,pwd);
		 homepage.verifyloggedAsUsername();
		 homepage.hoverOnFirstProduct();
		 productpage.clickContinueShoppingButton();
		 homepage.hoverOnSecondProduct();
		 productpage.clickViewCartbutton();
		 homepage.clickCartButton();
		 cartpage.verifyCartPageIsDisplayed();
		 cartpage.clickProceedToCheckout();
		 cartpage.verifyAddressDetails();
		 cartpage.reviewOrder();
		 cartpage.placeOrder();
		 cartpage.enterDescription(description);
		 cartpage.enterPaymentDetails(ename,num,cvc,emonth,eyear);
		 cartpage.clickPayAndConfirm();
		 cartpage.verifysuccessMessage();
		 homepage.deleteAccount();
		 homepage.verifyAccountDeletedIsVisible();
		 signup.clickContinue();
	}
	@Test(priority = 17)
	public void removeProductsFromCart() throws Exception {
		loginpage=new LoginPage(driver);
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		homepage=new HomePage(driver);
		
		 homepage.scrollDown();
		 homepage.hoverOnFirstProduct();
		 productpage.clickContinueShoppingButton();
		 homepage.hoverOnSecondProduct();
		 productpage.clickViewCartbutton();
		 homepage.clickCartButton();
		 cartpage.verifyCartPageIsDisplayed();
		 cartpage.cancelProductOne();
 		 cartpage.verifyProductIsRemoved();
	}
@Test(priority = 24,dataProviderClass = ReadDataForCartPage.class,dataProvider="downloadInvoiceAfterPurchaseOrder")
	public void downloadInvoiceAfterPurchaseOrder(String name,String email,String uname,String pwd,String day,String month,String year,String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo,String description,String ename,String num,String cvc,String emonth,String eyear) throws Exception {
		loginpage=new LoginPage(driver);
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		signup=new SignupPage(driver);
		homepage=new HomePage(driver);
		
		 homepage.scrollDown();
		 homepage.hoverOnFirstProduct();
		 productpage.clickContinueShoppingButton();
		 homepage.hoverOnSecondProduct();
		 productpage.clickViewCartbutton();
		 homepage.clickCartButton();
		 cartpage.clickProceedToCheckout();
		 cartpage.clickRegisterButton();
		 homepage.signinOrLogin();
		 loginpage.enterNameAndEmailID(name,email);
		 signup.clickMrradioButton();
		 signup.accountInformation(uname, pwd,day,month,year);
		 signup.addressInformation(fname,lname,company,add1,add2,country,state,city,zipcode,mobileNo);
		 signup.createAccount();
		 signup.verifyAccountCreated();
		 signup.clickContinue();
		 homepage.verifyloggedAsUsername();
		 homepage.clickCartButton();
		 cartpage.clickProceedToCheckout();
		 cartpage.verifyAddressDetails();
		 cartpage.reviewOrder();
		 cartpage.placeOrder();
		 cartpage.enterDescription(description);
		 cartpage.enterPaymentDetails(ename,num,cvc,emonth,eyear);
		 cartpage.clickPayAndConfirm();
		 cartpage.verifysuccessMessage();
		 cartpage.downloadInvoice();
		 cartpage.verifyInvoiceIsDownloaded();
		 signup.clickContinue();
		 homepage.deleteAccount();
		 homepage.verifyAccountDeletedIsVisible();
		 signup.clickContinue();
	}
	
	}
			
		
		

