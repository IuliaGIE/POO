import java.util.Random;
import java.util.Vector;

public class p3 {
    public static void main(String[] args) {
        Vector<Integer> vector = generateRandomVector(20);
        System.out.println("Vector generat: " + vector);

        int x = 5; // Numărul pe care vrem să-l eliminăm
        int count = removeAndCountOccurrences(vector, x);
        System.out.println("Numărul de apariții ale lui " + x + " eliminate: " + count);
        System.out.println("Vector după eliminare: " + vector);

        int maxValue = findMaxValue(vector);
        System.out.println("Valoarea maximă din vector: " + maxValue);

        int minIndex = findMinIndex(vector);
        System.out.println("Poziția minimului din vector: " + minIndex);

        double average = calculateAverage(vector);
        System.out.println("Media aritmetică a elementelor din vector: " + average);
    }

    // Metodă pentru a genera un Vector cu numere aleatoare
    public static Vector<Integer> generateRandomVector(int size) {
        Vector<Integer> vector = new Vector<>();
        Random generator = new Random();

        for (int i = 0; i < size; i++) {
            int randomValue = generator.nextInt(11); // Interval [0..10]
            vector.add(randomValue);
        }

        return vector;
    }

    // Metodă pentru a elimina aparițiile lui x și a număra câte au fost eliminate
    public static int removeAndCountOccurrences(Vector<Integer> vector, int x) {
        int count = 0;
        for (int i = vector.size() - 1; i >= 0; i--) {
            if (vector.get(i) == x) {
                vector.remove(i);
                count++;
            }
        }
        return count;
    }

    // Metodă pentru a găsi valoarea maximă din vector
    public static int findMaxValue(Vector<Integer> vector) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : vector) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    // Metodă pentru a găsi poziția minimului din vector
    public static int findMinIndex(Vector<Integer> vector) {
        int minIndex = 0;
        for (int i = 1; i < vector.size(); i++) {
            if (vector.get(i) < vector.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Metodă pentru a calcula media aritmetică a elementelor din vector
    public static double calculateAverage(Vector<Integer> vector) {
        if (vector.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int value : vector) {
            sum += value;
        }
        return (double) sum / vector.size();
    }
}
