package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


public class AndroidCalcApp {

    protected AndroidDriver<AndroidElement> appDriver = null;
    private double num1;
    private double num2;
    private String[] arrNum1;
    private String[] arrNum2;



    public AndroidCalcApp(AndroidDriver driver) {

        appDriver=driver;

    }

    public boolean clickKey(String key) {

        String arrKey[] = key.split("");
        for (String arr: arrKey) {

        }
        appDriver.findElement(By.xpath("//*[@text='" + key + "']")).click();

        return true;
    }

    public String[] getNum1() {
        return arrNum1;
    }

    public String[] getNum2() {
        if (arrNum1.length == 0) {
            throw new IllegalStateException("Error: arrNum1 contains NO data.");
        }
        return arrNum2;
    }

    public void setNum1(String num1) {
        arrNum1 = num1.split("");
    }

    public void setNum2(String num2) {
        arrNum2 = num2.split("");
    }


    public void pressNum1(String num1) {

        arrNum1 = num1.split("");
        for (String arrCalcNum: arrNum1) {
            appDriver.findElement(By.xpath("//*[@text='" + arrCalcNum + "']")).click();
            //System.out.println("Array of ".concat(arrCalc));
        }
    }

    public void pressNum2(String num2) {

        arrNum2 = num2.split("");
        for (String arrCalcNum : arrNum2) {
            appDriver.findElement(By.xpath("//*[@text='" + arrCalcNum + "']")).click();
            //System.out.println("Array of ".concat(arrCalc));
        }
    }

    public void pressMultiplication() {
        appDriver.findElement(By.xpath("//*[@text='×']")).click();
    }

    public void pressDivision() {
        appDriver.findElement(By.xpath("//*[@text='/']")).click();
    }

    public void pressAddition() {
        appDriver.findElement(By.xpath("//*[@text='+']")).click();
    }

    public void pressSubtraction() {
        appDriver.findElement(By.xpath("//*[@text='−']")).click();
    }

    public void pressEqual() {
        appDriver.findElement(By.xpath("//*[@text='=']")).click();
    }

    public String getCalcResult() {
        String output;
        output = appDriver.findElement(By.xpath("//*[@id='calc_edt_formula']")).getText();
        return output;
    }


}
