package testUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
	
	int counter =1;
	int maxRetry=2;

	@Override
	public boolean retry(ITestResult result) {
		
		if (counter <= maxRetry) {
			
			counter++;
			return true;
		
		}
		return false;
	}

}
