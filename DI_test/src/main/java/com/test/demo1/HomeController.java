package com.test.demo1;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.demo1.bean.Member;
import com.test.demo1.di.A;
import com.test.demo1.di.Person;
import com.test.demo1.di.Student;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	Spring에서 IoC에 저장된 빈(객체)을 주입
	
//	1.필드 주입(비권장)
//	@Autowired 
	private Student std;
	private Person p;
	
//	2.생성자 주입(권장)
//	@Autowired
//	public HomeController(Student std) {
//		this.std=std;
//	}

//	3.setter 주입(비권장)
	@Autowired
	public void setStd(Student student) {
		this.std=student;
	}
	
	@GetMapping({"/","/a"})
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale); 
//		log.info("locale is {}",locale);

//		Version 1
//		Student std=new Student();
		
//		Version 2
//		HomeController, Student, Person간 결합도 너무 높다.
//		boolean condition=false;
//		Student std=new Student(condition);
		
//		DI로 결합도를 낮출 수 있다.
//		boolean condition=false;
//		Person person=new Person(condition);
//		Student 객체에 Person 객체를 주입(DI)한다.
//		Student std=new Student(person);
		
		A a=new A(10,"aaa");
		a=new A();
		
//		1.필드 주입
		std.print();
		return "home";
	}
	
	@GetMapping("/access")
	public String access(Model model,  Member mb ) { //bean Version @ModelAttribute("mb") 어노션 생략 가능
//	 public String access(Model model, @RequestParam Map<String,String> mb ) { //Map Version
//	 public String access(Model model, @RequestParam("id") String id, @RequestParam() String pw) { //일일이
		
//		DB~~
//		Request 영역에 id Key,Value 저장

//		bean Version
//		model.addAttribute("mb",mb);
		model.addAttribute("id", mb.getId());
		model.addAttribute("pw", mb.getPw());
//		String id=((Member)model.getAttribute("member")).getId();
//		System.out.println("id: "+id);
//		model.addAttribute("id",id);
		
//		Map Version
//		model.addAttribute("id", mb.get("id")); 
//		model.addAttribute("pw", mb.get("pw"));

//		일일이
//		model.addAttribute("id", id); 
//		model.addAttribute("pw", pw);
		return "main"; //main.jsp 포워딩
	}

}
