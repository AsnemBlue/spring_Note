package com.tj.ex1;

public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	public void getStudentInfo() {
		System.out.println("이릅 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("학년 : "+gradeNum);
		System.out.println("반 : "+classNum);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
}
