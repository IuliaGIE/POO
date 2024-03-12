package lab08.lab08;

import java.util.*;

public class Catalog extends TreeSet<Catalog.Student> {
    public Catalog() {
        super();
    }

    public Catalog(Comparator<Student> comparator) {
        super(comparator);
    }

    public void addStudent(String name, double media, int clazz) {
        add(new Student(name, media, clazz));
    }

    public Student getStudent(String name) {
        for (Student student : this) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(String name) {
        Iterator<Student> iterator = iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.name.equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    public Catalog byClass(int clazz) {
        Catalog result = new Catalog();
        for (Student student : this) {
            if (student.clazz == clazz) {
                result.add(student);
            }
        }
        return result;
    }

    public static class Student implements Comparable<Student> {
        String name;
        double media;
        private int clazz;

        public Student(String name, double media, int clazz) {
            this.name = name;
            this.media = media;
            this.clazz = clazz;
        }

        @Override
        public int compareTo(Student other) {
            int mediaComparison = Double.compare(other.media, this.media);
            if (mediaComparison != 0) {
                return mediaComparison;
            }
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', media=" + media + ", clazz=" + clazz + '}';
        }
    }
}
