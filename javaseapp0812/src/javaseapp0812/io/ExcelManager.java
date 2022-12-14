package javaseapp0812.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
			
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);//첫번째 시트
			
			Iterator rowIt = sheet.iterator();
			
			while(rowIt.hasNext()) {//이터레이터 안의 요소 중 다음 요소가 있는지 판단
				Row row=(Row)rowIt.next();//다음 요소 접근
				//하나의 row에 포함된 Cell들을 Iterator를 통해 얻어옴
				Iterator<Cell> cellIt =row.cellIterator();
				
				while(cellIt.hasNext()) {//셀의 개수 만큼
					Cell cell=cellIt.next();//셀 하나를 얻어옴
					if(cell.getCellType() == CellType.STRING) {
						System.out.print(cell.getStringCellValue());
					}else if(cell.getCellType()==CellType.NUMERIC) {
						System.out.print(cell.getNumericCellValue());
					}else if(cell.getCellType() == CellType.STRING) {
						System.out.print(cell.getStringCellValue());
					}
				}
				System.out.println("");//row의 줄바꿈
			}
			
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
			}}
		}
		
	}
	
	public static void main(String[] args) {
		new ExcelManager();
	}
}
