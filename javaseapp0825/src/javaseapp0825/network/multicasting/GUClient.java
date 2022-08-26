package javaseapp0825.network.multicasting;

import java.awt.Choice;
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
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * telnet으로는 영문으로 명령어를 넣기 위해 만든 것*/
public class GUClient extends JFrame {
	Choice ch;//html의 select박스와 동일
	JTextField t_port;
	JButton bt_connection;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt_send;
	
	int port=9999;


	
	public GUClient() {
		ch = new Choice();
		t_port = new JTextField(Integer.toString(port),6);
		bt_connection = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(15);
		bt_send = new JButton("전송");
		
		for(int i=13; i<=136;i++) {
			ch.add("192.168.25."+i);
			if(i==82) {//본인 IP인 경우
				ch.select("192.168.25."+i);
			}
			
		}
	
		//스타일
		scroll.setPreferredSize(new Dimension(280,270));
		area.setBackground(Color.YELLOW);
		
		//조립
		setLayout(new FlowLayout());
		add(ch);
		add(t_port);
		add(bt_connection);
		add(scroll);
		add(t_input);
		add(bt_send);
		
		//윈도우 설정
		setVisible(true);
		setBounds(200,100,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}
	
	
	
		
	
	public static void main(String[] args) {
		new GUClient();
	}
}
