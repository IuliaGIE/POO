package lab9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Problema5 extends JFrame implements ActionListener {
    private JButton colorButton;
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private int currentColorIndex = 0;

    public Problema5() {
        super("Problema 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorButton = new JButton("Colors");
        colorButton.setPreferredSize(new Dimension(80, 40));
        colorButton.setMnemonic(KeyEvent.VK_C); // ALT+C shortcut

        colorButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(colorButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            currentColorIndex = (currentColorIndex + 1) % colors.length;
            updateButtonColor();
        }
    }

    private void updateButtonColor() {
        Color currentColor = colors[currentColorIndex];
        colorButton.setForeground(currentColor);
        colorButton.setBackground(currentColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Problema5::new);
    }
}

