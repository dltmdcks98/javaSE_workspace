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
���� -> �ϵ忡 ����Ǿ�����
������ -> ������ �ϵ忡 �Ǿ�������, ����� ����Ǿ��ִ�. 
���� -> 
�ڵ尡 static������ ����(�ε�) stack������ Car��ü�� �ּҸ� �ְ� 
Heap������ company,name,color(�ν��Ͻ� ����)�� ����ǰ� price(Ŭ��������)�� static������ ����ǰ� 
�޼ҵ�� �����Ͱ� �ƴϱ⶧���� ���� �ö��� ������ �ö󰣴ٰ� �����ϸ� ���ϴ� 
�������� price(15��°��)�� stack�� ����ȴ�. 
c1.price�� �����Ҷ� ó������ heap������ ���� �����ϱ� static������ �����Ƿ� ������ ���� �ʴ´�.
c2.price�� ����Ҷ� c1�� ���������� �����ϱ� static������ ����. 

*/
	}
}
