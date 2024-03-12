package lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Problema6 extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public Problema6() {
        super("Problema 6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Calea:");
        textField = new JTextField(20);
        button = new JButton("Afiseaza continutul");
        textArea = new JTextArea(10, 30);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVisible(false);

        button.addActionListener(this);

        setLayout(new FlowLayout());
        add(label);
        add(textField);
        add(button);
        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String filePath = textField.getText();
            File file = new File(filePath);

            if (file.exists() && !file.isDirectory()) {
                try {
                    String content = Files.readString(Path.of(filePath));
                    textArea.setText(content);
                    scrollPane.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fisierul nu exista!", "Eroare", JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                textArea.setText("");
                scrollPane.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Problema6::new);
    }
}
