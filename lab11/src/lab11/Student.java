package lab11;

import java.util.ArrayList;

public class Student extends User {

    public ArrayList<Parent> parents = new ArrayList<Parent>();
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public void setMother(Parent parent){
        parents.add(parent);
    }
    public void setFather(Parent parent){
        parents.add(parent);
    }
    public boolean isParent(Parent parent){
        return parents.contains(parent);
    }
    public String getFirstName(){
        return this.firstName;
    }
}
