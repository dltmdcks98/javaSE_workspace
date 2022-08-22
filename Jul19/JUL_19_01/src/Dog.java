
public class Dog {
	//속성 
	//멤버변수, 속성, 필드
	//멤버변수에 직접 값을 넣지 않는 이유는 heap영역에 저장소 낭비가 심해서 
	String name;
//	String name="말숙"; -> 쓰레기 코드 써야한다면
	static String name1 ="말숙";
	int age;
	
	//액션 : 함수 
	public void bark() {
		System.out.println("짖는중 ");
	}

}
