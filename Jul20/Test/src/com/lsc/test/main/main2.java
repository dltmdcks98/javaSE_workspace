package com.lsc.test.main;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = 10.00;
		
		pay("이승찬",base,40);
		pay("asdf",base,61);
		
		
	}
	static void pay(String name, double basepay, int time){
		double pay=0;
		pay=basepay*time;
		if(time>40 && time<=60) {
			double add = (time-40)*basepay*1.5;
			System.out.println("추가금 : "+add);
			pay=pay+add;
		}else if(time<8) {
			System.err.println("에러 : 최저 근무량 미만 ");
		}else if(time>60) {
			System.err.println("에러 : 초과 근무시간을 넘겼습니다. ");
		}else {
		System.out.printf("%s씨가 받아갈 금액 : %.2f 원 \n",name,pay);
		}
	}
}
