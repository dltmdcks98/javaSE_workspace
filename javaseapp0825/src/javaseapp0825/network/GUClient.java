package javaseapp0825.network;

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
	Socket socket;
	BufferedWriter buffw;
	BufferedReader buffr;
	
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
		
		//접속버튼에 리스너 연결
		bt_connection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		//전송 버튼에 리스너 연결
		bt_send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
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
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//입력한 데이터를 서버에 보내자(출력-실행중인 프로그램내에서 보내는 것이라)
	public void send() {
		String msg = t_input.getText();
		try {
			buffw.write(msg+"\n");//버퍼로 모은 문장의 긑을 알려주기 위해 반드시 줄바꿈 문자를 포함해서 보내야 서버가 무한정 대기하지 않는다.
			//출력스트림은 입력 스트림과는 다르게 버퍼를 처리할경우 데이터 전송시 반드시 버퍼를 비워야한다.
			buffw.flush();//버퍼 비우기
			t_input.setText("");//입력값 초기화
			
			//서버가 보낸 메시지 받기
			String data = null;
			data = buffr.readLine();
			area.append(data+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new GUClient();
	}
}
