import java.awt.*;
import javax.swing.*;

/**
 * ��ɫ�� SuitPile��
 * 
 * @author RobinsonWang
 *  2011��11��
 */
public class SuitPile extends CardPile {
	JLabel suitCard[];
	
	public SuitPile()
	{
		suitCard=new JLabel[4];//4������suit_pile�ѵ��ƣ�
		for(int i=0;i<4;i++)
		{
			suitCard[i]=new JLabel("Suit");
			suitCard[i].setIcon(new ImageIcon("image/sky.jpg"));
		}
		
	}
//----------------------------------------------------------------

}
