package ExamenTeste.E2022;

class TestA{
        static String x;
        static void test() {
            try {
                System.out.print(" " + x.toString());
            } finally {
                System.out.print("FINALLY ");
            }
        }
public static void main(String[] args) {

    try {
        new TestA().test();
    } catch (Exception x) {
        System.out.print("EXC");
    }
}}
