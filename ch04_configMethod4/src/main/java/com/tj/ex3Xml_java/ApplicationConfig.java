package com.tj.ex3Xml_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tj.ex1xml.Student;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가"); hobbies.add("마라톤");
		Student student1 = new Student("신길동", 30, hobbies);
		student1.setHeight(165);
		student1.setWeight(55);
		return student1;
	}	
}
