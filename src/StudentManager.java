import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
/**
 * Student Manager
 * contains all logic
 */


public class StudentManager {
	

	ArrayList<Student> students;
   

    public StudentManager() {
    	students = new ArrayList<>();
    	loadFromFile();
    }

    public void addStudent(String name, int studentNumber, int grade) {
      students.add(new Student(name, studentNumber, grade));
      saveToFile();
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
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {
                writer.println(s.getName() + "," + s.getStudentNumber() + "," + s.getGrade());
            }

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
    private void loadFromFile() {

        try (Scanner fileScanner = new Scanner(new File("students.txt"))) {

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                int number = Integer.parseInt(parts[1]);
                int grade = Integer.parseInt(parts[2]);

                students.add(new Student(name, number, grade));
            }

        } catch (FileNotFoundException e) {
            System.out.println("No saved students yet.");
        }
    }
}