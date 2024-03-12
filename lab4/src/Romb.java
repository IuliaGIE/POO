public class Romb extends Patrulater{
    private double diag1, diag2;
    public Romb(int latura, double unghi){
        super(latura, latura, unghi, 180 - unghi);
            this.diag1 = 2 * latura * Math.sin(Math.toRadians(unghi / 2));
            this.diag2 = 2 * latura * Math.cos(Math.toRadians(unghi / 2));
    }
    public double arie(){
        return (this.diag1 * this.diag2) / 2;
    }
}
