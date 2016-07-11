import java.awt.*;
import javax.swing.*;

/**
 * 待用堆 DeckPile类。
 * 
 * @author RobinsonWang
 *  2011年11月
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
