/*
java��  c#�� ���� �Ϲ����� �������α׷�ó�� GUI�� ���� 
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.CheckboxGroup;
import java.awt.TextArea;
public class  ChatMain
{
	public static void main(String[] args) 
	{
		//������ ����
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setSize(300,400);

		//��ư ����
		Button bt = new Button("�� ��ư");

		//�ؽ�Ʈ �Է�
		TextField t = new TextField(10);//10�� ������ ũ��

		Checkbox ch = new Checkbox("����");
		Checkbox ch1 = new Checkbox("���α׷���");


		Choice c = new Choice();
		c.add("red");
		c.add("yellow");
		c.add("blue");

		//Radio ������ �������� �ʰ� CheckBox�� �׷�ȭ
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox c1 = new Checkbox("��",cbg,true); 
		Checkbox c2 = new Checkbox("��",cbg,false);
		Checkbox c3 = new Checkbox("Ʈ����",cbg,false);
 

 		//TextArea(��Ƽ���� �Է�â)
		TextArea area = new TextArea(20,10);//row,col
		//�����ӿ� ������ ��ġ������ 
		frame.setLayout(new java.awt.FlowLayout());

		frame.add(bt);
		frame.add(t);
		frame.add(ch);
		frame.add(ch1);
		frame.add(c);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
		frame.add(area);

	}
}
