package lab11;

import java.util.*;

public class Grade implements Comparable<Grade>{
    private Double partialScore, examScore;
    private Student student;
    private String course;
    private Course str_course;

    public Grade(String course, Student student) {
        partialScore = 0.0;
        examScore = 0.0;
        this.course = course;
        this.student = student;
    }

    public Grade(String course, Student student,Double partialScore, Double examScore ) {
        this.partialScore = partialScore;
        this.examScore = examScore;
        this.course = course;
        this.student = student;
    }

    public void setPartialScore(Double score) {
        partialScore = score;
    }
    public void setExamScore(Double score) {
        examScore = score;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public Double getTotal() {
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Grade o) {
        return Double.compare(this.getTotal(), o.getTotal());
    }

    @Override
    public String toString() {
        return "Grade{" +
                "partialScore=" + partialScore +
                ", examScore=" + examScore +
                ", student=" + student +
                ", course='" + course + '\'' +
                ", str_course=" + str_course +
                '}';
    }
}
