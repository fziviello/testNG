package com.academy.utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("TestNG suite output directory = "+ suite.getOutputDirectory());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("TestNG invoked methods = " + suite.getAllInvokedMethods());
    }

}
