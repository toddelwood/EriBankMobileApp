# EriBankMobileApp
Execute login test cases on ExperiBank App using Android Phone


EriBank Mobile Application

1. Install EriBank App for test automation
2. Install APK Info application (Defines the full path of targeted application)
3. Intellij (IDE): create Maven Project
4. Create Packages:
		.com.qa.pages
		.com.qa.utils
		.com.qa.testcases

5. Create Java Class files (EriBankPage, EriTest, and TestUtils)
		
6. Add Dependencies:  Goto mvnrepository.com website and search/copy dependency snipets for testNG, Selenium WebDriver, Appium

Update pom.xml file:

    <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>7.3.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>4.0.9</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>6.14.3</version>
        <scope>test</scope>
    </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.0.0</version>
            <scope>compile</scope>
        </dependency>
		
		
7. Install/Setup/Verify environment for Appium Studio

Detailed instructions for above will be included in another HowTo file.

