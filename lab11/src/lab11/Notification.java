package lab11;
public class Notification {
    String mesaj;
    Grade grade;

    public Notification(String mesaj, Grade grade) {
        this.mesaj = mesaj;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.mesaj + this.grade;
}
}
