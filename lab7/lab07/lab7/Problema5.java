package lab7;

import java.io.File;
import java.util.*;

public class Problema5 {
    public static void main(String[] args) {
        System.out.println("Utilizare HashMap:");
        Map<String, Integer> fileMapHashMap = createFileDictionary(new HashMap<>());
        printFileDictionary(fileMapHashMap);

        System.out.println("\nUtilizare TreeMap (ordonare după nume):");
        Map<String, Integer> fileMapTreeMapByName = new TreeMap<>(fileMapHashMap);
        printFileDictionary(fileMapTreeMapByName);

        System.out.println("\nUtilizare TreeMap (ordonare după dimensiune):");
        Map<String, Integer> fileMapTreeMapBySize = new TreeMap<>(Comparator.comparingInt(fileMapHashMap::get));
        fileMapTreeMapBySize.putAll(fileMapHashMap);
        printFileDictionary(fileMapTreeMapBySize);
    }

    private static Map<String, Integer> createFileDictionary(Map<String, Integer> fileMap) {
        File directory = new File("lab7");

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        int fileSizeInKb = (int) (file.length() / 1024);

                        fileMap.put(fileName, fileSizeInKb);
                    }
                }
            }
        } else {
            System.out.println("Calea specificată nu este un director.");
        }

        return fileMap;
    }

    private static void printFileDictionary(Map<String, Integer> fileMap) {
        Set<Map.Entry<String, Integer>> entrySet = fileMap.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("Nume fișier: " + entry.getKey() + ", Dimensiune: " + entry.getValue() + " KB");
        }
    }
}

