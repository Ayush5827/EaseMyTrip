package com.blinkit.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.easeMyTrip.TestBase.TestBase;
import com.easeMyTrip.pages.HomePage;

public class TrainBookingTest extends TestBase {
	
	HomePage homepage;
	HomePageAction actions_home;
public TrainBookingTest() {
		
		super();	
	}
	
	@BeforeClass
	public void SteUp() throws InterruptedException {
		initialization();
 		homepage=new HomePage();
 		actions_home=new HomePageAction();

	}
	
	@Test
	public void pageTitleTest() {
		actions_home.a_ValidateTrainsTitle();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.easemytrip.com/railways/");
		
	}
	
	@Test(dependsOnMethods="pageTitleTest")
	public void SearchBtn_funcTest() throws InterruptedException {
		actions_home.a_validateSearchBtn();
	Assert.assertEquals(homepage.Validation_msge().isDisplayed(), true);	
	}
	
	@Test(dependsOnMethods="pageTitleTest")
	public void SearchResult_Test() throws InterruptedException {
		actions_home.a_ValidatesearchResult();
		Assert.assertEquals(homepage.Validate_text().isDisplayed(), true);
		
	}
	@Test(dependsOnMethods="SearchResult_Test")
	public void ModifyBtn_Test() throws InterruptedException {
		actions_home.a_ModifyBtn();
		Assert.assertEquals(homepage.Validate_text().isDisplayed(),true);
	}
	
	@Test(dependsOnMethods="ModifyBtn_Test")
	public void ViewRoute_Test() throws InterruptedException {
		actions_home.a_ClickViewroute();
		Assert.assertEquals(homepage.Route_Text().isDisplayed(), true);
	}
	@Test(dependsOnMethods="SearchResult_Test")
	public void BookBTn_Test() throws InterruptedException {
		actions_home.a_BookBTnTest();
		Assert.assertEquals(homepage.cntnu_Btn().isDisplayed(),true);
	}

}
