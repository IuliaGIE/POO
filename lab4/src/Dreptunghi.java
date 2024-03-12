public class Dreptunghi extends Patrulater{

    public Dreptunghi(int latura1, int latura2) {
        super(latura1, latura2, latura1, latura2, 90,90, 90, 90);
    }

    public double arie(){
        return latura1 * latura2;
    }

}
