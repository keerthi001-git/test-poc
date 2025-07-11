package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPaintingPage extends BasePage {

	public AddPaintingPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@placeholder='Enter painting title']")
	WebElement Text_Title;

	@FindBy(xpath = "//select[@class='w-full px-4 py-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition-all duration-200']")
	WebElement SelectDropdown_Artist;

	@FindBy(xpath = "//input[@placeholder='e.g., 20x30 in']")
	WebElement Text_Dimensions;

	@FindBy(xpath = "//input[@placeholder='e.g., Oil on Canvas']")
	WebElement Text_Medium;

	@FindBy(xpath = "//input[@placeholder='Enter price']")
	WebElement Text_Price;

	@FindBy(xpath = "//input[@placeholder='Enter year']")
	WebElement Text_CreationYear;

	@FindBy(xpath = "//textarea[@placeholder='Describe the inspiration or theme']")
	WebElement TextArea_InspirationTheme;

	@FindBy(xpath = "//input[@type='file']")
	WebElement FileUpload_Image;

	@FindBy(xpath = "//button[normalize-space()='Add Painting']")
	WebElement Button_AddPainting;

	@FindBy(xpath = "//button[normalize-space()='Reset Form']")
	WebElement Button_ResetForm;

	@FindBy(xpath = "//h2[normalize-space()='Confirm Submission']")
	WebElement PopupMessage_ConfirmSubmission;

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement Button_AddPainting_Confirm;

	@FindBy(xpath = "//p[@class='text-lg text-green-700 mb-6']")
	WebElement Popup_SucessMessage;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement Button_Sucesspopup_ok;
	
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement Link_Home;
	

	public void Enter_text_in_titleField(String title) {

		Text_Title.sendKeys(title);
	}

	public void select_Artist_from_dropdown(String artist) {

		Select select = new Select(SelectDropdown_Artist);
		//List<WebElement> optionList = select.getOptions();
		//if (optionList.equals("Ishita")) {

			select.selectByVisibleText(artist);
		//}
	}

	public void Enter_text_in_DimensionsField(String dimension) {

		Text_Dimensions.sendKeys(dimension);
	}

	public void Enter_text_in_MediumField(String medium) {

		Text_Medium.sendKeys(medium);
	}

	public void Enter_text_in_PriceField(String price) {

		Text_Price.sendKeys(price);
	}

	public void enter_year_in_CreationYearField(String year) {

		Text_CreationYear.sendKeys(year);
	}
	
	/*
	 * public void enter_year_in_InvalidCreationYearField() {
	 * 
	 * Text_CreationYear.sendKeys("808"); }
	 */

	public void enter_text_in_InspirationThemeField(String inspirationTheme) {

		TextArea_InspirationTheme.sendKeys(inspirationTheme);
	}

	public void upload_image_in_imageField() {

		FileUpload_Image.sendKeys(System.getProperty("user.dir")+"\\TestData\\images\\pexels-ekrulila-3246665.jpg");

	}

	public void click_on_AddPaintingButton() {

		Button_AddPainting.click();
	}

	public void click_on_ResetFormButton() {

		Button_ResetForm.click();
	}

	public String verify_ConfirmSubmission_PopupMessage() {

		String confirmSubmission = PopupMessage_ConfirmSubmission.getText();
		return confirmSubmission;
	}

	public void click_on_AddPainting_ConfirmButton() {

		Button_AddPainting_Confirm.click();
	}

	public String PopupSucessMessage_in_addPaintingPage() {
		String PopupSucessMessage = Popup_SucessMessage.getText();

		return PopupSucessMessage;
	}

	public void click_Ok_on_success_Popup_in_addPaintingPage() {
		Button_Sucesspopup_ok.click();
	}

	// Reset Form Validation methods
	public String get_text_from_TitleField() {
		String title = Text_Title.getAttribute("value");

		return title;
	}

	public String get_text_from_artistField() {
		String artist = SelectDropdown_Artist.getText();

		return artist;
	}

	public String get_text_from_DimensionsField() {
		String Dimensions = Text_Dimensions.getAttribute("value");

		return Dimensions;
	}

	public String get_text_from_MediumField() {
		String Medium = Text_Medium.getAttribute("value");

		return Medium;
	}

	public String get_text_from_PriceField() {
		String Price = Text_Price.getAttribute("value");

		return Price;
	}

	public String get_text_from_CreationYearField() {
		String CreationYearField = Text_CreationYear.getAttribute("value");

		return CreationYearField;
	}

	public String get_text_from_InspirationThemeField() {
		String InspirationThemeField = TextArea_InspirationTheme.getAttribute("value");

		return InspirationThemeField;
	}

	// confirmation popup is not displayed
	public Boolean verify_ConfirmSubmission_PopupMessage_isNotDisplayed() {

		Boolean confirmationpopup = PopupMessage_ConfirmSubmission.isDisplayed();
		return confirmationpopup;
	}

	//click on home menu
	public void click_on_homeLink() {

		Link_Home.click();
	}
	
 public boolean addPaintingRequiredField_ValidationMessag() {
		 
		 if(Text_Title.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Title);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
		 }else if(SelectDropdown_Artist.getText()=="Select an artist") {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", SelectDropdown_Artist);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				
			 }
		 }else if(Text_Medium.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Medium);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				
			 }
			 
		 }else if(Text_Dimensions.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Dimensions);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
			 
		 }else if(Text_Price.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Price);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
			 
		 }else if(Text_CreationYear.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_CreationYear);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
		 }else if(TextArea_InspirationTheme.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", TextArea_InspirationTheme);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
		 
	 }
		return true;
	 } 
	
 
 	public boolean price_ValidationMessag() {
	 
	
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Price);
	 if(validationMessage.contains("Value must be greater than or equal to 1."))
	 {
		 System.out.print(validationMessage);
		
	 }return true;

}
 
	public boolean year_ValidationMessag() {
		 
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Price);
		 if(validationMessage.contains("Value must be greater than or equal to 1800."))
		 {
			 System.out.print(validationMessage);
			
		 }return true;

	}
}
