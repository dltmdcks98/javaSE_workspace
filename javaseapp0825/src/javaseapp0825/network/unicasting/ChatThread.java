package javaseapp0825.network.unicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

/*대화를 담당할 객체
 * 이 객체는 독립수행되어야 하므로, 쓰레드로 정의한다.
 */
public class ChatThread extends Thread{
	BufferedReader buffr;
	BufferedWriter buffw;
	GUIUniServer guiUniServer;
	boolean flag = true;//청취를 할지 말지 결정짓는 논리값
	
	public ChatThread(Socket socket, GUIUniServer guiUniServer) {
		this.guiUniServer=guiUniServer;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//클라이언트에게 말하기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//클라이언트의 말 듣기
	public void listen() {
		String msg = null;
		
		try {
			msg = buffr.readLine();
			send(msg);//듣자 마자 클라이언트로 보냄 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		guiUniServer.area.append(msg+"\n");
	}

	public void run() {
		while(flag) {
			listen();	
		}
	}
}
