package com.digital.utils;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.mobile.NetworkConnection;

import java.time.Duration;

public class WebDriverUtils {
    public static WebDriver getDriver() {
        WebDriver driver;
        String browser = "chrome";
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver =new  SafariDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }else {
            throw new RuntimeException("Unsupported browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}