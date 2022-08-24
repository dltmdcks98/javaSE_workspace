package javaseapp0812.thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 인터넷 상의 이미지를 나의 Pc로 저장
 */
public class ImageCollector {
	FileInputStream fis;
	FileOutputStream fos;
	
	
	public ImageCollector() {
		InputStream is = null;
		try {
			URL url = new URL("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
			is =url.openStream();
			fos = new FileOutputStream("Z:/SLAcademy/javaSE_workspace/javaseapp0812/data/test.jpg");
			//생성된 스트림을 이용하여 데이터 읽기
			int data =-1;
			while(true) {
				data = is.read();//1byte 읽기
				if(data==-1)break;
				fos.write(data);
				System.out.println(data);
			}
			System.out.println("수집완료");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
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
