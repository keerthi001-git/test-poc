package pageTest;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddPaintingPage;
import pageObjects.HomePage;
import testUtilities.DataProviders;

public class AddPaintingPageTest extends BaseClass {

	
	@Test (dataProvider="AddPaintRequiredFieldData", dataProviderClass=DataProviders.class, enabled=true)
	public void TC07_verify_Required_Field_Validation(String title, String artist, String Dimensions, String Medium,
			String PriceField, String CreationYearField, String inspirationTheme, String exp) {

		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddPainting_link();
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.Enter_text_in_titleField(title);
			addPaint.select_Artist_from_dropdown(artist);
		
			Thread.sleep(5000);
			addPaint.Enter_text_in_DimensionsField(Dimensions);
			addPaint.Enter_text_in_MediumField(Medium);
			addPaint.Enter_text_in_PriceField(PriceField);
			addPaint.enter_year_in_CreationYearField(CreationYearField);
			addPaint.enter_text_in_InspirationThemeField(inspirationTheme);
			addPaint.upload_image_in_imageField();
			Thread.sleep(5000);
			addPaint.click_on_AddPaintingButton();
			boolean Actualrequired = addPaint.addPaintingRequiredField_ValidationMessag();

			if (exp.equalsIgnoreCase("Invalid")) {

				if (Actualrequired == true) {

					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
				addPaint.click_on_ResetFormButton();
			}

			/*
			 * try { boolean ActualValue=
			 * addPaint.verify_ConfirmSubmission_PopupMessage_isNotDisplayed();
			 * if(ActualValue) {
			 * 
			 * System.out.println("Element is displayed"); } } catch(NoSuchElementException
			 * e){
			 * 
			 * System.out.println("Element is not displayed"); }
			 * System.out.println("Start11");
			 */

			/*
			 * System.out.println("ActualValue"); Assert.assertEquals(ActualValue, true);
			 */
			// addPaint.verify_ConfirmSubmission_PopupMessage();

		} catch (Exception e) {
			System.out.println("unable to validated Add Painting required field message");
			Assert.fail();
		}

	}
	
