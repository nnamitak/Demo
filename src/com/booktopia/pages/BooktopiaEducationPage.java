package com.booktopia.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BooktopiaEducationPage extends BasePage{
	//Initialization of web-elements
	public BooktopiaEducationPage(WebDriver driver) {
		super(driver);
	}

	public void searchEducationBook() throws IOException{
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement preschoolTab = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='head-quick-links']/li[1]")));
		//WebElement preschoolTab = driver.findElement(By.xpath("//ul[@id='head-quick-links']/li[1]"));
		actions.moveToElement(preschoolTab).click().perform();
		//preschoolTab.click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement startingSchool = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='pre-school']/ul/li[1]")));
		
		//WebElement startingSchool = driver.findElement(By.xpath("//section[@id='pre-school']/ul/li[1]"));
		actions.moveToElement(startingSchool).click().perform();
		//startingSchool.click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement searchText = driver.findElement(By.id("refine-search-box"));	
				
		WebElement searchGo = driver.findElement(By.xpath("//button[@class='submit refine-search-submit']"));	
	

		//Reading data from Excel
		waitForLoad(driver);  
		FileInputStream fis = new FileInputStream(new File("E:\\Namita\\projects\\Demo\\data\\Booktopia.xlsx"));
	
		Reporter.log("File Opened .... ",true);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String bookName = sheet.getRow(1).getCell(2).getStringCellValue();
		waitForLoad(driver);
		searchText.sendKeys(bookName);
		waitForLoad(driver);

		Reporter.log("Searching a Educational book... ",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchGo.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> lstElements = driver.findElements(By.xpath("(//*[@class='product-results']/li)"));
		lstElements.get(0).click();
	
		String winHandleBefore = driver.getWindowHandle();
		WebElement buyNowBtn= driver.findElement(By.linkText("BUY NOW"));
		buyNowBtn.click();
		for (String currentWindow: driver.getWindowHandles()) {
			if(currentWindow != winHandleBefore) {
				driver.switchTo().window(currentWindow);
				boolean staleElement = true; 
				while(staleElement){
					try{
						WebElement continuebtn= driver.findElement(By.linkText("CONTINUE SHOPPING"));
						staleElement = false;
						continuebtn.click();
					}
					catch(StaleElementReferenceException e){
						staleElement = true;
					}
				}break;
			}
		}
		driver.switchTo().window(winHandleBefore);
	}
	
	
}
