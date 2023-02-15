package com.board.icia.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Attr;

import com.board.icia.dto.BoardDto;
import com.board.icia.dto.MemberDto;
import com.board.icia.service.BoardMM;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired //게시판 서비스 클래스
	private BoardMM bm;
	
	@GetMapping("/list")
	public ModelAndView boardList(@RequestParam(defaultValue = "1")Integer pageNum,
			MemberDto.access member)
			/*@RequestParam("m_id") String m_id,
			@RequestParam("m_name") String m_name,
			@RequestParam("m_point") String m_point,
			@RequestParam("m_grade") String m_grade)*/ {
		log.info("pnum:{}",pageNum);
		
		ArrayList<BoardDto> bList=bm.getBoardList(pageNum);
		log.info(bList.toString());
//		new ModelAndView("boardList").addObject("bList", new Gson().toString(bList));
		return new ModelAndView("boardList").addObject("bList", bList); //jstl 제어
				//"boardList";
	}
}
