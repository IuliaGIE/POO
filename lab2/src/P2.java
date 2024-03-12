public class P2 {
    public static void main(String[] args){
        String s2 = "si";
        String s1 = "sir1 si cu sir2 fac un sir3";
        System.out.println(aparitiiCuvant(s1, s2));
    }

    public static int aparitiiCuvant(String s1, String s2){
        String[] cuvinte = s1.split(" ");
        int ct = 0;
        for(String cuvant : cuvinte){
            if(cuvant.equals(s2))
                ct++;
        }
        return ct;
    }
}
