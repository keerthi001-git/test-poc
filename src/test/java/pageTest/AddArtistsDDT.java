package pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddArtistPage;
import pageObjects.HomePage;
import testUtilities.DataProviders;

public class AddArtistsDDT extends BaseClass {
	
	@Test(dataProvider="AddArtistsData", dataProviderClass=DataProviders.class) //getting data provider from different class
	public void verify_AddArtisDDT(String name, String email, String phoneNumber, String bio, String exp ) throws InterruptedException {

		//logger.info( "verify_AddArtisDDT test start ");
		
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
			 
			boolean ActualErrorTitle=addartist.verifyerrorPopup_titleisExists();
			// String ExpectedErrorTitle = "Validation Error";
			//Assert.assertEquals(ActualErrorTitle, ExpectedErrorTitle);
			//System.out.println("Title is matched");
			 
			 
			 if(exp.equalsIgnoreCase("invalid")) {
				 
				 if(ActualErrorTitle==true)
				 {
					 addartist.clickOkButton();
					 addartist.clickResetFormSubmit();
					 Assert.assertTrue(true);
					
					 
				 }
				 else {
					 Assert.assertTrue(false);
				 }
			 }
				
			
		} catch (Exception e) {
			System.out.println("unable to verify error message");
			Assert.fail();
		}
			//logger.info( "verify_AddArtisDDT test start ");
	
	}

}
