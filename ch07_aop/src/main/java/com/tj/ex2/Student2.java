package com.tj.ex2;

public class Student2 {
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
