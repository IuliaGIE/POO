public class p1 {
    public static void main(String[] args) {
        String s2 = "si";
        String s1 = "sir1 si cu sir2 fac un sir3";

        // Folosind metoda substring
        int countSubstring = countSubstringOccurrences(s1, s2);
        System.out.println("Numărul de apariții folosind metoda substring: " + countSubstring);

        // Folosind metoda indexOf
        int countIndexOf = countIndexOfOccurrences(s1, s2);
        System.out.println("Numărul de apariții folosind metoda indexOf: " + countIndexOf);
    }

    // Metoda pentru a număra aparițiile folosind substring
    public static int countSubstringOccurrences(String s1, String s2) {
        int count = 0;
        int startIndex = 0;

        while ((startIndex = s1.indexOf(s2, startIndex)) != -1) {
            count++;
            startIndex += s2.length();
        }

        return count;
    }

    // Metoda pentru a număra aparițiile folosind indexOf
    public static int countIndexOfOccurrences(String s1, String s2) {
        int count = 0;
        int startIndex = 0;

        while ((startIndex = s1.indexOf(s2, startIndex)) != -1) {
            count++;
            startIndex++;
        }

        return count;
    }
}
