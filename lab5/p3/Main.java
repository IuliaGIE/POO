import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ!");
    }
}

public class Main {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        try {
            myRead(numbers);
            if (!numbers.isEmpty()) {
                int max = Collections.max(numbers);
                System.out.println("Elementul maxim este: " + max);
            } else {
                System.out.println("Nu s-au introdus numere pozitive.");
            }
        } catch (NumarNegativ e) {
            System.out.println(e.getMessage());
        }
    }

    public static void myRead(Vector<Integer> numbers) throws NumarNegativ {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numerele (opriți-vă cu un număr negativ):");

        while (true) {
            int num = scanner.nextInt();
            if (num < 0) {
                if (numbers.isEmpty()) {
                    throw new NumarNegativ();
                }
                break;
            }
            numbers.add(num);
        }

        scanner.close();
    }
}
