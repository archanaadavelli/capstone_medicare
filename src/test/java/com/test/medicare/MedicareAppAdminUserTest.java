

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

public class MedicareAppAdminUserTest {

	WebDriver driver;

	@Test
	public void medicareApptest() throws Exception {

		// Open Home page
		HomePage homePage = new HomePage(driver);

		assertTrue(homePage.verifyHomePage());
		Thread.sleep(5000);
		
		homePage.clickLogin();
		
		Thread.sleep(5000);
		
		// Do login
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserName("vk@gmail.com");
		loginPage.enterPassword("admin");

		this.takeSnapShot(driver, "LoginPage.png") ;
		
		loginPage.clickLogin();
		
		Thread.sleep(5000);
		this.takeSnapShot(driver, "HomePageAdmin.png") ;
		
		// Products page
		
		ManageProducts manageProductsPage = new ManageProducts(driver);
		
		Thread.sleep(5000);
		
		this.takeSnapShot(driver, "ProductsListPage.png") ;
		Thread.sleep(5000);
		
//		manageProductsPage.addProduct("Colpal", "Reddys", "Fever Medicine", "156", "300");
//		Thread.sleep(5000);
//		this.takeSnapShot(driver, "NewProductPage.png") ;
//		manageProductsPage.saveProduct();
//		Thread.sleep(1000);
//		this.takeSnapShot(driver, "SaveNewProductPage.png") ;
//		manageProductsPage.disableProduct("Paracetamol");
		Thread.sleep(5000);
//		this.takeSnapShot(driver, "DisableProductPage.png") ;
		int productId = manageProductsPage.editProduct("Combiflame");
		String PAGE_URL = "http://localhost:8081/medicare/manage/"+productId+"/product";
		
		EditProductPage editProductPage = new EditProductPage(driver, PAGE_URL);
		
		editProductPage.changePrice("100");
		
		Thread.sleep(5000);
		this.takeSnapShot(driver, "EditProductPage.png") ;
		editProductPage.clickSave();
		Thread.sleep(1000);
		this.takeSnapShot(driver, "EditProductSuccessPage.png") ;
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
		
		String filePath = "D:\\PERSONAL_NEW\\ARCHU_DOCUMENTS\\Simplilearn training\\projects\\Capstone\\screenshots\\admin\\";
		
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

}
