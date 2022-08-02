/*
사용자가 키보드 관련된 이벤트를 발생시키면, os가 다시 jvm에게 전달하고, 
이 정보를 받은 jvm이 메모리에 KeyEvent 인스턴스를 생성한다.
이 정보는 개발자에게 전달되어야 하므로, 개발자는 리스너 객체를 이용하여 전달받을 수 있는데,
이때 리스너가 인터페이스로 제공되는 이유는 이 인터페이스를 완성할 의무를 개발자에게 부여했기 때문이다.
*/
package ui;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyKeyListenser implements KeyListener
{
	public void keyPressed(KeyEvent e){//키를 누를때 동작
		System.out.println("키를 눌렀군요");
	}
	public void keyReleased(KeyEvent e){//키를 눌렀다 뗄때 
		System.out.println("키를 눌렀다 떼었군요");
	}
	public void keyTyped(KeyEvent e){
		System.out.println("키를 입력했군요");	
	}
}
