public class Fractie {
    int numarator;
    int numitor;

    public Fractie(int numarator, int numitor){
        this.numarator = numarator;
        this.numitor = numitor;
    }

    public Fractie(){
        new Fractie(0,0);
    }

    Fractie suma(Fractie a){
        a.numarator = this.numarator * a.numitor + this.numitor * a.numarator;
        a.numitor = this.numitor * a.numitor;
        return a;
    }

    @Override
    public String toString() {
        return this.numarator + "/" + this.numitor;
    }

    @Override
    public boolean equals(Object obj) {
            if(getClass() != obj.getClass())
                return false;
            Fractie that = (Fractie) obj;
            return numarator == that.numarator && numitor == that.numitor;
    }

    public static void main(String[] args) {
        Fractie fractie1 = new Fractie(1, 2);
        Fractie fractie2 = new Fractie(3, 4);

        System.out.println("Fractie 1: " + fractie1);
        System.out.println("Fractie 2: " + fractie2);


        Fractie suma = fractie1.suma(fractie2);


        System.out.println("Suma: " + suma);
        System.out.println("Fracția 1 este egală cu fracția 2: " + fractie1.equals(fractie2));
    }
}
