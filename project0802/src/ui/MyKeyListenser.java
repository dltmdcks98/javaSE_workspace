/*
����ڰ� Ű���� ���õ� �̺�Ʈ�� �߻���Ű��, os�� �ٽ� jvm���� �����ϰ�, 
�� ������ ���� jvm�� �޸𸮿� KeyEvent �ν��Ͻ��� �����Ѵ�.
�� ������ �����ڿ��� ���޵Ǿ�� �ϹǷ�, �����ڴ� ������ ��ü�� �̿��Ͽ� ���޹��� �� �ִµ�,
�̶� �����ʰ� �������̽��� �����Ǵ� ������ �� �������̽��� �ϼ��� �ǹ��� �����ڿ��� �ο��߱� �����̴�.
*/
package ui;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyKeyListenser implements KeyListener
{
	public void keyPressed(KeyEvent e){//Ű�� ������ ����
		System.out.println("Ű�� ��������");
	}
	public void keyReleased(KeyEvent e){//Ű�� ������ ���� 
		System.out.println("Ű�� ������ ��������");
	}
	public void keyTyped(KeyEvent e){
		System.out.println("Ű�� �Է��߱���");	
	}
}
