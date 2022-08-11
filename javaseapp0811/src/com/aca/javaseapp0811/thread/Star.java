package com.aca.javaseapp0811.thread;

//별을 출력하는 쓰레드 정의
public class Star extends Thread{
	String mark;
	public Star(String mark) {
		this.mark=mark;
	}
	//쓰레드의 실행 순서는 개발자가 결정짓는게 아니지만, 적어도 로직은 개발자가 작성해야 하므로 run메서드를 재정의 해 놓아야한다.
	//run()메서드의 호출자는 JVM
	@Override
	public void run() {
		while(true) {
		System.out.println(mark);
		//while문은 속도가 너무 빠르므로 jvm에게 너무 빠른 run이 된다.
		//따라서 지정한 시간동안 non-Runnable 영역으로 빼놓을 수 있는 기능이 지원
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
