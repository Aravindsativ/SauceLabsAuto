package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath="//div[@id='inventory_container']//div[@class='inventory_item_label']//div[@class='inventory_item_name']")
	List<WebElement> products;
	@FindBy(css=".shopping_cart_link")
	WebElement cartBtn;
	@FindBy(css="#header_container .title")
	WebElement productTitle;
	By addToCart=By.xpath("following::div[@class='pricebar']/button");
	public void addProductToCart(String item) {
		
		for(WebElement a:products) {
			if(a.getText().equalsIgnoreCase(item)){
				System.out.println(a.getText());
				ScrollToElement(a);
				a.findElement(addToCart).click();
		
			
			}
		
			else{
				System.out.println("element not found");
			}
			}	
	
		}
	
	public boolean isProductTitleVisible() {
		try {
		return(productTitle.isDisplayed());	
	}
		catch(Exception e)
		{
			return(false);
		}
	}
	public CartAndCheckoutPage goToCart() {
		cartBtn.click();
		return new CartAndCheckoutPage(driver);
	}

}
