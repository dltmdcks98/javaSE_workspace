package animal;

public class Duck
{
	String name = "Áý¿À¸®";//property,¼Ó¼º, ¸â¹öº¯¼ö 
	int age = 3;
	
	public void quack(){
		System.out.println("²Ð²Ð");
	}

	public static void main(String [] args){
		Duck d = new Duck();
		d.age =5;
		System.out.println(d.age);
	}
}