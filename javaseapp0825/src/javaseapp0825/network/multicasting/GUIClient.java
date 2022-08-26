package javaseapp0825.network.multicasting;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class GUIClient extends JFrame {
	Choice ch;//html의 select박스와 동일
	JTextField t_port;
	JButton bt_connection;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt_send;
	
	int port=9999;
	Socket socket;//통신용 소켓(데이터를 주고 받을 수 있다.)
	ClientThread clientThread;
	
	public GUIClient() {
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
		
		bt_connection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		//메시지 입력 텍스트 필드의 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {//어댑터 : 추상클래스나 인터페이스의 강제성을 sun사에서 줄이기 위해 중간자역할을 하는것
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {//엔터치면~
					//자바에서는 상수가 주로 사람이 이해하기 힘든 데이터의 경우 의미를 부여한 직관성을 부여한 단어을 이용하여 상수를 정의
					clientThread.send(t_input.getText());
					t_input.setText("");//디자인은 신경쓰지 않도록 하기 위해 send()에서 정의 안함
					
				}
			}
		});
	}
	
	//소켓을 생성하는 시점에 접속이 시도됨
	public void connect() {
		try {
			socket = new Socket(ch.getSelectedItem(),Integer.parseInt(t_port.getText()));
			//접속이 성공되어있다면, 이 시점 부터는 대화가  가능해야 하므로 쓰레드로하여금 대화를 나누게하자
			clientThread = new ClientThread(socket, this);//쓰레드 생성
			clientThread.start();//대화 시작, 이 시점  부터는 listen을 실시간으로 시도하고 있다.
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*

	*/
	public static void main(String[] args) {
		new GUIClient();
	}
}
