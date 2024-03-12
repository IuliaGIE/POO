package lab11;
import java.util.Collection;
public interface Strategy {
    Student getBestStudent(Collection<Grade> grades);
}

class BestExamScore implements Strategy{
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 1.0;
        Student bestStudent = null;
        for (Grade grade : grades) {
            if (grade.getExamScore() > max) {
                max = grade.getPartialScore();
                bestStudent = grade.getStudent();
            }
        }
        return bestStudent;
    }
}

class BestTotalScore implements Strategy{
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 1.0;
        Student bestStudent = null;
        for (Grade grade : grades) {
            if (grade.getTotal() > max) {
                max = grade.getPartialScore();
                bestStudent = grade.getStudent();
            }
        }
        return bestStudent;
    }
}

class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 1.0;
        Student bestStudent = null;
        for (Grade grade : grades) {
            if (grade.getPartialScore() > max) {
                max = grade.getPartialScore();
                bestStudent = grade.getStudent();
            }
        }
        return bestStudent;
    }
}
