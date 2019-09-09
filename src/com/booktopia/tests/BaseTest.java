package com.booktopia.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.booktopia.generic.ITestConstants;


//@Listeners(com.infostore.generics.FWListeners.class)
public class BaseTest implements ITestConstants{
	public  WebDriver driver;

	//Set chrome browser system properties
	@BeforeSuite
	public void setBrowserProperties(){

		System.setProperty(CHROME_KEY, CHROME_VALUE);

	}	

	//Setup the test by launching the browser with root URL
	@BeforeMethod
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	//Test teardown 
/*	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
}