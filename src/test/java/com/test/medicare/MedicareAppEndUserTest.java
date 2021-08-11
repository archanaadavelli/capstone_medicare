package com.test.medicare;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class MedicareAppEndUserTest {

	WebDriver driver;
	
	String FirstName = "Archana";
	String LastName = "Adavelli";
	String email = "test123@gmail.com";
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

	@Test
	public void medicareApptest() throws Exception {

		// Open Home page
		HomePage homePage = new HomePage(driver);

		assertTrue(homePage.verifyHomePage());
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "HomePage.png") ;
		
		homePage.clickLogin();
		//homePage.clickSignUp();
		
		//doSignup();
		
		Thread.sleep(5000);
		
		// Do login
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserName("kn@gmail.com");
		loginPage.enterPassword("12345");

		this.takeSnapShot(driver, "LoginPage.png") ;
		
		loginPage.clickLogin();
		
		Thread.sleep(5000);
		
		// Products page
		
		Products productsPage = new Products(driver);
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "ProductsListPage.png") ;
		
		productsPage.addProductToCart("Paracetamol");
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "CartPage.png") ;
		
		// Cart page
		
		CartPage cartPage = new CartPage(driver);
		
		cartPage.clickCheckout();
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "CheckoutPageOne.png") ;
		
		// Checkout page one
		
		CheckoutPageOne checkoutPageOne = new CheckoutPageOne(driver);
		
		checkoutPageOne.clickAdress();
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "CheckoutPageTwo.png") ;
		
		// Checkout page one

		CheckoutPageTwo checkoutPageTwo = new CheckoutPageTwo(driver);
		
		checkoutPageTwo.clickPay();
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "InvoicePage.png") ;
		
		checkoutPageTwo.clickContShop();
		
		Thread.sleep(5000);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\PERSONAL_NEW\\ARCHU_DOCUMENTS\\Simplilearn training\\projects\\Capstone\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileName) throws Exception{
		
		String filePath = "D:\\PERSONAL_NEW\\ARCHU_DOCUMENTS\\Simplilearn training\\projects\\Capstone\\screenshots\\enduser\\";
		
		String fileWithPath =  filePath + fileName;
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);
	}
	
	public void doSignup() throws Exception {
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "SignUp.png") ;
		
		// SignUp Page
		
		SignUpPage signUpPage = new SignUpPage(driver);
		
		signUpPage.inputFirstName(FirstName);
		signUpPage.inputLastName(LastName);
		signUpPage.inputEmail(email);
		signUpPage.inputContactNumber(contactNumber);
		signUpPage.inputPassword(password);
		signUpPage.inputConfirmPassword(confirmPassword);
		this.takeSnapShot(driver, "SignUpOne.png") ;
		signUpPage.clickNextBilling();
		Thread.sleep(5000);
		signUpPage.inputAddressLineOne(AddressLineOne);
		signUpPage.inputaddressLineTwo(AddressLineTwo);
		signUpPage.inputCity(City);
		signUpPage.inputPostalCode(postalCode);
		signUpPage.inputState(State);
		signUpPage.inputCountry(Country);
		this.takeSnapShot(driver, "SignUpTwo.png") ;
		signUpPage.clickNextConfirm();
		Thread.sleep(5000);
		this.takeSnapShot(driver, "SignUpConfirm.png") ;
		signUpPage.clickConfirm();
		Thread.sleep(5000);
		this.takeSnapShot(driver, "SignUpSuccess.png") ;
		signUpPage.clickLogin();
	}

}
