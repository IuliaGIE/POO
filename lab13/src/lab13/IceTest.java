package lab13;

public class IceTest {
    public static void main(String[] args) {
        BasicIceCream basic = new BasicIceCream();
        Chocolate chocobasic = new Chocolate(basic);
        Vanilla vanchocobasic = new Vanilla(chocobasic);
        System.out.println(vanchocobasic.getDescription());

        System.out.println("Ingredients: " + vanchocobasic.getDescription());
        System.out.println("Cost: " + vanchocobasic.getCost());

    }
}