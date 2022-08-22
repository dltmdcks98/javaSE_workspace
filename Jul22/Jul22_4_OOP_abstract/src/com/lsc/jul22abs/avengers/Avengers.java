package com.lsc.jul22abs.avengers;

import com.lsc.jul22abs.smoker.Smoker;

//아이언맨, 헐크 같은 애들이 만든 조직 -> 추상적인 개념 
public abstract class Avengers{
	private String name;
	private int age;
	private String type;
	
	public Avengers() {
		// TODO Auto-generated constructor stub
	}

	public Avengers(String name, int age, String type) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//어벤져스들의 공통적인 기능이나 어벤져스의 추상적인 개념 
	public abstract void attack();
	
	public void print() {
		System.out.println(name + age + type);
	}
}
