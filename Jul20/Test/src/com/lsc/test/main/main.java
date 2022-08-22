package com.lsc.test.main;

import java.util.Random;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r= new Random();
		Scanner input = new Scanner(System.in);
		int num = r.nextInt(100)+1;
		
		int cnt =1;
		int i;
		while(true) {
			/*
			 * nextLine과 nextInt를 같이 쓰면 버퍼에 값이 생겨서 문제가 되지만 큰 숫자가 아니라 아래와 같이 작은 숫자이면 
			 * Int로 하는 것이 맞다.
			 */
			i = input.nextInt();
			if(i>num) {
				cnt++;
				System.out.println("좀 더 작은 값을 입력하세요");
			}else if (i < num) {
				cnt++;
				System.out.println("좀 더 큰 값을 입력하세요 ");
			}else {
				System.out.println("총"+cnt+"번에 맞췄습니다.");
				System.out.println(num);
				break;
			}	
		}
		
		//cmd창에서 실행시 바로 꺼지지 않도록 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

