package utilities;

import org.testng.annotations.DataProvider;

public class ReadDataForContactUs {

	@DataProvider(name="verifyContactUsForm")
	public Object[][]contactpagetest1(){
		return new Object[][] {{"adarsh","adarshsagar@gmail.com","product placing","product placing","C:\\Users\\HP\\Desktop\\flower.jpg"}};
}
}