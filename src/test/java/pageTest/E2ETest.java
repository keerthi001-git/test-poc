package pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddArtistPage;
import pageObjects.AddPaintingPage;
import pageObjects.HomePage;

public class E2ETest extends BaseClass{
	
	@Test
	public void verify_User_able_add_artist_and_Add_painting_and_see_the_newly_added_painting_in_homepage() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
		hp.ClickAddArtist_link();
		Thread.sleep(2000);
		AddArtistPage addartist = new AddArtistPage(driver);
		String artistName = BaseClass.RandamString();
		addartist.Enter_Name(artistName);
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
		System.out.println("Testcase003 is passed");
		addartist.clickAddPainting_link();
		AddPaintingPage addPaint = new AddPaintingPage(driver);
		String PaintingTitleName= "testakb";
		addPaint.Enter_text_in_titleField(PaintingTitleName);
		System.out.println("Start2");
		addPaint.select_Artist_from_dropdown(artistName);
		System.out.println("Start3");
		addPaint.Enter_text_in_DimensionsField(BaseClass.generateRandomdimention());
		System.out.println("Start4");
		addPaint.Enter_text_in_MediumField(BaseClass.RandomMedium());
		System.out.println("Start5");
		addPaint.Enter_text_in_PriceField(BaseClass.randamPrice());
		System.out.println("Start6");
		addPaint.enter_year_in_CreationYearField(BaseClass.RandomYearGenerator());
		System.out.println("Start7");
		addPaint.enter_text_in_InspirationThemeField(BaseClass.RandamString());
		System.out.println("Start8");
		addPaint.upload_image_in_imageField();
		System.out.println("Start9");
		addPaint.click_on_AddPaintingButton();
		System.out.println("Start10");
		addPaint.click_on_AddPainting_ConfirmButton();
		System.out.println("Start11");
		String ActualText= addPaint.PopupSucessMessage_in_addPaintingPage();
		System.out.println("Start12");
		System.out.println(ActualText);
		System.out.println("Start13");
		String ExpectedText =" ";
		System.out.println("Start14");
		addPaint.click_Ok_on_success_Popup_in_addPaintingPage();
		System.out.println("Start15");
		addPaint.click_on_homeLink();
	//a	HomePage hp=new HomePage(driver); 
		String ExpectedNewArt = PaintingTitleName;
		Assert.assertEquals(hp.Veify_new_painting_Added_in_home_page(), ExpectedNewArt);
		System.out.println(" New Art image is displayed in home page and art name matched and test case is passed");	
		
	}
	

}
