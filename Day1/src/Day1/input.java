package Day1;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input1=0; //초기화가 중요 c언어에서는 바로 warning
		int input2=0;

		Scanner scan = new Scanner(System.in);
		input1 = scan.nextInt();
		input2 = scan.nextInt();
		float inputResult = (float)input1/(float)input2;
		float inputResult2 = Math.round(inputResult);
		System.out.println(inputResult);
		System.out.println("inputResult2 is "+ inputResult2);
	}

}
