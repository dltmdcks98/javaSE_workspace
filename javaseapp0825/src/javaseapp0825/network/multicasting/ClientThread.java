package javaseapp0825.network.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
	클라이언트가 메시지를 보낼때 청취하는 것이 아니라 언제나 서버로부터 전송되어 오는 메시지를
	무한루프로 받아야하므로 별도의 쓰레드가 필요하다.
	main으로 받으면 멈춤
*/
public class ClientThread extends Thread{
	BufferedReader buffr;
	BufferedWriter buffw;
	Socket socket;
	GUIClient guClient;
	boolean flag = true;
	//이 쓰레드가 태어날때 대화할 준비가 되어있어야함
	public ClientThread(Socket socket, GUIClient guClient) {
		this.socket = socket;
		this.guClient = guClient;
		
		//접속이 성공 되었다면 대화가 가능해야 하므로, 입출력 스트림을 Socket으로부터 뽑아낸다.
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));//듣기용
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//말하기용
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//서버로부터 전송된 데이터를 받는다.
	public void listen() {
		try {
			String msg = buffr.readLine();
			guClient.area.append(msg+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//출력 스트림을 이용하여 문자열을 출력
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");//문장의 끝임을 즉 버퍼의 한줄의 끝임을 알려줘야함
			buffw.flush();//버퍼처리된 출력 스트림의 경우만
			
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(flag) {	
			listen();
		}
	}
	
}
