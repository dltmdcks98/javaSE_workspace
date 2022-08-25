package javaseapp0825.network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIEchoServer extends JFrame{
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	
	public GUIEchoServer() {
		t_port = new JTextField(12);
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
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new GUIEchoServer();
	}
}
