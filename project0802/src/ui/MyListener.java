package ui;
/*����ڰ� gui�󿡼� ��� �ൿ�� ������, ���ϸ��� os�� �����Ͽ� jvm���� �������ϰ� jvm�� �� �̺�Ʈ ������ �̿��Ͽ� �̺�Ʈ ��ü�� �ν��Ͻ��� �����Ѵ�.
�̶� �� �ν��Ͻ��� �����ڿ��� ���޵� �� �ִµ� �� �ν��Ͻ��� �����ڰ� ���޹������� ���� �����ʸ� Ȱ���ؾ��ϴµ�
�� �����ʴ� ��ü�� ���� �ҿ����� ��ü�� �Ǿ��ִ�. �� ������ ��ü�� �ϼ���ų �ǹ��� �����ڿ��� �ο��ϱ� ����*/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyListener  implements ActionListener // implements = is a = extends
{
	//�츮�� ��ӹ��� ActionListener�������̽��� �ҿ����� ��ü�̹Ƿ�, 
	//MyListener Ŭ������ �� �ҿ������� �����ϰ� �� �����ǹ��� ������ �ȴ�.
	//Ư�� ActionListener �������̽��� actionPerformed()��� �߻� �޼ҵ带 ������ �����Ƿ� �̸� �ϼ��ؾ���
	public void actionPerformed(ActionEvent e){
		System.out.println("clicked button?");
	}
}
