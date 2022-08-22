package jul19_IsA;

public class Student extends Person {
	String schoolName;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	//상위 클래스의 생성자
	public Student(String name, int age, String schoolName) {
		super(name, age);
		this.schoolName = schoolName;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(schoolName);
	}
}
