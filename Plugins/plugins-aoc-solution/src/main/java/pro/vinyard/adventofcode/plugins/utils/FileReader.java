package pro.vinyard.adventofcode.plugins.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class FileReader {

    public static String readFileToString(String fileName) throws IOException, URISyntaxException {
        try (InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found");
            }
            return new String(inputStream.readAllBytes());
        }
    }
}
