package javaseapp0825.network;

import java.io.IOException;
import java.net.ServerSocket;

//연결이 유지 StateFull , 메아리 서버 구축
public class EchoServer {
	int port = 9999 ;//1~1024-> os및 다른 시스템 차원에서 점유되는 포트 
	ServerSocket server; //네트워크를 통해 데이터를 주고 받기 전에 먼저 클라이언트와 서버와의 연결이 선행
	//이 연결을 처리해주는 전담객체를 가리켜 서버 소켓이라고한다.(대화형 소켓이 아님)
	public EchoServer() {
		try {
			server = new ServerSocket(port);//서버생성
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
