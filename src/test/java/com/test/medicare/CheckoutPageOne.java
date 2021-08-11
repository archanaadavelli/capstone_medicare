
package com.test.medicare;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageOne {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/cart/checkout?execution=e1s1";
	

	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[1]/div/div[1]/div/a")
	WebElement address;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div/div[2]/form/div[7]/div/button")
	WebElement addAddress;	
	
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
	
	
	
	public CheckoutPageOne(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
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

	public void clickAddAdress() {
		//addAddress.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", addAddress);
	}
	
	public void clickAdress() {
		//address.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", address);
	}
}
