package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;

import BaseTest.BaseTestClass;
import dataProvider.LoginData;

public class VerifyLoginDDT extends BaseTestClass{
	
	public LoginPage lp;
	public ProductPage p;
	@Test(dataProviderClass =LoginData.class,dataProvider="LoginCred",groups="smoke")
	public void loginDtt(String userName,String Password,String exp) {
		try {
		lp=new LoginPage(driver);
		lp.setEmail(userName);
		lp.setPassword(Password);
		p=lp.clickLogin();
		boolean r=p.isProductTitleVisible();
		//Assert.assertTrue(r);
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(r==true)
			{
		
				Assert.assertTrue(true);
			}
			else
			{
			
				Assert.assertTrue(false);
			}
		}	
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(r==true)
			{
				Assert.assertTrue(false);
			}
			else
			{		
				Assert.assertTrue(true);
			}
		}
		
		}
	
	catch(Exception e)
	{

		Assert.fail();
	}
		
		
	}
	

}
