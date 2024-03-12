import java.lang.Math;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }

    public double arie() {
        return 0.0;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, double unghi1) {
        super(latura1, latura2, latura1, latura2, unghi1, 180 - unghi1, unghi1, 180 - unghi1);
    }

    @Override
    public double arie() {
        return latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
    }
}

class Romb extends Paralelogram {
    private double diag1, diag2;

    public Romb(int latura, double unghi) {
        super(latura, latura, unghi);
        this.diag1 = 2 * latura * Math.sin(Math.toRadians(unghi / 2));
        this.diag2 = 2 * latura * Math.cos(Math.toRadians(unghi / 2));
    }

    @Override
    public double arie() {
        return (diag1 * diag2) / 2;
    }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi(int lungime, int latime) {
        super(lungime, latime, 90);
    }

    @Override
    public double arie() {
        return latura1 * latura2;
    }
}

class Patrat extends Dreptunghi {
    public Patrat(int latura) {
        super(latura, latura);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Patrulater patrulater = new Patrulater(5, 7, 5, 7, 60, 120, 60, 120);
        Paralelogram paralelogram = new Paralelogram(5, 7, 60);
        Romb romb = new Romb(5, 60);
        Dreptunghi dreptunghi = new Dreptunghi(5, 7);
        Patrat patrat = new Patrat(5);

        System.out.println("Aria patrulaterului: " + patrulater.arie());
        System.out.println("Aria paralelogramului: " + paralelogram.arie());
        System.out.println("Aria rombului: " + romb.arie());
        System.out.println("Aria dreptunghiului: " + dreptunghi.arie());
        System.out.println("Aria patratului: " + patrat.arie());
    }
}
