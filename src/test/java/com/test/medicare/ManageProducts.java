package com.test.medicare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ManageProducts {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8081/medicare/manage/product";
	
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
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div[1]/a")
	WebElement home;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/label/input")
	WebElement productFilter;
	
	@FindBy(id = "productsTable")
	WebElement productList;

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
	
	
	JavascriptExecutor executor;
	
	public ManageProducts(WebDriver driver) {
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
	
	public void disableProduct(String productName) throws InterruptedException {
		
		executor.executeScript("window.scrollBy(0,550)", "");
		int counter = 0;
		List<WebElement> productRows = productList.findElements(By.tagName("tr"));
		outerloop:
		
		for (WebElement productRow : productRows) {
			counter = counter + 1;
			WebElement product = productRow.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr["+counter+"]"));
			System.out.println("item disable :"+product.findElement(By.xpath(".//td[3]")).getText());
			if(product.findElement(By.xpath(".//td[3]")).getText().equals(productName)) {
					System.out.println("test:"+productRow.getAttribute("class").toString());	
					WebElement editElement = product.findElement(By.xpath(".//td[7]"));
					executor.executeScript("arguments[0].click();", editElement);
						break outerloop;
			}
		}
	}
	
	public int editProduct(String productName) throws InterruptedException {
		//executor.executeScript("window.scrollBy(0,550)", "");
		//Thread.sleep(2000);
		int counter = 0;
		List<WebElement> productRows = productList.findElements(By.tagName("tr"));
		outerloop:
		
		for (WebElement productRow : productRows) {
			counter = counter + 1;
			WebElement product = productRow.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr["+counter+"]"));
			System.out.println("item edit :"+product.findElement(By.xpath(".//td[3]")).getText());
			if(product.findElement(By.xpath(".//td[3]")).getText().equals(productName)) {
					System.out.println("test:"+productRow.getAttribute("class").toString());	
					WebElement editElement = product.findElement(By.xpath(".//td[8]/a"));
					executor.executeScript("arguments[0].click();", editElement);
						break outerloop;
			}
		}
		return counter;
	}
	
	public void addProduct(String name, String brand, String description, String price, String quantity) {
		this.name.sendKeys(name);
		this.brand.sendKeys(brand);
		this.description.sendKeys(description);
		this.unitPrice.sendKeys(price);
		this.quantity.sendKeys(quantity);
		
		this.file.sendKeys("D:\\PERSONAL_NEW\\ARCHU_DOCUMENTS\\Simplilearn training\\projects\\Capstone\\images\\medicine image.jpg");
	}
	
	public void saveProduct() {
		executor.executeScript("arguments[0].click();", this.saveBtn);
	}

}
