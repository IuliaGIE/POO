package lab13;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.IOException;

public class Problema2 {
    public static void main(String[] args) {
        String filePath = "src/lab13/test01.in";

        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))) {
            String line;

            while ((line = lineNumberReader.readLine()) != null) {
                int lineNumber = lineNumberReader.getLineNumber();

                if (lineNumber % 2 == 1) {
                    System.out.println(lineNumber + " " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("A aparut o eroare la citirea fisierului: " + e.getMessage());
        }
    }
}
