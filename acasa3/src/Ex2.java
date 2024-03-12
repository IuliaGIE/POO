class Produs{
    private String nume;
    private double pret;
    private int cant;
    public Produs(String s, double p, int c){
        this.nume = s;
        this.pret = p;
        this.cant = c;
    }
    public String toString(){
        return "Produs " + nume + " " + pret + " " + cant;
    }
    public double getTotalProdus(){
        return pret * cant;
    }
}

class Magazin{
    private String nume;
    private Produs[] produse;
    public Magazin(String s, Produs[] pr){
        this.nume = s;
        this.produse = pr;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Produs produs : produse)
            sb.append(produs.toString()).append("\n");
        String s = sb.toString();
        return s;
    }
    public double getTotalMgazin(){
        double total = 0;
        for(Produs produs : produse){
            total += produs.getTotalProdus();
        }
        return total;
    }
}

public class Ex2 {
    public static void main(String[] args){
        Magazin magazin = new Magazin("MegaImage",new Produs[]
                {new Produs("Malai",5.3,10),
                        new Produs("Faina",3.7,12),
                        new Produs("Zahar",1.5,15)});
        String str = magazin.toString();
        double total = magazin.getTotalMgazin();
        System.out.print(str);
        System.out.println(total);
    }
}
