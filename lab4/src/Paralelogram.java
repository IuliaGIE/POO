import java.sql.SQLOutput;

public class Paralelogram extends Patrulater{

    public Paralelogram(int latura1, int latura2, double unghi1) {
        super(latura1, latura2, latura1, latura2, unghi1, 180 - unghi1, unghi1, 180 - unghi1);
    }


    public double arie(){
        return latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
    }


}
