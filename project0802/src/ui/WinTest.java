package ui;
//awt�� os�� ���� �������� �ణ�� Ʋ������. => ���� ���õ� ui�� ����ϱ� ���� ����ϴ� ��Ű�� swing
//swing�� ������ awt��Ű���� Ŭ�������� ���Ǵ� J�� ���ξ�� 
import javax.swing.JFrame; //javax�� java���� ����� Ȯ��� �� 
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
public class WinTest
{
	/*��ü�� �¾��, �ʱ�ȭ�� ����ϴ� �޼��带 �����ڶ�� �� 
		��ȯ���� ���� �������� ������ �ȵǰ� �޼���� �����Ѵ�. 
	*/
	JFrame frame;
	JButton bt;
	JTextField t;
	public WinTest(){
		frame = new JFrame();
		bt= new JButton("button");
		t= new JTextField(10);
		//��ư�� ������ ����
		bt.addActionListener(new MyListener());
		//�ؽ�Ʈ�ڽ��� �����ʿ���
		t.addKeyListener(new MyKeyListenser());
	//����
		frame.add(bt);
		frame.add(t);
		//�������� ��ҵ��� ��� ��ġ������ �����ؾ��� =>gui������ 
		//��ġ���õ� ��ü �����ؼ� �����ΰ� �������� ������ ���� api�� ������ awt�� ���
		frame.setLayout(new FlowLayout());
	
		
		//������ ���̰�
		frame.setVisible(true);
		frame.setSize(300,400);
	}
}


