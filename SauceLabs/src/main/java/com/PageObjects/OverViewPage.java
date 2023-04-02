package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverViewPage extends BasePage {


	public OverViewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="finish")
	WebElement finishBtn;
	@FindBy(css=".title")
	WebElement overView;
	

public completePage clickToFinsih() {
	finishBtn.click();
	return new completePage(driver);
	
}
public boolean overviewIsviewed() {
	boolean r=overView.isDisplayed();
	return r;
}
//


}
