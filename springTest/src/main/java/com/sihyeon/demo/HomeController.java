package com.sihyeon.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sihyeon.demo.bean.Member;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//@RequestMapping(value = "/")
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home"; //home.jsp
	}
	 
//	@RequestMapping(value = "/access", method = RequestMethod.GET)
	@GetMapping("/access")
//	?id(key)=aaaa(value)&pw(key)=1234(value)
	
	public String access(Model model, Member mb){ //직접 만든 bean 사용시 param X
//	public String access(Model model, @RequestParam Map<String, String> mb){
		System.out.println("id: "+mb.getId()+"\npw: "+mb.getPw());
		model.addAttribute("mb",mb); //request.setattribute("mb",mb);
		mb=(Member)model.getAttribute("mb");
		System.out.println(mb.toString());
		return "main"; //main.jsp
	}
	
//	public void access(Locale locale, Model model) {	
//	리턴받지 못하면 MappingUrl.jsp를 찾아감
//	}
	
	
}
