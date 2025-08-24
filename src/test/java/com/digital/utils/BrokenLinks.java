package com.digital.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class BrokenLinks {
public static void findBrokenLinkOnUI(WebDriver driver, String webUrl, String directoryPath, String fileName) throws Exception{
String urlString = webUrl;
URL url;
String baseUrl;
List<WebElement> webElementList;
FileWriter writer = null;
WebElement webElement;
HttpURLConnection httpURLConnection;
Path filePath = Paths.get(directoryPath, fileName+".csv");
url = new URL(urlString);
baseUrl = url.getProtocol() + "://" + url.getHost();
webElementList = driver.findElements(By.tagName("a"));
if (Files.exists(filePath)) {
writer = new FileWriter(filePath.toString(),true);
} else {
// Create directories if they don't exist
Files.createDirectories(filePath.getParent());
// Create the file
Files.createFile(filePath);
writer = new FileWriter(filePath.toString(),true);
// Write header
writer.write("PageURL,Url,Status Code,Response Message\n");
}
for(int i=0; i<webElementList.size();i++) {
webElement = webElementList.get(i);
urlString = webElement.getDomAttribute("href");
if(urlString != null && urlString != "#" && !urlString.contains("https") && !urlString.contains("javascript")){
urlString = baseUrl+urlString;
}
try {
url = new URL(urlString);
httpURLConnection = (HttpURLConnection)url.openConnection();
httpURLConnection.setConnectTimeout(6000);
httpURLConnection.connect();
if(httpURLConnection.getResponseCode()>=400){
// Write data rows
writer.write(webUrl+ ","+url+ ","+httpURLConnection.getResponseCode()+","+httpURLConnection.getResponseMessage()+"\n");
}
else {
// Write data rows
writer.write(webUrl+ ","+url+ ","+httpURLConnection.getResponseCode()+","+httpURLConnection.getResponseMessage()+"\n");
}
}
catch (Exception e) {
writer.append(webUrl+ ","+urlString+ ",,"+e+"\n");
}
}
writer.close();
driver.quit();
}public static void loadWebPage(WebDriver driver,String webUrl){
driver.get(webUrl);
}public static void waitToResolveHumanCaptcha() throws InterruptedException{
Thread.sleep(20000);  //It is added due to given use case because on given web we've captcha which needs to be manually done OR bypass(not possible) OR automate through third party tool(not possible)
}
}