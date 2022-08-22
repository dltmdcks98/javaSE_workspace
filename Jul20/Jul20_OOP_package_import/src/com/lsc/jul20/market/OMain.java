package com.lsc.jul20.market;

/**
 * 쇼핑몰을 운영하는데
 * 책, 요구르트,컵이 있는 쇼핑몰 
 * 책
 * 이름 : 삼국지
 * 가격 10000
 * 지은이 나관중 
 * 
 * 요구르트 
 * 이름 : 연요
 * 가격 : 1000
 * 유통기한 : 2022-08-10
 * 
 * 컵
 * 이름 : 가나다컵
 * 가격 : 300
 * 사이즈 : 스몰
 * @author 에스엘아카데미
 *
 */
public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book("삼국지",10000,"나관중");
		b.print();
		System.out.println("=====================================");
		Drink d = new Drink("연오",1000,"2022-08-10");
		d.print();
		System.out.println("=====================================");
		Cup c= new Cup("가나다컵",300,"스몰사이즈");
		c.print();
		System.out.println("=====================================");
		/*
		 * 객체 이름이 같으면 
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		Scanner s = new Scanner("캐논스캐너",300,10);
		s.print();
	}

}
