package ExamenTeste.E2020;

public class Ex3a {
    // a
    public static void main(String[] args) {
        try { throw new Error(); }
        catch (Error e) {
            try { throw new RuntimeException(); }
            catch (Throwable t) { }
        }
        System.out.println("Oioioi!");
    }

}
