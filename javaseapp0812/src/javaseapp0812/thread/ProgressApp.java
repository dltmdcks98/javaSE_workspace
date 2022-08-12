package javaseapp0812.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressApp extends JFrame {
	JProgressBar bar,bar2,bar3;
	JButton bt;
	MyThread myThread,myThread2,myThread3;

	public ProgressApp() {
		bar = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bt = new JButton("download");
		myThread = new MyThread(bar,1);
		myThread2 = new MyThread(bar2,5);
		myThread3 = new MyThread(bar3,15);
		
		// style
		bar.setPreferredSize(new Dimension(380, 50));
		bar2.setPreferredSize(new Dimension(380, 50));
		bar3.setPreferredSize(new Dimension(380, 50));

		// 배치 관리자 적용
		setLayout(new FlowLayout());

		// 조립
		add(bar);
		add(bar2);
		add(bar3);
		
		add(bt);

		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				addValue();
				//생성된 스레드를 JVM의 Runnable 영역으로 넣는다.
				myThread.start();
				myThread2.start();
				myThread3.start();
				
			}
		});
	}

//	public void addValue() {
//		bar.setValue();
//	}

	public static void main(String[] args) {
//		int[] arr = {1,2,3};
//		System.out.println(arr[4]);
		new ProgressApp();
	}
}
