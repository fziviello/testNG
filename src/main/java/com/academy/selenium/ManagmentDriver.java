package com.academy.selenium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;

import static com.academy.settings.GlobalParameters.*;

public class ManagmentDriver {

    private static ChromeDriver chromeDriver;

    private static RemoteWebDriver remoteWebDriver;
    private static AndroidDriver androidDriver;
    private static IOSDriver iosDriver;

    public static void startDriver(DefaultChromeOptions defaultChromeOptions){

        WebDriverManager.chromedriver().setup();

        chromeDriver = new ChromeDriver(defaultChromeOptions);

        System.setProperty("org.freemarker.loggerLibrary", "none");
        System.err.close();
        System.setErr(System.out);

        new Utility().loadProp("log4j");
        BasicConfigurator.configure();

    }

    public static void startRemoteDriver(URL url, ChromeOptions chromeOptions){

        remoteWebDriver = new RemoteWebDriver(url, chromeOptions);

        System.setProperty("org.freemarker.loggerLibrary", "none");
        System.err.close();
        System.setErr(System.out);

        new Utility().loadProp("log4j");
        BasicConfigurator.configure();
    }

    private static AppiumDriverLocalService getBuilder(){
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .usingPort(4723)
                .build();
        service.start();

        return service;
    }

    public static void startAndroidDriver(UiAutomator2Options options){
        androidDriver = new AndroidDriver(getBuilder().getUrl(), options);
    }

    public void startIosDriver(XCUITestOptions options){
        iosDriver = new IOSDriver(getBuilder().getUrl(), options);
    }

    public static ChromeDriver getChromeDriver(){
        return chromeDriver;
    }

    public static RemoteWebDriver getRemoteWebDriver(){
        return remoteWebDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static IOSDriver getIOSDriver() {
        return iosDriver;
    }

    public static Wait<ChromeDriver> getWaitChromeDriver() {
        return new FluentWait<>(chromeDriver)
                .withTimeout(WAIT_TIMEOUT)
                .pollingEvery(POLLING_EVERY)
                .ignoring(NoSuchElementException.class);
    }

    public Wait<AndroidDriver> getWaitAndroid() {
        return new FluentWait<AndroidDriver>(getAndroidDriver())
                .withTimeout(WAIT_TIMEOUT)
                .pollingEvery(POLLING_EVERY)
                .ignoring(NoSuchElementException.class);
    }

    public Wait<IOSDriver> getWaitIOSDriver() {
        return new FluentWait<IOSDriver>(getIOSDriver())
                .withTimeout(WAIT_TIMEOUT)
                .pollingEvery(POLLING_EVERY)
                .ignoring(NoSuchElementException.class);
    }

    public static void stopDriver(){
        if(remoteWebDriver !=null) remoteWebDriver.quit();
        if(chromeDriver !=null) chromeDriver.quit();
        if(androidDriver !=null) androidDriver.quit();
        if(iosDriver !=null) iosDriver.quit();
    }
}
