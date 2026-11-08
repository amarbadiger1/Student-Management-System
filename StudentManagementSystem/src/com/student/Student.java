package com.student;

import java.util.Objects;

public class Student {
	private String studentName;
	private String studentId;
	private double marks;

//	private final static int MODLIMIT = 3;

	public Student(String studentName, String studentId, double marks) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.marks = marks;
	}

	public String getStudentName() {
		return studentName;
	}

	public double getMarks() {
		return marks;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (!(obj instanceof Student)) {
			return false;
		}
		
		Student s = (Student) obj;
		return this.studentId.equals(s.studentId);
	}

	@Override
	public String toString() {
		return studentName + " | " + studentId + " | " + marks;
	}

}
