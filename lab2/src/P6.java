import java.util.Vector;

public class P6 {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();

        vector.add(7);
        vector.add(6);
        vector.add(7.5);
        vector.add(3.14f);
        vector.add("String");
        vector.add('A');
        vector.add(true);
        System.out.println("Vectorul original: " + vector);

        Vector<Integer> numarAparitii = new Vector<>();

        for (int i = 0; i < 6; i++) {
            numarAparitii.add(0);
        }

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

        System.out.println("Numărul de apariții pentru fiecare tip: " + numarAparitii);
    }
}
