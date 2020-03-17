package com.qa.testcases;

import com.qa.pages.AndroidCalcApp;
import com.qa.testdata.CalcTestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.testng.annotations.*;
import java.net.URL;
import java.util.logging.Level;


public class AndroidCalcTest {

    private AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    private final static boolean runCalcAdditionDataSet = true;
    private final static boolean runCalcSubtractionDataSet=false;
    private final static boolean runCalcSubtraction=false;
    private final static boolean runCalcMultiplication=false;
    private final static boolean runCalcAddition=false;



    @BeforeMethod
    public void setUp() throws MalformedURLException {

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "CalculatorPlus";

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "4439364a4a573398");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sec.android.app.popupcalculator");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Calculator");
        //dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sec.android.app.popupcalculator");
        //dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(enabled=runCalcSubtraction)
    @Parameters({"num1","num2","expectedResult"})
    public void testCalcSubtraction(String num1, String num2, String expectedResult) {

        AndroidCalcApp calcApp = new AndroidCalcApp(driver);
        calcApp.pressNum1(num1);
        calcApp.pressSubtraction();
        calcApp.pressNum2(num2);
        calcApp.pressEqual();

        String output = calcApp.getCalcResult();

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        Assert.assertEquals(output, expectedResult,err);

    }


    @Test(priority=1,enabled=runCalcMultiplication)
    @Parameters({"num1","num2","expectedResult"})
    public void testCalcMultiplication(String num1, String num2, String expectedResult) {

        AndroidCalcApp calcApp = new AndroidCalcApp(driver);
        calcApp.pressNum1(num1);
        calcApp.pressMultiplication();
        calcApp.pressNum2(num2);
        calcApp.pressEqual();

        String output = calcApp.getCalcResult();

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        Assert.assertEquals(output, expectedResult,err);
    }


    @Test(enabled=runCalcAddition,priority=2)
    @Parameters({"num1","num2","expectedResult"})
    public void testCalcAddition(String num1, String num2, String expectedResult) {

        AndroidCalcApp calcApp = new AndroidCalcApp(driver);
        calcApp.pressNum1(num1);
        calcApp.pressAddition();
        calcApp.pressNum2(num2);
        calcApp.pressEqual();

        String output = calcApp.getCalcResult();

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        Assert.assertEquals(output, expectedResult,err);

    }


    @Test(enabled=runCalcAdditionDataSet, priority=2, dataProvider = "dataAddition",dataProviderClass = CalcTestData.class)
    public void testCalcAdditionDataSet(String num1, String num2, String expectedResult) {

        AndroidCalcApp calcApp = new AndroidCalcApp(driver);
        calcApp.pressNum1(num1);
        calcApp.pressAddition();
        calcApp.pressNum2(num2);
        calcApp.pressEqual();

        String output = calcApp.getCalcResult();

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        ///Assert.assertEquals(Integer.parseInt(output), expectedResult,err);
        Assert.assertEquals(output,expectedResult,err);
    }


    @Test(enabled=runCalcSubtractionDataSet, dataProvider = "dataSubtraction",dataProviderClass = CalcTestData.class)
    public void testCalcSubtractionDataSet(String num1, String num2, String expectedResult) {

        AndroidCalcApp calcApp = new AndroidCalcApp(driver);
        calcApp.pressNum1(num1);
        calcApp.pressSubtraction();
        calcApp.pressNum2(num2);
        calcApp.pressEqual();

        String output = calcApp.getCalcResult();

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        Assert.assertEquals(output, expectedResult,err);
    }




    /*

        driver.findElement(By.xpath("//*[@text='7']")).click();
        driver.findElement(By.xpath("//*[@text='8']")).click();
        driver.findElement(By.xpath("//*[@text='9']")).click();
        driver.findElement(By.xpath("//*[@text='4']")).click();
        driver.findElement(By.xpath("//*[@text='5']")).click();
        driver.findElement(By.xpath("//*[@text='6']")).click();
        driver.findElement(By.xpath("//*[@text='1']")).click();
        driver.findElement(By.xpath("//*[@text='2']")).click();
        driver.findElement(By.xpath("//*[@text='3']")).click();
        driver.findElement(By.xpath("//*[@text='×']")).click();
        driver.findElement(By.xpath("//*[@text='÷']")).click();
        driver.findElement(By.xpath("//*[@text='−']")).click();
        driver.findElement(By.xpath("//*[@text='+']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();

        System.out.println("Total array size " + data.length);
        System.out.println(data[0][0]);
        System.out.println(data[0][1]);

        System.out.println(data[1][0]);
        System.out.println(data[1][1]);

        driver.findElement(By.xpath("//*[@text='9']")).click();
        driver.findElement(By.xpath("//*[@text='×']")).click();
        driver.findElement(By.xpath("//*[@text='8']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();


        //calcApp.setNum1(num1);
        //String[] calc = calcApp.getNum1();
        //for (String arrCalc: calc) {
        //    driver.findElement(By.xpath("//*[@text='" + arrCalc + "']")).click();
            //System.out.println("Array of ".concat(arrCalc));
        //}

        //driver.findElement(By.xpath("//*[@text='" + num1 + "']")).click();

        driver.findElement(By.xpath("//*[@text='" + num2 + "']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();

        //Retrieve output
        String output = driver.findElement(By.xpath("//*[@id='calc_edt_formula']")).getText();


        driver.findElement(By.xpath("//*[@text='" + num1 + "']")).click();
        driver.findElement(By.xpath("//*[@text='+']")).click();
        driver.findElement(By.xpath("//*[@text='" + num2 + "']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();
        String output = driver.findElement(By.xpath("//*[@id='calc_edt']")).getText();
        //id = *[@id='calc_edt']

        System.out.println("Output: " + output);
        String err = "Error: Calculated value " + output + " does not match expected value of " + expectedResult;
        Assert.assertEquals(Integer.parseInt(output), expectedResult,err);



        driver.findElement(By.xpath("//*[@text='" + num1 + "']")).click();
        driver.findElement(By.xpath("//*[@text='−']")).click();
        driver.findElement(By.xpath("//*[@text='" + num2 + "']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();

        String output = driver.findElement(By.xpath("//*[@id='calc_edt_formula']")).getText();


        driver.findElement(By.xpath("//*[@text='" + num1 + "']")).click();
        //driver.findElement(By.xpath("//*[@text='-']")).click();
        driver.findElement(By.xpath("//*[@text='−']")).click();
        driver.findElement(By.xpath("//*[@text='" + num2 + "']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();

        //Retrieve output
        String output = driver.findElement(By.xpath("//*[@id='calc_edt_formula']")).getText();


    /*
    @Test
    @Parameters({"num1","num2"})
    public void testCalculatorPlus(double num1, double num2) {
        //driver.findElement(By.xpath("//*[@id='iconview_imageView' and ./parent::*[@contentDescription='Calculator']]")).click();
        driver.findElement(By.xpath("//*[@text='" + num1 + "']")).click();
        driver.findElement(By.xpath("//*[@text='1']")).click();
        driver.findElement(By.xpath("//*[@text='" + num2 + "']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();
    }


    @Test(enabled=false)
    public void testCalculatorPlus() {
        System.out.println("Executing testCalculatorPlus test method\n");
        driver.findElement(By.xpath("//*[@text='8']")).click();
        driver.findElement(By.xpath("//*[@text='+']")).click();
        driver.findElement(By.xpath("//*[@text='8']")).click();
        driver.findElement(By.xpath("//*[@text='=']")).click();
    }


    //protected Object[][] data;
    //private int arrSize = 10;




    */



}
