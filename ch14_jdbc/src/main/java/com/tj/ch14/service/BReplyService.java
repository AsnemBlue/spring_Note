package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;

public class BReplyService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest  request = (HttpServletRequest) map.get("request");
		BoardDto			boardDto	= (BoardDto)map.get("boardDto");
		boardDto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("replyResult",bDao.reply(boardDto));
	}

}
