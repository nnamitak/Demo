package com.booktopia.pages;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.interactions.Actions;

public class BooktopiaHomePage extends BasePage{

	private String  url = "https://www.booktopia.com.au/";

	//Initialization of web-elements
	public BooktopiaHomePage(WebDriver driver) {
		super(driver);
	}

	//Utilization of web-elements
	public void navigateToBooktopoiaHomePage()
	{
		navigateToPage(url);		
		Reporter.log("https://www.booktopia.com.au/",true);
	}

	//Selecting tab for Children of age group  6 to 9
	public void mouseHoverChildren(){
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement childrenTab = driver.findElement(By.id("mnu-books-children"));
		actions.moveToElement(childrenTab).perform();

		Reporter.log("Mouse hover Children Tab ... ",true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("6 - 9 years old")).click();  

		//Asserting the screen
		Reporter.log("Search results for Children Tab ... ",true);
		WebElement errorMessage= driver.findElement(By.linkText("Age 6 - 9"));
		Assert.assertEquals(errorMessage.getText(),"Age 6 - 9");

	}

	public void mouseHoverFiction(){
		Actions actions = new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Reporter.log("Clicking Fiction Tab ... ",true);
		WebElement fictionTab = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.id("mnu-books-fiction")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		actions.moveToElement(fictionTab).click().perform();;
		//fictionTab.click();
	}

	public void mouseHoverEducation(){
		Actions actions = new Actions(driver);
		Reporter.log("Clicking on Educational Tab ... ",true);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement educationTab = (new WebDriverWait(driver, 30))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.id("mnu-books-schools")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		actions.moveToElement(educationTab).click().perform();
		//educationTab.click();

	}
}