package Lab06;

import java.util.ArrayList;

abstract class Vagon {
    // Capacitatea de pasageri și colete poștale
    int capacitatePasageri;
    int capacitateColetePostale;

    public abstract void deschideUsa();
    public abstract void inchideUsa();

    // Metodă pentru blocarea geamurilor (se suprascrie în subclasa potrivită)
    public void blocheazaGeamuri() {
        System.out.println("Geamurile sunt blocate manual.");
    }
}

class CalatoriA extends Vagon {
    public CalatoriA() {
        capacitatePasageri = 40;
        capacitateColetePostale = 300;
    }

    @Override
    public void deschideUsa() {
        System.out.println("Ușile sunt deschise automat.");
    }

    @Override
    public void inchideUsa() {
        System.out.println("Ușile sunt închise automat.");
    }
}

class CalatoriB extends Vagon {
    public CalatoriB() {
        capacitatePasageri = 50;
        capacitateColetePostale = 400;
    }

    @Override
    public void deschideUsa() {
        System.out.println("Ușile sunt deschise automat.");
    }

    @Override
    public void inchideUsa() {
        System.out.println("Ușile sunt închise automat.");
    }

    @Override
    public void blocheazaGeamuri() {
        System.out.println("Geamurile sunt blocate automat.");
    }
}

class Marfa extends Vagon {
    public Marfa() {
        capacitateColetePostale = 400;
    }

    @Override
    public void deschideUsa() {
        System.out.println("Operatiunea de deschidere a usilor este manuala.");
    }

    @Override
    public void inchideUsa() {
        System.out.println("Operatiunea de inchidere a usilor este manuala.");
    }
}

class Tren {
    private ArrayList<Vagon> vagoane = new ArrayList<>();

    public void addVagon(Vagon vagon) {
        vagoane.add(vagon);
    }

    public void afiseazaTipuriVagoane() {
        for (Vagon vagon : vagoane) {
            if (vagon instanceof CalatoriA) {
                System.out.println("Vagon de tip CalatoriA");
            } else if (vagon instanceof CalatoriB) {
                System.out.println("Vagon de tip CalatoriB");
            } else if (vagon instanceof Marfa) {
                System.out.println("Vagon de tip Marfa");
            }
        }
    }

    // Suprascrierea metodei toString pentru afișarea numărului de colete totale
    @Override
    public String toString() {
        int coleteTotale = 0;
        for (Vagon vagon : vagoane) {
            coleteTotale += vagon.capacitateColetePostale;
        }
        return "Trenul poate transporta un total de " + coleteTotale + " colete.";
    }
}
