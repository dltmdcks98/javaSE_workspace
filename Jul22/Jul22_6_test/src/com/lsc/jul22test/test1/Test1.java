package com.lsc.jul22test.test1;

import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		//String은 글자가 객체로 생성되어 저장된다.
		//char는 기본형 
		char random[]= {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ'};
		int rand;;
		while(true) {
			rand = ran.nextInt(5);
			System.out.println(random[rand]);
			if(rand==4) {
				break;
			}			
		}
		
		
		String bb= "ㄱㄴㄷㄹㅁ";
		System.out.println(bb.charAt(4));
	}

}
