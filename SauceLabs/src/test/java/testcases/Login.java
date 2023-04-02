package testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;

import BaseTest.BaseTestClass;

@Test(groups="smoke")
public class Login extends BaseTestClass {
	public LoginPage lp;
	public ProductPage p;

	public void logIn() {
	
		lp=new LoginPage(driver);
		lp.setEmail("standard_user");
		lp.setPassword("secret_sauce");
		p=lp.clickLogin();
		boolean r=p.isProductTitleVisible();
		Assert.assertTrue(r);

}
}
