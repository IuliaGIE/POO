public class P1 {
    public static void main(String[] args){
        String s2 = "si";
        String s1 = "sir1 si cu sir2 fac un sir3";
        int aparitii = numarAparitii(s1, s2);
        System.out.println(aparitii);
    }

    public static int numarAparitii(String s1, String s2){
        int ct = 0;
        int index = 0;
        while((index = s1.indexOf(s2, index)) != -1){
            ct++;
            index ++;
        }
        return ct;
    }
}
