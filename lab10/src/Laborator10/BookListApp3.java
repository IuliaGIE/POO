package Laborator10;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BookListApp3 extends JFrame implements ListSelectionListener {
    private DefaultListModel<Laborator10.Book> listModel;
    private JList<Laborator10.Book> listBook;
    private JTextField titleTextField;
    private JTextField authorTextField;

    public BookListApp3() {
        super("Book List");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        for (int i = 0; i < 20; i++) {
            listModel.addElement(new Laborator10.Book("Book" + (i + 1), "Author" + (i + 1), ""));
        }

        listBook = new JList<>(listModel);
        listBook.setCellRenderer(new BookListCellRenderer());
        listBook.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(listBook);

        titleTextField = new JTextField(20);
        authorTextField = new JTextField(20);

        JPanel infoPanel = new JPanel(new GridLayout(10, 10));
        infoPanel.add(new JLabel("Titlu:"));
        infoPanel.add(titleTextField);
        infoPanel.add(new JLabel("Autor:"));
        infoPanel.add(authorTextField);

        JButton deleteButton = new JButton("Șterge");
        deleteButton.addActionListener(e -> deleteSelectedBook());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.WEST);
        add(infoPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (listBook.isSelectionEmpty()) {
            return;
        }

        Laborator10.Book selectedBook = listBook.getSelectedValue();
        if (selectedBook != null) {
            titleTextField.setText(selectedBook.getName());
            authorTextField.setText(selectedBook.getAuthor());
        }
    }

    private void deleteSelectedBook() {
        int selectedIndex = listBook.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            clearTextFields();
        }
    }

    private void clearTextFields() {
        titleTextField.setText("");
        authorTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Laborator10.BookListApp3::new);
    }
}

class BookListCellRenderer3 extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Laborator10.Book) {
            Laborator10.Book book = (Book) value;
            setText(book.getName() + " by " + book.getAuthor());
        } else {
            setText("");
        }

        return this;
    }
}

