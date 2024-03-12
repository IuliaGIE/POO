package lab10;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class BookListApp extends JFrame {
    public BookListApp() {
        super("Book List");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a Vector to hold Book objects
        Vector<Book> books = new Vector<>();

        // Add more books for testing scrolling
        for (int i = 0; i < 20; i++) {
            books.add(new Book("Book" + (i + 1), "Author" + (i + 1), ""));
        }

        // Create a JList with the Vector of Book objects
        JList<Book> bookList = new JList<>(books);

        // Set the cell renderer to display title and author
        bookList.setCellRenderer(new BookListCellRenderer());

        // Make the list scrollable
        JScrollPane scrollPane = new JScrollPane(bookList);

        // Set layout and add components
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookListApp::new);
    }
}

