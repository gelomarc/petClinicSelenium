package com.petClinic.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Utils {

    public static WebDriver initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
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
