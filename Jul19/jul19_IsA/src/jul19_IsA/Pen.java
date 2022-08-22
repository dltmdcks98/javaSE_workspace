package jul19_IsA;
public class Pen extends Product{
	//아무것도 없어보이지만, 상위 클래스의 멤버변수, 메소드를 물려받는 것을 extends(상속)이라고 함 
////	String name;
	String color;
////	int price;
////	
////	public void Print() {
////		System.out.println(name);
////		System.out.println(color);
////		System.out.println(price);
////	}
//	
	@Override
	public void print() {
		//멤버 변수에는 없지만 상속 받아서 있음 
	System.out.println(name);
	System.out.println(price);
	System.out.println(color);
	}
}
