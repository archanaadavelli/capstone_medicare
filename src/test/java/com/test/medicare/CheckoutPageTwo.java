
package com.test.medicare;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageTwo {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/cart/checkout?execution=e1s2";
	

	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/a")
	WebElement payBtn;	
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div[4]/a")
	WebElement contShopBtn;	
	
	@FindBy(id = "cardNumber")
	WebElement cardNumber;
	
	@FindBy(id = "expityMonth")
	WebElement expityMonth;
	
	@FindBy(id = "expityYear")
	WebElement expityYear;
	
	@FindBy(id = "cvCode")
	WebElement cvCode;
	
	
	
	public CheckoutPageTwo(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void inputCardNumber(String cardNumber) {
		this.cardNumber.sendKeys(cardNumber);
	}
	
	public void inputExpityMonth(String expityMonth) {
		this.expityMonth.sendKeys(expityMonth);
	}
	
	public void inputExpityYear(String expityYear) {
		this.expityYear.sendKeys(expityYear);
	}
	
	public void inputCvCode(String cvCode) {
		this.cvCode.sendKeys(cvCode);
	}
	
	public void clickPay() {
		//payBtn.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", payBtn);
	}
	public void clickContShop() {
		//payBtn.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", contShopBtn);
	}	
}
