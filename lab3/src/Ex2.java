import javax.swing.*;

class Product {
    String nume;
    double pret;
    int cantitate;

    public Product(String nume, double pret, int cantitate){
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Produs: " + nume + " " + "pret: " + pret + " cantitate: " + cantitate;
    }

    public double getTotalProdus() {
        return pret * cantitate;
    }
}

class Magazin {
    String nume;
    Product[] produse;

    public Magazin(String nume, Product[] produse){
        this.nume = nume;
        this.produse = produse;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Product produs : produse)
            sb.append(produs.toString()).append("\n");
        return sb.toString();
    }

    public double getTotalMgazin() {
        double total = 0;
        for (Product produs : produse) {
            total += produs.getTotalProdus();
        }
        return total;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Magazin magazin = new Magazin("Mega", new Product[]{
                new Product("Ciocolata", 5.8, 10),
                new Product("Biscuiti", 7.7, 9),
                new Product("Zahar", 1.5, 25)
        });
        String str = magazin.toString();
        double total = magazin.getTotalMgazin();
        System.out.print(str);
        System.out.println(total);
    }
}
