package com.tj.ex1student;

public class StudentInfo {
	private Student student;
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	Student getStudent() {
		return student;
	}

	public void print() {
		if(student!=null) {
			System.out.println("이름: "+student.getName());
			System.out.println("나이: "+student.getAge());
			System.out.println("학년: "+student.getGradeNum());
			System.out.println("학반: "+student.getClassNum());
			System.out.println("--------------------------------");
		}else {
			System.out.println("학생정보가 조회되지 않습니다.");
		}
	}
}
