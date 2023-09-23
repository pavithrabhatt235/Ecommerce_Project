package utilities;

import org.testng.annotations.DataProvider;

public class ReadDataForHomePage {
	
	@DataProvider(name="RegisterUser")
	public Object[][]homepagetest1(){
		return new Object[][] {{"shivsagar","shivsagar555@gmail.com","sagar","Sagarshiv@12","8","March","1990","sagar","shiv","xyzabc","silkboard","3rd cross","India","karnataka","Bengaluru","520056","9876543210"}};
}
	@DataProvider(name="verifySubscriptionInHomePage")
	public Object[][]homepagetest2(){
		return new Object[][] {{"shivsagar555@gmail.com"}};
}
	@DataProvider(name="verifyAddressDetailsInCheckoutPage")
	public Object[][]homepagetest3(){
		return new Object[][] {{"shivsagar","shivsagar556@gmail.com","sagar","Sagarshiv@612","8","March","1990","sagar","shiv","xyzabc","silkboard","3rd cross","India","karnataka","Bengaluru","520056","9876543210"}};
}
}
