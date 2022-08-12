package javaseapp0812.thread;

import javax.swing.JProgressBar;

//프로그래스바를 증가시킬 쓰레드 정의
//메인스레드는 무한루프나, 대기상태에 빠지게
public class MyThread extends Thread {
	JProgressBar bar;
	int n=0;
	int speed;
	public MyThread(JProgressBar bar, int speed) {
		this.bar = bar;
		this.speed = speed;
	}
	
	//개발자는 쓰레드 정의시 원하는 로직을 run메소드에 작성(오버라이딩)
	//추후, run메소드는 JVM에게 선택되어지며 이 순간을 가리켜 running상태라고 한다.
	public void run() {
		while(true) {
			n= n+speed;
			bar.setValue(n);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
