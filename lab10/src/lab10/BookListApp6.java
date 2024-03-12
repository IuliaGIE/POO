package lab10;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookListApp6 extends JFrame implements ListSelectionListener {
    private DefaultListModel<Book> listModel;
    private JList<Book> listBook;
    private JTextField titleTextField;
    private JTextField authorTextField;

    public BookListApp6() {
        super("Book List");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        listModel.addElement(new Book("The Great Gatsby", "F. Scott Fitzgerald", "android"));
        listModel.addElement(new Book("To Kill a Mockingbird", "Harper Lee", "cpp"));
        listModel.addElement(new Book("1984", "George Orwell", "cs"));
        listModel.addElement(new Book("Pride and Prejudice", "Jane Austen", "ios"));
        for (int i = 0; i < 20; i++) {
            listModel.addElement(new Book("Book" + (i + 1), "Author" + (i + 1), "java"));
        }

        listBook = new JList<>(listModel);
        listBook.setCellRenderer(new BookRenderer());
        listBook.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(listBook);

        titleTextField = new JTextField(20);
        authorTextField = new JTextField(20);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        infoPanel.add(new JLabel("Title:"));
        infoPanel.add(titleTextField);
        infoPanel.add(new JLabel("Author:"));
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
        SwingUtilities.invokeLater(BookListApp6::new);
    }
}

class BookRenderer extends JPanel implements ListCellRenderer<Book> {
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel imageLabel;

    public BookRenderer() {
        setLayout(new GridLayout(1, 3));

        titleLabel = new JLabel();
        authorLabel = new JLabel();
        imageLabel = new JLabel();

        add(titleLabel);
        add(authorLabel);
        add(imageLabel);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book value, int index, boolean isSelected, boolean cellHasFocus) {
        titleLabel.setText("Title: " + value.getName());
        authorLabel.setText("Author: " + value.getAuthor());

        // Obțineți calea completă către directorul imaginilor
        String imagePath = System.getProperty("user.dir") + File.separator + "C:\\Users\\gie10\\OneDrive - Universitatea Politehnica Bucuresti\\An2\\sem1\\POO\\lab10\\src\\lab10\\Imagini" + File.separator + value.getIconName() + ".jpg";
        ImageIcon icon = new ImageIcon(imagePath);
        imageLabel.setIcon(icon);

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            if (index % 2 == 0) {
                setBackground(Color.GREEN); // Fiecare celulă pe poziție para va avea fundal verde
            } else {
                setBackground(Color.YELLOW); // Fiecare celulă pe poziție impara va avea fundal galben
            }
            setForeground(list.getForeground());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
