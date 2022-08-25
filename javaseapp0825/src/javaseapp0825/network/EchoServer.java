package javaseapp0825.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//연결이 유지 StateFull , 메아리 서버 구축
public class EchoServer {
	int port = 9999 ;//1~1024-> os및 다른 시스템 차원에서 점유되는 포트 
	ServerSocket server; //네트워크를 통해 데이터를 주고 받기 전에 먼저 클라이언트와 서버와의 연결이 선행
	//이 연결을 처리해주는 전담객체를 가리켜 서버 소켓이라고한다.(대화형 소켓이 아님)
	public EchoServer() {
		try {
			server = new ServerSocket(port);//서버생성
			
//			int data=-1;
			String data =null;
			while(true) {
				Socket socket =server.accept();//클라이언트가 접속하기를 기다린다.
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("접속자 발견"+ip);
				
				//Socket을 통해 데이터를 클라이언트와 주고 받을 수 있다. 이때 개발자는 네트워크에 대한 지식이 필요없고 IO(스트림)제어에 집중
				//가능한 이유: 소켓이 네트워크 하부 구조에 대한 추상화 담당
				InputStream is =socket.getInputStream();
				InputStreamReader reader=new InputStreamReader(is);//바이트->문자기반
				BufferedReader buffr = new BufferedReader(reader);
				
//				data=is.read();//1byte읽기
				data = buffr.readLine();
				System.out.println(data);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
