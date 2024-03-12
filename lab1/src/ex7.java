public class ex7 {
    public static void main(String args[]){
        ex7 numar = new ex7();
        int n = 5;
        System.out.println(n + " numere");
        for(int j = 1; j <= n; j++){
            int a = j * 2;
            //System.out.println(a);
            for(int b = 1; b <= a; b++){
                int c = a - b;
                //System.out.println(b);
                boolean okb = numar.prim(b), okc = numar.prim(c);
                if(okb && okc)
                    System.out.println(a + " = " + b + " + " + c);
            }
            //boolean ok;
            //ok = numar.prim(j);
            //if(ok)
              //  System.out.println(j);
        }
    }
    boolean prim (int x){
        if(x == 1 || x == 0)
            return false;
        for(int i = 2; i * i <= x; i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }
}
