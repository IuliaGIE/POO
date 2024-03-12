import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    public static void createAndShowGUI() {
        // Crearea ferestrei
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);

        // Crearea panelului și a layout-ului
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        // Afișarea ferestrei
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        // Eticheta pentru email
        JLabel userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Câmpul de text pentru email
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Eticheta pentru parolă
        JLabel passwordLabel = new JLabel("Parola:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Câmpul de text pentru parolă
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Butonul de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Butonul de logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 80, 80, 25);
        panel.add(logoutButton);

        // Acțiunea butonului de login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = userText.getText();
                char[] password = passwordText.getPassword();
                // Aici poți adăuga logica de autentificare
                System.out.println("Email: " + email);
                System.out.println("Password: " + new String(password));
            }
        });

        // Acțiunea butonului de logout
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aici poți adăuga logica de deconectare
                System.out.println("Logout successful");
                frame.dispose();// Închide fereastra
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
