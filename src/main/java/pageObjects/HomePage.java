package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
 @FindBy(xpath ="//h2[normalize-space()='The wall painting']")
 WebElement ClickThewallpainting;
 
 @FindBy(xpath ="//select[@id='sort']")
 WebElement ClickSortDropdown;
 
 @FindBy(xpath ="//a[normalize-space()='Add Artist']")
 WebElement Link_ClickAddArtist;
 
 @FindBy(xpath ="//a[normalize-space()='About Artists']")
 WebElement Link_AboutArtists;
 
 @FindBy(xpath ="//a[normalize-space()='Add Painting']")
 WebElement Link_AddPainting;

 @FindBy(xpath ="//div[@class='grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-4']/a/div[2]/h2")
 List<WebElement> AllArtPaintings;

 
 
 public void clickPiant()
 {
	 ClickThewallpainting.click();
 }
 
 
 public void clickSort()
 {
	 ClickSortDropdown.click();
 }
 
 public void ClickAddArtist_link()
 {
	 Link_ClickAddArtist.click();
 }

 public void ClickAboutArtists_link()
 {
	 Link_AboutArtists.click();
 }
 
 public void clickAddPainting_link()
 {
	 Link_AddPainting.click();
 }

 
 public String Veify_new_painting_Added_in_home_page()
	{
		String newpaintImage = null;
		for(WebElement aap:AllArtPaintings)
		{
			newpaintImage=aap.getText();
			if(newpaintImage.equalsIgnoreCase("testakb")) {
				
				System.out.println("New Artist " + newpaintImage +" got added successfully in Home Page ");
				
				break;
			}
		}return  newpaintImage;
	
	}
 
 
//xpath
	@FindBy(xpath="//select[@id='sort']")
	WebElement SortFiltr;
	@FindBy(xpath="//a[@class='group bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-xl transition-all duration-300']//p[2]")
	List<WebElement> ascendOrder;
	@FindBy(xpath="//a[@class='group bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-xl transition-all duration-300']//p[2]")
	List<WebElement> BeforeSorting;
	@FindBy(xpath="//input[@id='inspiration']")
	WebElement inspirtationTheme;
	@FindBy(xpath="//input[@id='medium']")
	WebElement medium;
	@FindBy(xpath="//select[@id='artist']")
	WebElement allArtist;
	@FindBy(xpath="//div[@class='absolute inset-0 bg-black/0 group-hover:bg-black/20 transition-all duration-300']")
	List<WebElement> artistResults;
	@FindBy(xpath="//button[normalize-space()='Apply']")
	WebElement applyBtn;
	@FindBy(xpath="//a[@aria-label='View The wall painting by Charan']//div[@class='relative w-full h-32 sm:h-36 lg:h-40']//div")
	WebElement product;
	@FindBy(xpath="//button[contains(text(),'I’m Interested in Buying')]")
	WebElement imInterested;
	@FindBy(xpath="//button[normalize-space()='Reset']")
	WebElement resetCta;
	@FindBy(xpath="//input[@id='name']")
	WebElement inputName;
	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmail;
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement inputSubmit;
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement inputCancel;
	@FindBy(xpath="//p[@class='text-sm text-gray-600 mb-6']")
	WebElement successMessage;
	@FindBy(xpath="//button[normalize-space()='Close']")
	WebElement closeCta;
	@FindBy(xpath="//a[normalize-space()='About Artists']")
	WebElement aboutArtistCTA;
	@FindBy(xpath="//a[normalize-space()='Loan Management']")
	WebElement loanManagementClick;
	
	@FindBy(xpath ="//p[@class='text-sm text-gray-600 mb-6']")
	WebElement successMessage1;
	

	public void srtFilterUsingDropdown()
	{
		try {
			List<Double> BeforeSortprices = new ArrayList<>();
			for (WebElement e : BeforeSorting)
			{
				BeforeSortprices.add(Double.valueOf(e.getText().replace("$", ""))) ;
			}
			Select sortDropdown = new Select(SortFiltr);
			sortDropdown.selectByValue("price-asc");
			List<Double> AfterSortprices = new ArrayList<>();
			for (WebElement e : ascendOrder)
			{
				AfterSortprices.add(Double.valueOf(e.getText().replace("$", ""))) ;
			}
			Collections.sort(BeforeSortprices);		
			Assert.assertEquals(BeforeSortprices, AfterSortprices);
			System.out.println("Prices are displaying in ascending order"+""+BeforeSortprices.equals(AfterSortprices));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void inpFiltervalues()
	{
		try {
			inspirtationTheme.sendKeys("Mt Everest");
			medium.sendKeys("oil");
			Select sortDropdown = new Select(allArtist);
			sortDropdown.selectByValue("6850f5ef13b0901f2dd8b794");
			applyBtn.click();
			System.out.println(artistResults.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resetCta.click();
	}
	public boolean navigatePdp()
	{
		product.click();
		try{
			imInterested.isDisplayed();
           return true;
       }
       catch(NoSuchElementException imInterested){
           return false;
       }
	}
	public void succsessMessageDisplay()
	{
		product.click();
		imInterested.click();
		inputName.sendKeys("test");
		inputEmail.sendKeys("test@yopmail.com");
		inputSubmit.click();
		String Actualmessage=successMessage.getText();
		String ExpectedMessage="Thank you! We’ll connect soon to discuss payment and delivery via FedEx.";
		Assert.assertEquals(Actualmessage,ExpectedMessage);
		closeCta.click();
	}
	public void successMessageNotDisplay()
	{
		product.click();
		imInterested.click();
		inputName.sendKeys("test");
		inputEmail.sendKeys("test@yopmail.com");
		inputCancel.click();
	    System.out.println("successfully clicked on Cancel CTA");
	}
	public boolean VerifySuccessmessageNotdisplayed()
	{

	  boolean status=successMessage1.isDisplayed();
	  return status;

	}

	
	public void aboutArtistClick()
	{
		aboutArtistCTA.click();
	}
	public void loanManagementClick()
	{
		loanManagementClick.click();
	}

 
}
