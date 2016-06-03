#### README ####

* This Webdriver project demonstrates design and development of functional test using  page object pattern.

### Features covered ###  

1. Get car quote on http://sydneytesters.herokuapp.com/.
2. Buy Insurance.

### HOW To RUN THE TEST ### 

* Right click pom.xml and select Run As -> Maven test.
* Alternatively, Right click testng.xml (src/main/resources/testng.xml) and 
  select Run As -> TestNG Suite.

### Project details ###

It's a maven project with testng.xml test suite added as a dependency to pom.xml.File testng.xml has two test classes and input test data configured.Tests can be configured to run on either Firefox or Chrome.

### Test Classes ###  

CarPageTests.java and PaymentPageTest.java

### Dependency ###
All the dependency like Webdriver.jar and ChromeDriver.exe are bundled in lib/ dir