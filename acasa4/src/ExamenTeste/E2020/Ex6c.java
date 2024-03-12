package ExamenTeste.E2020;

class A {
    private static int counter = 0;
    public static int getInstCount() {
        return counter;
    }
    public A() { counter++; }
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        System.out.println(A.getInstCount());
    }
}
