import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * 视图类CardView
 * 本类用于创建可视化界面，与数据相分离。
 * 
 * @author RobinsonWang
 *  2011年11月
 */
public class CardView {
	JFrame mainJFrame;
	JLayeredPane mainJPanel;//最主要的面板，是一个可以分图层放置组件的面板；
	JMenuBar mainMenuBar;//菜单条
	JMenu playMenu,helpMenu;//游戏菜单和帮助菜单
	JMenuItem newgameItem,exitItem,aboutcardItem;
	
//------------------------------------------------------------
	public CardView()
	{
		mainJFrame=new JFrame("纸牌游戏");
		mainJPanel=new JLayeredPane();
		
		mainJPanel.setLayout(null);
		
		mainJFrame.setJMenuBar(mainMenuBar);
		mainJFrame.getContentPane().setBackground(Color.GREEN);
		mainJFrame.getContentPane().add(mainJPanel);
		mainJFrame.setSize(850,600);
		mainJFrame.setLocationRelativeTo(null);//使游戏位于屏幕中央；
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//-----------------------------------------------------------------
	public void createMenu()//创建菜单；
	{
		mainMenuBar=new JMenuBar();
		playMenu=new JMenu("游戏");
		helpMenu=new JMenu("帮助");
		
		newgameItem=new JMenuItem("新游戏");
		exitItem=new JMenuItem("退出");
		aboutcardItem=new JMenuItem("关于纸牌");
		
		playMenu.add(newgameItem);
		playMenu.addSeparator();
		playMenu.add(exitItem);
		helpMenu.add(aboutcardItem);
		
		mainMenuBar.add(playMenu);
		mainMenuBar.add(helpMenu);
	}
//----------------------------------------------------------------
}
