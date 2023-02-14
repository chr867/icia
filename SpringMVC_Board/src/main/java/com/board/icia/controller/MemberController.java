package com.board.icia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dto.MemberDto;
import com.board.icia.service.MemberMM;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberMM mm;
	
	@GetMapping(value="/access")
	public ModelAndView access(MemberDto.access mb) {
		System.out.println("ID: "+mb.getM_id()+"\nPW: "+mb.getM_pw());
		boolean result=mm.access(mb);
		if(result) {
			System.out.println("성공");
			return new ModelAndView("main").addObject("msg","login ok");
		}else {
			System.out.println("실패");
			return new ModelAndView("home").addObject("msg","login Fail");
		}
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mav,MemberDto mb) {
//		log.info("로그");
//		ModelAndView mav=mm.access(mb);
//		mav.addObject("msg","MAV-OK").setViewName("home");
//		return mav;

		return new ModelAndView("home").addObject("msg","MAV-OK");
	}
	
}
