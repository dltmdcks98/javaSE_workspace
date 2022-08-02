package ui;
/*사용자가 gui상에서 어떠한 행동을 했을때, 제일먼저 os가 감지하여 jvm에게 ㅈ전달하고 jvm은 이 이벤트 정보를 이용하여 이벤트 객체의 인스턴스를 생성한다.
이때 이 인스턴스는 개발자에게 전달될 수 있는데 이 인스턴스를 개발자가 전달받으려면 전담 리스너를 활용해야하는데
이 리스너는 몸체가 없는 불완전한 객체로 되어있다. 그 이유는 몸체를 완성시킬 의무를 개발자에게 부여하기 위함*/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyListener  implements ActionListener // implements = is a = extends
{
	//우리가 상속받은 ActionListener인터페이스는 불완전한 객체이므로, 
	//MyListener 클래스는 이 불완전함을 완전하게 할 구현의무를 가지게 된다.
	//특히 ActionListener 인터페이스는 actionPerformed()라는 추상 메소드를 가지고 있으므로 이를 완성해야함
	public void actionPerformed(ActionEvent e){
		System.out.println("clicked button?");
	}
}
