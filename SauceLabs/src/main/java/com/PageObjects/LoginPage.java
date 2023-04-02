package com.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	
		//PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='user-name']")
	WebElement uName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement loginBtn;
	@FindBy(className ="login_logo")
	WebElement logo;
	
	public ProductPage logIntoaccount(String UserName,String Password) {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(uName));
		uName.click();
		uName.sendKeys(UserName);
		password.sendKeys(Password);
		loginBtn.click();
		return new ProductPage(driver);
		
	}
	public boolean isLogoVisible() {
		boolean r=logo.isDisplayed();
		return r;
	}
	public void setEmail(String email)
	{
		uName.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public ProductPage clickLogin()
	{
		loginBtn.click();
		return new ProductPage(driver);
	}
	
}
