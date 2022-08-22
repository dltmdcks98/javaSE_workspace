package com.lsc.oopecl.main;

import java.util.Scanner;

import com.lsc.oopecl.person.Person;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("홍길동",20);
		p.print();
		
		//Person의 멤버변수가 private일때 값 변경하는 법 
		Scanner input = new Scanner(System.in);
		p.setter(input.nextLine()); 
		p.setter(Integer.parseInt(input.nextLine()));;
		p.print();
	}

}
