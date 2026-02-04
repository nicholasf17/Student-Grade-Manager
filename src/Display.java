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
		Student[] students = new Student[10];
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int count=0;
		System.out.println("Welcome to my Class analyzer");
		boolean flag = false;
		do {
		System.out.println("1. Add a student");
		System.out.println("2. Display classroom");
		System.out.println("3. Search by student Number");
		System.out.println("4. Calculate Average Grade");
		System.out.println("5. Exit");
		int input = scanner.nextInt();
		switch(input) {
		case 1:
			System.out.println();
			if(i == 0) {
				System.out.println("What is the students name?");
				String name = scanner.next();
				
				System.out.println("What is the student number");
				int studentNumber = scanner.nextInt();
				System.out.println("What was the grade");
				int grade = scanner.nextInt();
				students[count] = new Student(name, studentNumber, grade);
				count++;
			}
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("All students");
			for(int j = 0; j < count; j++) {
				System.out.println(students[j]);
			}
			System.out.println();
			break;
		case 3:
			
			//Search by student number 
			//grab students name number and grade
			//display it
			System.out.println();
			System.out.println("What is the students number that your searching for ");
			int studentNumber = scanner.nextInt();
			for(int k = 0; k < students.length - 1; k++) {
				if(students[k].getStudentNumber() == studentNumber) {
					System.out.println("Name: "+ students[k].getName() + " Grade: "+students[k].getGrade() );
					break;
				}	
				}
			System.out.println("No such student ");
			break;
		case 4:
			System.out.println();
			double average = getAverage(students, count);
			System.out.println("Class average " + average);
			System.out.println();
			break;
		case 5: 
			flag = true;
			break;
		default:
			System.out.println("Invalid input");
			System.out.println();
			break;
		}
		}while(flag == false);

	}
	
	public static double getAverage(Student[] students, int count){
		int i = 0;
		int sum = 0;
		while(i < count) {
			sum = students[i].getGrade() + sum;
			i++;
		}
		double value = (double) sum / count;
		return Math.round(value* 100.0)/100.0;
		
	}

}
