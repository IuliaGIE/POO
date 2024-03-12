public class Ex1 {
    public static void main(String[] args) {
        Patrulater patrulater = new Patrulater(5, 7, 5, 7, 60, 120, 60, 120);
        Paralelogram paralelogram = new Paralelogram(5, 7, 60);
        Romb romb = new Romb(5, 60);
        Dreptunghi dreptunghi = new Dreptunghi(5, 7);
        Patrat patrat = new Patrat(5);


        System.out.println("Aria paralelogramului: " + paralelogram.arie());
        System.out.println("Aria rombului: " + romb.arie());
        System.out.println("Aria dreptunghiului: " + dreptunghi.arie());
        System.out.println("Aria patratului: " + patrat.arie());
    }
}