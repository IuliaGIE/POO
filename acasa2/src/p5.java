public class p5 {
    public static void main(String[] args) {
        String text = "Un terorist avea o bomba";
        String[] cuvinte = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";

        p5 prb5 = new p5();
        String rezultat = prb5.cenzurare(text, cuvinte);

        if (prb5.contineCuvinte(text, cuvinte)) {
            System.out.println("Text suspect");
        } else {
            System.out.println("Nimic suspect");
        }

        System.out.println("Text cenzurat: " + rezultat);
    }

    // Metoda pentru verificarea dacă textul conține cuvinte din vector
    public boolean contineCuvinte(String text, String[] cuvinte) {
        for (String cuvant : cuvinte) {
            if (text.contains(cuvant)) {
                return true;
            }
        }
        return false;
    }

    // Metoda pentru cenzurarea cuvintelor din text
    public String cenzurare(String text, String[] cuvinte) {
        String rezultat = text;

        for (String cuvant : cuvinte) {
            // Folosim expresia regulată pentru a înlocui cuvinte întregi
            rezultat = rezultat.replaceAll("\\b" + cuvant + "\\b", cenzureazaCuvant(cuvant));
        }

        return rezultat;
    }

    // Metoda pentru a înlocui cuvântul cu caractere asterisc
    public String cenzureazaCuvant(String cuvant) {
        int lungime = cuvant.length();
        StringBuilder cenzurat = new StringBuilder();

        for (int i = 0; i < lungime; i++) {
            cenzurat.append("*");
        }

        return cenzurat.toString();
    }
}
