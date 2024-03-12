class Punct{
    private int x, y;
    public Punct(){
        this.x = 0;
        this.y = 0;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    public double distance(int a, int b){
        return Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
    }
    public double distance(Punct p1){
        return Math.sqrt((x-p1.x)*(x-p1.x)+(y-p1.y)*(y-p1.y));
    }

}

public class Ex5 {
    public static void main(String[] args){
        Punct A = new Punct();
        Punct B = new Punct();
        A.setX(1);
        A.setY(2);
        B.setX(-1);
        B.setY(3);
        double dist1 = A.distance(B.getX(), B.getY());
        double dist2 = A.distance(B);
        System.out.println("Dist1 dintre A" + A.toString() + " si B" + B.toString() + ": " + dist1);
        System.out.println("Dist2 dintre A" + A.toString() + " si B" + B.toString() + ": " + dist2);
    }
}
