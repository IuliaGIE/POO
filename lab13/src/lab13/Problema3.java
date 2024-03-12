package lab13;

import java.io.*;

public class Problema3 {
    public void print(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String key = "";
        System.out.println("Introduceti textul (scrieti 'exit' pentru a opri):");
        try{
            String line = null;
            while ((line = in.readLine()) != null && !line.contains("exit"))
                key += line;
            File myObj = new File("scr/lab13/citire.out");
            FileWriter myWriter = new FileWriter("src/lab13/citire.out");
            myWriter.write(key);
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Problema3().print(args);
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/lab13/1citire.out"))) {
            String line;

            System.out.println("Introduceti textul (scrieti 'exit' pentru a opri):");
            while (!(line = reader.readLine()).equals("exit")) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("A aparut o eroare: " + e.getMessage());
        }*/
    }
}
