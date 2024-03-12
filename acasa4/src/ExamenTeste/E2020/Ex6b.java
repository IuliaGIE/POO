package ExamenTeste.E2020;

    class F {
        static String s = "hello";
        public static void main(String[] args) {
            new F().met(s);
            System.out.println(s);
        }
        void met(String s) { s = "world"; }
    }


