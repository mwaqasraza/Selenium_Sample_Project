package com.digital.util;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverUtils {
    public static WebDriver getDriver() {
        WebDriver driver;
        String browser = System.getenv("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver =new  SafariDriver();
        } else {
            throw new RuntimeException("Unsupported browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}