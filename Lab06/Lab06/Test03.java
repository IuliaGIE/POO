package Lab06;

import java.util.Arrays;
import java.util.Vector;
import java.util.Collections;

interface Persoana extends Comparable<Persoana> {
    double calculMedieGenerala();
    String getNume();
    void setNume(String nume);
    void addMedie(double medie);
}

class Student implements Persoana {
    private String nume;
    private Vector<Double> medii = new Vector<>();

    public Student(String nume) {
        this.nume = nume;
    }

    @Override
    public double calculMedieGenerala() {
        if (medii.isEmpty()) return 0.0;
        double sum = 0;
        for (Double medie : medii) {
            sum += medie;
        }
        return sum / medii.size();
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public void addMedie(double medie) {
        medii.add(medie);
    }

    @Override
    public int compareTo(Persoana otherPerson) {
        if (this.getNume().equals(otherPerson.getNume())) {
            return Double.compare(otherPerson.calculMedieGenerala(), this.calculMedieGenerala());
        }
        return this.getNume().compareTo(otherPerson.getNume());
    }
}

public class Test03 {
    public static void main(String[] args) {
        // Crearea vectorului cu elemente de tip Student
        Vector<Persoana> studenti = new Vector<>();
        Student student1 = new Student("Ana");
        student1.addMedie(9.5);
        student1.addMedie(8.5);
        studenti.add(student1);

        Student student2 = new Student("George");
        student2.addMedie(7.8);
        student2.addMedie(8.0);
        studenti.add(student2);

        Student student3 = new Student("Ana");
        student3.addMedie(8.0);
        student3.addMedie(9.0);
        studenti.add(student3);

        // Sortarea vectorului conform criteriilor
        Collections.sort(studenti);

        // Afișarea rezultatului
        for (Persoana student : studenti) {
            System.out.println("Nume: " + student.getNume() + " Medie: " + student.calculMedieGenerala());
        }
    }
}
