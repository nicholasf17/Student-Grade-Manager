/**
Features:

Console-based

Menu-driven

Uses a Student class

Stores students in an array

Options:

Add student

Display all students

Search student by ID

Calculate average grade

Exit

 */

import java.util.Scanner;

public class Display {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StudentManager manager= new StudentManager();
		boolean exit = false;
		
		System.out.println("Welcome to my Class analyzer");
		
		while(!exit){
		System.out.println("\n1. Add a student");
		System.out.println("2. Display classroom");
		System.out.println("3. Search by student Number");
		System.out.println("4. Calculate Average Grade");
		System.out.println("5. Exit");
		System.out.print("Choose an option:");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		 case 1:
             System.out.print("Student name: ");
             String name = scanner.next();

             System.out.print("Student number: ");
             int studentNumber = scanner.nextInt();

             System.out.print("Grade: ");
             int grade = scanner.nextInt();

             boolean added = manager.addStudent(name, studentNumber, grade);

             if (!added) {
                 System.out.println("Class is full. Cannot add more students.");
             } else {
                 System.out.println("Student added successfully.");
             }
             break;
		 case 2:
             System.out.println("\nAll Students:");
             for (int i = 0; i < manager.getCount(); i++) {
                 System.out.println(manager.getStudents()[i]);
             }
             break;
		 case 3:
             System.out.print("Enter student number to search: ");
             int searchNumber = scanner.nextInt();

             Student found = manager.findStudentByNumber(searchNumber);

             if (found != null) {
                 System.out.println(found);
             } else {
                 System.out.println("No such student.");
             }
             break;
		 case 4:
             double average = manager.calculateAverage();
             System.out.println("Class average: " + average);
             break;
		 case 5:
             exit = true;
             System.out.println("Goodbye!");
             break;
		default:
			System.out.println("Invalid input");
			break;
		}
		}
		scanner.close();
	}
		
}

