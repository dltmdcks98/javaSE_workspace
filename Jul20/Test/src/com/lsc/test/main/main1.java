package com.lsc.test.main;


/*
 * 구구단 
 * 내가 단수 입력하면 그 단수만 
 * 2x1=2
 * 2x2=4
 * ...
 * 2x9=18
 */
public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<10;i++) {
			for(int j =2; j<10; j++) {
				System.out.printf("%d x %d = %02d\t",j ,i,j*i);
			}
			System.out.println("");
		}

	}

}