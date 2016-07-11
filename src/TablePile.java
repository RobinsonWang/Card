import java.awt.*;
import javax.swing.*;

/**
 * 桌面堆 TablePile类
 * 
 * @author RobinsonWang
 *  2011年11月
 */
public class TablePile extends CardPile {
	JLabel blueCard[];
	
	public TablePile()
	{
		blueCard=new JLabel[7];//7张用于中间牌堆的背景；
		for(int i=0;i<7;i++)
		{
			blueCard[i]=new JLabel("Blue");
			blueCard[i].setIcon(new ImageIcon("image/blue.jpg"));
		}
		
		
	}
//----------------------------------------------------------------------

}
