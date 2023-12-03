package com.adventofcode.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public static List<String> readFileToList(String fileName) throws IOException, URISyntaxException {
        URL url = FileReader.class.getClassLoader().getResource(fileName);
        assert url != null;
        Path filePath = Path.of(url.toURI());

        return Files.readAllLines(filePath);
    }

    public static String readFileToString(String fileName) throws IOException, URISyntaxException {
        URL url = FileReader.class.getClassLoader().getResource(fileName);
        assert url != null;
        Path filePath = Path.of(url.toURI());

        return Files.readString(filePath);
    }
}
