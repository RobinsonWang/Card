import java.awt.*;
import javax.swing.*;

/**
 * 花色堆 SuitPile类
 * 
 * @author RobinsonWang
 *  2011年11月
 */
public class SuitPile extends CardPile {
	JLabel suitCard[];
	
	public SuitPile()
	{
		suitCard=new JLabel[4];//4张用于suit_pile堆的牌；
		for(int i=0;i<4;i++)
		{
			suitCard[i]=new JLabel("Suit");
			suitCard[i].setIcon(new ImageIcon("image/sky.jpg"));
		}
		
	}
//----------------------------------------------------------------

}
