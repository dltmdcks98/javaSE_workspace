package javaseapp0812.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 인터넷 상의 이미지를 나의 Pc로 저장
 */
public class ImageCollector {
	FileInputStream fis;
	FileOutputStream fos;
	
	
	public ImageCollector() {
		try {
			fis = new FileInputStream("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
			System.out.println("스트림 성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("스트림 실패");
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
		//실행중인 프로그램으로 데이터를 읽어와서, 원하는 위치에 빈파일을 만든후 데이터를 채워 넣기
		new ImageCollector();
	}
}
