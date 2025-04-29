package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "src/hust/soict/hedspi/garbage/test.txt";
        byte[] inp = { 0 };
        long startTime, endTime;

        try {
            inp = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file '" + filename + "'. Ensure the file exists and is accessible.");
            return; // Exit the program gracefully
        }

        if (inp.length == 0) {
            System.out.println("The file '" + filename + "' is empty.");
            return;
        }

        startTime = System.currentTimeMillis();
        StringBuilder out = new StringBuilder();
        for (byte b : inp) {
            out.append((char) b);
        }
        endTime = System.currentTimeMillis();

        // Print results
        System.out.println("File size: " + inp.length + " bytes");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}