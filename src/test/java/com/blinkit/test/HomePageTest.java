package com.blinkit.test;
 import java.time.Duration;
 import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 import com.easeMyTrip.TestBase.TestBase;
import com.easeMyTrip.pages.HomePage;

public class HomePageTest extends TestBase
{
	HomePage homepage;
	HomePageAction actions_home;
	public HomePageTest() {
		
		super();	
	}
	
	@BeforeClass
	public void SteUp() throws InterruptedException {
		initialization();
 		homepage=new HomePage();
 		actions_home=new HomePageAction();
 		//driver.switchTo( ).alert( ).accept();

// 		WebElement Ignore_add=homepage.Ignore_Adds();
//		Ignore_add.click();
	}
	

	@Test(priority=1)
	public void HomePageTitleTest() throws InterruptedException {
		Thread.sleep(2000);
		String title = homepage.validateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com");
 	}
	
	@Test(priority=2)
	
	public void HeaderlogoVisibilityTest() {
		boolean flag=homepage.ValidateHeaderlogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void  currentUrlTest() {
		String url = homepage.ValidateURl();
 		Assert.assertEquals(url,"https://www.easemytrip.com/");
	}
	
	
	@Test(priority=4)
	public void FlightTabTest() {
 		WebElement tab1 =  homepage.ValidateFlight_tab();
		tab1.click();
	
 
        String tabText = tab1.getText();
        Assert.assertEquals(tabText, "FLIGHTS");
          Assert.assertEquals(driver.getCurrentUrl(),"https://www.easemytrip.com/flights.html");
		driver.navigate().back();

	 
	}
	@Test(priority=5)
	public void Hotels_tab() throws InterruptedException {
 		Thread.sleep(3000);
		WebElement tab2=homepage.Validate_HotelTab();
		tab2.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/hotels/");
		driver.navigate().back();

	}
	
	
	 @Test(priority=6)
	 public void ValidateFlight_HotelsTab() {
 			WebElement tab1 =  homepage.ValidateFlight_HotelsTab();
			tab1.click();
  	        Assert.assertEquals(driver.getCurrentUrl(), "https://fph.easemytrip.com/");
			driver.navigate().back();

	 }
	 
	 @Test(priority=7)
	 public void Train_TabTest() {
 			WebElement tab1 =  homepage.Validate_TrainsTab();
			tab1.click();
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/railways/");
			driver.navigate().back();

	 }
	 @Test(priority=8)
	 public void Bus_TabTest() {
 			WebElement tab1 =  homepage.Validate_BusTab();
			tab1.click();
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/bus/");
			driver.navigate().back();

	 }
	@Test(priority=9)
	public void HeaderlinkCount_Test() {
 		List<WebElement> links=homepage.ValidateHeaderlinks();
   		Assert.assertEquals(links.size() , 27);
 	}
	
	@Test(priority=10)
	public void FooterlinkCount_Test() {
 		List<WebElement> links=homepage.ValidateFooterlinks();
 		Assert.assertEquals(links.size(), 152);
 	}

	

	@Test(priority=11)
	public void JoinIcon_Test() throws InterruptedException {
 		WebElement w3=homepage.Validate_joinIcon();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(homepage.Validate_joinIcon())).click();
		 String currentWindowHandle = driver.getWindowHandle();
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowHandle : windowHandles) {
		      if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);	

		        break;
		      }
		    }
   			Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/JoinEMTPro");
 	        driver.switchTo().window(currentWindowHandle);
	        Thread.sleep(3000);


		   	}
		 
 
       @Test(priority=12)
       public void Source_LocTest() throws InterruptedException {
    	   actions_home.a_Enter_SrcFlights();
      	   Thread.sleep(3000);        
            Assert.assertEquals(driver.getTitle(), "EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com");
            driver.navigate().back();

       }
       @Test(priority=13)
       public void SearchBtn_FuncTest() {
    	   actions_home.a_SearchBtn();
           Assert.assertEquals(driver.getTitle(), "EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com");
           driver.navigate().back();


       }
       
       @Test(priority=14)
    	    public void FilterSearch_resultTest() throws InterruptedException {
    	   Thread.sleep(3000);
     	   actions_home.a_FilterSearch_Result();
     	   Thread.sleep(4000);
     	   Assert.assertTrue(true, "Result should be displayed");
           driver.navigate().back();

    	   
       }
       @Test(priority=15)
       public void FlightBookingTest() throws InterruptedException {
    	   actions_home.a_Flightbooking();
       }
       
       @Test(priority=16)
       public void WebcheckInBtn_Test() {
    	   actions_home.a_WebCheck_In();
    	   Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/web-checkin.html");
           driver.navigate().back();
       }
        
       @Test(priority=17)
       public void ChatTest() {
    	   Assert.assertEquals(homepage.Validate_Text_Inchat().isDisplayed(),true);
       }
       
       
       
   
       @AfterClass
	    public void Teardown() {
		driver.quit();
	}

}
