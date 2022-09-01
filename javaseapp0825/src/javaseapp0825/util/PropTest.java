package javaseapp0825.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropTest {
	Properties props;//key-value로 이루어진 데이터를 이해하는 객체
	FileInputStream fis;
	
	public PropTest() {
		try {
			fis = new FileInputStream("D:/OneDrive-LSC/SLAcademy/javaSE_workspace/javaseapp0825/data/star.txt");
			props = new Properties();
			props.load(fis);//이 시점부터 파일을 대상으로 검색이 가능 
			
			//검색은 Key로
			String value = props.getProperty("terran");
			System.out.println("결과 값은 :" + value);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		new PropTest();
	}
}
