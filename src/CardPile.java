import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * CardPile类：实现一些牌堆公共的功能。
 * 
 * @author RobinsonWang
 *  2011年11月
 */
public class CardPile {
	JLabel cardLabel[],backCard[];
	
	public CardPile()
	{
		cardLabel=new JLabel[52];//一共52张牌，没有大小王；
		backCard=new JLabel[22];//8张背面的牌；
		for(int i=0;i<22;i++)
		{
			backCard[i]=new JLabel("Back");
			backCard[i].setIcon(new ImageIcon("image/back.jpg"));
		}
		//红桃1~13
		cardLabel[0]=new JLabel("H1");
		cardLabel[0].setIcon(new ImageIcon("image/h1.jpg"));
		cardLabel[1]=new JLabel("H2");
		cardLabel[1].setIcon(new ImageIcon("image/h2.jpg"));
		cardLabel[2]=new JLabel("H3");
		cardLabel[2].setIcon(new ImageIcon("image/h3.jpg"));
		cardLabel[3]=new JLabel("H4");
		cardLabel[3].setIcon(new ImageIcon("image/h4.jpg"));
		cardLabel[4]=new JLabel("H5");
		cardLabel[4].setIcon(new ImageIcon("image/h5.jpg"));
		cardLabel[5]=new JLabel("H6");
		cardLabel[5].setIcon(new ImageIcon("image/h6.jpg"));
		cardLabel[6]=new JLabel("H7");
		cardLabel[6].setIcon(new ImageIcon("image/h7.jpg"));
		cardLabel[7]=new JLabel("H8");
		cardLabel[7].setIcon(new ImageIcon("image/h8.jpg"));
		cardLabel[8]=new JLabel("H9");
		cardLabel[8].setIcon(new ImageIcon("image/h9.jpg"));
		cardLabel[9]=new JLabel("H10");
		cardLabel[9].setIcon(new ImageIcon("image/h10.jpg"));
		cardLabel[10]=new JLabel("H11");
		cardLabel[10].setIcon(new ImageIcon("image/h11.jpg"));
		cardLabel[11]=new JLabel("H12");
		cardLabel[11].setIcon(new ImageIcon("image/h12.jpg"));
		cardLabel[12]=new JLabel("H13");
		cardLabel[12].setIcon(new ImageIcon("image/h13.jpg"));
		//黑桃1~13
		cardLabel[13]=new JLabel("S1");
		cardLabel[13].setIcon(new ImageIcon("image/s1.jpg"));
		cardLabel[14]=new JLabel("S2");
		cardLabel[14].setIcon(new ImageIcon("image/s2.jpg"));
		cardLabel[15]=new JLabel("S3");
		cardLabel[15].setIcon(new ImageIcon("image/s3.jpg"));
		cardLabel[16]=new JLabel("S4");
		cardLabel[16].setIcon(new ImageIcon("image/s4.jpg"));
		cardLabel[17]=new JLabel("S5");
		cardLabel[17].setIcon(new ImageIcon("image/s5.jpg"));
		cardLabel[18]=new JLabel("S6");
		cardLabel[18].setIcon(new ImageIcon("image/s6.jpg"));
		cardLabel[19]=new JLabel("S7");
		cardLabel[19].setIcon(new ImageIcon("image/s7.jpg"));
		cardLabel[20]=new JLabel("S8");
		cardLabel[20].setIcon(new ImageIcon("image/s8.jpg"));
		cardLabel[21]=new JLabel("S9");
		cardLabel[21].setIcon(new ImageIcon("image/s9.jpg"));
		cardLabel[22]=new JLabel("S10");
		cardLabel[22].setIcon(new ImageIcon("image/s10.jpg"));
		cardLabel[23]=new JLabel("S11");
		cardLabel[23].setIcon(new ImageIcon("image/s11.jpg"));
		cardLabel[24]=new JLabel("S12");
		cardLabel[24].setIcon(new ImageIcon("image/s12.jpg"));
		cardLabel[25]=new JLabel("S13");
		cardLabel[25].setIcon(new ImageIcon("image/s13.jpg"));
		//梅花1~13
		cardLabel[26]=new JLabel("C1");
		cardLabel[26].setIcon(new ImageIcon("image/c1.jpg"));
		cardLabel[27]=new JLabel("C2");
		cardLabel[27].setIcon(new ImageIcon("image/c2.jpg"));
		cardLabel[28]=new JLabel("C3");
		cardLabel[28].setIcon(new ImageIcon("image/c3.jpg"));
		cardLabel[29]=new JLabel("C4");
		cardLabel[29].setIcon(new ImageIcon("image/c4.jpg"));
		cardLabel[30]=new JLabel("C5");
		cardLabel[30].setIcon(new ImageIcon("image/c5.jpg"));
		cardLabel[31]=new JLabel("C6");
		cardLabel[31].setIcon(new ImageIcon("image/c6.jpg"));
		cardLabel[32]=new JLabel("C7");
		cardLabel[32].setIcon(new ImageIcon("image/c7.jpg"));
		cardLabel[33]=new JLabel("C8");
		cardLabel[33].setIcon(new ImageIcon("image/c8.jpg"));
		cardLabel[34]=new JLabel("C9");
		cardLabel[34].setIcon(new ImageIcon("image/c9.jpg"));
		cardLabel[35]=new JLabel("C10");
		cardLabel[35].setIcon(new ImageIcon("image/c10.jpg"));
		cardLabel[36]=new JLabel("C11");
		cardLabel[36].setIcon(new ImageIcon("image/c11.jpg"));
		cardLabel[37]=new JLabel("C12");
		cardLabel[37].setIcon(new ImageIcon("image/c12.jpg"));
		cardLabel[38]=new JLabel("C13");
		cardLabel[38].setIcon(new ImageIcon("image/c13.jpg"));
		//方片1~13
		cardLabel[39]=new JLabel("D1");
		cardLabel[39].setIcon(new ImageIcon("image/d1.jpg"));
		cardLabel[40]=new JLabel("D2");
		cardLabel[40].setIcon(new ImageIcon("image/d2.jpg"));
		cardLabel[41]=new JLabel("D3");
		cardLabel[41].setIcon(new ImageIcon("image/d3.jpg"));
		cardLabel[42]=new JLabel("D4");
		cardLabel[42].setIcon(new ImageIcon("image/d4.jpg"));
		cardLabel[43]=new JLabel("D5");
		cardLabel[43].setIcon(new ImageIcon("image/d5.jpg"));
		cardLabel[44]=new JLabel("D6");
		cardLabel[44].setIcon(new ImageIcon("image/d6.jpg"));
		cardLabel[45]=new JLabel("D7");
		cardLabel[45].setIcon(new ImageIcon("image/d7.jpg"));
		cardLabel[46]=new JLabel("D8");
		cardLabel[46].setIcon(new ImageIcon("image/d8.jpg"));
		cardLabel[47]=new JLabel("D9");
		cardLabel[47].setIcon(new ImageIcon("image/d9.jpg"));
		cardLabel[48]=new JLabel("D10");
		cardLabel[48].setIcon(new ImageIcon("image/d10.jpg"));
		cardLabel[49]=new JLabel("D11");
		cardLabel[49].setIcon(new ImageIcon("image/d11.jpg"));
		cardLabel[50]=new JLabel("D12");
		cardLabel[50].setIcon(new ImageIcon("image/d12.jpg"));
		cardLabel[51]=new JLabel("D13");
		cardLabel[51].setIcon(new ImageIcon("image/d13.jpg"));
	}
//--------------------------------------------------------------
}
