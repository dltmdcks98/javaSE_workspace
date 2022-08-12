package javaseapp0812.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressApp extends JFrame {
	JProgressBar bar;
	JButton bt;
	int n=0;
	public ProgressApp() {
		bar=new JProgressBar();
		bt = new JButton("download");
		//style
		bar.setPreferredSize(new Dimension(380,50));
		
		//배치 관리자 적용
		setLayout(new FlowLayout());
		
		
		//조립
		add(bar);
		add(bt);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addValue();
			}
		});
	}
	public void addValue() {
		bar.setValue(10);
	}
	
	public static void main(String[] args) {
		new ProgressApp();
	}
}
