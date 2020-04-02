package com.tj.ch12.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch12.dto.Student;
import com.tj.ch12.dto.StudentValidator;

@Controller
public class HomeController {
	@RequestMapping(value = "inputForm" , method=RequestMethod.GET)
	public String memberInput() {
		return "inputForm";
	}
	@RequestMapping(value = "input" , method=RequestMethod.POST)
	public String input(@Valid Student student, BindingResult errors, Model model) {	//두줄 대신에 어노테이션 사용가능 함수밑의 어노테이션 추가 해야 함
		//StudentValidator validator = new StudentValidator();
		//validator.validate(student, errors); //검증해
		if(errors.hasErrors()) {
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("nameError", "name을 입력하시오");
			}
			if(errors.getFieldError("id")!=null) {
				model.addAttribute("idError", "id에 자연수를 입력하시오");
			}
			return "inputForm";
		}
		return "inputResult";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
