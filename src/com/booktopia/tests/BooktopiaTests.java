package com.booktopia.tests;


import java.io.IOException;

import org.testng.annotations.Test;

import com.booktopia.pages.BooktopiaChildrenPage;
import com.booktopia.pages.BooktopiaEducationPage;
import com.booktopia.pages.BooktopiaFictionPage;
import com.booktopia.pages.BooktopiaHomePage;
import com.booktopia.pages.BootopiaCartPage;


public class BooktopiaTests extends BaseTest {

	@Test
	public void BooktopiaHome() throws InterruptedException, IOException {

		BooktopiaHomePage bookHomePage= new BooktopiaHomePage(driver);
		BooktopiaChildrenPage bookSearchPage = new BooktopiaChildrenPage(driver);
		BooktopiaFictionPage bookFictionPage= new BooktopiaFictionPage(driver);
		BooktopiaEducationPage bookEducationPage= new BooktopiaEducationPage(driver);
		BootopiaCartPage cartItems= new BootopiaCartPage(driver);

		// Step 1: Navigate to the following URL: https://www.booktopia.com/
		bookHomePage.navigateToBooktopoiaHomePage();

		//Step 2: Navigate to Children Tab and Search Book
		bookHomePage.mouseHoverChildren();
		bookSearchPage.searchBook();

		//Step 3: Navigate to Fiction Tab and Search Book
		bookHomePage.mouseHoverFiction();
		bookFictionPage.searchFictionBook();

		//Step 4: Navigate to Education Tab and Search Book
		bookHomePage.mouseHoverEducation();
		bookEducationPage.searchEducationBook();

		//Step 5: Viewing cart Items
		cartItems.viewCart();
		
		
	}

}