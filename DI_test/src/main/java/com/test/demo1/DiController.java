package com.test.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.demo1.di.A;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //@NonNull or final 필드값을 생성자 주입

public class DiController {
//	@Autowired //(type을 기준으로 주입)

//	@NonNull
//	A a1;
	final A a1;
//	@Autowired
	final A a2;

//	@Autowired
//	public DiController(A a1, A a2) {
//		this.a1=a1; this.a2=a2;
//	} -->	@RequiredArgsConstructor
	
	@GetMapping("/di")
	public String diTest() {
		System.out.println("result: "+(a1==a2));	
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a1.equals(a2));
		return "home";
	}
}
