package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoanManagementPage extends BasePage {

	public LoanManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	//xpath
		@FindBy(xpath="//select[@class='w-full px-4 py-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition-all duration-200']")
		WebElement paintDropdown;
		@FindBy(xpath="//input[@placeholder='Enter exhibition name']")
		WebElement exhibitionName;
		@FindBy(xpath="//input[@type='date']")
		WebElement date;
		@FindBy(xpath="//button[normalize-space()='Loan Painting']")
		WebElement loanPaintingBtn;
		@FindBy(xpath="//button[normalize-space()='Confirm']")
		WebElement confirmBtn;
		@FindBy(xpath="//p[@class='text-lg text-green-700 mb-6']")
		WebElement painConfirmMessage;
		@FindBy(xpath="//button[normalize-space()='OK']")
		WebElement okBtn;
		@FindBy(xpath="//table[@class='min-w-full divide-y divide-gray-200']//tbody//tr")
		List<WebElement> tableData;
		@FindBy(xpath="//table[@class='min-w-full divide-y divide-gray-200']//tbody//tr//td[2]")
		List<WebElement> artistData;
		@FindBy(xpath="//table[@class='min-w-full divide-y divide-gray-200']//tbody//tr//td[5]")
		List<WebElement> statusData;
		@FindBy(xpath="//button[@class='text-indigo-600 hover:text-indigo-800 font-medium transition-colors duration-200'][text()='Return']")
		WebElement returnBtn;
		@FindBy(xpath="//button[normalize-space()='Confirm']")
		WebElement confrmBtn;
		@FindBy(xpath="//button[normalize-space()='OK']")
		WebElement okBton;
		@FindBy(xpath="//p[@class='text-lg text-green-700 mb-6']")
		WebElement returnMessage;
		@FindBy(xpath="//button[@class='text-indigo-600 hover:text-indigo-800 font-medium transition-colors duration-200'][text()='Loan']")
		WebElement loanBtn;
		@FindBy(xpath="//button[normalize-space()='OK']")
		WebElement errorokBton;
		@FindBy(xpath="//p[@class='text-lg text-red-700 mb-6']")
		WebElement errorMessage;

		public void loanPainting() throws InterruptedException
		{
			Select paintDropdownlist = new Select(paintDropdown);
			Thread.sleep(2000);
			paintDropdownlist.selectByValue("686293bb9b5e90bc3b806356");
			Thread.sleep(2000);
			exhibitionName.sendKeys("testaccount");
			date.sendKeys("17/06/2025");
			loanPaintingBtn.click();
			confirmBtn.click();
			String Actualpaintmessage=painConfirmMessage.getText();
			String ExpectPaintMessage="Painting loaned successfully!";
			Assert.assertEquals(Actualpaintmessage,ExpectPaintMessage);
			okBtn.click();
			}
		public void returnLoanedPainting()
		{
			System.out.println(tableData.size());
			int rowSize=tableData.size();
			for(int r=1;r<=rowSize;r++)
			{
				String artistNames=artistData.get(r).getText();
				String artistStatus=statusData.get(r).getText();
				String comp="Loaned";
				boolean returnStatus=returnBtn.isEnabled();
				if(artistStatus.equals(comp) && returnStatus)
				{
					returnBtn.click();
					confrmBtn.click();
					String Actualreturnmessage=returnMessage.getText();
					String ExpectreturnMessage="Painting returned successfully!";
					Assert.assertEquals(Actualreturnmessage,ExpectreturnMessage);
					okBton.click();
					break;
				}
			}
		}
		public void errorValidationForreturned()
		{
			System.out.println(tableData.size());
			int rowSize=tableData.size();
			for(int r=1;r<=rowSize;r++)
			{
				String artistNames=artistData.get(r).getText();
				String artistStatus=statusData.get(r).getText();
				String comp="Returned";
				boolean loanStatus=loanBtn.isEnabled();
				if(artistStatus.equals(comp) && loanStatus)
				{
					loanBtn.click();
			        String Actualloanerrormessage=errorMessage.getText();
					String ExpectloanerrorMessage="Please provide both an exhibition name and a return date.";
					Assert.assertEquals(Actualloanerrormessage,ExpectloanerrorMessage);
					errorokBton.click();
					break;
				}
			}
		}

}
