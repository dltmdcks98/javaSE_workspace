package javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageReader {
	FileInputStream fis;//파일을 대상으로 데이터를 읽어오는 바이트 기반 스트림
	
	public ImageReader(){
		try {
			fis = new FileInputStream("Z:/SLAcademy/javaSE_workspace/javaseapp0822/data/memo.txt");//바이트기반 스트림
			System.out.println("스트림 생성 성공");
			
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
				data = fis.read();//1byte읽기
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
