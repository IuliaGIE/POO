package lab10;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BookListApp2 extends JFrame implements ListSelectionListener {
    private DefaultListModel<Book> listModel;
    private JList<Book> listBook;
    private JTextField titleTextField;
    private JTextField authorTextField;

    public BookListApp2() {
        super("Book List");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        listModel.addElement(new Book("The Great Gatsby", "F. Scott Fitzgerald", ""));
        listModel.addElement(new Book("To Kill a Mockingbird", "Harper Lee", ""));
        listModel.addElement(new Book("1984", "George Orwell", ""));
        listModel.addElement(new Book("Pride and Prejudice", "Jane Austen", ""));
        for (int i = 0; i < 20; i++) {
            listModel.addElement(new Book("Book" + (i + 1), "Author" + (i + 1), ""));
        }

        listBook = new JList<>(listModel);
        listBook.setCellRenderer(new BookListCellRenderer());
        listBook.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(listBook);

        titleTextField = new JTextField(20);
        authorTextField = new JTextField(20);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        infoPanel.add(new JLabel("Titlu:"));
        infoPanel.add(titleTextField);
        infoPanel.add(new JLabel("Autor:"));
        infoPanel.add(authorTextField);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.WEST);
        add(infoPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (listBook.isSelectionEmpty()) {
            return;
        }

        Book selectedBook = listBook.getSelectedValue();
        if (selectedBook != null) {
            titleTextField.setText(selectedBook.getName());
            authorTextField.setText(selectedBook.getAuthor());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookListApp2::new);
    }
}

class BookListCellRenderer2 extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Book) {
            Book book = (Book) value;
            setText(book.getName() + " by " + book.getAuthor());
        } else {
            setText("");
        }

        return this;
    }
}

