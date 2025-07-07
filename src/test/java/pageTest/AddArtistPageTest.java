package pageTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AboutArtistsPage;
import pageObjects.AddArtistPage;
import pageObjects.HomePage;
import testUtilities.DataProviders;

public class AddArtistPageTest extends BaseClass {
	
	@Test (dataProvider="AddArtistsData", dataProviderClass=DataProviders.class, enabled=true) 
	public void TC01_verify_PhoneNumber_Field_validation(String name, String email, String phoneNumber, String bio, String exp) throws InterruptedException {

	try {
		HomePage hp = new HomePage(driver);
		hp.ClickAddArtist_link();
		System.out.println("Click on artist page");
		Thread.sleep(5000);
		
		//add artist
		AddArtistPage addartist = new AddArtistPage(driver);
		System.out.println("artistpage is opened");
		
		addartist.Enter_Name(name);
		Thread.sleep(5000);
		addartist.Enter_emailId(email);
		addartist.Enter_InvalidPhoneNumber(phoneNumber);
		addartist.Enter_TextInBio_AdditionalInformation(bio);
		addartist.Click_Attachment_ImageFile();
		Thread.sleep(5000);
		addartist.clickAddArtistSubmit();
		Thread.sleep(5000);
		 
		//boolean ActualErrorTitle=addartist.verifyerrorPopup_titleisExists();
		// String ExpectedErrorTitle = "Validation Error";
		//Assert.assertEquals(ActualErrorTitle, ExpectedErrorTitle);
				
			if(exp.equalsIgnoreCase("Valid")) {
			 
			 if(addartist.verify_from_Submitionpopup_isDisplayed()==true)
			//	 addartist.click_Confirm_Submition_Popup();
			// 	addartist.click_Ok_on_success_Popup();
				 System.out.println("Susscess popup is displayed for valid data "+ name);
				Assert.assertTrue(true);
				 
			 }else {
				 addartist.clickOkButton();
				 addartist.clickResetFormSubmit();
				 System.out.println("error popup is displayed for valid data "+ name);
				 Assert.assertTrue(false);
			 }
				 
			if(exp.equalsIgnoreCase("Invalid")) {
			 
			 if(addartist.verify_from_Submitionpopup_isDisplayed()==true)
			 {
				 System.out.println("Susscess popup is displayed for Invalid data "+ name);
				// addartist.click_Confirm_Submition_Popup();
				// addartist.click_Ok_on_success_Popup();
					 Assert.assertTrue(false);
				 
			 }
			 else {
				 System.out.println("error popup is displayed for invalid data "+ name);
				 addartist.clickOkButton();
				 addartist.clickResetFormSubmit();
				 Assert.assertTrue(true);
			 }
		 } 
		 
		
			// hp.ClickAddArtist_link();
			
		
	} catch (Exception e) {
		System.out.println("unable to verify error message");
		Assert.fail();
	}

	
	}
	
	
	@Test (dataProvider="RequiredFieldData", dataProviderClass=DataProviders.class, enabled=true)
	public void TC02_Required_Field_Validation(String name, String email, String phoneNumber, String bio, String exp) {
		

		try {
			HomePage hp = new HomePage(driver);
			System.out.println("start1");
			hp.ClickAddArtist_link();
			System.out.println("start1");
			Thread.sleep(5000);
			
			//add artist
			AddArtistPage addartist = new AddArtistPage(driver);
			System.out.println("start1");
			addartist.Enter_Name(name);
			Thread.sleep(5000);
			addartist.Enter_emailId(email);
			addartist.Enter_InvalidPhoneNumber(phoneNumber);
			addartist.Enter_TextInBio_AdditionalInformation(bio);
			addartist.Click_Attachment_ImageFile();
			Thread.sleep(5000);
			addartist.clickAddArtistSubmit();
			Thread.sleep(5000);
			
			boolean Actualrequired=addartist.requiredField_ValidationMessag();
			
			 if(exp.equalsIgnoreCase("Invalid")) {
				 
				 if(Actualrequired==true)
				 {
					 
					 Assert.assertTrue(true);
					
					 
				 }
				 else {
					 Assert.assertTrue(false);
				 }
				 addartist.clickResetFormSubmit();
			 }
				
		} catch (Exception e) {
			System.out.println("unable to validated required field message");
			Assert.fail();
		}

				
	}
	
	@Test (dataProvider="EmailFieldData", dataProviderClass=DataProviders.class)
	public void TC03_verify_EmailPattren_Field_Validation(String name, String email, String phoneNumber, String bio, String exp) {
		try {
			HomePage hp = new HomePage(driver);
			System.out.println("home page is displayed");
			hp.ClickAddArtist_link();
			System.out.println("Click on add artist");
			Thread.sleep(5000);
			
			//add artist
			AddArtistPage addartist = new AddArtistPage(driver);
			System.out.println("artist page is displayed");
			addartist.Enter_Name(name);
			Thread.sleep(5000);
			addartist.Enter_emailId(email);
			addartist.Enter_InvalidPhoneNumber(phoneNumber);
			addartist.Enter_TextInBio_AdditionalInformation(bio);
			addartist.Click_Attachment_ImageFile();
			Thread.sleep(5000);
			addartist.clickAddArtistSubmit();
			Thread.sleep(5000);
			
			boolean ActualemailID=addartist.emailID_ValidationMessag();
			
			 if(exp.equalsIgnoreCase("Invalid")) {
				 
				 if(ActualemailID==true)
				 {
					 
					 Assert.assertTrue(true);
					
					 
				 }
				 else {
					 Assert.assertTrue(false);
				 }
				
			 }
			 if(exp.equalsIgnoreCase("Valid")) {
				 
				 if(ActualemailID==true)
					 				 
				 {
					 Assert.assertTrue(false);
				 }
				 else {
					 Assert.assertTrue(true);
				 }
				 
			 }
				
		} catch (Exception e) {
			System.out.println("unable to validated required field message");
			Assert.fail();
		}

			
		
		
	}
	
