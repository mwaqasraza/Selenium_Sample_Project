package com.digital.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    public static String readAnyPropertyFile(String propFileName, String propertyName) throws IOException {
        Properties prop = new Properties();
        InputStream input = PropertyUtils.class.getClassLoader().getResourceAsStream(propFileName + ".properties");
        prop.load(input);
        return prop.getProperty(propertyName);
    }
}