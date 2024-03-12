package ExamenTeste.E2019;

import java.util.Vector;
import java.util.Collections;

class Complex implements Comparable<Complex> {
    private int re; // partea reala
    private int im; // partea imaginara

    // Constructor fara parametri
    public Complex() {
        this(0, 0);
    }

    // Constructor cu doi parametri
    public Complex(int re, int im) {
        this.re = re;
        this.im = im;
    }

    // Metoda toString
    public String toString() {
        return "(" + re + ", " + im + "i)";
    }

    // Implementarea metodei compareTo
    public int compareTo(Complex other) {
        if (this.re == other.re) {
            return other.im - this.im; // ordine descrescătoare pentru partea imaginara
        }
        return this.re - other.re; // ordine crescătoare pentru partea reală
    }

    // Metoda main pentru test
    public static void main(String[] args) {
        Vector<Complex> vector = new Vector<>();
        vector.add(new Complex(1, 5));
        vector.add(new Complex(1, 3));
        vector.add(new Complex(2, 2));

        Collections.sort(vector);

        for (Complex complex : vector) {
            System.out.println(complex);
        }
    }
}
