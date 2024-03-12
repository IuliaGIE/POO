public class Numar {
    public final int n;
    public Numar(int n){
        this.n = n;
    }

    //returneaza suma dintre nr (membrul clasei) si a
    public int suma(int a){
        return n + a;
    }
    //returneaza suma dintre nr, a si b
    public int suma(int a, int b){
        return suma(a) + b;
    }
    //returneaza suma dintre nr, a, b si c
    public int suma(int a, int b, int c){
        return suma(a, b) + c;
    }
    //returneaza suma dintre nr, a, b, c si d
    public int suma(int a, int b, int c, int d){
        return suma(a, b, c) + d;
    }

    public static void main(String[] args){
        Numar n = new Numar(7);
        System.out.println("Suma de 1 numar: " + n.suma(3));
        System.out.println("Suma de 2 numere: " + n.suma(3, 4));
        System.out.println("Suma de 3 numere: " + n.suma(3, 4, 5));
        System.out.println("Suma de 4 numere: " + n.suma(3, 4, 5, 6));
    }
}
