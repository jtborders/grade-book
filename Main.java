import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Grades g = new Grades("data.csv");
        g.printAll();
        // System.out.println("Hello, world!");
        // final Scanner scanner = new Scanner(System.in);
        // System.out.println("Welcome to GradingTool, the helpful CLI tool for managing grades!");
        // System.out.println("How can I help you today?");
        // String userAnswer = scanner.nextLine();
        // System.out.println("You said: " + userAnswer);
    }
    private static void writeStringToFile(String data, String filepath) {
        Path filePath = Path.of(filepath);
        try {
            Files.writeString(filePath, data);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    private static String readStringFromFile(String filepath) {
        Path filePath = Path.of(filepath);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

}