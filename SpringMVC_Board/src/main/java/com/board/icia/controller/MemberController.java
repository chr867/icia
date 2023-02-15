package com.board.icia.controller;

import java.lang.ProcessHandle.Info;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.dto.MemberDto;
import com.board.icia.service.MemberMM;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
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
	public String index(@RequestParam(required = false) Integer val, @RequestParam String str) {
		log.info(val+","+str);
		return "index";
	}
	
	@PostMapping(value = "/join")
	public ModelAndView join(MemberDto mb, RedirectAttributes attr) {
		boolean result=mm.join(mb);
		if(result) {
			return new ModelAndView("home").addObject("msg", "join OK").addObject("check", "1");
		}else {
			return new ModelAndView("join").addObject("msg", "join Fail").addObject("check", "2"); 
		}
	}
	//로그아웃
	@PostMapping(value = "/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("id")!=null) {
			session.invalidate();
			return "redirect:/member/";
		}else {
			log.info("접속 30분후...세션초기화"); //세션타임아웃(30분,초기화)후 redirect에러남
			return "forward:/member/"; //forward가 처리되지 않지만 에러는 안남
		}
		
	}
	
	  @PostMapping(value = "/access")
	  public ModelAndView access(MemberDto mb, HttpSession session, RedirectAttributes attr) {
	  MemberDto member=mm.access(mb); 
	  if(member !=null) { 
		  session.setAttribute("id", mb.getM_id());//로그인 마킹
		  //redirect전 session영역에 저장한 뒤 request객체에 저장후 session영역 삭제 함
		  //attr.addAttribute("msg", "login OK!!!"); //여러번사용가능
		  //session영역에 저장한뒤 한번 사용하고 삭제
		  //attr.addFlashAttribute("msg", "login OK!!!"); //한번만 사용가능
		 // attr.addFlashAttribute("check", "1"); //한번만 사용가능
		  //Redirect 시 새로운 request객체에 속성값을 저장한다.
	 // attr.addFlashAttribute("member",member);
	  //get방식만 가능
		  //attr.addAttribute("mb",member);
		  log.info("MC member: "+new Gson().toJson(member));//.getClass().getName());
//		  attr.addAttribute("member",new Gson().toJson(member));
		  return new ModelAndView("redirect:/board/list").addObject("member",new Gson().toJson(member));//.addObject("member",member);
		  }else { 
			  attr.addFlashAttribute("msg", "login Fail!!!");
			  attr.addFlashAttribute("check", "2");	//회원가입성공:1, 로그인 실패:2
			  
			  return new ModelAndView("redirect:/member/");  //home.jsp
		 // return new ModelAndView("home").addObject("msg", "login Fail"); 
		  } 
	  }
	 	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	
	
}
