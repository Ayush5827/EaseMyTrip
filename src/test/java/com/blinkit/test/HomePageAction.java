package com.blinkit.test;

 
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.easeMyTrip.pages.HomePage;

public class HomePageAction extends HomePage{
	HomePage home_ele=new HomePage();
 	
	public void a_Enter_SrcFlights() throws InterruptedException {
 	   		Thread.sleep(3000);
		WebElement element =  home_ele.Click_SrcLoc();
	        Actions actions = new Actions(driver);
	       actions.moveToElement(element).click(element).sendKeys("Del").build().perform();
	       Thread.sleep(2000);
  		WebElement Clk_finalLoc=home_ele.Validate_FinalLoc();
 	       actions.moveToElement(Clk_finalLoc).click(Clk_finalLoc).sendKeys("Ban").build().perform();
	       Thread.sleep(2000);
	       WebElement Sel_FinalLoc=home_ele.Select_FinalLoc();
	       Sel_FinalLoc.click();
 		WebElement Clk_startdt=home_ele.Validate_Clickdt();
 	       actions.moveToElement(Clk_startdt).click(Clk_startdt).build().perform();
	       Thread.sleep(2000);
	       WebElement Sel_FinalLoc1=home_ele.ValidateSlelectdt();
	       Sel_FinalLoc1.click();
  		WebElement Select_Traveller =home_ele.Validate_SelectTraveller();
 	       actions.moveToElement(Select_Traveller).click(Select_Traveller).build().perform();
	       Thread.sleep(2000);
	        WebElement Add_Trvlr=home_ele.Validate_AddTraveller();
	        Add_Trvlr.click();
	        Thread.sleep(2000);
	        WebElement Search_btn=home_ele.Validate_Searchbutton();
	        Search_btn.click();
	        Thread.sleep(3000);
	        System.out.println(driver.getTitle());
	}
	public void a_SearchBtn() {
        WebElement Search_btn=home_ele.Validate_Searchbutton();
        Search_btn.click();
        System.out.println(driver.getCurrentUrl());

		
	}
	public void a_FilterSearch_Result() throws InterruptedException {
 		WebElement Search_btn=home_ele.Validate_Searchbutton();
        Search_btn.click();
        Thread.sleep(5000);
        WebElement Nonstop_filter= home_ele.Choose_Filter1();
        Nonstop_filter.click();
        WebElement Move_slider=home_ele.Validate_Move_Slider();
        Actions action= new Actions(driver);
 	    action.moveToElement(Move_slider).perform();
 	    action.clickAndHold(Move_slider).perform();
 	    action.dragAndDropBy(Move_slider,-70,0).perform();
 	    action.release().build().perform();
 	   JavascriptExecutor js = (JavascriptExecutor) driver;
 	  js.executeScript("window.scrollBy(0,250)", "");
        WebElement Indigo_Filter=home_ele.Choose_Filter2();
        Indigo_Filter.click();
        Thread.sleep(2000);
        List<WebElement> search_Result=home_ele.Validate_filter_result();
        System.out.println(search_Result.size());
		
	}
	
	
	public void a_Flightbooking() throws InterruptedException {
		
		WebElement Select_rndTrip=home_ele.Select_radiobtn();
		Select_rndTrip.click();
        Thread.sleep(2000);

		WebElement Search_btn=home_ele.Validate_Searchbutton();
        Search_btn.click();
        Thread.sleep(4000);
        WebElement Click_Oneway=home_ele.Select_Oneway();
        Click_Oneway.click();
        WebElement FromCity_click=home_ele.Click_FromCity();
        FromCity_click.click();
        FromCity_click.sendKeys("Pat");
        Thread.sleep(3000);
        WebElement To_City=home_ele.select_FromCity();
        To_City.click();
	}
	public void a_WebCheck_In() {
		 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(home_ele.Validate_Web_checkIn())).click();
		 String currentWindowHandle = driver.getWindowHandle();
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowHandle : windowHandles) {
		      if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);	

		        break;
		      }
		    }
		    Assert.assertEquals(driver.getCurrentUrl(), "https://www.easemytrip.com/web-checkin.html");
	}
	
	
	public void a_clickChat() throws InterruptedException {
		Thread.sleep(5000);
		WebElement click_chat=home_ele.Validate_clickChat();
		click_chat.click();
//		WebElement send_chat=home_ele.Validate_SendCaht();
//		send_chat.sendKeys("Hello");
 		
	}
	 
	//hotel Module Test--------
	
	public void a_ClickHotels_Tab() {
		WebElement Clikc_Hotels=home_ele.Validate_HotelTab();
		 Actions actions = new Actions(driver);
	       actions.moveToElement(Clikc_Hotels).click(Clikc_Hotels).build().perform();
	       System.out.println(driver.getTitle());
	       System.out.println(driver.getCurrentUrl());
	}
	public void a_VisibleSearchBtn() {
		WebElement click_searchbtn=home_ele.ValidateVisibilty_srchBtn();
		 
 	}
	public void a_ClickSearch_Btn() throws InterruptedException {
		WebElement click_searchbtn=home_ele.ValidateVisibilty_srchBtn();
		click_searchbtn.click();
		Thread.sleep(2000);

		
	}
	public void a_ClickTCityText() throws InterruptedException {
		WebElement Text_City=home_ele.Click_TextCity();
		Thread.sleep(2000);
		Text_City.click();
		Text_City.sendKeys("Del");
		Thread.sleep(2000);
		
		WebElement Select_city=home_ele.Select_City1();
		Select_city.click();
		Thread.sleep(2000);
 		WebElement Click_In_date=home_ele.Click_date();
		Click_In_date.click();
		Thread.sleep(2000);

		WebElement Select_indate=home_ele.Select_In_date();
		Select_indate.click();
		Thread.sleep(3000);

		WebElement Selct_outDate=home_ele.Selct_out_Date();
		Selct_outDate.click();
//		WebElement Click_drpdwn_=home_ele.Click_Dropdwon();
//		Click_drpdwn_.click();
		WebElement quantity =  home_ele.Click_Dropdwon();
		quantity.click();
		Thread.sleep(2000);
		WebElement Adult_quantity=home_ele.click_AdultPlus();
		Adult_quantity.click();
	    Thread.sleep(1000);
 		    WebElement plusButton =home_ele.ClickplusBtn();
		    plusButton.click();
 		    WebElement Click_done=home_ele.Click_Done();
		    Click_done.click();
		    Thread.sleep(2000);
 		    WebElement Click_Search=home_ele.Click_searchBtn();
		    Click_Search.click();
		    Thread.sleep(2000);
 		    List<WebElement> hotelNameElements =home_ele.Validate_HotelListing();
		    ArrayList<String> hotelNames = new ArrayList<String>();
		    for (WebElement hotelNameElement : hotelNameElements) {
		        hotelNames.add(hotelNameElement.getText());
		    }
		    for (String hotelName : hotelNames) {
		        System.out.println(hotelName);
		    }
	}
	public void a_HotelLinkTest() {
		WebElement Hote_list=home_ele.Validate_ListHotelLink();
		Hote_list.click();
		System.out.println(driver.getCurrentUrl());
	}
	public void a_ClickBestOffers() throws InterruptedException {
		Thread.sleep(2000);
//		
//		String parentWindowHandle = driver.getWindowHandle();
//		WebElement Best_offers=home_ele.Click_BestOffers();
//		Best_offers.click();
//          Set<String> windowHandles = driver.getWindowHandles();
//          for (String windowHandle : windowHandles) {
//            if (!windowHandle.equals(parentWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(home_ele.Click_BestOffers())).click();
		 String currentWindowHandle = driver.getWindowHandle();
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowHandle : windowHandles) {
		      if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);	

		        break;
		      }
		    }
	}
		    public void a_clickViewRoom() throws InterruptedException {
		    	Thread.sleep(2000);
		    	WebElement Click_viewRoom =home_ele.click_viewRoom();
		    	Click_viewRoom.click();
		    	Thread.sleep(4000);
		    	 String currentWindowHandle = driver.getWindowHandle();
				    Set<String> windowHandles = driver.getWindowHandles();
				    for (String windowHandle : windowHandles) {
				      if (!windowHandle.equals(currentWindowHandle)) {
				        driver.switchTo().window(windowHandle);	

				        break;
				      }
				    }		

	}
		    public void a_clickviewRoomBtn() {
		    	WebElement Click_Booknow =home_ele.BookNow_visibility();

		    	Click_Booknow.click();
		    	
		    	WebElement View_Totalprice=home_ele.TotalPrice_();
		    	

		    }
		    public void a_CheckPaymentFunc() throws InterruptedException {
		    	WebElement Enter_email=home_ele.Enter_email();
		    	Enter_email.sendKeys("teste123@gmail.com");
		    	WebElement Enter_Mob=home_ele.Enter_MOB();
		    	Enter_Mob.sendKeys("9787574634");
		    	WebElement Enter_firstName=home_ele.Enter_firstname();
		    	Enter_firstName.sendKeys("test");
		    	WebElement Enter_lastName=home_ele.Enter_Lastname();
		    	Enter_lastName.sendKeys("david");
		    	WebElement Enter_childfirstName=home_ele.Enter_Childfirstname();
		    	Enter_childfirstName.sendKeys("john");
		    	WebElement Enter_childlastName=home_ele.Enter_Childlastname();
		    	Enter_childlastName.sendKeys("john");
		    	 WebElement click_paymentBtn=home_ele.Click_payment();
				 click_paymentBtn.click();
				 Thread.sleep(2000);
		    	
		    	
		    	
		    }
		    
		    
		    //flight-Hotel Module
		    
		    public void a_FlightHotelTitle() {
		    	WebElement Flight_hotel=home_ele.ValidateFlight_HotelsTab();
		    	Flight_hotel.click();
		    	System.out.println(driver.getCurrentUrl());
		    }
		    
		    public void a_SearchBtnVisibility() throws InterruptedException {
		    	WebElement Click_searchBtn=home_ele.Validate_visibilityBtn();
		    	Click_searchBtn.click();
		    	Thread.sleep(3000);
		    	WebElement View_detailsBtnVisibility =home_ele.Validate_ViewDetailsBtn();
		    	
		    }
		    
		    public void a_CheckBox_Func() {
		    	WebElement click_checkBox=home_ele.Validate_checkBox();
		    	click_checkBox.click();
		    }
		    
		    public void a_SearchResults() throws InterruptedException {
		    	WebElement click_frmCity=home_ele.Click_srcLoc();
		    	click_frmCity.clear();
		    	click_frmCity.sendKeys("Patna");
		    	Thread.sleep(2000);
		    	WebElement Select_Loc1=home_ele.select_FromCity();
		    	Select_Loc1.click();
		    	WebElement click_ToCity=home_ele.Click_ToCity();
		    	click_ToCity.sendKeys("Bang");
		    	Thread.sleep(2000);
		    	WebElement Select_Loc2=home_ele.Select_FinalLoc2();
		    	Select_Loc2.click();
		    	WebElement clickStDate=home_ele.Click_strtDate();
		    	clickStDate.click();
		    	Thread.sleep(2000);
		    	WebElement Select_stdate=home_ele.select_Date();
		    	Select_stdate.click();
		    	WebElement click_Rtdate=home_ele.click_EndDate();
		    	click_Rtdate.click();
		    	Thread.sleep(2000);
		    	WebElement select_Rtdate=home_ele.Select_EndDate();
		    	select_Rtdate.click(); 
		    	Thread.sleep(2000);
 		    	WebElement Click_trav =home_ele.click_Trvlr();
		    	Click_trav.click(); 
 		    	WebElement  Add_adu =home_ele.Add_adult();
		    	Add_adu.click();
 		    	WebElement  Add_chld =home_ele.Add_child();
		    	Add_chld.click();
 		    	WebElement  click_done =home_ele.click_Done();
		    	click_done.click();
 		    	WebElement  Click_room =home_ele.Click_Rooms();
		    	Click_room.click();
 		    	WebElement  Add_room =home_ele.Add_Room();
		    	Add_room.click();
 		    	WebElement  Click_roomsdone =home_ele.Click_roomsDone();
		    	Click_roomsdone.click();
 		    	WebElement  Click_night =home_ele.Click_Nights();
		    	Click_night.click();
 		    	WebElement  Add_night =home_ele.Add_nights();
		    	Add_night.click();
  		    	WebElement  click_Donenight =home_ele.click_DoneNights();
		    	click_Donenight.click();
  		    	WebElement Click_searchBtn=home_ele.Validate_visibilityBtn();
		    	Click_searchBtn.click();
		    	Thread.sleep(6000);
		    }
		    
		    public void  a_View_details() {
		    	WebElement ViewDeatils_Btn=home_ele.Click_viewDeatail();
		    	ViewDeatils_Btn.click();
		    }
		    
		    public void a_Edit_detailsBtn() {
		    	WebElement Edit_details=home_ele.validate_EditDetails_Btn();
		    	Edit_details.click();
		    }
		    
		    public void a_BookNow() throws InterruptedException {
		    	Thread.sleep(2000);
//		    	 JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	 js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

 		    	  WebElement Book_nowBtn=home_ele.Click_BookNow();
		    	  Book_nowBtn.click();
		    	  Thread.sleep(3000);
//		    	  JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	  js.executeScript("window.scrollBy(0,250)", Book_nowBtn );
//		    	  
		    }
		    
		    public void a_GetTotalPrice() {
		    	WebElement total_Price=home_ele.Validate_totalPrice();
		    }
		    
		    
		    
		    
		    
		    public void a_ValidateCntnueBtn() throws InterruptedException {
		    	WebElement FirstName1_=home_ele.FirstName_1();
		    	 JavascriptExecutor js = (JavascriptExecutor) driver;
 		    	js.executeScript("arguments[0].scrollIntoView(true);", home_ele.FirstName_1());

		    	//WebElement FirstName1_=home_ele.FirstName_1();
		    	FirstName1_.sendKeys("John");
		    	WebElement LastName1_=home_ele.LastName_1();
		    	LastName1_.sendKeys("david");
		    	WebElement FirstName2_=home_ele.FirstName_2();
		    	FirstName2_.sendKeys("michael");
		    	WebElement LastName2_=home_ele.lastName_2();
		    	LastName2_.sendKeys("albert");
		    	WebElement ChFirstname_=home_ele.Ch_Firstname();
		    	ChFirstname_.sendKeys("stuart");
		    	WebElement ChLastname_=home_ele.ch_LastName();
		    	ChLastname_.sendKeys("little");
		    	WebElement _Email=home_ele.Email_();
		    	_Email.sendKeys("testdavid123@gmail.com");
		    	WebElement _MobNo=home_ele.MobNo_();
		    	_MobNo.sendKeys("9876536332");
		    	WebElement click_Btn=home_ele.click_cntnBtn();
		    	click_Btn.click();
		    	Thread.sleep(2000);
		    	
		    }
		    
		    
		    //Trains module
		    
		    public void a_ValidateTrainsTitle() {
		    	WebElement Trains_Tab=home_ele.click_TrainsTab();
		    	Trains_Tab.click();
		    }
		    
		    public void a_validateSearchBtn() throws InterruptedException {
		    	Thread.sleep(2000);
		    	WebElement Search_Btn=home_ele.Click_searchBtnTest();
		    	Search_Btn.click();
		    	
		    }
		    public void a_ValidatesearchResult() throws InterruptedException {
		    	WebElement Frm_city=home_ele.Enter_frmCity_();
		    	Frm_city.click();
		    	Thread.sleep(2000);
		    	WebElement Select_frmcity=home_ele.Select_city1();
		    	Select_frmcity.click();
		    	WebElement To_city=home_ele.Enter_tocity();
		    	To_city.click();
		    	WebElement Select_tocity=home_ele.Selectcity_2();
		    	Select_tocity.click();
		    	WebElement click_date=home_ele.click_date();
		    	click_date.click();
		    	WebElement Search_Btn=home_ele.Click_searchBtnTest();
		    	Search_Btn.click();
		    	Thread.sleep(2000);
		    }
		    
		    public void a_ModifyBtn() throws InterruptedException {
		    	WebElement Click_des=home_ele.Click_dest();
		    	Click_des.sendKeys("Chandigarh");
		    	Thread.sleep(3000);
		    	WebElement modify_dest=home_ele.Modify_dest();
		    	modify_dest.click();
		    	WebElement Click_ModBtn=home_ele.click_ModifyBtn();
		    	Click_ModBtn.click();
 		    	System.out.println(home_ele.Validate_text().getText());
		    	
		    	
		    }
		    
		    public void a_ClickViewroute() throws InterruptedException {
		    	Thread.sleep(2000);
		    	WebElement Click_viewrt=home_ele.Click_viewRoute();
		    	Click_viewrt.click();
		    	Thread.sleep(2000);
		    	System.out.println(home_ele.Route_Text().getText());
		    }
		    
		    public void a_BookBTnTest() throws InterruptedException {
		    	WebElement Book_btn=home_ele.click_BookBtn();
		    	Book_btn.click();
		    	Thread.sleep(2000);
		    	
 		    }

	

}
