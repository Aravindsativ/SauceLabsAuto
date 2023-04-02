package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class completePage extends BasePage {


	public completePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id="back-to-products")
WebElement HomeBtn;
@FindBy(css = "#checkout_complete_container .complete-header")
WebElement thankMsg;

public boolean validateThankYouMsg() {
	boolean k=
	thankMsg.isDisplayed();
	return k;
	
}
}
