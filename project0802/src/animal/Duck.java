package animal;

public class Duck
{
	String name = "������";//property,�Ӽ�, ������� 
	int age = 3;
	
	public void quack(){
		System.out.println("�в�");
	}

	public static void main(String [] args){
		Duck d = new Duck();
		d.age =5;
		System.out.println(d.age);
	}
}