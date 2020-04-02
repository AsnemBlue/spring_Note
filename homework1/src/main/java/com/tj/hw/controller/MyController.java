package com.tj.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.hw.dto.Student;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt(){
		return 4;
	}
	@RequestMapping(value="inputForm", method=RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String input(Student student) {
		return "input";
	}
	
}
