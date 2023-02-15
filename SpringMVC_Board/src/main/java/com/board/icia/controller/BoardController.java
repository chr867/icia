package com.board.icia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dto.BoardDto;
import com.board.icia.dto.MemberDto;
import com.board.icia.service.BoardMM;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired //게시판 서비스 클래스
	private BoardMM bm;
	
	@GetMapping("/list")
	public ModelAndView boardList(@RequestParam(defaultValue = "1") Integer pageNum
			, String member
			){
		log.info("pnum:{}",pageNum);
		log.info("BC member: "+member);
//		log.info("BC member: "+new Gson().fromJson(member,MemberDto.class));
		List<BoardDto> bList=bm.getBoardList(pageNum);
//		new ModelAndView("boardList").addObject("bList",new Gson().toString(bList));
		return new ModelAndView("boardList").addObject("bList",bList).addObject("member", new Gson().fromJson(member,MemberDto.class)); //jstl제어
//		log.info(bList.toString());
		//return "boardList";
	}
}
