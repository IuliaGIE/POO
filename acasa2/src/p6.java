import java.util.Vector;

public class p6 {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();

        // Adăugăm diverse tipuri de obiecte în vector
        vector.add(7); // Integer (int)
        vector.add(7.5); // Double (double)
        vector.add(3.14f); // Float (float)
        vector.add("String"); // String
        vector.add('A'); // Character (char)
        vector.add(true); // Boolean (boolean)

        // Creăm un vector pentru a stoca numărul de apariții pentru fiecare tip
        Vector<Integer> numarAparitii = new Vector<>();

        // Initializăm numărul de apariții pentru fiecare tip cu 0
        for (int i = 0; i < 6; i++) {
            numarAparitii.add(0);
        }

        // Determinăm numărul de apariții pentru fiecare tip
        for (Object element : vector) {
            if (element instanceof Integer) {
                int index = 0;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            } else if (element instanceof Double) {
                int index = 1;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            } else if (element instanceof Float) {
                int index = 2;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            } else if (element instanceof String) {
                int index = 3;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            } else if (element instanceof Character) {
                int index = 4;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            } else if (element instanceof Boolean) {
                int index = 5;
                numarAparitii.set(index, numarAparitii.get(index) + 1);
            }
        }

        // Afișăm rezultatele
        System.out.println("Vectorul original: " + vector);
        System.out.println("Numărul de apariții pentru fiecare tip: " + numarAparitii);
    }
}
