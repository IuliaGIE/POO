

/**
 *
 * @author Nan Mihai
 */
class Animal {
    private static String nume;
    private static String culoare;
    
    static {
        System.out.println("Bloc 1 - Animal");
        nume = "Animal";
        culoare = "negru";
    }
    
    {
        System.out.println("Bloc 2 - Animal");
    }
    
    public static String getCuloare() {
         return culoare;
    }
}

class Caine extends Animal {
    private static String tipRasa;
    
    static {
        tipRasa = "medie";
        System.out.println("Bloc 1 - Caine " + getCuloare());
    }
    
    {
        System.out.println("Bloc 2 - Caine");
    }
    
    static {
        System.out.println("Bloc 3 - Caine");
        tipRasa = "mare";
    }
    
    {
        System.out.println("Bloc 4 - Caine");
        tipRasa = "mica";
    }
}

class SharPei extends Caine {
    private static int varsta;
    private static String taraProvenienta;
    
    {
        System.out.println("Bloc 1 - SharPei");
        taraProvenienta = "China";
    }
    
    {
        System.out.println("Bloc 2 - SharPei " + taraProvenienta);
    }
    
    static {
        varsta = 5;
        System.out.println("Bloc 3 - SharPei " + varsta);
    }
}

class Problema1 {
    public static void main(String args[]) {
        SharPei cutu = new SharPei();
    }
}