package jul19_hasA;

public class Person {
	String name;
	int age;
	static Planet home = new Planet("지구");
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void Print() {
		System.out.println(name);
		System.out.println(age);
		
	}
}
