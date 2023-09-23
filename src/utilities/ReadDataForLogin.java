package utilities;

import org.testng.annotations.DataProvider;

public class ReadDataForLogin {
	
@DataProvider(name="validemailandpassword")
public Object[][]logintest1(){
	return new Object[][] {{"adarshsagar1967@gmail.com","Adarsh@1967"}};
	}
@DataProvider(name="invalidemailandpassword")
public Object[][]logintest2(){
	return new Object[][] {{"adarshsagar@gmail.com","Adarsh@1967"}};
	}
@DataProvider(name="logoutUser")
public Object[][]logintest3(){
	return new Object[][] {{"adarshsagar@gmail.com","Adarsh@1967"}};
	}
@DataProvider(name="registeruserwithexistingemail")
public Object[][]logintest4(){
	return new Object[][] {{"adarshsagar","adarshsagar1967@gmail.com"}};
	}

}