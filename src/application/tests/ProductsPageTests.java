package application.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import application.pages.CartPage;
import application.pages.HomePage;
import application.pages.LoginPage;
import application.pages.ProductsPage;
import utilities.ReadDataForProductPage;

public class ProductsPageTests extends BaseClass{
	ProductsPage productpage;
	CartPage cartpage;
	LoginPage loginpage;
	
@Test(priority = 8)
  public void verifyProductsAndProductsDetails() {
		productpage=new ProductsPage(driver);
		homepage=new HomePage(driver);
		 
		 homepage.clickProductsButton();
		 productpage.verifyUserNavigatedToAllProductsPage();
		 productpage.clickViewProduct();
		 productpage.userIsLandedToProductDetailPage();
		 productpage.productName();
		 productpage.category();
		 productpage.price();
		 productpage.available();
		 productpage.condition();
		 productpage.brand();
  }
	@Test(priority=9,dataProviderClass = ReadDataForProductPage.class,dataProvider="verifySearchProduct")
	public void verifySearchProduct(String product) {
		productpage=new ProductsPage(driver);
		homepage=new HomePage(driver);
		
		 homepage.clickProductsButton();
		 productpage.verifyUserNavigatedToAllProductsPage();
		 productpage.clickSearchButton(product);
		 productpage.verifySearchedProductsAreVisible();
		 productpage.scrollDownToSearchedProduct();
		 productpage.verifyProductsRelatedToSearchAreVisible();
	}
	@Test(priority = 18)
	public void verifyViewCategoryProducts() {
		 productpage=new ProductsPage(driver);
		 homepage=new HomePage(driver);
		 
		 homepage.scrollDown();
		 productpage.positionOfCategory();
		 productpage.clickOnWomenCategory();
		 productpage.clickOnDress();
		 productpage.verifyCategoryPageDisplayedAndConfirmtext();
		 productpage.clickOnMenCategory();
		 productpage.clickOnTshirts();
		 productpage.verifyUserNavigatedToCategoryPage();
	}
	@Test(priority = 19)
	public void verifyViewAndCartBrandProducts() {
		productpage=new ProductsPage(driver);
		homepage=new HomePage(driver);
		
		homepage.clickProductsButton();
		productpage.scrollDownToBrands();
		productpage.positionOfBrands();
		productpage.clickOnPOLO();
		productpage.verifyBrandPageIsDisplayedAndConfirmText();
		productpage.clickOnHMBrand();
		productpage.verifyHMBrandPage();
	}
	@Test(priority = 20,dataProviderClass = ReadDataForProductPage.class,dataProvider="searchProductAndVerifyCartAfterLogin")
	public void searchProductAndVerifyCartAfterLogin(String pname,String email,String password) {
		productpage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		
		 homepage.clickProductsButton();
		 productpage.verifyUserNavigatedToAllProductsPage();
		 productpage.clickSearchButton(pname);
		 productpage.verifySearchedProductsAreVisible();
		 productpage.scrollDownToProduct();
		 productpage.hoverOnSummerWhiteTop();
		 productpage.clickViewCartbutton();
		 homepage.clickCartButton();
		 cartpage.verifyProductIsVisibleInCart();
		 homepage.signinOrLogin();
		 loginpage.loginUser(email,password);
		 homepage.clickCartButton();
		 cartpage.verifyProductIsVisibleInCart();
	}
	@Test(priority = 21)
	public void addReviewOnProduct(String ename,String mail,String rev) {
		productpage=new ProductsPage(driver);
		homepage=new HomePage(driver);
		
		 homepage.clickProductsButton();
		 productpage.verifyUserNavigatedToAllProductsPage();
		 productpage.scrollDownToProduct();
		 productpage.hoverFirstProduct();
		 productpage.clickViewProduct();
		 productpage.verifyWriteYourReviewIsVisible();
		 productpage.writeReview(ename,mail,rev);
		 productpage.clickReviewSubmitButton();
		 productpage.verifySuccessMessage();
	}
}
