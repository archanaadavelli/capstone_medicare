package com.test.medicare;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/membership?execution=e2s1";
	
	@FindBy(id = "firstName")
	WebElement firstName;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "contactNumber")
	WebElement contactNumber;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"role1\"]")
	WebElement role;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[2]/form/div[8]/div/button")
	WebElement nextBilling;
	
	@FindBy(id = "addressLineOne")
	WebElement addressLine1;
	
	@FindBy(id = "addressLineTwo")
	WebElement addressLine2;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "postalCode")
	WebElement postalCode;
	
	@FindBy(id = "state")
	WebElement state;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[2]/form/div[7]/div/button[2]")
	WebElement nextConfirBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div/div/a")
	WebElement confirmBtn;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div/a")
	WebElement loginPostSignUpBtn;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyLoginPage() {
		String title = "";
		title = driver.getTitle();
		
		return title.equals("Medicare - Login");
		
	}
	
	public void inputFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}	
	
	public void inputLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void inputEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void inputContactNumber(String contactNumber) {
		this.contactNumber.sendKeys(contactNumber);
	}
	
	public void inputPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void inputConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public void inputAddressLineOne(String addressLine1) {
		this.addressLine1.sendKeys(addressLine1);
	}
	
	public void inputaddressLineTwo(String addressLine2) {
		this.addressLine2.sendKeys(addressLine2);
	}
	
	public void inputCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void inputPostalCode(String postalCode) {
		this.postalCode.sendKeys(postalCode);
	}
	
	public void inputState(String state) {
		this.state.sendKeys(state);
	}
	
	public void inputCountry(String country) {
		this.country.sendKeys(country);
	}	
	
	public void clickNextBilling() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", nextBilling);
	}
	
	public void clickNextConfirm() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", nextConfirBtn);
	}
	
	public void clickConfirm() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", confirmBtn);
	}

	public void clickLogin() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginPostSignUpBtn);
	}
}
