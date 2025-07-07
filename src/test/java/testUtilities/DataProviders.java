package testUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//DataProvider 1
	@DataProvider(name="AddArtistsData")
	public String [][] getData() throws IOException {
		
		String path=".\\TestData\\ArtVault_testdataexcel.xlsx";//taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); // creating an object for XLUtility
				
				int totalrows= xlutil.getRowCount("PhoneNumberFieldValidation");
				int totalcols=xlutil.getCellCount("PhoneNumberFieldValidation", 1);
				
				String AddArtistsData[][] = new String[totalrows][totalcols]; // created for two dimension array which can store
				
				for(int i=1; i<totalrows; i++)  //1 //read the data from xl storing in two dimensional array
				{
					for(int j=0; j<totalcols; j++)  //0 i is rows j is cols
					{
						AddArtistsData[i-1][j] = xlutil.getCellData("PhoneNumberFieldValidation", i, j);  //1,0
					}
				}
				return AddArtistsData;  // returning two dimension array
	
	}
	
	//DataProvider 2
	
	@DataProvider(name="RequiredFieldData")
	public String [][] getDataRequired() throws IOException {
		
		String path=".\\TestData\\ArtVault_testdataexcel.xlsx";//taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); // creating an object for XLUtility
				
				int totalrows= xlutil.getRowCount("REquiredFieldValidation");
				int totalcols=xlutil.getCellCount("REquiredFieldValidation", 1);
				
				String RequiredFieldData[][] = new String[totalrows][totalcols]; // created for two dimension array which can store
				
				for(int i=1; i<=totalrows; i++)  //1 //read the data from xl storing in two dimensional array
				{
					for(int j=0; j<totalcols; j++)  //0 i is rows j is cols
					{
						RequiredFieldData[i-1][j] = xlutil.getCellData("REquiredFieldValidation", i, j);  //1,0
					}
				}
				return RequiredFieldData;  // returning two dimension array
	
	}
	
	//DataProvider 3
	@DataProvider(name="EmailFieldData")
	public String [][] getDataForEmailField() throws IOException {
		
		String path=".\\TestData\\ArtVault_testdataexcel.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path); 
				
				int totalrows= xlutil.getRowCount("EmailPattrenValidation");
				int totalcols=xlutil.getCellCount("EmailPattrenValidation", 1);
				
				String EmailFieldData[][] = new String[totalrows][totalcols]; 
				
				for(int i=1; i<=totalrows; i++)  
				{
					for(int j=0; j<totalcols; j++)  
					{
						EmailFieldData[i-1][j] = xlutil.getCellData("EmailPattrenValidation", i, j);  
					}
				}
				return EmailFieldData;  // returning two dimension array
	
	}
	//DataProvider 4
	@DataProvider(name="AddPaintRequiredFieldData")
	public String [][] getDataRequired1() throws IOException {
		
		String path=".\\TestData\\ArtVault_testdataexcel.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path); 
				
				int totalrows= xlutil.getRowCount("RequiredFieldValidationAddPaint");
				int totalcols=xlutil.getCellCount("RequiredFieldValidationAddPaint", 1);
				
				String AddPaintRequiredFieldData[][] = new String[totalrows][totalcols]; 
				
				for(int i=1; i<=totalrows; i++)  
				{
					for(int j=0; j<totalcols; j++)  
					{
						AddPaintRequiredFieldData[i-1][j] = xlutil.getCellData("RequiredFieldValidationAddPaint", i, j);  
					}
				}
				return AddPaintRequiredFieldData;  // returning two dimension array
	
	}
	
	
	//DataProvider 5
		@DataProvider(name="AddPaintPriceData")
		public String [][] getDataRequired2() throws IOException {
			
			String path=".\\TestData\\ArtVault_testdataexcel.xlsx";
			
			ExcelUtility xlutil=new ExcelUtility(path); 
					
					int totalrows= xlutil.getRowCount("AddPaintPriceFieldValidation");
					int totalcols=xlutil.getCellCount("AddPaintPriceFieldValidation", 1);
					
					String AddPaintPriceData[][] = new String[totalrows][totalcols]; 
					
					for(int i=1; i<=totalrows; i++)  
					{
						for(int j=0; j<totalcols; j++)  
						{
							AddPaintPriceData[i-1][j] = xlutil.getCellData("AddPaintPriceFieldValidation", i, j);  
						}
					}
					return AddPaintPriceData;  // returning two dimension array
		
		}
		

		//DataProvider 6
			@DataProvider(name="AddPaintYearData")
			public String [][] getDataRequired3() throws IOException {
				
				String path=".\\TestData\\ArtVault_testdataexcel.xlsx";
				
				ExcelUtility xlutil=new ExcelUtility(path); 
						
						int totalrows= xlutil.getRowCount("AddPaintYearFieldValidation");
						int totalcols=xlutil.getCellCount("AddPaintYearFieldValidation", 1);
						
						String AddPaintYearData[][] = new String[totalrows][totalcols]; 
						
						for(int i=1; i<=totalrows; i++)  
						{
							for(int j=0; j<totalcols; j++)  
							{
								AddPaintYearData[i-1][j] = xlutil.getCellData("AddPaintYearFieldValidation", i, j);  
							}
						}
						return AddPaintYearData;  // returning two dimension array
			
			}
			
			//DataProvider 7
			@DataProvider(name="AddPaintingValidData")
			public String [][] getDataRequired4() throws IOException {
				
				String path=".\\TestData\\ArtVault_testdataexcel.xlsx";
				
				ExcelUtility xlutil=new ExcelUtility(path); 
						
						int totalrows= xlutil.getRowCount("AddPaintingData");
						int totalcols=xlutil.getCellCount("AddPaintingData", 1);
						
						String AddPaintingValidData[][] = new String[totalrows][totalcols]; 
						
						for(int i=1; i<=totalrows; i++)  
						{
							for(int j=0; j<totalcols; j++)  
							{
								AddPaintingValidData[i-1][j] = xlutil.getCellData("AddPaintingData", i, j);  
							}
						}
						return AddPaintingValidData;  // returning two dimension array
			
			}
		
	
}
