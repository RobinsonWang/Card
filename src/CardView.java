import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * ��ͼ��CardView
 * �������ڴ������ӻ����棬����������롣
 * 
 * @author RobinsonWang
 *  2011��11��
 */
public class CardView {
	JFrame mainJFrame;
	JLayeredPane mainJPanel;//����Ҫ����壬��һ�����Է�ͼ������������壻
	JMenuBar mainMenuBar;//�˵���
	JMenu playMenu,helpMenu;//��Ϸ�˵��Ͱ����˵�
	JMenuItem newgameItem,exitItem,aboutcardItem;
	
//------------------------------------------------------------
	public CardView()
	{
		mainJFrame=new JFrame("ֽ����Ϸ");
		mainJPanel=new JLayeredPane();
		
		mainJPanel.setLayout(null);
		
		mainJFrame.setJMenuBar(mainMenuBar);
		mainJFrame.getContentPane().setBackground(Color.GREEN);
		mainJFrame.getContentPane().add(mainJPanel);
		mainJFrame.setSize(850,600);
		mainJFrame.setLocationRelativeTo(null);//ʹ��Ϸλ����Ļ���룻
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//-----------------------------------------------------------------
	public void createMenu()//�����˵���
	{
		mainMenuBar=new JMenuBar();
		playMenu=new JMenu("��Ϸ");
		helpMenu=new JMenu("����");
		
		newgameItem=new JMenuItem("����Ϸ");
		exitItem=new JMenuItem("�˳�");
		aboutcardItem=new JMenuItem("����ֽ��");
		
		playMenu.add(newgameItem);
		playMenu.addSeparator();
		playMenu.add(exitItem);
		helpMenu.add(aboutcardItem);
		
		mainMenuBar.add(playMenu);
		mainMenuBar.add(helpMenu);
	}
//----------------------------------------------------------------
}
