package com.test.medicare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/login";
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div[2]/form/div[3]/div/input[2]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Register Here")
	WebElement register;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyLoginPage() {
		String title = "";
		title = driver.getTitle();
		
		return title.equals("Medicare - Login");
		
	}
	
	public void enterUserName(String userName) {
		this.username.sendKeys(userName);
	}	
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}	
	
	public void clickLogin() {
		loginBtn.click();
	}

}
