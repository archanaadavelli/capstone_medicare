package com.test.medicare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/";
	
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
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(id = "manageProduct")
	WebElement manageProduct;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyHomePage() {
		String title = "";
		title = driver.getTitle();
		
		return title.equals("Medicare - Home");
		
	}
	
	public void clickSignUp() {
		signUp.click();
	}
	
	public void clickLogin() {
		login.click();
	}	

}
