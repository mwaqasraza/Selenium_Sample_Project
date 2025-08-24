package com.digital.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class DynamicContentValidator {
    private enum dynamicContentTags {
        IMG, UL, LI, A, P, BUTTON, VIDEO, AUDIO, TH, TD
    }
    private static final String DISPLAY_NONE = "display: none";
    private static final String VISIBILITY_HIDDEN = "visibility: hidden";
    private static final String OPACITY_ZERO = "opacity: 0";
    private static final String HEIGHT_ZERO = "height: 0";
    private static final String WIDTH_ZERO = "width: 0";
    private static final String JAVASCRIPT_PREFIX = "javascript:";
    private static final String HASH_PREFIX = "#";
    private static final String MAILTO_PREFIX = "mailto:";
    private static final String TEL_PREFIX = "tel:";
    private static final String FTP_PREFIX = "ftp:";
    private static final String TEXT_ERROR = "Error";
    private static final String TEXT_NOT_FOUND = "Not Found";
    private static final String TEXT_EMPTY = " ";
    // Extensions
    private static final String[] VIDEO_EXTENSIONS = {"mp4", "webm", "ogg", "avi", "mov", "mkv", "flv", "wmv"};
    private static final String[] AUDIO_EXTENSIONS = {"mp3", "wav", "ogg", "aac", "flac", "m4a", "wma", "opus"};
    private static final String[] IMAGE_EXTENSIONS = {"jpg", "png", "gif", "svg"};

    // Utility Methods
    private static boolean isNotHidden(String style) {
        return !style.contains(DISPLAY_NONE)
                && !style.contains(VISIBILITY_HIDDEN)
                && !style.contains(OPACITY_ZERO)
                && !style.contains(HEIGHT_ZERO)
                && !style.contains(WIDTH_ZERO);
    }
    private static boolean hasInvalidText(String text) {
        return text == null || text.isEmpty() || TEXT_EMPTY.equals(text)
                || TEXT_ERROR.equalsIgnoreCase(text)
                || TEXT_NOT_FOUND.equalsIgnoreCase(text);
    }
    private static boolean hasInvalidValue(String value) {
        return value == null || value.isEmpty() || TEXT_EMPTY.equals(value)
                || TEXT_ERROR.equalsIgnoreCase(value)
                || TEXT_NOT_FOUND.equalsIgnoreCase(value);
    }
    private static boolean hasInvalidSrc(String src, String tagName) {
        boolean isSrcInValid = false;
        if(src == null || src.isEmpty() || src.startsWith("javascript:") || src.startsWith("#")){
            return true;
        }
        else {
            if ("img".equalsIgnoreCase(tagName)) {
                if(!Arrays.asList(src).contains(IMAGE_EXTENSIONS)){
                    isSrcInValid = true;
                }
            }
            else if ("video".equalsIgnoreCase(tagName)) {
                if(!Arrays.asList(src).contains(VIDEO_EXTENSIONS)){
                    isSrcInValid = true;
                }
            }
            else if ("audio".equalsIgnoreCase(tagName)) {
                if(!Arrays.asList(src).contains(AUDIO_EXTENSIONS)){
                    isSrcInValid = true;
                }
            }
        }

        return isSrcInValid;
    }
    private static boolean hasInvalidHref(String href) {
        return href == null || href.isEmpty()
                || href.startsWith(JAVASCRIPT_PREFIX)
                || href.startsWith(HASH_PREFIX)
                || href.startsWith(MAILTO_PREFIX)
                || href.startsWith(TEL_PREFIX)
                || href.startsWith(FTP_PREFIX);
    }
    public static class ConfigReader {
        private static final Properties properties = new Properties();
        static {
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("scriptingaccelerator/config.properties")) {
                if (input == null) {
                    throw new RuntimeException("config.properties not found in classpath");
                }
                properties.load(input);
            } catch (IOException ex) {
                throw new RuntimeException("Failed to load config.properties", ex);
            }
        }
        public static String get(String key) {
            return properties.getProperty(key);
        }
    }
    public static void validateDynamicContent(String webUrl, WebDriver driver) throws Exception {
        String directoryPathForCsv="src/main/resources/BrokenDynamicContent/";
        String fileName="BrokenDynamicContent";
        String directoryPathForScreenshot = "src/main/resources/Screenshot/";
        boolean screenshot = true;
        validateDynamicContent(driver, webUrl, directoryPathForCsv, fileName, directoryPathForScreenshot, screenshot);
    }
        public static void validateDynamicContent(WebDriver driver, String webUrl, String directoryPathForCsv, String fileName, String directoryPathForScreenshot, boolean screenshot) throws IOException {
            driver.get(webUrl);
            String text = null, value = null, src = null, href = null, tagName = null, classAttr = null, idAttr = null, type = null;
            boolean hasNotImage, hasNotSvg;
            int highlightedCount = 0;
            FileWriter writer = null;
            Path filePath = Paths.get(directoryPathForCsv, fileName+".csv");
            if (Files.exists(filePath)) {
                writer = new FileWriter(filePath.toString(),true);
            } else {
                // Create directories if they don't exist
                Files.createDirectories(filePath.getParent());
                // Create the file
                Files.createFile(filePath);
                writer = new FileWriter(filePath.toString(),true);
                // Write header
                writer.write("Tag Name,id,class,src,type,href,text,value\n");
            }
            for (dynamicContentTags tag : dynamicContentTags.values()) {
                List<WebElement> elements = driver.findElements(By.tagName(String.valueOf(tag)));
                for (WebElement element : elements) {
                    if (element.isDisplayed()) {
                        text = element.getText().trim();
                        value = element.getAttribute("value");
                        src = element.getAttribute("src");
                        href = element.getAttribute("href");
                        type = element.getAttribute("type");
                        tagName = element.getTagName();
                        hasNotImage = element.findElements(By.tagName("img")).isEmpty();
                        hasNotSvg = element.findElements(By.tagName("svg")).isEmpty();
                        classAttr = element.getAttribute("class");
                        idAttr = element.getAttribute("id");
                        if ("p".equalsIgnoreCase(tagName) || "li".equalsIgnoreCase(tagName) || "ul".equalsIgnoreCase(tagName) || "td".equalsIgnoreCase(tagName) || "th".equalsIgnoreCase(tagName) || "button".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if(hasNotSvg && hasNotImage) {
                                    if (hasInvalidText(text)) {
                                        writer.write(tagName+","+idAttr+","+classAttr+",-,-,-,"+text+",-\n");
                                        if(screenshot) {
                                            highlightElement(element, "#FF0000", driver);
                                            highlightedCount++;
                                        }
                                    }
                                }
                            }
                        }
                        if ("text".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if (hasInvalidValue(value)) {
                                    writer.write(tagName+","+idAttr+","+classAttr+",-,-,-,-,"+value+"\n");
                                    if(screenshot) {
                                        highlightElement(element, "#FF0000", driver);
                                        highlightedCount++;
                                    }
                                }
                            }
                        }
                        if ("video".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if (hasInvalidSrc(src,"video")) {
                                    writer.write(tagName+","+idAttr+","+classAttr+","+src+","+type+",-,-,-\n");
                                    if(screenshot) {
                                        highlightElement(element, "#FF0000", driver);
                                        highlightedCount++;
                                    }
                                }
                            }
                        }
                        if ("audio".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if (hasInvalidSrc(src,"audio")) {
                                    writer.write(tagName+","+idAttr+","+classAttr+","+src+","+type+",-,-,-\n");
                                    if(screenshot) {
                                        highlightElement(element, "#FF0000", driver);
                                        highlightedCount++;
                                    }
                                }
                            }
                        }
                        if ("a".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if (hasInvalidHref(href)) {
                                    writer.write(tagName+","+idAttr+","+classAttr+",-,-,"+href+",-,-\n");
                                    if(screenshot) {
                                        highlightElement(element, "#FF0000", driver);
                                        highlightedCount++;
                                    }
                                }
                            }
                        }
                        if ("img".equalsIgnoreCase(tagName)) {
                            if (isNotHidden(element.getAttribute("style"))) {
                                if (hasInvalidSrc(src,"image")) {
                                    writer.write(tagName+","+idAttr+","+classAttr+","+src+",-,"+href+",-,-\n");
                                    if(screenshot) {
                                        highlightElement(element, "#FF0000", driver);
                                        highlightedCount++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            writer.close();
            if (screenshot && highlightedCount > 0) {
                try {
                    takeFullPageScreenshot(directoryPathForScreenshot, driver);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            driver.quit();
        }
    private static void highlightElement(WebElement element, String color, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.border='4px solid " + color + "';" +
                        "arguments[0].style.padding='4px';" +
                        "arguments[0].style.borderRadius='8px';", element);
    }
    private static void takeFullPageScreenshot(String directoryPath, WebDriver driver) throws Exception {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File outputDir = new File(directoryPath);
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }
        ImageIO.write(screenshot.getImage(), "PNG", new File(outputDir, timestamp + ".png"));
    }
}