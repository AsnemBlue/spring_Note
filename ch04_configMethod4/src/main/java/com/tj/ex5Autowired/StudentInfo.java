package com.tj.ex5Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentInfo {
	@Autowired	//setter에 붙일수도 있음.
	private Student student;
	
	public Student getStudent() {
		return student;
	}
}
