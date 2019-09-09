package com.booktopia.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BootopiaCartPage extends BasePage{
	
	public BootopiaCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void viewCart(){
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement cart = driver.findElement(By.xpath("//div[@class='icon-cart']"));
		actions.moveToElement(cart).click().perform();
		//cart.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement checkOut = driver.findElement(By.xpath("//div[@class='checkout-text']"));
		actions.moveToElement(checkOut).click().perform();
		//checkOut.click();
		
		
	}
	
	
}
