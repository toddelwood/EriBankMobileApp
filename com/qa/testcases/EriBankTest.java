package com.qa.testcases;

import com.qa.pages.EriBankLoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class EriBankTest {

    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    //Future Step: Add step to pull from XML file
    private final static boolean testInvalidUserNameLogin=true;
    private final static boolean testInvalidPasswordLogin=true;


    @BeforeMethod
    public void setUp() throws MalformedURLException {

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "EriBank";

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(priority=1,enabled=testInvalidUserNameLogin)
    public void testInvalidUserNameLogin() {

        EriBankLoginPage eriBank = new EriBankLoginPage(driver);
        String username = "baduser";
        String password = "welcome1";
        eriBank.setUserName(username);
        eriBank.setPassword(password);
        eriBank.clickLoginButton();
        eriBank.verifyLoginErrorMessage();
    }

    @Test(priority = 2, enabled=testInvalidPasswordLogin)
    public void testInvalidPasswordLogin() {

        EriBankLoginPage eriBank = new EriBankLoginPage(driver);
        String username = "guest";
        String password = "badpassword";
        eriBank.setUserName(username);
        eriBank.setPassword(password);
        eriBank.clickLoginButton();
        eriBank.verifyLoginErrorMessage();
    }


    @Test(enabled=false)
    public void testEriBank() {

    }
}