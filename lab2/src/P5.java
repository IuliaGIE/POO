public class P5 {
    public static void main(String[] args){
        String text = "Un terorist avea o bomba";
        String[] cuvinte = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";
        boolean verif = contineCuvinte(text, cuvinte);
        if(verif)
                System.out.println("Suspect");
            else
                System.out.println("Nimic suspect");

        P5 prb5 = new P5();
        String rezultat;
        rezultat = prb5.cenzurare(text, cuvinte);
        System.out.println(rezultat);

    }

    public static String cenzurare(String text, String[] cuvinte){
        int ok = 0;
        String rezultat = "";
        String[] s = text.split(" "); // "\\b"
        for(String cuv : s){
            for(String cuvant : cuvinte){
                if(cuv.equals(cuvant)){
                    ok = 1;
                    StringBuffer sb = new StringBuffer(cuv);
                    for (int i = 1; i < cuv.length() - 1; i++) {
                        sb.setCharAt(i, '*');
                    }
                    cuv = sb.toString();
                }
            }
            rezultat += cuv;
            rezultat += " ";
        }
        if (ok == 1)
            System.out.println("Text suspect");
        else
            System.out.println("Nimic suspect");
        return rezultat;
    }
    public static boolean contineCuvinte(String text, String[] cuvinte){
        for(String cuvant : cuvinte)
            if(text.contains(cuvant))
                return true;

        return false;

    }
}
