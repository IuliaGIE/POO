import java.util.HashMap;

class Person {
    private String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Teacher extends Person {
    private HashMap<String, Boolean> courses;

    public Teacher(String name, String address) {
        super(name, address);
        courses = new HashMap<>();
    }

    public boolean addCourse(String course) {
        if (!courses.containsKey(course)) {
            courses.put(course, true);
            return true;
        }
        return false;
    }

    public boolean removeCourse(String course) {
        if (courses.containsKey(course)) {
            courses.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", address='" + super.address + '\'' +
                '}';
    }
}

class Student extends Person {
    private HashMap<String, Integer> courseGrades;

    public Student(String name, String address) {
        super(name, address);
        courseGrades = new HashMap<>();
    }

    public void addCourseGrade(String course, int grade) {
        courseGrades.put(course, grade);
    }

    public double getAverageGrade() {
        double total = 0;
        for (int grade : courseGrades.values()) {
            total += grade;
        }
        if (!courseGrades.isEmpty()) {
            return total / courseGrades.size();
        } else {
            return 0.0;
        }
    }

    public void printGrades() {
        for (String course : courseGrades.keySet()) {
            System.out.println("Course: " + course + ", Grade: " + courseGrades.get(course));
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", address='" + super.address + '\'' +
                '}';
    }
}

class Test4 {
    public static void main(String[] args) {
        Student student;
        Teacher teacher;
        Person person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");

        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementată corect";

        assert (teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementată corect";
        assert (teacher.addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este implementată corect";
        assert (teacher.addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este implementată corect";
        assert (!teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementată corect";
        assert (teacher.removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementată corect";
        assert (!teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementată corect";

        student.addCourseGrade("Programare", 10);
        student.addCourseGrade("Algoritmica", 9);
        student.addCourseGrade("Matematica", 8);
        assert (Math.abs(student.getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa Student nu a fost implementată corect";

        student.printGrades();

        System.out.println(student);
        System.out.println(person);

        System.out.println("Felicitări! Problema a fost rezolvată corect!");
    }
}
