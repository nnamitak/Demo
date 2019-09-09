package com.booktopia.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class BooktopiaChildrenPage extends BasePage{

	//Initialization of web-elements
	public BooktopiaChildrenPage(WebDriver driver) {
		super(driver);
	}

	public void searchBook() throws IOException{
		Actions actions = new Actions(driver);

		WebElement searchText = driver.findElement(By.id("refine-search-box"));	
		WebElement searchGo = driver.findElement(By.xpath("//button[@class='submit refine-search-submit']"));	

		actions.moveToElement(searchText);
		actions.click();

		//Reading data from Excel
		waitForLoad(driver);  
		FileInputStream fis = new FileInputStream(new File("E:\\Namita\\projects\\Demo\\data\\Booktopia.xlsx"));
		Reporter.log("File Opened .... ",true);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String bookName = sheet.getRow(1).getCell(0).getStringCellValue();
		waitForLoad(driver);
		searchText.sendKeys(bookName);
		waitForLoad(driver);

		Reporter.log("Searching a Children book... ",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchGo.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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