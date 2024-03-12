package lab08.lab08;
import java.util.Vector;

public class Table {
    private Vector<Vector<Object>> data;

    public Table(Object[][] rows) {
        this.data = new Vector<>();
        for (Object[] row : rows) {
            Vector<Object> rowData = new Vector<>();
            for (Object cell : row) {
                rowData.add(cell);
            }
            data.add(rowData);
        }
    }

    public void print(Printer printer) {
        printer.print(this);
    }

    public interface Printer {
        void print(Table table);
    }

    public class AsciiPrinter implements Printer {
        private int[] columnWidths;

        public AsciiPrinter(int[] columnWidths) {
            this.columnWidths = columnWidths;
        }

        @Override
        public void print(Table table) {
            for (Vector<Object> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    Object cell = row.get(i);
                    System.out.format("%-" + columnWidths[i] + "s", cell);
                    System.out.print("|");
                }
                System.out.println();
            }
        }
    }

    public class CsvPrinter implements Printer {
        @Override
        public void print(Table table) {
            for (Vector<Object> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    Object cell = row.get(i);
                    System.out.print(cell);
                    if (i < row.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Object rows[][] = new Object[][] {
                {"#", "Materie", "An", "Semestru", "Credite"},
                {1, "Programarea calculatoarelor", 1, 1, 6},
                {2, "Structuri de date", 1, 2, 6},
                {3, "Programare Orientata pe Obiecte", 2, 1, 6},
        };
        Table t = new Table(rows);
        t.print(t.new CsvPrinter());
        t.print(t.new AsciiPrinter(new int[] {2, 32, 8, 8, 8}));
    }
}
