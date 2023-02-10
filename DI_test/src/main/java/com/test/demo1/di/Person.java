package com.test.demo1.di;

public class Person {
	boolean condition = true;
	public Person(boolean condition) {
		this.condition=condition;
	}

	public int calc() {
		if(condition) return 1;
		else  return 0;
	}
}