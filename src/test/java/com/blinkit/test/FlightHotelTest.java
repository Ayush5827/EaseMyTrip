package com.blinkit.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.easeMyTrip.TestBase.TestBase;
import com.easeMyTrip.pages.HomePage;

public class FlightHotelTest extends TestBase{
	HomePage homepage;
	HomePageAction actions_home;
public FlightHotelTest() {
		
		super();	
	}
	
	@BeforeClass
	public void SteUp() throws InterruptedException {
		initialization();
 		homepage=new HomePage();
 		actions_home=new HomePageAction();

	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		actions_home.a_FlightHotelTitle();
		Assert.assertEquals(driver.getCurrentUrl(), "https://fph.easemytrip.com/");
	}
	
	@Test(dependsOnMethods="pageTitleTest")
	public void SrachBtnVisibiltyTest() {
		Assert.assertEquals(homepage.Validate_visibilityBtn().isDisplayed(), true);
		
	}
	@Test(dependsOnMethods="SrachBtnVisibiltyTest")
	public void SearchBtnFuncTest() throws InterruptedException {
		actions_home.a_SearchBtnVisibility();
		Assert.assertEquals(homepage.Validate_ViewDetailsBtn().isDisplayed(),true);
		driver.navigate().back();
	}
	
	@Test(dependsOnMethods="SrachBtnVisibiltyTest")
	public void CheckBox_FuncTest() {
		actions_home.a_CheckBox_Func();
		Assert.assertEquals(homepage.Validate_diffCiti().isDisplayed(), true);
	}
	
	@Test(dependsOnMethods="pageTitleTest")
	public void SearchResultTest() throws InterruptedException {
		actions_home.a_SearchResults();
		Assert.assertEquals(homepage.SearchResult_Data().isDisplayed(),true);
	}
	
	
	@Test(dependsOnMethods="SearchResultTest")
	public void View_DetailsBtnFuncTest() {
		actions_home.a_View_details();
		Assert.assertEquals(homepage. ViewDatails_Btn().isDisplayed(),true);
		}
	
	@Test(dependsOnMethods="View_DetailsBtnFuncTest")
	public void Edit_detais_btnTest() throws InterruptedException {
		Assert.assertEquals(homepage.Validate_ModifySearch_text().isDisplayed(),true);
		Thread.sleep(2000);
		WebElement Cancel_Modify=homepage.Cancel_modify();
		Cancel_Modify.click();
	}
	
	@Test(dependsOnMethods="View_DetailsBtnFuncTest")
	public void BookNow_BtnTest() throws InterruptedException {
		actions_home.a_BookNow();
		Assert.assertEquals(homepage.Continue_Booking().isDisplayed(), true);
	}
	
	@Test(dependsOnMethods="BookNow_BtnTest")
	public void Total_priceTest() throws InterruptedException {
		Assert.assertEquals(homepage.Validate_totalPrice().isDisplayed(), true);
		Thread.sleep(4000);
    	System.out.println(homepage.Validate_totalPrice().getText());
 	}
	
	@Test(dependsOnMethods="BookNow_BtnTest")
	public void Payement_cntnueTest() throws InterruptedException {
		actions_home.a_ValidateCntnueBtn();

		Assert.assertEquals(homepage.MakePayment_visibility().isDisplayed(), true);
	}
	
	
	
//	@AfterClass
//	public void  TearDown() {
//	driver.quit();
//	}

}