	@Test (dataProvider="AddPaintPriceData", dataProviderClass=DataProviders.class, enabled=true)
	public void TC08_verify_PriceField_Validation(String title, String artist, String Dimensions, String Medium,
			String PriceField, String CreationYearField, String inspirationTheme, String exp) {

		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddPainting_link();
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.Enter_text_in_titleField(title);
			addPaint.select_Artist_from_dropdown(artist);
			
			Thread.sleep(5000);
			addPaint.Enter_text_in_DimensionsField(Dimensions);
			addPaint.Enter_text_in_MediumField(Medium);
			addPaint.Enter_text_in_PriceField(PriceField);
			Thread.sleep(5000);
			addPaint.enter_year_in_CreationYearField(CreationYearField);
			addPaint.enter_text_in_InspirationThemeField(inspirationTheme);
			addPaint.upload_image_in_imageField();
			Thread.sleep(5000);
			addPaint.click_on_AddPaintingButton();
			boolean ActualemailID=addPaint.price_ValidationMessag();
								
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
			System.out.println("unable to validated price field invalid input price message");
			Assert.fail();
		}

	}
	
	
	@Test (dataProvider="AddPaintYearData", dataProviderClass=DataProviders.class, enabled=true)
	public void TC09_verify_CreationYearField_Validation(String title, String artist, String Dimensions, String Medium,
			String PriceField, String CreationYearField, String inspirationTheme, String exp) {

		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddPainting_link();
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.Enter_text_in_titleField(title);
			
			addPaint.select_Artist_from_dropdown(artist);
			
			Thread.sleep(5000);
			addPaint.Enter_text_in_DimensionsField(Dimensions);
			addPaint.Enter_text_in_MediumField(Medium);
			addPaint.Enter_text_in_PriceField(PriceField);
			addPaint.enter_year_in_CreationYearField(CreationYearField);
			Thread.sleep(5000);
			addPaint.enter_text_in_InspirationThemeField(inspirationTheme);
			addPaint.upload_image_in_imageField();
			Thread.sleep(5000);
			addPaint.click_on_AddPaintingButton();
			

			boolean ActualemailID=addPaint.year_ValidationMessag();
								
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
			System.out.println("unable to validated creation year field invalid input year message");
			Assert.fail();
		}

	}
	

	

	@Test(dataProvider="AddArtistAddPaintingData", dataProviderClass=DataProviders.class, enabled = true)
	public void TC00011_Verify_entered_data_should_be_removed_from_the_fields_when_the_user_click_on_reset_form_CTA(
			String title, String artist, String Dimensions, String Medium, String PriceField, String CreationYearField,
			String inspirationTheme, String exp) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddPainting_link();
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.Enter_text_in_titleField(title);
			addPaint.select_Artist_from_dropdown(artist);
			Thread.sleep(5000);
			addPaint.Enter_text_in_DimensionsField(Dimensions);
			addPaint.Enter_text_in_MediumField(Medium);
			addPaint.Enter_text_in_PriceField(PriceField);
			addPaint.enter_year_in_CreationYearField(CreationYearField);
			addPaint.enter_text_in_InspirationThemeField(inspirationTheme);
			addPaint.upload_image_in_imageField();
			Thread.sleep(5000);
			addPaint.click_on_AddPaintingButton();
			addPaint.click_on_ResetFormButton();
		

			if (addPaint.get_text_from_TitleField().isEmpty() && addPaint.get_text_from_DimensionsField().isEmpty()
					&& addPaint.get_text_from_MediumField().isEmpty() && addPaint.get_text_from_PriceField().isEmpty()
					&& addPaint.get_text_from_CreationYearField().isEmpty()
					&& addPaint.get_text_from_InspirationThemeField().isEmpty()) {
				System.out.println("All fields are empty!!");
				System.out.println("TestCase00011_ResetForm_Test case is pass");

			} else {
				System.out.println("TestCase00011_ResetForm_Test case is Failed");
			}
					} catch (Exception e) {
			System.out.println("unable to clear the form fields");

		}

	}

	@Test(dataProvider="AddArtistAddPaintingData",dataProviderClass=DataProviders.class, enabled = true)
	public void TC00012_Verify_New_paining_can_be_added_from_add_painting_page(String title, String artist,
			String Dimensions, String Medium, String PriceField, String CreationYearField, String inspirationTheme,
			String exp) {

		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddPainting_link();
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.Enter_text_in_titleField(title);
			addPaint.select_Artist_from_dropdown(artist);
			
			Thread.sleep(5000);
			addPaint.Enter_text_in_DimensionsField(Dimensions);
			addPaint.Enter_text_in_MediumField(Medium);
			addPaint.Enter_text_in_PriceField(PriceField);
			addPaint.enter_year_in_CreationYearField(CreationYearField);
			addPaint.enter_text_in_InspirationThemeField(inspirationTheme);
			addPaint.upload_image_in_imageField();
			Thread.sleep(5000);
			addPaint.click_on_AddPaintingButton();
			addPaint.click_on_AddPaintingButton();
			addPaint.click_on_AddPainting_ConfirmButton();
			String ActualText = addPaint.PopupSucessMessage_in_addPaintingPage();
			System.out.println(ActualText);
			String ExpectedText = " ";
			addPaint.click_Ok_on_success_Popup_in_addPaintingPage();
		

			/*
			 * Thread.sleep(5000); String
			 * ActualErrorTitle=addartist.verifyerrorPopup_title(); String
			 * ExpectedErrorTitle = "Validation Error";
			 * Assert.assertEquals(ActualErrorTitle, ExpectedErrorTitle);
			 * System.out.println("Title is matched");
			 * 
			 * System.out.println("Error pop up is closed");
			 */

		} catch (Exception e) {
			System.out.println("unable to Add new Painting");
			Assert.fail();
		}

	}

	@Test (dataProvider="AddArtistAddPaintingData",dataProviderClass=DataProviders.class, enabled = false)
	public void TC005_Verify_Newly_added_Painting_is_displayed_in_Home_page() {
		try {
			AddPaintingPage addPaint = new AddPaintingPage(driver);
			addPaint.click_on_homeLink();
			HomePage hp = new HomePage(driver);
			String ExpectedNewArt = "Animi";
			Assert.assertEquals(hp.Veify_new_painting_Added_in_home_page(), ExpectedNewArt);
			System.out.println(" New Art image is displayed in home page and art name matched and test case is passed");

		} catch (Exception e) {

			System.out.println("New Art Image not added in Home page");

			Assert.fail();
		}
	}

}
