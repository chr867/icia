package com.test.demo1.di;

import org.springframework.beans.factory.annotation.Autowired;

//Student는 Person에게 의존성이 있다.
//Person 소스가 변경되면 Student 소스도 변경해야 됨 (결합성(복잡도)이 높다)
public class Student {
//	@Autowired //필드 주입
	private Person person;
	
	
//	@Autowired //생성자 주입
	public Student(Person person) {
		this.person=person;
	}

//	@Autowired //setter 주입
	public void setPerson(Person person) {
		this.person = person;
	}

	public void print() {
		System.out.println(person.calc());
	}
}
