import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Student Manager
 * contains all logic
 */


public class StudentManager {
	

	ArrayList<Student> students;
   

    public StudentManager() {
    	students = new ArrayList<>();
       
    }

    public void addStudent(String name, int studentNumber, int grade) {
      students.add(new Student(name, studentNumber, grade));
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

   
    public Student findStudentByNumber(int studentNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber() == studentNumber) {
                return students.get(i);
            }
        }
        return null;
    }

    public double calculateAverage() {
        if (students.size() == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).getGrade();
        }

        double average = (double) sum / students.size();
        return Math.round(average * 100.0) / 100.0;
    }
    
    public void sortByStudentNumber() {
    	Collections.sort(students, Comparator.comparingInt(Student::getStudentNumber));
    }
}