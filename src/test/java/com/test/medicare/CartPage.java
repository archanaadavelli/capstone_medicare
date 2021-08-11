package com.test.medicare;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/cart/show?result=maximum";
	
	@FindBy(id = "about")
	WebElement about;
	
	@FindBy(id = "contact")
	WebElement contact;
	
	@FindBy(id = "listProducts")
	WebElement listProducts;
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/table/tfoot/tr[2]/td[4]/a")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/table/tfoot/tr[2]/td[1]/a")
	WebElement contShopBtn;	
	
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyHomePage() {
		String title = "";
		title = driver.getTitle();
		
		return title.equals("Medicare - Home");
		
	}
	
	public void clickCheckout() {
	//	Actions act =  new Actions(driver);
	//	act.moveToElement(checkoutBtn).click().build().perform();
	//	checkoutBtn.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", checkoutBtn);
	}
	
	public void clickContShop() {
		//contShopBtn.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", contShopBtn);
	}	

}

