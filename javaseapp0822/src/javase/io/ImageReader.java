
/*
 * 스트림의 유형 
 * 1)방향 - 입력, 출력
 * 2) 데이터 처리 방법 	- 바이트 기반:1byt식 처리하므로 2byte로 구성된 경우 문자가 깨져보임
 * 					- 문자 기반 : 2byte로 묶어서 문자로 인식하는 스트림(비영여권 뿐만 아니라 전세계 모든 문자가 깨지지 않음)
 * 								~~Reader(문자기반입력),~~~Writer(문자기반 출력)
 * 					- 버퍼기반  : 데이터를 효율적으로 입출력하기 위한 스트림
 * 
 */
package javase.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImageReader {
	FileInputStream fis;//파일을 대상으로 데이터를 읽어오는 바이트 기반 스트림
	FileReader reader;//파일을 대상으로 데이터를 읽어오되, 2byte를 하나의 문자로 읽을 수 있는 스트림 

	public ImageReader(){
		try {
			fis = new FileInputStream("Z:/SLAcademy/javaSE_workspace/javaseapp0822/data/memo.txt");//바이트기반 스트림
			System.out.println("스트림 생성 성공");
			reader = new FileReader("Z:/SLAcademy/javaSE_workspace/javaseapp0822/data/memo.txt");
			/*
			//연결된 스트림을 이용하여, 1바이트를 읽어보자 
			int data =-1;
			data = fis.read();
			while(true){
				if(data==-1)break;
				System.out.println(data);
			}
			System.out.println(data);
			*/
			int data =-1;
			while(true) {	
				//data = fis.read();//1byte읽기
				//data = reader.read();//글자 하나하나 읽기
				
				if(data==-1)break;
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ImageReader();
	}
}
