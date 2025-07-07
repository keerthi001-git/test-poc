package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutArtistsPage extends BasePage {

	public AboutArtistsPage(WebDriver driver) {
		super(driver);
		
	}
		
	@FindBy(xpath ="//div[@class='flex-1']/h2")
	 List<WebElement> AllArtistsNames;
	
	public String Veify_new_artist_Added_in_about_artist_page()
	{
		String newArtist = null;
		for(WebElement an:AllArtistsNames)
		{
			 newArtist=an.getText();
			if(newArtist.equalsIgnoreCase("ishita")) {
				
				System.out.println("New Artist " + newArtist +" got added successfully in About Artist Page ");
				
				break;
			}
		}return  newArtist;
	
	}
	
	//xpath
		@FindBy(xpath="//div[@class='flex-1']")
		List<WebElement> aboutArtistList;
		@FindBy(xpath="//div[@class='flex-1']//h2")
		List<WebElement> artistListname;
		
		public void countOfAllArtist()
		{
			System.out.println(aboutArtistList.size());
		}
		public void printListOfArtistNames()
		{
			List<String> artistNames = new ArrayList<>();
			for (WebElement e : artistListname)
			{
				artistNames.add(e.getText());
			}
			System.out.println(artistNames);
		}
	 
		
}

//@FindBy(xpath ="//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8']/div")
		// List<WebElement> AllArtists;
