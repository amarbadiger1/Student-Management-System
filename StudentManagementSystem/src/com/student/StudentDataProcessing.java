package com.student;

import java.util.Set;

public class StudentDataProcessing {

	private static Set<Student> getAllStudent() {
		Set<Student> allStudents = StudentDatabase.getAllStudents();
		return allStudents;
	}

	public static void addStudent(String studentName, String studentId, double marks) {

		Student s = new Student(studentName, studentId, marks);

		StudentDatabase.studentDb(s);
	}

	public static void updateStudent(String newName, String Studentid) {

		Set<Student> allStudents = getAllStudent();

		Student s = allStudents.stream().filter(a -> a.getStudentId().equals(Studentid)).findFirst().orElse(null);

		if (s == null) {
			System.err.println("Student Not Found");
		} else {
			s.setStudentName(newName);
			System.out.println("New Name Updated to " + newName);
			System.out.println(s);
		}

	}

	public static void deleteStudent(String studentId) {
		Set<Student> allStudents = getAllStudent();

		Student s = allStudents.stream().filter(a -> a.getStudentId().equals(studentId)).findFirst().orElse(null);

		if (s == null) {
			System.err.println("Student Not Found");
		} else {
			allStudents.remove(s);
			System.err.println("Student Removed");
		}

	}

	public static void viewAllStudents() {
		Set<Student> allStudents = getAllStudent();
		allStudents.stream().forEach(a -> System.out.println(a));
	}

	public static void SearchByRollNumber(String rno) {
		Set<Student> allStudents = getAllStudent();

		allStudents.stream().filter(a -> a.getStudentId().equals(rno)).findFirst()
				.ifPresentOrElse((s) -> System.out.println(s), () -> System.out.println("Student Not Found"));
	}

	public static void sortStudentsByMarks() {
		Set<Student> allStudents = getAllStudent();

		allStudents.stream().sorted((a, b) -> (int) a.getMarks() - (int) b.getMarks()).forEach(System.out::println);
	}

	public static void showToppers() {
		Set<Student> allStudents = getAllStudent();
		
		allStudents.stream().sorted((a,b)->(int) b.getMarks()-(int) a.getMarks()).limit(10).forEach(i->System.out.println(i));
	} 

	public static void showPassedStudents() {

	}

	public static void showAverageMarks() {

	}
}
