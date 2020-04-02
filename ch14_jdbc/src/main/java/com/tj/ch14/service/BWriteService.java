package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;

public class BWriteService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //model안에 있는 dto와 request객체를 빼기 위한 작업
		BoardDto dto = (BoardDto) map.get("boardDto"); //bname, btitle, bcontent
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		dto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.write(dto);
		model.addAttribute("writeResult",result);
	}

}
