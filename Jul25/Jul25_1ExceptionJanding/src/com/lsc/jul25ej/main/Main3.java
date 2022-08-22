package com.lsc.jul25ej.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("숫자입력 : ");
		String temp = input.nextLine();
		String num[] = temp.split("/");
		int numTemp = 0,sum = 0;
		for(int i =0; i<num.length; i++) {
			try {
				numTemp = Integer.parseInt(num[i]);
				sum+=numTemp;
			}catch (Exception e) {
				System.out.println("글자있음");
			}
		
		}
		
		System.out.println("합은 : "+sum);
		
		//===============강사님 코드=========================================
		String no = input.next();
		StringTokenizer st = new StringTokenizer(no,"/");
		int sum1=0;
		while(st.hasMoreTokens()) {
			try {
				sum1 +=Integer.parseInt(st.nextToken());
			}catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
			
		}
		System.out.println(sum1);
	}

}
