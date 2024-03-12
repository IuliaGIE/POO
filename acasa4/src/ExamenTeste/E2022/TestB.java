package ExamenTeste.E2022;

class Pass {
    void function(int x, String s) {
        s="function x=";
    System.out.println(s+ (++x));
    }

    public static void main(String[] args){

        int x = 5; String s="main x=";

        Pass p = new Pass();
        p.function(x,s);
        System.out.print(s + x); }

    }