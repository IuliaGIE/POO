package lab12;

import java.util.ArrayList;

public class IntegerMatrix extends AMatrix<Integer> {

    // Constructorul
    public IntegerMatrix(int n, int m) {
        super();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            this.add(row);
        }
    }

    // Metoda toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append("[");
            for (int j = 0; j < this.get(i).size(); j++) {
                sb.append(this.get(i).get(j) + " ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    // Metoda sum()
    @Override
    public Integer sum(Integer obj1, Integer obj2) {
        return obj1 + obj2;
    }

    // Metoda addition()
    @Override
    public AMatrix<Integer> addition(AMatrix<Integer> m) {
        if (this.size() != m.size() || this.get(0).size() != m.get(0).size()) {
            throw new IllegalArgumentException("Matricile nu au aceeași dimensiune");
        }


        IntegerMatrix result = new IntegerMatrix(this.size(), this.get(0).size());


        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.get(i).size(); j++) {
                result.get(i).set(j, this.get(i).get(j) + m.get(i).get(j));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        IntegerMatrix m1 = new IntegerMatrix(3, 2);
        m1.get(0).set(0, 1);
        m1.get(0).set(1, 2);
        m1.get(1).set(0, 3);
        m1.get(1).set(1, 4);
        m1.get(2).set(0, 5);
        m1.get(2).set(1, 6);

        IntegerMatrix m2 = new IntegerMatrix(3, 2);
        m2.get(0).set(0, 7);
        m2.get(0).set(1, 8);
        m2.get(1).set(0, 9);
        m2.get(1).set(1, 10);
        m2.get(2).set(0, 11);
        m2.get(2).set(1, 12);

        IntegerMatrix m3 = (IntegerMatrix) m1.addition(m2);
        System.out.println(m3);
    }
}


