package com.optum.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

    public static String getData(String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = "/src/main/resources/testdata/consent/"+ fileName;
        path = path + filePath;
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
