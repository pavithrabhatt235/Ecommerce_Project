package utilities;

import org.testng.annotations.DataProvider;

public class ReadDataForProductPage {
	@DataProvider(name="verifySearchProduct")
	public Object[][]producttest1(){
		return new Object[][] {{"white top"}};
}
	@DataProvider(name="searchProductAndVerifyCartAfterLogin")
	public Object[][]producttest2(){
		return new Object[][] {{"White top","sagar254@gmail.com","Sagar@1234"}};
}
	@DataProvider(name="addReviewOnProduct")
	public Object[][]producttest3(){
		return new Object[][] {{"sagar","sagar254@gmail.com","good"}};
	}
}