package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLineNumbers {
    public static void main(String[] args) {
        String fileName = "lab7/test01.txt";

        TreeMap<String, LinkedList<Integer>> wordLineMap = new TreeMap<>();

        readWordsFromFile(fileName, wordLineMap);


        Iterator<Map.Entry<String, LinkedList<Integer>>> iter = wordLineMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, LinkedList<Integer>> entry = iter.next();
            String word = entry.getKey();
            LinkedList<Integer> lineNumbers = entry.getValue();
            int occurrences = lineNumbers.size();

            System.out.println(word + ":");
            System.out.println("Line numbers: " + lineNumbers);
            System.out.println("Number of occurrences: " + occurrences);
            System.out.println();
        }
    }

    private static void readWordsFromFile(String fileName, TreeMap<String, LinkedList<Integer>> wordLineMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNr = 1;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    LinkedList<Integer> lineNumbers = wordLineMap.getOrDefault(word, new LinkedList<>());
                    lineNumbers.add(lineNr);
                    wordLineMap.put(word, lineNumbers);
                }

                lineNr++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
