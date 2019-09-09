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
import org.testng.Reporter;

public class BooktopiaFictionPage extends BasePage{
	//Initialization of web-elements
	public BooktopiaFictionPage(WebDriver driver) {
		super(driver);
	}

	public void searchFictionBook() throws IOException{
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement searchText = driver.findElement(By.xpath("//input[@id='refine-search-box']"));	
		WebElement submit = driver.findElement(By.xpath("//input[@type='Submit']"));	

		//Reading data from Excel
		waitForLoad(driver);  
		FileInputStream fis = new FileInputStream(new File("E:\\Namita\\projects\\Demo\\data\\Booktopia.xlsx"));
		Reporter.log("File Opened .... ",true);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String bookName = sheet.getRow(1).getCell(1).getStringCellValue();
		
		
		waitForLoad(driver);
		searchText.sendKeys(bookName);
		waitForLoad(driver);
		actions.moveToElement(searchText);
		actions.click();
		
		Reporter.log("Searching a Fiction book... ",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
