public class ex6 {
    public static void main(String args[]){
        ex6 numar = new ex6();
        for(int j = 1; j <= 20; j++){
            boolean ok;
            ok = numar.prim(j);
            if(ok)
                System.out.println(j);
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
