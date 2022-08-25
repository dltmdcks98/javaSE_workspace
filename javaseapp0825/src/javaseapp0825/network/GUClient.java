package javaseapp0825.network;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
	Socket socket;
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
		}
	
		//스타일
		area.setPreferredSize(new Dimension(280,270));
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
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//접속버튼에 리스너 연결
		bt_connection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
	}
	public void connect() {
		//원하는 서버의 IP와 포트번호를 이용해서 접속 즉 연결 시도
		try {
			socket = new Socket(ch.getSelectedItem(),port);
			if(socket!=null) {
				System.out.println("접속 성공");	
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new GUClient();
	}
}
