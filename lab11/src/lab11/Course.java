package lab11;
import java.util.ArrayList;

public class Course {
    String name;
    Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    ArrayList<Assistant> assistants;
    ArrayList<Grade> grades;
    Strategy strategy;

    public Course(String name, Teacher teacher, ArrayList<Assistant> assistants,
                  ArrayList<Grade> grades, Strategy strategy) {
        this.name = name;
        this.teacher = teacher;
        this.assistants = assistants;
        this.grades = grades;
        this.strategy = strategy;
    }

    public String toString() {
        return name;
    }

    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }
    public void addGrade(Grade g){
        grades.add(g);
    }
    public static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private ArrayList<Assistant> assistants = new ArrayList<>();
        private ArrayList<Grade> grades = new ArrayList<>();
        private Strategy strategy;

        public CourseBuilder(String name) {
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            this.assistants.add(assistant);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            this.grades.add(grade);
            return this;
        }
        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(name, teacher, assistants, grades, strategy);
        }
    }
}