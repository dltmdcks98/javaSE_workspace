package ui;
//awt�� os�� ���� �������� �ణ�� Ʋ������. => ���� ���õ� ui�� ����ϱ� ���� ����ϴ� ��Ű�� swing
//swing�� ������ awt��Ű���� Ŭ�������� ���Ǵ� J�� ���ξ�� 
import javax.swing.JFrame; //javax�� java���� ����� Ȯ��� �� 
import javax.swing.JButton;

public class WinTest
{
	/*��ü�� �¾��, �ʱ�ȭ�� ����ϴ� �޼��带 �����ڶ�� �� 
		��ȯ���� ���� �������� ������ �ȵǰ� �޼���� �����Ѵ�. 
	*/
	JFrame frame;
	JButton bt;
	public WinTest(){
		frame = new JFrame();
		bt= new JButton("button");

		//����
		frame.add(bt);

		//������ ���̰�
		frame.setVisible(true);
		frame.setSize(300,400);
	}
}


