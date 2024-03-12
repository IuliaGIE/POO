package lab13;

import java.io.*;

public class Problema4 {
    public void wordCounter() {
        FileReader in = null;
        try {
            in = new FileReader(new File("src/lab13/test02.in"));
            StreamTokenizer str = new StreamTokenizer(in);
            int currentToken = str.nextToken();
            int noWords = 0;
            while (currentToken != StreamTokenizer.TT_EOF) {
                if (currentToken == StreamTokenizer.TT_WORD)
                    noWords++;

                currentToken = str.nextToken();
            }
            System.out.println(noWords);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Problema4().wordCounter();
    }
}
