package com.petClinic.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Utils {

    public static String getOperatingSystemType() {
        String detectedOS;
        String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) {
            detectedOS = "macOS";
        } else if (os.indexOf("nux") >= 0) {
            detectedOS = "unix";
        } else {
            detectedOS = "windows";
        }
        return detectedOS;
    }

    public static WebDriver initDriver() {
        String actualOperationSystem = getOperatingSystemType();
        switch (actualOperationSystem) {
            case "macOS":
                System.setProperty("webdriver.chrome.driver,", ".\\drivers\\chromedriver_mac");
                break;
            case "unix":
                System.setProperty("webdriver.chrome.driver,", ".\\drivers\\chromedriver_unix");
                break;
            case "windows":
                System.setProperty("webdriver.chrome.driver,", ".\\drivers\\chromedriver_win.exe");
                break;
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(2500, 1800));
        return driver;
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static String clearString(String stringToClear) {
        stringToClear = stringToClear.replaceAll("\n", "");
        stringToClear = stringToClear.trim();
        return stringToClear;
    }

    public static String dateFormat(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(date);
    }
}
