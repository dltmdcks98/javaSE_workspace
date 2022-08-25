package javaseapp0825.network;

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

public class GUIEchoServer extends JFrame{
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;//접속자 감지용 소켓
	Thread serverThread;//서버를 가동하고 접속자를 감지하는 용도->accept()메서드는 접속자가 발생할때까지 대기상태에 빠지므로
	public GUIEchoServer() {
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
		serverThread = new Thread() {
			//개발자가 쓰레드를 통해 구현하고싶은 로직은 run() 메서드에 작성해놓으면 JVM이 선택
			public void run() {
				startServer();
			}
		};
		
		
		//가동버튼 리스너 연결
		bt_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				serverThread.start();//개발자 주도가 아닌 JVM에게 실행을 맡긴다.
			}
		});
	}
	
	//서버 가동하기
	public void startServer() {
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버 가동 및 접속자 청취충..\n");			
			Socket socket = server.accept();//접속과 동시에 네트워크 정보 및 스트림을 제공해주는 소켓을 반환
			String ip = socket.getInetAddress().getHostAddress();
			area.append(ip+"접속자 발견\n" );
			
			//소켓으로부터 스트림을 뽑아서 데이터 주고 바기
			BufferedReader buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));//듣기용
			BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//말하기 용
			
			String data =null;
			while(true) {
				data = buffr.readLine();//한줄 읽기,한줄이 들어올때 \n도 딸려온다. 그래서 줄을 구분할 수 있음
				area.append(data+"\n");//textarea 내에서의 줄바꿈
				
				//클라이언트가 보낸 메시지를 다시 돌려보내기
				buffw.write(data+"\n");
				buffw.flush();
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
		new GUIEchoServer();
	}
}
