package javaseapp0823.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memeoapp extends JFrame{
	JMenu m_file, m_edit, m_style, m_view, m_help;	//자바에서는 메뉴라 부른다.
	JMenuItem item_open,item_save,item_exit;		//메뉴의 하위메뉴를 가리켜 메뉴아이템이라고 한다.
	JMenuBar bar;									//눈에 보이지는 않지만, 메뉴들을 감싸안는 컨테이너
	JTextArea content;
	JScrollPane scroll; 							//편집기에 적용할 스크롤
	JFileChooser chooser;							//파일 탐색기
	FileReader reader;								//파일을 대상으로 한 문자기반의 스트림, 복사가 목적이 아니라 데이터의 한글이 깨지면 안됨
									
	
	public Memeoapp() {
		//부모의 생성자 접근
		//부모의 생성자 호출은 자식의 생성자내에서 호출시 그 무엇보다 우선시 되어야한다.
		super("메모장");
		
		m_file 	= new JMenu("파일");
		m_edit	= new JMenu("편집");
		m_style = new JMenu("서식");
		m_view 	= new JMenu("보기");
		m_help 	= new JMenu("도움말");
		
		item_open = new JMenuItem("파일열기");
		item_save = new JMenuItem("저장하기");
		item_exit = new JMenuItem("종료");
		
		bar 	= new JMenuBar();
		content = new JTextArea();
		scroll 	= new JScrollPane(content);
		chooser = new JFileChooser("Z:/SLAcademy/javaSE_workspace/javaseapp0823/data/");//기본 경로 설정 
		
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.addSeparator();//구분선
		m_file.add(item_exit);
		
		bar = new JMenuBar();
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
		
		//bar는 우리가 원하는 곳에 붙일수 있는 것이 아니라, 언제나 윈도우창 상단에 고정
		this.setJMenuBar(bar);
		add(scroll);
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//파일 열기 이벤트 
		item_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
		});
	}
	public void openFile() {
		 int result = chooser.showOpenDialog(this);
		 
		 //상수는 직관성이 있는 문자를 이용하므로, 개발시 이해하기 좋다.
		 if(result == JFileChooser.APPROVE_OPTION) {
			 //user가 선택한 파일에 대한 정보를 얻어야한다.
			 File file = chooser.getSelectedFile();
			 try {
				reader = new FileReader(file);//유저가 파일을 선택한 시점에 해당파일에 빨대가 꽂아짐
				
				//한 문자 읽기 
				int data =-1;
				data = reader.read();
				content.append(data+"");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	}
	
	public static void main(String[] args) {
		new Memeoapp();

	}

}
