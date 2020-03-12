package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EriBankLoginPage {

    protected AndroidDriver<AndroidElement> appDriver = null;

    private By usernameID = By.xpath("//*[@id='usernameTextField']");
    private By passwordID = By.xpath("//*[@id='passwordTextField']");
    private By loginButton = By.xpath("//*[@id='loginButton']");
    private By errorMessage = By.xpath("//*[@id='message']");
    private static final String LOGIN_ERR_MESSAGE = "Invalid username or password!";


    public EriBankLoginPage(AndroidDriver driver) {
        appDriver=driver;
    }


    public void setUserName(String userName) {
        try {
            appDriver.findElement(usernameID).sendKeys(userName);
        } catch (Exception err) {
            TestUtils.reportError(err);
        }


    }

    public void setPassword(String password) {

        try {
            appDriver.findElement(passwordID).sendKeys(password);
        } catch (Exception err) {
            TestUtils.reportError(err);
        }

    }

    public void clickLoginButton() {

        try {
            appDriver.findElement(loginButton).click();
        } catch (Exception err) {
            TestUtils.reportError(err);
        }
    }


    public void verifyLoginErrorMessage() {

        WebElement msgExists;
        String errMessage=null;

        msgExists = appDriver.findElement(errorMessage);
        if (msgExists.isDisplayed()) {
            errMessage=msgExists.getText();
        }
        Assert.assertEquals(errMessage, LOGIN_ERR_MESSAGE,LOGIN_ERR_MESSAGE);
    }

}