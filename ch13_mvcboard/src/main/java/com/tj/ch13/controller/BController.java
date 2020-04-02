package com.tj.ch13.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch13.dto.BoardDto;
import com.tj.ch13.service.*; //service 들이 들어있는 패키지

@Controller
public class BController {
	private BService service;
	private int writable=0;
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		writable = 0;
		return "mvcboard/list";
	}
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		writable = 0;
		return "mvcboard/list";
	}
	@RequestMapping(value="write_view", method = RequestMethod.GET)
	public String write_view() {
		writable=1;
		return "mvcboard/write_view";
	}
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(BoardDto boardDto, HttpServletRequest request, Model model) {	//ip때문에 request객체 어쩔수 없이 model에 넣음.
		if(writable==1) {
			model.addAttribute("request",request);
			service = new BWriteService();
			service.execute(model);
			writable = 0;
		}
		return "forward:list.do";
	}
	@RequestMapping(value="content_view", method = RequestMethod.GET)
	public String content_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		writable = 0;
		return "mvcboard/content_view";
	}
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BDeleteService();
		service.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="modify_view", method = RequestMethod.GET)
	public String modify_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BModifyViewService();
		service.execute(model);
		writable=1;
		return "mvcboard/modify_view";
	}
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("bDto") BoardDto bDto, HttpServletRequest request ,Model model) {	//boardDto가 아닌 다른 이름으로 넣고 싶으면 모델 어트리뷰트 어노테이션 사용
		if(writable==1) {
			model.addAttribute("request", request);
			service = new BModifyService();
			service.execute(model);
			writable = 0;
		}
		return "forward:list.do";
	}
	@RequestMapping(value="reply_view", method = RequestMethod.GET)
	public String reply_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BReplyViewService();
		service.execute(model);
		writable=1;
		return "mvcboard/reply_view";
	}
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String reply(BoardDto boardDto, HttpServletRequest request ,Model model) {	
		if(writable==1) {
			model.addAttribute("request", request);
			service = new BReplyService();
			service.execute(model);
			writable = 0;
		}
		return "forward:list.do";
	}
	
}
