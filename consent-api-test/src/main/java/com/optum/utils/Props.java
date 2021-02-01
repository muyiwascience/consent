package com.optum.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Props {

    private static String currentEnv = System.getProperty("env");

    public static String getValue(String keyName) {
        String resourcePath = "/src/main/resources/envs/"+currentEnv+".properties";
        String filePath = System.getProperty("user.dir") + resourcePath;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(keyName);
    }




}

