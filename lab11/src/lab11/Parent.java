package lab11;

import java.util.ArrayList;

public class Parent extends User implements Observer{
    private ArrayList<Student> children;
    private ArrayList<Notification> notif;
    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        this.notif = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addStudentMother(Student student) {
        if (!children.contains(student)) {
            children.add(student);
            student.setMother(this);
        }
    }

    public void addStudentFather(Student student) {
        if (!children.contains(student)) {
            children.add(student);
            student.setFather(this);
        }
    }



    @Override
    public void update(Notification notification) {
        notif.add(notification);
        System.out.println("Parent " + firstName + " " + lastName + " received notification: " + notification);
    }

    public boolean contains(Parent parent) {
        return children.contains(parent);
    }
}
