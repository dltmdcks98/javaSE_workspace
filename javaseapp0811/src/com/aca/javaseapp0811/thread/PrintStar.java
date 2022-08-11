package com.aca.javaseapp0811.thread;

public class PrintStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//스레드 한개를 생성하여, 일을 시켜보자
		Star s1 = new Star("☆");
		Star s2 = new Star("★");
		s1.start();//run()을 호출하면 일반 메서드 수행-> 스레드 효과X start()가 jvm이 실행하는 것
		s2.start();
	}	

}
