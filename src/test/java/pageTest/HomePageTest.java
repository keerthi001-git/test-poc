package pageTest;


import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class HomePageTest extends BaseClass{
	
	
		@Test(groups= {"Home", "Master", "Regression"}, enabled=false)
		public void TC001_verify_homepage_sort() throws InterruptedException
		{
			
			HomePage hp=new HomePage(driver);
			
			//hp.ClickOnSortFilter();
			Thread.sleep(2000);
			hp.srtFilterUsingDropdown();
			
			
		}
		@Test(groups= {"Home", "Master", "Regression"},enabled=false)
		public void TC002_verify_homepage_filterUsingInput()
		{
			HomePage hp=new HomePage(driver);
			hp.inpFiltervalues();
		}
		@Test(groups= {"Home", "Master", "Regression, sanity"},enabled=false)
		public void TC003_Verify_clickOnProduct_pdp()
		{
			HomePage hp=new HomePage(driver);
			hp.navigatePdp();
			driver.navigate().back();
		}
		
		@Test(groups= {"Home", "Master", "Regression"},enabled=false)
		public void TC004_Verify_successMessageDisplay_onShowInterest()
		{
			HomePage hp=new HomePage(driver);
			hp.succsessMessageDisplay();
			driver.navigate().back();
		}
		
		@Test(groups= {"Home", "Master", "Regression"},enabled=true)
		public void TC005_Verify_successMessageNotDisplay()
		{
			HomePage hp=new HomePage(driver);
			hp.successMessageNotDisplay();
			try {
				boolean ActualValue= hp.VerifySuccessmessageNotdisplayed();
				if(ActualValue) {
					System.out.println("Element is displayed");
				}
			}
			catch(NoSuchElementException e){
				System.out.println("Element is not displayed");
			}
			
			driver.navigate().back();
			
		}
	
	 
	 
	
	
	public void Verify_AddArtistPageisLoading() {
		HomePage hp=new HomePage(driver);
		logger.info(" click on add artist page");
		hp.ClickAddArtist_link();
		
		
	}

}
