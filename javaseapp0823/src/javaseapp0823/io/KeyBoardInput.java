/*
 *지금까지 사용해왔던 대부분의 스트림은 개발자가 원하는 시점에 생성하여 사용할 수 있었지만,
 *키보드나, 모니터와 관련되 스트림은 개발자가 생성할 수 있는 것이 아니라, 현재 사용중인 OS가 생성한다.
 *따라서 키보드나 모니터에 연결된 스트림을 사용하기 위해서는 시스템으로부터 얻어와야한다. 
 */

package javaseapp0823.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInput {
	public static void main(String[] args) {
		InputStream is = System.in; //이미 존재하는 스트림을 얻은 것 
		//주의 : 여기서 얻는 입력스트립은 반드시 키보드가 아님
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffr = new BufferedReader(reader);
		
		//int data = -1;
		String data =null;
		try {
			//data = is.read();
			//data = reader.read();
			data = buffr.readLine();
			
			//모니터에 출력
//			System.out.print((char)data);
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
