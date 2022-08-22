package jul19_IsA;

public class Omain6 {
	public static void main(String[] args) {
		for(String string : args) {
			System.out.println(string);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
