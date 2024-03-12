package lab10;

import javax.swing.*;
import java.awt.*;

public class BookListCellRenderer extends DefaultListCellRenderer {
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
