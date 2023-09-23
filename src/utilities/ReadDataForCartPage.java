package utilities;

import org.testng.annotations.DataProvider;

public class ReadDataForCartPage {
	
	@DataProvider(name="subscriptionincartpage")
	public Object[][]cartpagetest1(){
		return new Object[][] {{"adarshsagar1967@gmail.com"}};
}
	@DataProvider(name="registerWhileCheckout")
	public Object[][]cartpagetest2(){
		return new Object[][] {{"ramsagar","shivsagar1254@gmail.com","sagar","Sagar@1234","8","May","1990","sagar","shiv","xyzabc","silkboard","3rd cross","India","karnataka","Bengaluru","520056","9876543210","product should be good","sagar","56789101213","111","10","2023"}};
}
	@DataProvider(name="registerBeforeCheckout")
	public Object[][]cartpagetest3(){
		return new Object[][] {{"sagar","sagar2546@gmail.com","sagar","Sagar1@1234","8","May","1990","sagar","shiv","xyzabc","silkboard","3rd cross","India","karnataka","Bengaluru","520056","9876543210","product should be good","sagar","56789101213","111","10","2023"}};
}
	@DataProvider(name="loginBeforeCheckout")
	public Object[][]cartpagetest4(){
		return new Object[][] {{"sagar254@gmail.com","Sagar@1234","product should be good","sagar","56789101213","111","10","2023"}};
	}
	@DataProvider(name="downloadInvoiceAfterPurchaseOrder")
	public Object[][]cartpagetest5(){
		return new Object[][] {{"sagar","sagar254@gmail.com","sagar","Sagar@1234","8","May","1990","sagar","shiv","xyzabc","silkboard","3rd cross","India","karnataka","Bengaluru","520056","9876543210","product should be good","sagar","56789101213","111","10","2023"}};
}
	@DataProvider(name="verifyProductQuantityInCart")
	public Object[][]cartpagetest6(){
		return new Object[][] {{"4"}};
}
}