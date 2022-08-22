package jul19_hasA;

public class Dog {
	String name;
	int age;
	Student owner;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
		owner.print();
	}

	public Dog(String name, int age, Student owner) {
		super();
		this.name = name;
		this.age = age;
		this.owner = owner;
	}
	
	
}
