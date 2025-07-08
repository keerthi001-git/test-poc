# Automation_ArtVault

ArtVault is a Datadriven automation testing framework to support web testing of ArtVault application built on Java Platform.

This repository contains an advanced Page Object Model (POM) based automation framework developed using Java and Selenium WebDriver for functional UI testing. The target web application is ArtVault.
The framework uses Maven (pom.xml) as the build tool and dependency manager, and is integrated with TestNG for test execution and suite management. Extent Reports is used for generating detailed and visually rich test reports. 

🛠️ Tech Stack & Tools Used: Programming Language: Java
Testing Framework: TestNG  DataDriven
Automation Tool: Selenium WebDriver
Design Pattern: Page Object Model (POM)
Build Tool: Maven (pom.xml)
Reporting: Extent Reports
Version Control: Git & GitHub
ArtVault - https://agreeable-island-08eca9200.6.azurestaticapps.net/

## 1. Clone the repo

Clone the Repo-: https://github.com/keerthi001-git/test-poc

Checkout bdd_framework branch
git checkout master

## 2. Install testng for eclipse

## 3. Update the maven project

Ensure the jar file is there in the lib folder. Update the maven project so that this jar is available in the local .m2 folder.

## 4. JRE Verssion

Check the JRE version. It should be 11.

## 5. Define Maven Run Configuration

  Define Run Configuration of type maven. 
  e.g. mvn clean test 

## 6. Run test through configuration

On Running the above configuration, the test should start executing. After execution report should be available in reports folder.

## Framework Structure:-

src/main/java      
   - PageObjects   	    
      
src/main/resources  
src/test/java   
    - PageTest 
    - testUtilities 
 
src/test/resources     
     - log4j.xml
configs
      - checkstyle
      - Configuration.properties	{contains env specific information} 
logs
      - log trace
reports
      - Output Extent Report
     
screenshots
      - failed step screenshots
    
target      
       - surefire reports
       - generated sources
       - generated test sources
       - maven-status
TestData        
       - images (contains upload images)	  
       - ArtVault Test Data	{contains xlsx static lookup data}   
	
test-output
       - emailable-report.html
crossbrowsertestng.xml
testng.xml
pom.xml
