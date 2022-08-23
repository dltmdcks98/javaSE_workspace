package javaseapp0823.io;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memeoapp extends JFrame{
	JMenu m_file, m_edit, m_style, m_view, m_help;	//자바에서는 메뉴라 부른다.
	JMenuBar bar;									//눈에 보이지는 않지만, 메뉴들을 감싸안는 컨테이너
	JTextArea content;
	JScrollPane scroll; 							//편집기에 적용할 스크롤
	
	public Memeoapp() {
		m_file 	= new JMenu("파일");
		m_edit	= new JMenu("편집");
		m_style = new JMenu("서식");
		m_view 	= new JMenu("보기");
		m_help 	= new JMenu("도움말");
		
		bar 	= new JMenuBar();
		content = new JTextArea();
		scroll 	= new JScrollPane(content);
		
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
	}
	
	public static void main(String[] args) {
		new Memeoapp();

	}

}
