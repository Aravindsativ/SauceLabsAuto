package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	
		
	}
	
	public  void ScrollToElement(WebElement l) {
		
	      // Javascript executor
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	}

	
	

}
