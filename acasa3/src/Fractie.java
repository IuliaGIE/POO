public class Fractie {
    private int numarator;
    private int numitor;
    public Fractie(int x, int y){
        this.numarator = x;
        if(y != 0)
            this.numitor = y;
        else
            System.out.println("Numitorul nu poate fi 0.");
    }

    public Fractie(){
        this(0,1);
    }

    public Fractie aduna(Fractie altaFractie) {
        int rezultatNumarator = this.numarator * altaFractie.numitor + altaFractie.numarator * this.numitor;
        int rezultatNumitor = this.numitor * altaFractie.numitor;

        return new Fractie(rezultatNumarator, rezultatNumitor);
    }

    public String toString() {
        return numarator + "/" + numitor;
    }

    public boolean equals(Object obj){
        //verifica daca f1 este de aceeasi clasa cu f2
        if(getClass() != obj.getClass())
            return false;
        Fractie that = (Fractie) obj;
        return numarator == that.numarator && numitor == that.numitor;
    }

    public static void main(String[] args) {
        Fractie fractie1 = new Fractie(1, 2);
        Fractie fractie2 = new Fractie(3, 4);

        Fractie suma = fractie1.aduna(fractie2);

        System.out.println("Fractie 1: " + fractie1);
        System.out.println("Fractie 2: " + fractie2);
        System.out.println("Suma: " + suma);
        System.out.println("Fracția 1 este egală cu fracția 2: " + fractie1.equals(fractie2));
    }

}
