
package javaseapp0825.network.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*대화를 담당할 객체
 * 이 객체는 독립수행되어야 하므로, 쓰레드로 정의한다.
 */
public class ChatThread extends Thread{
	BufferedReader buffr;
	BufferedWriter buffw;
	GUIMultiServer guiMultiServer;
	boolean flag = true;//청취를 할지 말지 결정짓는 논리값
	
	public ChatThread(Socket socket, GUIMultiServer guiUniServer) {
		this.guiMultiServer=guiUniServer;
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
			//나와 연결된 클라이언트에게만 보내지말고 서버에 접속한 모든 클라이언트의 ChatThread의
			//출력 스트림을 이용
			
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
			
			//접속한 모든 자에게 메시지 보내는것을 BoradCast
			for(int i=0; i<guiMultiServer.vec.size();i++) {
				ChatThread chatThread = guiMultiServer.vec.get(i);
				chatThread.send(msg);//듣자 마자 클라이언트로 보냄
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//readLine()가 실패한 경우 (상대방이 소켓을 끊고 나가는 경우)
			//vector에서 제거해주고 핸재쓰레드가 죽을 수 잇도록 무한루프를 종료해야한다.
			flag=false;
			
			e.printStackTrace();
		}
		
		guiMultiServer.area.append(msg+"\n");
	}

	public void run() {
		while(flag) {
			listen();	
		}
	}
}
