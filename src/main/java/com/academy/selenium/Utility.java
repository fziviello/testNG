package com.academy.selenium;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

import static com.academy.settings.GlobalParameters.*;

public class Utility {

    public Properties loadProp(String propName){
        String appConfigPath = PROPERTIES_PATH + File.separator + propName + ".properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getBase64Screenshot() {
        try {
            SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
            String sDate = oSDF.format(new Date());
            String encodedBase64 = null;
            FileInputStream fileInputStream = null;
            String destination = "";
            File source = null;

            source = ((TakesScreenshot) ManagmentDriver.getChromeDriver()).getScreenshotAs(OutputType.FILE);
            destination = SCREENSHOT_PATH  +  File.separator + File.separator + sDate + EXT_PNG;

            File finalDestination = new File(destination);
            FileUtils.copyFile(Objects.requireNonNull(source), finalDestination);

            try {
                fileInputStream = new FileInputStream(finalDestination);
                byte[] bytes = new byte[(int) finalDestination.length()];
                int fileSize = fileInputStream.read(bytes);
                encodedBase64 = new String(Base64.encodeBase64(bytes));

            } catch (FileNotFoundException ex) {
                Assert.fail("Errore: "+ ex.getMessage());
            } finally {
                if(fileInputStream != null) fileInputStream.close();
            }
            return "data:image/png;base64," + encodedBase64;
        } catch (Exception ex) {
            Assert.fail("Errore: "+ ex.getMessage());
        }
        return null;
    }

    public void getScreenshot(){
        try {
            SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
            String sDate = oSDF.format(new Date());
            byte[] imageBytes = ((TakesScreenshot)ManagmentDriver.getChromeDriver()).getScreenshotAs(OutputType.BYTES);
            Files.write(Paths.get(SCREENSHOT_PATH +"/" + sDate + ".png"), imageBytes);
        } catch (IOException ex) {
            Assert.fail("Errore: "+ ex.getMessage());
        }
    }

}
