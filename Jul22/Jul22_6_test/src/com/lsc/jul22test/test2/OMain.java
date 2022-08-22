package com.lsc.jul22test.test2;

import java.util.Scanner;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r;//바퀴 둘레
		double fr;//앞바퀴 기어
		double br;//뒷바퀴 기어 
		int foot;
		double dis;
		
	
		
		Scanner input = new Scanner(System.in);
		System.out.print("바퀴둘레 : ");
		r = input.nextInt();
		System.out.print("뒷바퀴 기어 수 : ");
		br = input.nextDouble();
		System.out.print("앞바퀴 기어 수 : ");
		fr = input.nextDouble();
		System.out.print("페달 수 : ");
		foot = input.nextInt();
		
		dis = r*(Math.round(br/fr))*foot; 
		System.out.println(dis+"cm");
		
		
	}

}
