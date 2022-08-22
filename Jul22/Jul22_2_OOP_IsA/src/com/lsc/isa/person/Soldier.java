package com.lsc.isa.person;

public class Soldier extends Person {
	private String grade;
	
	public Soldier() {
		// TODO Auto-generated constructor stub
	}

	public Soldier(String name, String job, int age, String grade) {
		super(name, job, age);
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	//왜 Person의 name을 가져오지 못하나? private라서
	//따라서 getter로 받아와야한다.
	
	@Override
	public String toString() {
		return "Soldier [grade=" + grade + ", name=" + name + ", job=" + getJob() + ", age=" + age + "]";
	}
	
}
