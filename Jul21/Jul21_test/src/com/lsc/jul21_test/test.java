package com.lsc.jul21_test;

import java.util.Random;
import java.util.Scanner;

/*
 * 가위바위보 게임을 만들려고합니다.
 * 숫자를 입력해서
 * 콘솔창에 1.가위 2.바위 3.보
 * 1~3까지 숫자를 입력하면 
 * 컴퓨터도 가위바위보 중 랜덤으로 하나 나오게 하고
 * 거기에 이겼는지 졌는지에대한 결과가 콘솔창에 나오게
 */
public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Random r = new Random();
		String list[] = {"가위","바위","보"};
		int ran = r.nextInt(3)+1;
	
		
		System.out.println("==========================");
		System.out.println("1.가위 2.바위 3.보");
		System.out.println("==========================");
		Scanner input =new Scanner(System.in);
		int i = input.nextInt();
		

		System.out.println("상대가 낸거 : "+list[ran-1]);
		System.out.println("내가 낸거 : "+list[i-1]);
	
		//3-1 ->v 2-1 1,3->l 2-3 -v
//		int chk = ran-i;
//		if(i==ran) {
//			System.out.println("비겼습니다.");
//		}else if(chk==1 || chk==-2) {
//			System.out.println("졌습니다.");
//		}else if(chk==2 || chk==-1) {
//			System.out.println("이겼습니다.");
//		}
//		
//		
		
		int chk = ran%i;
		if(i==ran) {
			System.out.println("비겼습니다.");
		}else if() {
			System.out.println("졌습니다.");
		}else  {
			System.out.println("이겼습니다.");
		}

	}
}
