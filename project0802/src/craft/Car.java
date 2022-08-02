package craft;
class  Car
{
	static int price = 100;
	String company = "kia";
	String name = "G90";
	String color = "black";

	public void run(){
		System.out.println("moving");
	}
	public static void main(String[] args) 
	{
		Car c1 = new Car();
		int price = 50;
		Car c2 = new Car();
		c1.price =500;
		System.out.println(c2.price);
/*
실행 -> 하드에 저장되어있음
컴파일 -> 저장은 하드에 되어있지만, 기계어로 저장되어있다. 
실행 -> 
코드가 static영역에 있음(로드) stack영역에 Car객체의 주소를 넣고 
Heap영역에 company,name,color(인스턴스 변수)가 저장되고 price(클래스변수)는 static영역에 저장되고 
메소드는 데이터가 아니기때문에 딸려 올라가지 않지만 올라간다고 생각하면 편하다 
지역변수 price(15번째줄)은 stack에 저장된다. 
c1.price를 실행할때 처음으로 heap영역을 보고 없으니까 static영역에 있으므로 오류가 나지 않는다.
c2.price를 출력할때 c1과 마찬가지로 없으니까 static영역을 본다. 

*/
	}
}
