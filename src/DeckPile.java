import java.awt.*;
import javax.swing.*;

/**
 * ���ö� DeckPile�ࡣ
 * 
 * @author RobinsonWang
 *  2011��11��
 *
 */
public class DeckPile extends CardPile {
	JLabel returnCard;
	
	public DeckPile()
	{
		returnCard=new JLabel("Return");
		returnCard.setIcon(new ImageIcon("image/love.jpg"));
	}

}
