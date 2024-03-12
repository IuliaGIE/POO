package ExamenTeste.E2022;

class AAA {
    public void m1(){
        System.out.println("A");
    }
}
class BBB extends AAA{
    public void m2(){
        System.out.println("B2");
    }
    public void m1(){
        System.out.println("B1");
    }
}
class CCC{
    public static void main(String[] args){
        AAA x = new BBB();
        //x.m1();
        ((AAA) new BBB()).m1();
        ((BBB)((AAA) new BBB())).m2();
        ((BBB)x).m2();
    }
}