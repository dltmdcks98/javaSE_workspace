package javaseapp0812.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//자바프로그램에서 excel 파일 제어하기
public class ExcelManager {
	FileInputStream fis;//파일 스트림
	XSSFWorkbook workbook; //엑셀 파일
	XSSFSheet sheet;//시트 
	
	public ExcelManager() {
		try {
			fis = new FileInputStream("Z:/SLAcademy/javaSE_workspace/javaseapp0812/data/상품.xlsx");
			System.out.println(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ExcelManager();
	}
}
