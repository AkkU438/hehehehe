import java.io.*;
import java.util.*;



public class Assign13 {
    public static void main(String[] args) {
        System.out.println("Please print out the name of the input file");
        @SuppressWarnings("resource")
        Scanner new1 = new Scanner(System.in);
        String inputFile = new1.nextLine();
        System.out.println("");
        System.out.println("Please print out the name of the output file");
        @SuppressWarnings("resource")
        Scanner new2 = new Scanner(System.in);
        String outputFile = new2.nextLine();
        

       // Read input file and count words
       Map<String, Integer> wordCount = new HashMap<>();
       try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
           String line;
           while ((line = br.readLine()) != null) {
               // Trim leading and trailing spaces
               line = line.trim();
               if (!line.isEmpty()) { // Ignore empty lines
                   // Convert to lowercase to make the comparison case-insensitive
                   String word = line.toLowerCase();
                   wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
               }
           }
       } catch (IOException e) {
           System.err.println("Error reading input file: " + e.getMessage());
           return;
       }

       // Write results to output file
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
           for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
               bw.write(entry.getKey() + " " + entry.getValue());
               bw.newLine();
           }
       } catch (IOException e) {
           System.err.println("Error writing output file: " + e.getMessage());
       }

       System.out.println("Word count successfully written to " + outputFile);
    }
}