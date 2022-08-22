package jul19_IsA;

public class Coffee extends Menu{
	String size;
	String temp;
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(size);
		System.out.println(temp);
	}

}
