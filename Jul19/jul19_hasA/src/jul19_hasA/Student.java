package jul19_hasA;

public class Student {
	String name;
	int age;
	
	//학생이 펜을 가지고 있을 경우 
	Pen pen;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}

	public Student(String name, int age, Pen pen) {
		super();
		this.name = name;
		this.age = age;
		this.pen = pen;
	}
	public void println() {
		System.out.println(name);
		System.out.println(age);
		pen.print();
	}
	
	
	
}
