public class Numar {
    private final int n;
    public Numar(int x){
        this.n = x;
    }
    //returneaza suma dintre nr (membrul clasei) si a
    public int suma(int a){
        return n + a;
    }
    //returneaza suma dintre nr, a si b
    public int suma(int a, int b){
        return n + a + b;
    }
    //returneaza suma dintre nr, a, b si c
    public int suma(int a, int b, int c){
        return n + a + b + c;
    }
    //returneaza suma dintre nr, a, b, c si d
    public int suma(int a, int b, int c, int d){
        return n + a + b + c + d;
    }
    public static void main(String[] args){
        Numar nr = new Numar (5);
        System.out.println("Suma 1: " + nr.suma(1));
        System.out.println("Suma 2: " + nr.suma(1, 2));
        System.out.println("Suma 3: " + nr.suma(1, 2, 3));
        System.out.println("Suma 4: " + nr.suma(1, 2, 3, 4));
    }
}
