package com.lsc.isa.person;

public class Student extends Person{
	private String school;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String job, int age, String school) {
		super(name, job, age);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [school=" + school + ", name=" + name + ", job=" + job + ", age=" + age + "]";
	}

	
	
}
