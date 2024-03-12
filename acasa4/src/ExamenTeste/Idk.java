package ExamenTeste;
class B {
    int x;
    B(int x) { this.x = x; }
}

class A1 {
    B obiect;
    A1(B ob) { obiect = ob; }
    void change() { obiect.x = 1; mprint(); }
    private void mprint() { System.out.print(obiect.x); }
}

class Test {
    public static void main(String[] args) {
        B b = new B(5);
        new A1(b).change();
        System.out.print(b.x);
    }
}



