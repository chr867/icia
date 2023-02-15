package com.board.icia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.dto.MemberDto;
import com.board.icia.service.MemberMM;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/member") //공통 URL
public class MemberController {
	@Autowired
	private MemberMM mm;
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping //member?val=10&str=hello
	public String index(@RequestParam(required = false, defaultValue = "1") Integer val, @RequestParam(required = false) String str) {
		log.info(val+","+str);
		return "index";
	}
	
	@GetMapping(value="/join") //GetMapping = SELECT or Forwarding
	public String joinFrm() {
		return "joinFrm";
	}
	
	@PostMapping(value="/join")
	public ModelAndView joinFrm(MemberDto.join mb) {
//		log.info("{}",mb);
		boolean result=mm.join(mb);
		if(result) {
			return new ModelAndView("home").addObject("msg","join ok").addObject("check",1);
		}else {
			return new ModelAndView("joinFrm").addObject("msg","join Fail");
		}
	}
		
	@PostMapping(value="/access")
	public ModelAndView access(MemberDto.access mb, HttpSession session, RedirectAttributes attr) {
		boolean result=mm.access(mb);
		if(result) {
			session.setAttribute("id", mb.getM_id());
//			attr.addAttribute("msg","login OK"); //Redirect 전 Session 영역에 저장, Request 객체에 저장 후 Session 삭제
			attr.addFlashAttribute("msg","login OK"); //Session 영역에 저장, 1번 사용 후 삭제
//			return new ModelAndView("main").addObject("msg","login Ok");
			return new ModelAndView("redirect:/board/list");
			//.addObject("msg","Login OK"); //Redirect 시 새로운 Request 객체에 속성 추가 (get 방식만 가능)
		}else {
			attr.addFlashAttribute("msg","login Fail");
			attr.addFlashAttribute("check",2);  //회원가입 성공:1, 로긴 실패:2
			return new ModelAndView("redirect:/member/");
		}
	}	
	
	@PostMapping(value="/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("id")!=null) {
			session.invalidate();
			return "redirect:/member/";
		}else {
			log.info("로그인이 돼있지 않습니다"); //세션 타임아웃(30분,초기화)후 redirect 에러
			return "forward:/member/";
		}
		
	}
}
		

/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelAndView mav,MemberDto mb) {
		log.info("로그");
		ModelAndView mav=mm.access(mb);
		mav.addObject("msg","MAV-OK").setViewName("home");
		return mav;

		return "home";
		return new ModelAndView("home").addObject("msg","OK");
	}*/
