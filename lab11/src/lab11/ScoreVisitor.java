package lab11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Visitor {
    void visit(Assistant assistant);
    void visit(Teacher teacher);
}

class Pair<K, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;

    public Pair(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public K getKey() {
        return key;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}

public class ScoreVisitor implements Visitor{
    private HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores;
    private HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores;
    public ScoreVisitor(HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores, HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores){
        this.examScores=examScores;
        this.partialScores=partialScores;
    }
    @Override
    public void visit(Assistant assistant) {
        Course course = Catalog.getInstance().getCourse(assistant.getFirstName());
        for(Map.Entry<Assistant, ArrayList<Pair<Student, String, Double>>> entry: partialScores.entrySet()){
            Assistant assistant1 = entry.getKey();
            ArrayList<Pair<Student, String, Double>> value= entry.getValue();
            //if we find the assistant
            if(assistant1.firstName.equals(assistant.getFirstName())){
                //iterate though the given list
                for(Pair<Student, String, Double> pair : value){
                    boolean wasFound = false;
                    //iterate though the grades of the course
                    for(Grade grade : course.grades)
                        //if we find the grade that matches the student
                        if(grade.getStudent().getFirstName().equals(pair.getKey().getFirstName())){
                            wasFound = true;
                            grade.setExamScore(pair.getValue2());
                        }
                    if(!wasFound){
                        Grade myGrade = new Grade(pair.getValue1(), pair.getKey());
                        course.addGrade(myGrade);
                        myGrade.setPartialScore(pair.getValue2());
                    }
                }
            }
        }


    }

    @Override
    public void visit(Teacher teacher) {
        Course course = Catalog.getInstance().getCourse(teacher.getFirstName());
        for(Map.Entry<Assistant, ArrayList<Pair<Student, String, Double>>> entry: partialScores.entrySet()){
            Assistant assistant1 = entry.getKey();
            ArrayList<Pair<Student, String, Double>> value= entry.getValue();
            //if we find the assistant
            if(assistant1.firstName.equals(teacher.getFirstName())){
                //iterate though the given list
                for(Pair<Student, String, Double> pair : value){
                    boolean wasFound = false;
                    //iterate though the grades of the course
                    for(Grade grade : course.grades)
                        //if we find the grade that matches the student
                        if(grade.getStudent().getFirstName().equals(pair.getKey().getFirstName())){
                            wasFound = true;
                            grade.setExamScore(pair.getValue2());
                        }
                    if(!wasFound){
                        Grade myGrade = new Grade(pair.getValue1(), pair.getKey());
                        course.addGrade(myGrade);
                        myGrade.setExamScore(pair.getValue2());
                    }
                }
            }
        }
    }
}
