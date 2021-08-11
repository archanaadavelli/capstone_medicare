package com.test.medicare;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MedicareEndUser {

	WebDriver driver;

	@Test
	public void testTitle() throws InterruptedException {

		String title = "";

		title = driver.getTitle();
		Assert.assertEquals("Medicare - Home", title);

		driver.findElement(By.id("signup")).click();
		Thread.sleep(5000);

		title = driver.getTitle();
		Assert.assertEquals("Medicare - Membership", title);

		String FirstName = "Archana";
		String LastName = "Adavelli";
		String email = "test@gmail.com";
		String contactNumber = "9230570012";
		String password = "niffj";
		String confirmPassword = "niffj";
		String userType = "User";
		String AddressLineOne = "test";
		String AddressLineTwo = "test";
		String City = "test";
	    String postalCode = "789";
	    String State = "test";
	    String Country = "test";
				
		
		
		driver.findElement(By.id("firstName")).sendKeys(FirstName);

		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("contactNumber")).sendKeys(contactNumber);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
		
//		List<WebElement> radioButtons = driver.findElements(By.className("radio-inline"));
//		for (WebElement radio : radioButtons) {
//			System.out.println("element : " + radio.findElement(By.name("role")).getText());
//			if(radio.findElement(By.name("role")).getText().equals(userType)) {
//				radio.findElement(By.name("role")).click();
//			}
//			
//		}
		driver.findElement(By.xpath("//*[@id=\"role1\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[2]/form/div[8]/div/button")).click();
		driver.findElement(By.id("addressLineOne")).sendKeys(AddressLineOne);
		driver.findElement(By.id("addressLineTwo")).sendKeys(AddressLineTwo);
		driver.findElement(By.id("city")).sendKeys(City);
		driver.findElement(By.id("postalCode")).sendKeys(postalCode);
		driver.findElement(By.id("state")).sendKeys(State);
		driver.findElement(By.id("country")).sendKeys(Country);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[2]/form/div[7]/div/button[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div/a")).click();
		
		String expectedText = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/h1")).getText();
		Assert.assertEquals(expectedText, "Welcome!");
		
		
		

		
		

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\PERSONAL_NEW\\ARCHU_DOCUMENTS\\Simplilearn training\\projects\\Capstone\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8081/medicare/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
