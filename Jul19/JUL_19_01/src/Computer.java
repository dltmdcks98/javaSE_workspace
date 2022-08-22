
public class Computer {
	String cpu;
	int ram;
	int hdd;
	static String maker ="삼성";
	//상수화, 변수명은 대문자로 입력함
	static final String MAKER1= "삼성";
	
	public void print() {
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
		System.out.println(maker);
	}
	
	//static 메소드 : 객체를 생성하지 않고 메소드를 사용할 수 있음 
	//공통된 공간을 가지고 있다는 느낌은 아님 
	public static void staticprint() {
		System.out.println("static");
	}
}
