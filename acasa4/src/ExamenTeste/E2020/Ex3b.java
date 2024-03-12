package ExamenTeste.E2020;

    // b
    class D { int method() { return 1; } }
    class E extends D { int method() {return 2; } }
    class FF extends E { int fun(D d) { return d.method(); } }
    class Test {
        public static void main(String[] args) {
            FF x = new FF();
            System.out.println(x.fun(new E()));
        }
    }

