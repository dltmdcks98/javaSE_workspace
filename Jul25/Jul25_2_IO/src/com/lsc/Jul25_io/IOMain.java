package com.lsc.Jul25_io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class IOMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 : ");
		String msg = k.next();
		
		try {
			/*
			 * flush() : stream을 닫지 않아도 데이터 전송  
			 * close() : steam을 닫고 싶을 때 전송 
			 */
			FileOutputStream fos = new FileOutputStream("D:/LSC/asdf.txt",true);//1byte 씩 읽음, 이어쓰기 
			//인코딩 방식 지정 
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			BufferedWriter bw1= new BufferedWriter(osw);//속도를 높이기 위해 ->1String 한 줄씩 넣음 
			bw1.write(msg+"\r\n");
			bw1.flush();
			bw1.close(); //데이터가 입력이 되는 시점, 한번 닫으면 다시 안열림
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
