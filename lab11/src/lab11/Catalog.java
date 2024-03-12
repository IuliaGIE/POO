package lab11;
import java.util.ArrayList;

public class Catalog implements Subject{
    private static Catalog obj = null;
    private ArrayList<Course> courses;
    public ArrayList<Observer> observers = new ArrayList<>();
    private Catalog(){

        courses = new ArrayList<>();
    }
    public void addCourse(Course course){

        this.courses.add(course);
    }
    public static Catalog getInstance(){
        if (obj == null)
            obj = new Catalog();
        return obj;
    }
    public String toString(){
        StringBuilder myString = new StringBuilder();
        for(Course course : Catalog.getInstance().courses){
            myString.append(" ");
            myString.append(course.toString());
       }
        return myString.toString();
}
    public Course getCourse(String name){
        for(Course course : courses){
            if (course.getTeacher().getFirstName().equals(name))
                return course;
            for(Assistant assistant : course.getAssistants()){
                if(assistant.firstName.equals(name))
                    return course;
            }
        }
        return null;
    }
    @Override
    public void addObserver(Observer observer) {

        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for(Observer observer : observers)
            if(grade.getStudent().isParent((Parent)observer))
                observer.update(new Notification("congratulations your child has received the grade", grade));
    }
}
