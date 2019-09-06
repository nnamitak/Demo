package com.booktopia.tests;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.booktopia.pages.BooktopiaChildrenPage;
import com.booktopia.pages.BooktopiaHomePage;


public class BooktopiaTests extends BaseTest {

	@Test
	public void BooktopiaHome() throws InterruptedException, IOException {

		BooktopiaHomePage bookHomePage= new BooktopiaHomePage(driver);
		BooktopiaChildrenPage bookSearchPage = new BooktopiaChildrenPage(driver);

		// Step 1: Navigate to the following URL: https://www.booktopia.com/
		bookHomePage.navigateToBooktopoiaHomePage();

		//Step 2: Click LOGIN
		bookHomePage.mouseHoverChildren();

		
		//Step 3: Searching for a book
		int row=1;
		bookSearchPage.searchBook(row);
		
		//Step 4: add couple of more books
		bookHomePage.mouseHoverChildren();
		bookSearchPage.searchBook(++row);
		
		  
/*		//Step 4: Click Login with FaceBook Account
		initialPage.clickFaceBookBtn();	
		driver.navigate().back();

		//Step 5: Click LOGIN and Enter Email and Password to Login 
		initialPage.clickLoginBtn();
		initialPage.userNameDetails();
*/
	}

}