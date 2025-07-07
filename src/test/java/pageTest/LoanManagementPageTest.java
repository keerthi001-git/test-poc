package pageTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoanManagementPage;

public class LoanManagementPageTest extends BaseClass {
	
		@Test
		public void TC001_loanPaintingCreation() throws InterruptedException
		{
			HomePage hp=new HomePage(driver);
			LoanManagementPage lmang=new LoanManagementPage(driver);
			hp.loanManagementClick();
			lmang.loanPainting();
		}
		@Test(enabled=false)
		public void TC002_returnLoanPainting() throws InterruptedException
		{
			HomePage hp=new HomePage(driver);
			LoanManagementPage lmang=new LoanManagementPage(driver);
			hp.loanManagementClick();
			lmang.returnLoanedPainting();
		}
		@Test(enabled=false)
		public void TC003_errorValidation_ReturnedImages()
		{
			HomePage hp=new HomePage(driver);
			LoanManagementPage lmang=new LoanManagementPage(driver);
			hp.loanManagementClick();
			lmang.errorValidationForreturned();
		}

	

}
