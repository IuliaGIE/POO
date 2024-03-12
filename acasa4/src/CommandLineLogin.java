import java.util.Scanner;

public class CommandLineLogin {

    private static boolean isAuthenticated = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!isAuthenticated) {
                // Solicită emailul
                System.out.print("Introduceți emailul: ");
                String email = scanner.nextLine();

                // Solicită parola
                System.out.print("Introduceți parola: ");
                String password = scanner.nextLine();

                // Verifică autentificarea
                isAuthenticated = authenticate(email, password);

                if (isAuthenticated) {
                    System.out.println("Conectare reușită!");
                } else {
                    System.out.println("Email sau parolă incorecte!");
                }
            } else {
                // Meniu post-autentificare
                System.out.println("1. Logout");
                System.out.println("2. Continuă");
                System.out.print("Alegeți o opțiune: ");
                String option = scanner.nextLine();

                if ("1".equals(option)) {
                    logout();
                } else if ("2".equals(option)) {
                    // Continuă cu alte funcționalități
                    System.out.println("Continuare...");
                } else {
                    System.out.println("Opțiune invalidă.");
                }
            }
        }
    }

    private static boolean authenticate(String email, String password) {
        // Aici ar trebui să verifici credențialele
        return email.equals("user@example.com") && password.equals("password123");
    }

    private static void logout() {
        isAuthenticated = false;
        System.out.println("Deconectare reușită.");
    }
}
