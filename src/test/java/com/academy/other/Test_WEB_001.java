package com.academy.other;

import com.academy.selenium.DefaultChromeOptions;
import com.academy.selenium.ManagmentDriver;
import com.academy.selenium.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import static com.academy.settings.GlobalParameters.*;
import static com.academy.settings.TestGroups.*;

public class Test_WEB_001 {

    private ExtentTest extentTest;
    private ExtentReports extentReports;
    private Properties webProp = null;
    private WebDriver driver;

    private RemoteWebDriver remoteWebDriver;
    private DefaultChromeOptions defaultChromeOptions;

    private boolean useSelenoid = false;

    @BeforeClass
    void beforeAll() {
        System.out.println("BEFORE CLASS");

        extentReports = new ExtentReports(REPORT_PATH + File.separator + "index.html", true);
        extentReports.loadConfig(new File(REPORT_CONFIG_XML));
        webProp = new Utility().loadProp("web");

        if(useSelenoid) {

            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("browserVersion", "102.0");
            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("name", "Test Web 001");
                put("enableVNC", true);
                put("enableVideo", false);
            }});

            try {
                ManagmentDriver.startRemoteDriver(new URL(webProp.getProperty("selenoid.host")), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            remoteWebDriver = ManagmentDriver.getRemoteWebDriver();
        }
        else{
            defaultChromeOptions = new DefaultChromeOptions(new ChromeOptions());

            defaultChromeOptions.addArguments("--kiosk");
            //defaultChromeOptions.addArguments("--window-size=375,812");
            //defaultChromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148");

            ManagmentDriver.startDriver(defaultChromeOptions);

            driver = ManagmentDriver.getChromeDriver();
        }

    }

    @BeforeGroups(groups = { WEB })
    void beforeGroups() {
        System.out.println("BEFORE GROUPS");
        beforeAll();
    }

    @BeforeMethod
    void beforeEach() { System.out.println("BEFORE EACH"); }

    @Test(testName = "Open Google", groups = { WEB })
    void TEST_001() {
        extentTest = extentReports.startTest("TEST_001");

        driver.get(webProp.getProperty("google.url"));

        extentTest.log(LogStatus.INFO, "INFO");
        extentTest.log(LogStatus.PASS, "PASSED");
        extentTest.log(LogStatus.FAIL,"StepName", extentTest.addBase64ScreenShot(new Utility().getBase64Screenshot()) + "Test Failed");
    }

    @Test(testName = "Take Screenshot", groups = { WEB })
    void TEST_002() {
        extentTest.log(LogStatus.PASS,"google.com", extentTest.addBase64ScreenShot(new Utility().getBase64Screenshot()) + "google.com");
    }

    @Test(testName = "Close PopUp", groups = { WEB })
    void TEST_003() {
        driver.findElement(By.id((webProp.getProperty("google.popUp.id")))).click();
    }

    @Test(testName = "Search", groups = { WEB })
    void TEST_004() {
        driver.findElement(By.cssSelector((webProp.getProperty("google.input.css")))).sendKeys("Fabio Ziviello");
    }

    @AfterMethod
    void tearDown() {
        System.out.println("AFTER EACH");
        extentReports.endTest(extentTest);
    }

    @AfterClass
    void tearDownAll() {
        System.out.println("AFTER CLASS");
        ManagmentDriver.stopDriver();
        extentReports.flush();
    }

    @AfterGroups(groups = { WEB })
    void afterGroups() {
        System.out.println("AFTER GROUPS");
        tearDownAll();
    }
}
