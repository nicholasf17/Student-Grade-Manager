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
		StudentManager manager = new StudentManager();
		boolean exit = false;
		
		System.out.println("Welcome to my Class analyzer");
		
		while(!exit){
		System.out.println("\n1. Add a student");
		System.out.println("2. Display classroom");
		System.out.println("3. Search by student Number");
		System.out.println("4. Calculate Average Grade");
		System.out.println("5. Sort by student Number");
		System.out.println("6. Exit");
		System.out.print("Choose an option:");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		 case 1:
             System.out.print("Student name: ");
             String name = scanner.next();

             int studentNumber = getValidStudentNumber(scanner);
             int grade = getValidGrade(scanner);

              manager.addStudent(name, studentNumber, grade);
              System.out.print("Student Added ");
            
             break;
		 case 2:
             System.out.println("\nAll Students:");
             for (int i = 0; i < manager.getAllStudents().size(); i++) {
                 System.out.println(manager.getAllStudents().get(i));
             }
             break;
		 case 3:
             System.out.print("Enter student number to search: ");
             int searchNumber = getIntInput(scanner);

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
			 manager.sortByStudentNumber();
             System.out.println("Sort Done!");
             break;
		 case 6:
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
	
	private static int getIntInput(Scanner scanner) {
	    while (!scanner.hasNextInt()) {
	        System.out.print("Invalid input. Enter a number: ");
	        scanner.next();
	    }
	    return scanner.nextInt();
	}
	
	private static int getValidGrade(Scanner scanner) {
	    int grade;
	    do {
	        System.out.print("Enter grade (0–100): ");
	        grade = getIntInput(scanner);
	    } while (grade < 0 || grade > 100);
	    return grade;
	}
	private static int getValidStudentNumber(Scanner scanner) {
	    int number;
	    do {
	        System.out.print("Enter student number (positive): ");
	        number = getIntInput(scanner);
	    } while (number <= 0);
	    return number;
	}

		
}

