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
		
		System.out.println("----------------------------------");
        System.out.println("        CLASS ANALYZER");
        System.out.println("----------------------------------");
		
		while(!exit){
			 printMenu();
			 System.out.print("Choose an option:");
			 int choice = scanner.nextInt();
		
			 switch(choice) {
			 	
			 	case 1:
			 		System.out.println("\n--- Add Student ---");
			 		
			 		System.out.print("Student name: ");
			 		String name = scanner.next();

			 		int studentNumber = getValidStudentNumber(scanner);
			 		int grade = getValidGrade(scanner);

			 		manager.addStudent(name, studentNumber, grade);
			 		System.out.print("Student Added ");
            
			 		break;
			 	case 2:
			 		System.out.println("\n------ STUDENT LIST ------");
			 		
			 		 if (manager.getAllStudents().isEmpty()) {
	                        System.out.println("No students found.");
	                        break;
	                    }
			 		 
			 		   System.out.printf("%-12s %-10s %-6s\n", "Name", "ID", "Grade");
	                    System.out.println("--------------------------------");

	                    for (Student student : manager.getAllStudents()) {
	                        System.out.printf("%-12s %-10d %-6d\n",
	                                student.getName(),
	                                student.getStudentNumber(),
	                                student.getGrade());
	                    }

	                    System.out.println("--------------------------------");
	                    break;
          
			 	case 3:
			 		System.out.println("Student found:");
			 		
			 		System.out.print("Enter student number to search: ");
			 		int searchNumber = getIntInput(scanner);

			 		Student found = manager.findStudentByNumber(searchNumber);

			 		if (found != null) {
			 			System.out.println("Student found:");
			 			System.out.println(found);
			 		} else {
			 			 System.out.println("Student not found.");
			 		}
			 		break;
			 	case 4:
			 		 System.out.println("\n--- Class Average ---");
	                 double average = manager.calculateAverage();
	                 System.out.printf("Class average: %.2f\n", average);
			 		break;
			 	case 5:
			 		manager.sortByStudentNumber();
			 		 System.out.println("Students sorted by ID.");
			 		break;
			 	case 6:
			 		exit = true;
			 		System.out.println("Exiting program...");
			 		break;
			 	default:
			 		 System.out.println("Invalid option. Try again.");
			 }
			}
			scanner.close();
		}
	
	private static void printMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Add Student");
        System.out.println("2. Display Classroom");
        System.out.println("3. Search by Student Number");
        System.out.println("4. Calculate Average Grade");
        System.out.println("5. Sort by Student Number");
        System.out.println("6. Exit");
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

