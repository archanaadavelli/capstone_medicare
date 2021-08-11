package com.test.medicare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {
	
	private WebDriver driver;
	
	private String PAGE_URL;
	
	@FindBy(id = "signup")
	WebElement signUp;
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(id = "about")
	WebElement about;
	
	@FindBy(id = "contact")
	WebElement contact;
	
	@FindBy(id = "listProducts")
	WebElement listProducts;
	
	@FindBy(id = "manageProduct")
	WebElement manageProduct;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "brand")
	WebElement brand;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(id = "unitPrice")
	WebElement unitPrice;
	
	@FindBy(id = "quantity")
	WebElement quantity;
	
	@FindBy(id = "categoryId")
	WebElement categoryId;
	
	@FindBy(id = "file")
	WebElement file;
	
	@FindBy(xpath  = "/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[8]/div/input")
	WebElement saveBtn;
	
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/label/input")
	WebElement productFilter;


	
	JavascriptExecutor executor;
	
	public EditProductPage(WebDriver driver, String PAGE_URL) {
		this.driver = driver;
		this.PAGE_URL = PAGE_URL;
		driver.get(this.PAGE_URL);
		
		PageFactory.initElements(driver,this);
		executor = (JavascriptExecutor)driver;
		
	}
	
	public boolean verifyHomePage() {
		String title = "";
		title = driver.getTitle();
		
		return title.equals("Medicare - All Products");
		
	}
	
	public void fliterProducts(String productName) {
		
		productFilter.sendKeys(productName);
	}
	
	public void clickLogin() {
		login.click();
	}	
	
	public void changePrice(String price) {
		unitPrice.clear();
		unitPrice.sendKeys(price);
	}
	
	public void clickSave() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveBtn);
	}

}
