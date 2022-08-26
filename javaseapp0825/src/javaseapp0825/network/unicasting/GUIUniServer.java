package javaseapp0825.network.unicasting;

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

public class GUIUniServer extends JFrame{
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	Thread listenThread;//메인쓰레드가 accept()에 의해 대기상태에 빠지않도록 별도의 쓰레드 필요
	ServerSocket server;//접속자 감지용,통신연결용
	boolean flag = true;//서버 가동 여부를 결정짓는 논리값
	
//	BufferedReader buffr;
//	BufferedWriter buffw;
	
	public GUIUniServer() {
		t_port = new JTextField("9999",12);
		bt_start = new JButton("서버가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		listenThread = new Thread() {
			public void run() {
				startServer();
			}
		};
		
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
				listenThread.start();//Runnable영역을 밀어버림 개발자는 관여하지 않음
			}
		});
	}
	
	public void startServer() {
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버 가동 및 접속자 기다리는 중 \n");
			
			while(flag) {//이게 없으면 listenThread가 접속하고 죽음 
				Socket socket = server.accept();//이 메소드에 의해 접속자가 발생할때까지 무한 대기
				String ip = socket.getInetAddress().getHostAddress();
				area.append(ip+"접속자 감지 \n");
				
				//대화 코드는 별도의 스레드로 구현해야한다.
//				buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//				
//				String msg = buffr.readLine();
//				area.append(msg+"\n");
					
				//대화용 쓰레드를 생성하여, 대화를 나누도록 해준다.
				ChatThread chatThread = new ChatThread(socket, this);
				chatThread.start();//대화시작
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new GUIUniServer();
	}
}
