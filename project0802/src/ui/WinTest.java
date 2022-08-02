package ui;
//awt는 os에 따라서 디자인이 약간씩 틀려진다. => 좀더 세련된 ui를 사용하기 위해 사용하는 패키지 swing
//swing은 기존의 awt패키지의 클래스명에서 거의다 J가 접두어로 
import javax.swing.JFrame; //javax는 java에서 기능이 확장된 것 
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
public class WinTest
{
	/*객체가 태어날때, 초기화를 담당하는 메서드를 생성자라고 함 
		반환형이 들어가면 생성자의 역할이 안되고 메서드로 동작한다. 
	*/
	JFrame frame;
	JButton bt;
	JTextField t;
	public WinTest(){
		frame = new JFrame();
		bt= new JButton("button");
		t= new JTextField(10);
		//버튼과 리스너 연결
		bt.addActionListener(new MyListener());
		//텍스트박스와 리스너연결
		t.addKeyListener(new MyKeyListenser());
	//조립
		frame.add(bt);
		frame.add(t);
		//조립전에 요소들을 어떻게 배치할지를 결정해야함 =>gui에서는 
		//배치관련된 객체 포함해서 디자인과 직접적인 관련이 없는 api는 여전이 awt를 사용
		frame.setLayout(new FlowLayout());
	
		
		//프레임 보이게
		frame.setVisible(true);
		frame.setSize(300,400);
	}
}


