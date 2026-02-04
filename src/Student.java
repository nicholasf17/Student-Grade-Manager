/**
 * 
 */

/**
 * 
 */
public class Student {
	private String name;
	private int studentNumber;
	private int grade;


public Student(String name, int studentNumber, int grade) {
	this.name = name;
	this.studentNumber = studentNumber;
	this.grade = grade;
}
public String getName() {
    return name;
}
public int getGrade() {
    return grade;
}

public int getStudentNumber() {
	return studentNumber;
}

public String toString() {
	return "Name: " + name + " Student Number: " + studentNumber + " Grade: " + grade;
	
}
}
