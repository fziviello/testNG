package com.academy.other;

import com.academy.selenium.ManagmentDriver;
import com.academy.selenium.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.io.File;
import java.util.Properties;

import static com.academy.settings.GlobalParameters.*;
import static com.academy.settings.TestGroups.*;

public class Test_MOBILE_001 {

    private static ExtentTest extentTest;
    private static ExtentReports extentReports;
    private static Properties androidProp = null;
    private static AndroidDriver androidDriver;

    @BeforeClass
    static void beforeAll() {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(RESOURCES_PATH +  File.separator + "app" + EXT_ANDROID)
                .eventTimings();

        ManagmentDriver.startAndroidDriver(options);

        androidDriver = ManagmentDriver.getAndroidDriver();

        extentReports = new ExtentReports(REPORT_PATH + File.separator + "Report_Mobile.html", false);
        extentReports.loadConfig(new File(REPORT_CONFIG_XML));
        androidProp = new Utility().loadProp("android");
    }

    @BeforeGroups(groups = { MOBILE })
    void beforeGroups() {
        beforeAll();
    }

    @BeforeMethod
    void beforeEach() { }

    @Test(testName = "Login", groups = { MOBILE })
    void TEST_001() {

        extentTest = extentReports.startTest("TEST_001");

        androidDriver.findElement(By.id(androidProp.getProperty("app.id.username"))).sendKeys("admin");
        extentTest.log(LogStatus.INFO, "username: admin");
        androidDriver.findElement(By.id(androidProp.getProperty("app.id.psw"))).sendKeys("admin");
        extentTest.log(LogStatus.INFO, "psw: admin");
        androidDriver.findElement(By.id(androidProp.getProperty("app.id.btn.login"))).click();
        extentTest.log(LogStatus.INFO, "Eseguo la Login");

        extentTest.log(LogStatus.PASS, "PASSED");

    }

    @AfterMethod
    void tearDown() {
        extentReports.endTest(extentTest);
    }

    @AfterClass
    static void tearDownAll() {
        ManagmentDriver.stopDriver();
        extentReports.flush();
    }

    @AfterGroups(groups = { MOBILE })
    void afterGroups() {
        tearDownAll();
    }
}
