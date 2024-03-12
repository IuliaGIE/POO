import java.util.StringTokenizer;

public class p2 {
    public static void main(String[] args) {
        String s1 = "sir1 si sir2 sunt 2 siruri";
        String s2 = "sir";

        int count1 = countWordOccurrencesUsingSplit(s1, s2);
        System.out.println("Numărul de apariții folosind split: " + count1);

        String text = "Marius, de ce nu l-ai ajutat pe George? Era de datoria ta sa vezi ce poti face.";
        s2 = "ce";

        int count2 = countWordOccurrencesUsingStringTokenizer(text, s2);
        System.out.println("Numărul de apariții folosind StringTokenizer: " + count2);
    }

    // Metoda pentru a număra aparițiile unui cuvânt folosind split
    public static int countWordOccurrencesUsingSplit(String s1, String s2) {
        String[] words = s1.split(" ");
        int count = 0;

        for (String word : words) {
            if (word.equals(s2)) {
                count++;
            }
        }

        return count;
    }

    // Metoda pentru a număra aparițiile unui cuvânt folosind StringTokenizer
    public static int countWordOccurrencesUsingStringTokenizer(String s1, String s2) {
        StringTokenizer tokenizer = new StringTokenizer(s1, ":,.-? \n");
        int count = 0;

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.equals(s2)) {
                count++;
            }
        }

        return count;
    }
}
