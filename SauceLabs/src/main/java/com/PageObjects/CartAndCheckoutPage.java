package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartAndCheckoutPage extends BasePage {

	public CartAndCheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	@FindBy(id="first-name")
	WebElement firstName;
	@FindBy(id="last-name")
	WebElement lastName;
	@FindBy(id="postal-code")
	WebElement zipCode;
	@FindBy(id="continue")
	WebElement ctnBtn;
	@FindBy(css=".title")
	WebElement yourCarttitle;
	@FindBy(css="#contents_wrapper .title")
	WebElement checkOutYourInfo;
	
	public void goToCheckoutInfo() {
		checkoutBtn.click();
		
	}
	public void EnterYourDetails(String fname,String lname,String zip) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		zipCode.sendKeys(zip);
	
		
	}
	public OverViewPage goToOVerPage() {
		ScrollToElement(ctnBtn);
		ctnBtn.click();
		return new OverViewPage(driver);
	}
	public boolean yourCartTitleIsVisisble() {
		boolean t=yourCarttitle.isDisplayed();
		return t;
	}
	public boolean checkOutYourInfoIsVisisble() {
		boolean t=checkOutYourInfo.isDisplayed();
		return t;
	}
}
