class Putere {
    int poww (int a, int b){
        int i = 0, x = a;
        for (i = 1; i < b; i++) {
            a = x * a;
        }
        return a;
    }

}
public class ex5 {
    public static void main(String args[]){
        Putere numar = new Putere();
        System.out.println(numar.poww(2, 3));
        System.out.println(Math.pow(2, 3));
    }
}
