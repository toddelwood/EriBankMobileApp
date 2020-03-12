package com.qa.utils;

public class TestUtils {


    public static void reportError(Exception err) {
        System.out.println("**** Reported Error ****");
        System.out.println("<<Method Name>> ".concat(Thread.currentThread().getStackTrace()[2].getMethodName()));
        System.out.println("<<Error Message>> ".concat(err.getMessage()));
    }

}
