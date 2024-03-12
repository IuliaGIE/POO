package ExamenTeste.E2019;

public class Sub6b {
    public static void main(String[] args) {
        String s = "-";
        try { throw new Exception();}
        catch (Exception e) {
            try {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    s += "ic ";
                }
                double x = 2;
                System.out.println(x / 0);
            } catch (Exception x) {
                s += "mc ";
            } finally {
                s += "mf ";
            }
        }finally { s += "of "; }
        System.out.println(s);
    }
}
