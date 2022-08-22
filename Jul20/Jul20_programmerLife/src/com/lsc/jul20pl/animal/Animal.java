package com.lsc.jul20pl.animal;

public class Animal {
	String name;
	int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
}
