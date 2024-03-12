package ExamenTeste.E2019;

class Hobbit {
    int count(int x, int y) {
        return x + y; }
}

class Frodo extends Hobbit {
    public static void main(String[] args){
        Frodo frodo = new Frodo();
        Short myGold = 7;

        System.out.println(frodo.count (myGold, 6));

    }
}