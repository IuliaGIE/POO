package lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.RandomAccessFile;

class Problema3 extends JFrame implements ItemListener {
    JTextField quiz;
    JCheckBox cb1, cb2, cb3, cb4;
    JButton button;

    public Problema3(String fis) {
        super("Problema 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quiz = new JTextField(150);
        quiz.setEditable(false);

        cb1 = new JCheckBox();
        cb2 = new JCheckBox();
        cb3 = new JCheckBox();
        cb4 = new JCheckBox();

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        cb4.addItemListener(this);

        JPanel cbPanel = new JPanel();
        cbPanel.setLayout(new GridLayout(4, 1));
        cbPanel.add(cb1);
        cbPanel.add(cb2);
        cbPanel.add(cb3);
        cbPanel.add(cb4);

        button = new JButton("Raspunde");
        button.setEnabled(false);
        button.addActionListener(e -> validateAnswer());

        add(quiz, BorderLayout.NORTH);
        add(cbPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        try {
            RandomAccessFile br = new RandomAccessFile(fis, "r");
            quiz.setText(br.readLine());
            cb1.setText(br.readLine());
            cb2.setText(br.readLine());
            cb3.setText(br.readLine());
            cb4.setText(br.readLine());
        } catch (IOException ex) {
            System.err.println("Exceptie");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        enableValidationButton();
    }

    private void enableValidationButton() {
        button.setEnabled(true);
    }

    private void validateAnswer() {
        if (cb1.isSelected() && !cb2.isSelected() && !cb3.isSelected() && cb4.isSelected()) {
            colorAnswer(cb1, Color.green);
            colorAnswer(cb2, Color.red);
            colorAnswer(cb3, Color.red);
            colorAnswer(cb4, Color.green);
        } else {
            colorAnswer(cb1, Color.red);
            colorAnswer(cb2, Color.red);
            colorAnswer(cb3, Color.red);
            colorAnswer(cb4, Color.red);
        }

        button.setEnabled(false);
    }

    private void colorAnswer(JCheckBox checkBox, Color color) {
        checkBox.setForeground(color);
    }

    public static void main(String args[]) {
        Problema3 pb3 = new Problema3("intrebare3.txt");
    }
}
