package Lab06;

public class Test02 {
    public static void main(String[] args){
        Rectangle rShape = new Rectangle();
        Rectangle rSquare = new Square(5.0, "red", true);


        Rectangle r = new Rectangle(5.0, 5.0);
        if (r instanceof Square) {
            Square sq = (Square) r;
        } else {
            System.out.println("Conversia de la Rectangle la Square nu este posibilă.");
        }


        Square sq = new Square(7.0);
        Rectangle r1;
        if (sq instanceof Rectangle) {
            r1 = (Rectangle) sq;
        } else {
            System.out.println("Conversia de la Square la Rectangle nu este posibilă.");
        }


        /* Circle c1 = new Circle();
        if (c1 instanceof Square) {
            Square sq = (Square) c1;
        } else {
            System.out.println("Conversia de la Circle la Square nu este posibila.");
        }*/
    }
}