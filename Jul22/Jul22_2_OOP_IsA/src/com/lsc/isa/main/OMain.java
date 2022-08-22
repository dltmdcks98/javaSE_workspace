package com.lsc.isa.main;

import com.lsc.isa.person.Person;
import com.lsc.isa.person.Soldier;
import com.lsc.isa.person.Student;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 홍길동, 20살, 강남대 
		 * 
		 * 김길동, 30살, 군인 
		 * 
		 * 이라는 각각의 사람 
		 * 공통점 사람이라는 공통점 
		 */
		
		Student P1 = new Student("홍길동", "학생", 20, "강남대");
		Soldier P2 = new Soldier("김길동", "군인", 30,"일병");
		
	}

}
