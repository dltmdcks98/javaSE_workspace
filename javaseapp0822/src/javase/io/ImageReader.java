package javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageReader {
	FileInputStream fls;//파일을 대상으로 데이터를 읽어오는 바이트 기반 스트림
	
	public ImageReader(){
		try {
			fls = new FileInputStream("Z:/SLAcademy/javaSE_workspace/javaseapp0822/images/2.png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ImageReader();
	}
}
