package stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import com.PageObjects.CartAndCheckoutPage;
import com.PageObjects.LoginPage;
import com.PageObjects.OverViewPage;
import com.PageObjects.ProductPage;
import com.PageObjects.completePage;

import BaseTest.BaseTestClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTestClass {
	public ProductPage p;
	public CartAndCheckoutPage cc;
	public OverViewPage ov;
	public completePage cp;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		setUp();
		
		}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username__and_password(String username,String password) {
		LoginPage lp=new LoginPage(driver);
		p=lp.logIntoaccount(username,password);
	}
	 @When("^I add product (.+) to the cart$")
	 public void I_add_product_to_the_cart(String product) {
		 p.addProductToCart("Sauce Labs Fleece Jacket");
		 
	 }
	 @And("go to the cart page and click on checkout button")
	 public void go_to_the_cart_page_and_click_on_checkout_button() {
		 cc=p.goToCart();
			cc.goToCheckoutInfo();
	 }
	 @And("^enter the cityname (.+) statename(.+) pincode (.+) and click on continue button$")
		public void enter_the_city_heldi_stategoa_pincode_and_click_on_continue_button(String city,String state,String pincode) throws InterruptedException{
		 Thread.sleep(2000);
		 cc.EnterYourDetails(city,state,pincode);
			ov=cc.goToOVerPage();		 
	 }
	 @And("check your details and click on finish button")
	 public void click_on_finish_button() {
		 cp=ov.clickToFinsih();
	 }
	 @Then("the thankyou for ordering message should appear")
	 public void thankyou_for_ordering_message_should_appear() {
		 boolean r=cp.validateThankYouMsg();
			Assert.assertTrue(r);
			driver.close();
	 }
	

}
