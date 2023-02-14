package com.board.icia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dto.MemberDto;
import com.board.icia.service.MemberMM;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/member") //공통 URL
public class MemberController {
	@Autowired
	private MemberMM mm;
	
	@GetMapping(value="/join") //GetMapping = SELECT or Forwarding
	public String joinFrm() {
		return "joinFrm";
	}
	
	@PostMapping(value="/join")
	public ModelAndView joinFrm(MemberDto.join mb) {
//		log.info("{}",mb);
		boolean result=mm.join(mb);
		if(result) {
			return new ModelAndView("home").addObject("msg","join ok");
		}else {
			return new ModelAndView("joinFrm").addObject("msg","join Fail");
			
		}
	}
		
	@PostMapping(value="/access")
	public ModelAndView access(MemberDto.access mb, HttpSession session) {
		boolean result=mm.access(mb);
		if(result) {
			session.setAttribute("id", mb.getM_id());
			return new ModelAndView("main").addObject("msg","login ok");
		}else {
			return new ModelAndView("home").addObject("msg","login Fail");
		}
	}	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelAndView mav,MemberDto mb) {
//		log.info("로그");
//		ModelAndView mav=mm.access(mb);
//		mav.addObject("msg","MAV-OK").setViewName("home");
//		return mav;

		return "home";
//		return new ModelAndView("home").addObject("msg","OK");
	}
	
}
