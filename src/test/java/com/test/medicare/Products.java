package com.test.medicare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/show/all/products";
	
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
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/label/input")
	WebElement productFilter;
	
	@FindBy(id = "productListTable")
	WebElement productList;
	
	@FindBy(tagName = "tr")
	List<WebElement> productRows;
	
	JavascriptExecutor executor;
	
	public Products(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
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
	
	public void addProductToCart(String productName) {
//		outerloop:
//		for (WebElement productRow : productRows) {
//			if(productRow.findElement(By.xpath("//td[2]")).getText().equals(productName)) {
//				List<WebElement> options = productRow.findElement(By.xpath("//td[6]")).findElements(By.tagName("a"));
//				for (WebElement option : options) {
//					System.out.println("test:"+option.getAttribute("class").toString());
//					if(option.getAttribute("class").toString().equals("btn btn-success")) {
//						option.click();
//						break outerloop;
//					}
//				}
//			}
//		}
		
		int counter = 0;
		List<WebElement> productRows = productList.findElements(By.tagName("tr"));
		outerloop:
		
		for (WebElement productRow : productRows) {
			counter = counter + 1;
			WebElement product = productRow.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr["+counter+"]"));
			System.out.println("item edit :"+product.findElement(By.xpath(".//td[2]")).getText());
			List<WebElement> options = productRow.findElement(By.xpath("//td[6]")).findElements(By.tagName("a"));
			for (WebElement option : options) {
				System.out.println("test:"+option.getAttribute("class").toString());
				if(option.getAttribute("class").toString().equals("btn btn-success")) {
					option.click();
					break outerloop;
				}
			}
		}
	}

}
