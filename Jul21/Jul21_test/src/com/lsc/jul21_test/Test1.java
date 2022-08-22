package com.lsc.jul21_test;

import java.util.Random;
import java.util.Scanner;

/*
 * 숫자야구 게임
 * 랜덤으로 3자리를 뽑고
 * 스트라이크, 볼을 구현 
 */

public class Test1 {
	static int ran[]= {0,0,0};
	static int strike = 0;
	static int ball=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compick();
		System.out.println("랜덤값 생성");
		System.out.printf("%d%d%d",ran[0],ran[1],ran[2]);
		Scanner input = new Scanner(System.in);
		while(true) {
			pick(input.nextInt());
			if(strike==3) {
				break;
			}
		}
		
		
		
	}
	
//랜덤으로 3자리 숫가자 나오는 메소드 중복 없게
	static void compick() {
		Random random = new Random();
		int temp;
		for(int i =0; i<3; i++) {
			ran[i] = random.nextInt(9);
		}
		while(true) {
			if(chkran()) {
				break;
			}
		}
		
	}
	
	static boolean chkran() {
		Random random = new Random();
		if(ran[0]==ran[1]) {
			ran[1]=random.nextInt(9);
			return false;
		}else if(ran[1]==ran[2]) {
			ran[2]=random.nextInt(9);
			return false;
		}else if(ran[2]==ran[0]) {
			ran[0]=random.nextInt(9);
			return false;
		}
		return true;
	}
	
	//선택
	static void pick(int input) {
		int hund = input/100;
		int ten = input%100/10;
		int one = input%10;
		jude(hund,ten,one);
		System.out.printf("%d s %d ball",strike,ball);
	}
	
	//판단
	static void jude(int hund,int ten, int one) {
		strike=0;
		ball=0;
			if(ran[0]==hund) {                                                                                         
				strike+=1;	
			}else if(ran[0]==ten | ran[0]==one) {
				ball+=1;
			}
		
			if(ran[1]==ten) {
				strike+=1;	
			}else if(ran[1]==hund | ran[1]==one) {
				ball+=1;
			}
			
			if(ran[2]==one) {
				strike+=1;	
			}else if(ran[2]==ten | ran[2]==hund) {
				ball+=1;
			}
		
	}
	
}
