package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddArtistPage extends BasePage {

	public AddArtistPage(WebDriver driver) {
		super(driver);
		
	}
	
		
	@FindBy(xpath ="//input[@placeholder=\"Enter artist's name\"]")
	 WebElement Text_Name;
	
	@FindBy(xpath ="//input[@type='email']")
	 WebElement Text_email;
	
	
	@FindBy(xpath ="//input[@placeholder='Enter phone (e.g., +1234567890)']")
	 WebElement Text_PhoneNumber;
	
	
	@FindBy(xpath ="//textarea[@placeholder='Write a short bio about the artist']")
	 WebElement Text_AdditionalInformation_Bio;
	
	
	@FindBy(xpath ="//input[@type='file']")  //input[@type='file'] //input[@accept='image/*'] // //"input[type='file']"
	 WebElement Attachment_ImageChooseFile;
	
	
	@FindBy(xpath ="//button[normalize-space()='Add Artist']")
	 WebElement Button_AddArtistSubmit;
	
	
	@FindBy(xpath ="//button[normalize-space()='Reset Form']")
	 WebElement Button_ResetFormSubmit;
	
	
	@FindBy(xpath ="//h2[normalize-space()='Validation Error']")
	 WebElement popupText_ErrorTitle;
	
	@FindBy(xpath ="//p[@class='text-lg text-red-700 mb-6']")
	 WebElement popupText_ErrorDescription;
	
	@FindBy(xpath ="//button[normalize-space()='OK']")
	 WebElement popupButton_ok;
	
	@FindBy(xpath ="//h2[normalize-space()='Confirm Submission']")
	 WebElement Popup_ConfirmSubmission;
	
	@FindBy(xpath ="//button[normalize-space()='Confirm']")
	 WebElement Button_ConfirmSubmission;
	
	@FindBy(xpath ="//h2[normalize-space()='Success']")
	 WebElement Popup_Sucess;
	
	@FindBy(xpath ="//p[@class='text-lg text-green-700 mb-6']")
	 WebElement Popup_SucessMessage;
	
	@FindBy(xpath ="//button[normalize-space()='OK']")
	 WebElement Button_Sucesspopup_ok;
	
	@FindBy(xpath ="//a[normalize-space()='About Artists']")
	 WebElement Link_AboutArtists;
	
	 @FindBy(xpath ="//a[normalize-space()='Add Painting']")
	 WebElement Link_AddPainting;
	 public void clickAddPainting_link()
	 {
		 Link_AddPainting.click();
	 }

	
	
	 public void Enter_Name(String name)
	 {
		 Text_Name.sendKeys(name);
	 }
	 
	 
	 public void Enter_emailId(String email)
	 {
		 Text_email.sendKeys(email);
	 }
	 
	 public void Enter_InvalidPhoneNumber(String phoneNumber)
	 {
		 Text_PhoneNumber.sendKeys(phoneNumber);
	 }
	 
	 public void Enter_PhoneNumber(String phoneNumber1)
	 {
		 Text_PhoneNumber.sendKeys(phoneNumber1);
	 }
	 
	 public void Enter_TextInBio_AdditionalInformation(String bio)
	 {
		 Text_AdditionalInformation_Bio.sendKeys(bio);
	 }

	 
	 public void Click_Attachment_ImageFile()
	 {
		 Attachment_ImageChooseFile.sendKeys(System.getProperty("user.dir")+"\\TestData\\images\\Art Image1.jpg"); 
		 // Attachment_ImageChooseFile.sendKeys("C:\\Users\\ake\\Downloads\\Art Image1.jpg");
		
		 		 
	 }
	 
	 
	 public void clickAddArtistSubmit()
	 {
		 Button_AddArtistSubmit.click();
	 }
	 
	 
	 public void clickResetFormSubmit()
	 {
		 Button_ResetFormSubmit.click();
	 }
	 
	 public String verifyerrorPopup_title()
	 {
		String errotTitle =popupText_ErrorTitle.getText();
		return errotTitle;
	 }
	 
	 public boolean verifyerrorPopup_titleisExists()
	 {
		 boolean errotTitleisExists =popupText_ErrorTitle.isDisplayed();
		return true;
	 }
	 
	 public String verifyerrorPopup_description()
	 {
		 String errotDescrip = popupText_ErrorDescription.getText();
		return errotDescrip;
	 }
	 
	 public void clickOkButton()
	 {
		 popupButton_ok.click();
	 }


	 
	 public String get_text_from_nameField()
	 {
		 String  name=Text_Name.getAttribute("value");
		
		return name;
	 }
	 
	 public String get_text_from_EmailField()
	 {
		 String  emailID=Text_email.getAttribute("value");
		
		return emailID;
	 }
	 
	 public String get_text_from_PhoneField()
	 {
		 String  phoneNumber=Text_PhoneNumber.getAttribute("value");
		
		return phoneNumber;
	 }
	 
	 
	 public String get_text_from_Submitionpopup()
	 {
		 String submissionpopuptext=Popup_ConfirmSubmission.getText();
		
		return submissionpopuptext;
	 }
	 
	 public boolean verify_from_Submitionpopup_isDisplayed()
	 {
		 boolean submissionpopuptext=Popup_ConfirmSubmission.isDisplayed();
		
		return true;
	 }
	 
	 public void click_Confirm_Submition_Popup()
	 {
		 Button_ConfirmSubmission.click();
	 }
	 
	 public String PopupSucessMessage()
	 {
		 String PopupSucessMessage=Popup_SucessMessage.getText();
		
		return PopupSucessMessage;
	 }
	 
	 public void click_Ok_on_success_Popup()
	 {
		 Button_Sucesspopup_ok.click();
	 }
	 
	 public void click_Link_AboutArtists()
	 {
		 Link_AboutArtists.click();
	 }

	 
	 public boolean requiredField_ValidationMessag() {
		 
		 if(Text_Name.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_Name);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
		 }else if(Text_email.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_email);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				
			 }
		 }else if(Text_PhoneNumber.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_PhoneNumber);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				
			 }
			 
		 }else if(Text_AdditionalInformation_Bio.getText().isEmpty()) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_AdditionalInformation_Bio);
			 if(validationMessage.contains("Please fill out this field"))
			 {
				 System.out.print(validationMessage);
				 
			 }
			 
		 }
		return true;
	 } 
		 public boolean emailID_ValidationMessag() {
			 
				
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_email);
			 if(validationMessage.contains("Please include an '@' in the email address."))
			 {
				 System.out.print(validationMessage);
				
			 }return true;
		 
	 }
	 
	
	 
	// Assuming 'emailField' is your WebElement for the input
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", Text_email);
	// System.out.println("Retrieved Validation Message: " + validationMessage);


	



	
}
