package lab9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema4 extends JFrame implements ChangeListener {
    JSlider redSlider, greenSlider, blueSlider;
    JTextField colorDisplay;

    public Problema4(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        colorDisplay = new JTextField();
        colorDisplay.setEditable(false);
        colorDisplay.setPreferredSize(new Dimension(200, 50));

        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);

        JPanel slidersPanel = new JPanel();
        slidersPanel.setLayout(new GridLayout(3, 1));
        slidersPanel.add(redSlider);
        slidersPanel.add(greenSlider);
        slidersPanel.add(blueSlider);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(slidersPanel);
        mainPanel.add(colorDisplay);

        add(mainPanel);

        updateColorDisplay();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateColorDisplay() {
        int redValue = redSlider.getValue();
        int greenValue = greenSlider.getValue();
        int blueValue = blueSlider.getValue();

        Color color = new Color(redValue, greenValue, blueValue);
        colorDisplay.setBackground(color);
        colorDisplay.setText("RGB: " + redValue + ", " + greenValue + ", " + blueValue);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateColorDisplay();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Problema4("Problema 4"));
    }
}
