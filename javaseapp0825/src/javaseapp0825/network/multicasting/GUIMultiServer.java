package javaseapp0825.network.multicasting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIMultiServer extends JFrame{
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	
	public GUIMultiServer() {
		t_port = new JTextField("9999",12);
		bt_start = new JButton("서버가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//스타일 
		scroll.setPreferredSize(new Dimension(280,320));
		area.setBackground(Color.CYAN);
		
		//조립
		setLayout(new FlowLayout());
		add(t_port);
		add(bt_start);
		add(scroll);
		
		//윈도우 설정
		setVisible(true);
		setBounds(500,100,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//쓰레드를 별도의 자바로 만들어도 되지만 내부익명으로 재정의
	
		
		
		//가동버튼 리스너 연결
		bt_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new GUIMultiServer();
	}
}
