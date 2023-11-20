package cp317;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class process {

    public static void RunCode(String Directory, String fileName) throws FileNotFoundException {
        // Replace "PathToYourOtherJavaProgram" with the actual path to your other Java
        // program
        String pathToOtherJavaProgram = Directory;

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", pathToOtherJavaProgram);
            // If your other Java program takes command-line arguments, you can add them
            // here
            // processBuilder.command("java", "-jar", pathToOtherJavaProgram, "arg1",
            // "arg2", ...);

            // Redirect the subprocess's standard output to this process's standard output
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output and print it
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // save console output
            PrintStream console = System.out;

            // redirects console output into a txt file for comparison
            FileOutputStream f = new FileOutputStream(fileName);
            System.setOut(new PrintStream(f));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // reset output to console
            System.setOut(console);

            // Wait for the process to finish
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

    public static String findID(String Directory) throws FileNotFoundException {
        String id = "000000000";
        try (BufferedReader br = new BufferedReader(new FileReader(Directory))) {
            String line;
            while ((line = br.readLine()) != null) {
                line.trim();
                if (line.startsWith("Student_ID")) {
                    id = line.substring(line.length() - 9);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
}