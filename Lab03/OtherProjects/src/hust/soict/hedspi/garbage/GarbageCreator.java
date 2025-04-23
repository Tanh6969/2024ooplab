package hust.soict.hedspi.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.io.IOException; 
import java.nio.file.NoSuchFileException; 
import java.nio.file.Path;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "src/hust/soict/hedspi/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        try { 
        	Path filePath = Paths.get(filename); 
        	inputBytes = Files.readAllBytes(filePath); 
        } 
        catch (IOException e) {
        	return;
        }
        startTime = System.currentTimeMillis();
        
//        String outputString = "";
//        for (byte b : inputBytes) {
//        	outputString += (char)b;
//        }
        
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
        	outputStringBuilder.append((char)b);
        }
        
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}