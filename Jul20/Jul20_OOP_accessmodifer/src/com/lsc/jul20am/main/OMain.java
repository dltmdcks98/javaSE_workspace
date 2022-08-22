package com.lsc.jul20am.main;

import com.lsc.jul20am.pen.Pen;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//모나미 123 500 펜
		Pen p = new Pen("모나미123",500);
		p.print();
	
//		//이름을 모모나미3으로 변경 -> 다른 패키지여서 안됨 
//		p.name = "모모나미3";
//		p.print();
		
		
		Book b = new Book();
		b.title ="ㅎㅇ";
		b.writer = "44";
		b.price = 333;
		b.pageCount = 400;
		
		
	}

}
