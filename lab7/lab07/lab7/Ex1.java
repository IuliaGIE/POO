package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Ex1 {

    public static void main(String[] args) {
        String fileName = "lab7/test01.txt";

        TreeSet<String> wordsTreeSet = printWords(fileName);

        System.out.println("Cuvinte distincte în ordine crescătoare:");
        for (String word : wordsTreeSet) {
            System.out.println(word);
        }

        TreeSet<String> wordsDescTreeSet = printWordsComparator(wordsTreeSet);
        System.out.println("\n");
        System.out.println("Cuvinte distincte în ordine descrescătoare:");
        for (String word : wordsDescTreeSet) {
            System.out.println(word);
        }
    }



    public static TreeSet<String> printWords(String fileName) {
        TreeSet<String> wordsTreeSet = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    wordsTreeSet.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsTreeSet;
    }



    public static TreeSet<String> printWordsComparator(TreeSet<String> wordsTreeSet) {
        Comparator<String> descendingComparator = Comparator.reverseOrder();

        TreeSet<String> wordsDescTreeSet = new TreeSet<>(descendingComparator);

        wordsDescTreeSet.addAll(wordsTreeSet);

        return wordsDescTreeSet;
    }
}

