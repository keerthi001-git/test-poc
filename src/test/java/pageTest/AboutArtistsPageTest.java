package pageTest;

import org.testng.annotations.Test;

import pageObjects.AboutArtistsPage;
import pageObjects.HomePage;

public class AboutArtistsPageTest extends BaseClass {
	
	@Test (groups= {"AboutArtist", "Master", "Regression"})
	public void TC001_verify_aboutArtistCount() throws InterruptedException 
	{
		HomePage hp=new HomePage(driver);
		hp.aboutArtistClick();
		AboutArtistsPage Art=new AboutArtistsPage(driver);
		Art.countOfAllArtist();
	}
	@Test(groups= {"AboutArtist", "Master", "Regression"})
	public void TC002_aboutArtist_PrintAllArtistNames()
	{
		HomePage hp=new HomePage(driver);
		AboutArtistsPage Art=new AboutArtistsPage(driver);
		hp.aboutArtistClick();
		Art.printListOfArtistNames();
	}
	
	

}
