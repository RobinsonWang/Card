import java.awt.*;
import javax.swing.*;

/**
 * ����� TablePile��
 * 
 * @author RobinsonWang
 *  2011��11��
 */
public class TablePile extends CardPile {
	JLabel blueCard[];
	
	public TablePile()
	{
		blueCard=new JLabel[7];//7�������м��ƶѵı�����
		for(int i=0;i<7;i++)
		{
			blueCard[i]=new JLabel("Blue");
			blueCard[i].setIcon(new ImageIcon("image/blue.jpg"));
		}
		
		
	}
//----------------------------------------------------------------------

}
