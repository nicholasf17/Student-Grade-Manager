/**
 * Student Mangaer
 * contains all logic
 */


public class StudentManager {
	private static final int MAX_STUDENTS = 10;

    private Student[] students;
    private int count;

    public StudentManager() {
        students = new Student[MAX_STUDENTS];
        count = 0;
    }

    public boolean addStudent(String name, int studentNumber, int grade) {
        if (count >= MAX_STUDENTS) {
            return false;
        }

        students[count] = new Student(name, studentNumber, grade);
        count++;
        return true;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getCount() {
        return count;
    }

    public Student findStudentByNumber(int studentNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentNumber() == studentNumber) {
                return students[i];
            }
        }
        return null;
    }

    public double calculateAverage() {
        if (count == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getGrade();
        }

        double average = (double) sum / count;
        return Math.round(average * 100.0) / 100.0;
    }
}