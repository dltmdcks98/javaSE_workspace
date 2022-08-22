package com.lsc.pmp.main;

import com.lsc.pmp.product.Monitor;
import com.lsc.pmp.product.Mouse;
import com.lsc.pmp.product.Product;

public class OMain {

	public static void main(String[] args) {
//		Monitor m = new Monitor();
//		Mouse mm = new Mouse();
//		
//		//상품을 담을 수 있는 그릇 p에 상품을 만들어 넣음 
//		Product p = new Product();
//		//마우스만 담을 수 있는 그릇 m 상품이 들어간 
//		Mouse m1 = new Product();
//		
//		//상품만 담을 수 있는 그릇 p2에 모니터가 들어간 
//		Product p1 = new Monitor();
//		
//		Product a[] = {p,p1};
//	}
//	public  Product print(Product a) {//이렇게 하면 Monitor나 Mouse를 받아도 에러가 나지 않음 
//		return new Monitor();
	
		Product p = new Monitor();
		p.print();
	
	}

}
