package com.lsc.oopecl.person;

 public class Person {
	private String name;
	private int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void setter(String name) {
		this.name = name;
	}
	public void setter(int age) {
		if(age<0) {
			age*=-1;
		}
		
		this.age = age;
	}

	public void print() {
		System.out.println(name);
		System.out.println(age);
		
		
	}
}
