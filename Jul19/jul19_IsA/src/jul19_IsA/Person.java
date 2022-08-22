package jul19_IsA;

public class Person {
	String name;
	int age;
	

	//부모클래스에 기본 생성자가있으면 상속이 가능한데 없으면 상속이 안된다.
	//없어도 됏던 이유는 컴파일 할때 기본 생성자가 생성이 되는데 상속이 되면 기볹 생성자가 생성이 안된다.
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
}
