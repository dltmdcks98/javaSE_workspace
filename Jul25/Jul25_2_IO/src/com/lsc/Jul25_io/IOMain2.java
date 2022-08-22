package com.lsc.Jul25_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("D:\\LSC\\asdf.txt");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			String line =null;;
			while((line = br.readLine()) != null) { //있는거 다 나오게 
				System.out.println(line);
			}
			br.close();//3개 열린것 중에 하나만 닫아도 다 닫힘 
		}catch (IOException e) {
			// TODO: handle exception
		}
	}

}
