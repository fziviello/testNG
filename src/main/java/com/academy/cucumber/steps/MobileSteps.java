package com.academy.cucumber.steps;

import com.academy.selenium.ManagmentDriver;
import com.academy.selenium.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import java.io.File;
import java.util.Properties;
import static com.academy.settings.GlobalParameters.*;

public class MobileSteps {

    private Properties androidProp = null;
    private AndroidDriver androidDriver;

    @Given("^I launch Android mobile app$")
    public void launchApp(){

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(RESOURCES_PATH +  File.separator + "app" + EXT_ANDROID)
                .eventTimings();

        ManagmentDriver.startAndroidDriver(options);

        androidDriver = ManagmentDriver.getAndroidDriver();

        androidProp = new Utility().loadProp("android");
    }

    @Given("^insert user (.*) and password (.*)$")
    public void insertUserAndPsw(String user, String psw){
        androidDriver.findElement(By.id(androidProp.getProperty("app.id.username"))).sendKeys(user);
        androidDriver.findElement(By.id(androidProp.getProperty("app.id.psw"))).sendKeys(psw);
    }

    @Given("^click Login button$")
    public void clickBtnLogin() {
        androidDriver.findElement(By.id(androidProp.getProperty("app.id.btn.login"))).click();
    }

    @Then("^close App$")
    public void closeApp() {
        androidDriver.closeApp();
        ManagmentDriver.stopDriver();
    }

}
