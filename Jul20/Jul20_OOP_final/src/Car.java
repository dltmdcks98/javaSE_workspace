
//클래스에 final을 붙이면 상속을 못한다.
public final class Car {
	static final String NAME = "차";
	
	//메소드에 final을 붙인 상태에서 오버라이딩하면 안됨 
	public final void run() {
		System.out.println("부릉");
	}
}
