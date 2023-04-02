package testcases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.CartAndCheckoutPage;
import com.PageObjects.LoginPage;
import com.PageObjects.OverViewPage;
import com.PageObjects.ProductPage;
import com.PageObjects.completePage;

import BaseTest.BaseTestClass;
import BaseTest.Retry;

public class End extends BaseTestClass {

	public ProductPage p;
	public CartAndCheckoutPage cc;
	public OverViewPage ov;
	public completePage cp;
	
	
	
		
	
	@Test(groups = "regression",retryAnalyzer = Retry.class)
	public void sauce() throws InterruptedException {
		logger.info("***     Starting end to end testing	***");
		LoginPage lp=new LoginPage(driver);
		p=lp.logIntoaccount("standard_user","secret_sauce");
		logger.info("successfully logged to product page");
		p.isProductTitleVisible();
		p.addProductToCart("Sauce Labs Fleece Jacket");
		logger.info("the product Sauce Labs Fleece Jacket is added to the cart");
		cc=p.goToCart();
		logger.info("successfully navigated to cartPage");
		cc.goToCheckoutInfo();
		logger.info("Checkout is clicked");
		cc.EnterYourDetails("sdf", "dfs", "dfsdf");
		logger.info("Address details are successfully entered");
		ov=cc.goToOVerPage();
		logger.info("go to overview button is clicked");
		
		cp=ov.clickToFinsih();
		logger.info("the final finish button is clicked to complete the order");
		boolean r=cp.validateThankYouMsg();
		Assert.assertTrue(r);
		logger.info("***     the thankyou message is displayed along with order placed message	***");
		
	
	}
	

}
