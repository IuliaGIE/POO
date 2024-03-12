import java.util.Vector;

public class p4 {
    public static void main(String[] args) {
        Vector<Integer> set1 = new Vector<>();
        Vector<Integer> set2 = new Vector<>();

        // Adăugăm elemente în set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);

        // Adăugăm elemente în set2
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        // Realizăm operațiile cu mulțimi
        Vector<Integer> unionResult = union(set1, set2);
        Vector<Integer> intersectionResult = intersection(set1, set2);
        Vector<Integer> differenceResult = difference(set1, set2);

        // Afișăm rezultatele
        System.out.println("Reuniunea: " + unionResult);
        System.out.println("Intersecția: " + intersectionResult);
        System.out.println("Diferența (set1 - set2): " + differenceResult);
    }

    // Metodă pentru reuniunea a două mulțimi
    public static Vector<Integer> union(Vector<Integer> set1, Vector<Integer> set2) {
        Vector<Integer> result = new Vector<>(set1);
        result.addAll(set2);
        return result;
    }

    // Metodă pentru intersecția a două mulțimi
    public static Vector<Integer> intersection(Vector<Integer> set1, Vector<Integer> set2) {
        Vector<Integer> result = new Vector<>(set1);
        result.retainAll(set2);
        return result;
    }

    // Metodă pentru diferența a două mulțimi (set1 - set2)
    public static Vector<Integer> difference(Vector<Integer> set1, Vector<Integer> set2) {
        Vector<Integer> result = new Vector<>(set1);
        result.removeAll(set2);
        return result;
    }
}
