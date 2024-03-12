package Laborator10;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class BookListApp1 extends JFrame {
    public BookListApp1() {
        super("Book List");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vector<Book> books = new Vector<>();
        for (int i = 0; i < 20; i++) {
            books.add(new Book("Book" + (i + 1), "Author" + (i + 1), ""));
        }

        JList<Book> bookList = new JList<>(books);
        bookList.setCellRenderer(new BookListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(bookList);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookListApp1::new);
    }
}

class BookListCellRenderer extends DefaultListCellRenderer {
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