	@Test (enabled=true)
	public void TC04_Verify_the_entered_data_should_be_removed_from_the_fields_when_user_click_on_the_reset_form_CTA_in_Add_Artist_page() throws InterruptedException {
		try {	
		HomePage hp = new HomePage(driver);
		hp.ClickAddArtist_link();
		AddArtistPage addartist = new AddArtistPage(driver);
		addartist.Enter_Name(BaseClass.RandamString());
		addartist.Enter_emailId(BaseClass.generateRandomEmail("yopmail.com", 8));
		addartist.Enter_PhoneNumber(BaseClass.randamNumber());
		addartist.Enter_TextInBio_AdditionalInformation(BaseClass.RandamString());
		addartist.Click_Attachment_ImageFile();
		Thread.sleep(5000);
		addartist.clickResetFormSubmit();
		Thread.sleep(5000);
		//System.out.println("start");
		//System.out.println(addartist.get_text_from_nameField());
		System.out.println("start1");
		
		 if(addartist.get_text_from_nameField().isEmpty() && addartist.get_text_from_EmailField().isEmpty() && addartist.get_text_from_PhoneField().isEmpty()) {
		 System.out.println("All fields are empty!!"); 
		 System.out.println("Test case is pass");
		 
		 }
		 else {
			 System.out.println("Test case is Failed");
		 }
		 
		//Boolean ActualNametext=addartist.get_text_from_nameField().isEmpty();
		//System.out.println("start2");
		//Boolean ExpectedNametext=true;
		//System.out.println("start3");
		//Assert.assertEquals(ActualNametext, ExpectedNametext);
		/*
		 * System.out.println(ActualNametext); System.out.println("start4");
		 */
		
		 
		} catch (Exception e) {
			System.out.println("unable to clear the form fields");
			
		}

		
		
	}
	
	@Test (enabled=true)
	public void TC05_Verify_New_artist_can_be_added_in_add_artist_page() throws InterruptedException {

		try {
			HomePage hp = new HomePage(driver);
			hp.ClickAddArtist_link();
			Thread.sleep(2000);
			AddArtistPage addartist = new AddArtistPage(driver);
			addartist.Enter_Name(BaseClass.RandamString());
			Thread.sleep(2000);
			addartist.Enter_emailId(BaseClass.generateRandomEmail("yopmail.com", 8));
			Thread.sleep(2000);
			addartist.Enter_PhoneNumber(BaseClass.randamNumber());
			Thread.sleep(2000);
			addartist.Enter_TextInBio_AdditionalInformation(BaseClass.RandamString());
			Thread.sleep(2000);
			
			addartist.Click_Attachment_ImageFile();
			Thread.sleep(5000);
			addartist.clickAddArtistSubmit();
			Thread.sleep(5000);
			addartist.click_Confirm_Submition_Popup();
			Thread.sleep(5000);
			Assert.assertEquals(addartist.PopupSucessMessage(), "Artist added successfully!");
			
			addartist.click_Ok_on_success_Popup();
			System.out.println("Artist added successfully");
			
			
			/*
			 * String Actualtext1= addartist.get_text_from_Submitionpopup(); String
			 * ExpectedText1 ="Confirm Submission"; if(Actualtext1==ExpectedText1) {
			 * 
			 * addartist.click_Confirm_Submition_Popup();
			 * System.out.println("test003 case is passed");
			 * 
			 * } else { System.out.println("test003 case is Failed"); }
			 */
	
			
			} catch (Exception e) {
				
				System.out.println("Unable to new add artist");

		//logger.error("Test failed....");
		//logger.debug("debug logs...");
		Assert.fail();
	}

//		logger.info("************************** Finished TC001_HomepageTest *******************");
	}

	@Test (enabled=true) 
	public void TC004_Verify_Newly_added_Artist_details_are_displayed_in_About_artist_page()
	{
		
		try {
			HomePage hp = new HomePage(driver);
			hp.ClickAddArtist_link();
			Thread.sleep(2000);
			String ArtistName = BaseClass.RandamString();
			AddArtistPage addartist = new AddArtistPage(driver);
			addartist.Enter_Name(ArtistName);
			Thread.sleep(2000);
			addartist.Enter_emailId(BaseClass.generateRandomEmail("yopmail.com", 8));
			Thread.sleep(2000);
			addartist.Enter_PhoneNumber(BaseClass.randamNumber());
			Thread.sleep(2000);
			addartist.Enter_TextInBio_AdditionalInformation(BaseClass.RandamString());
			Thread.sleep(2000);
			
			addartist.Click_Attachment_ImageFile();
			Thread.sleep(5000);
			addartist.clickAddArtistSubmit();
			Thread.sleep(5000);
			addartist.click_Confirm_Submition_Popup();
			Thread.sleep(5000);
			Assert.assertEquals(addartist.PopupSucessMessage(), "Artist added successfully!");
			addartist.click_Link_AboutArtists();
			Thread.sleep(2000);
			AboutArtistsPage aap=new AboutArtistsPage(driver);
			Assert.assertEquals(aap.Veify_new_artist_Added_in_about_artist_page(), ArtistName);
			System.out.println("Artistname matched and test case is passed");	
			
			
			
	} catch (Exception e) {
		
		System.out.println("New Artist not added in about artist page");

		Assert.fail();
}
		
	}
}
