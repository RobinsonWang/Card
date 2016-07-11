import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * 
 * @author RobinsonWang
 *  2011��11��
 */
public class CardGame {
	PlayCard playcard;
	CardView cardview;
	CardPile cardpile;
	SuitPile suitpile;
	TablePile tablepile;
	DeckPile deckpile;
	
	public CardGame()
	{
		playcard=new PlayCard();
		cardview=new CardView();
		cardpile=new CardPile();
		suitpile=new SuitPile();
		tablepile=new TablePile();
		deckpile=new DeckPile();
		
		Initialize();
		
	}
	
//------------------------------------------------------
	public void Initialize()
	{
		cardview.mainJPanel.add(deckpile.returnCard,new Integer(5));
		deckpile.returnCard.setBounds(0,0,100,150);
		cardview.mainJPanel.add(cardpile.backCard[0],new Integer(10));
		cardpile.backCard[0].setBounds(0,0,100,150);
		
		for(int i=1;i<=7;i++)//�����м��7���ƶѣ�
		{
			cardPile(i);
		}
		
		for(int i=0;i<4;i++)
		{
			int a=360+i*120;
			cardview.mainJPanel.add(suitpile.suitCard[i],new Integer(10));
			suitpile.suitCard[i].setBounds(a,0,100,150);
		}
		
		for(int i=0;i<7;i++)
		{
			int a=0+i*120;
			cardview.mainJPanel.add(tablepile.blueCard[i],new Integer(5));
			tablepile.blueCard[i].setBounds(a,170,100,150);
		}
		
		//��ӦbackCard��������¼���
		MouseListener smallMouse=new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(playcard.backCount>0 && playcard.spareListLength==0)
				{
					int a=playcard.list.get(playcard.addLabel);
					playcard.addLabel++;
					int b=24-playcard.backCount;
					b=b*10;
					cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
					cardpile.cardLabel[a].setBounds(120,0,100,150);
					playcard.backCount--;
					if(playcard.backCount==0)
						cardpile.backCard[0].setVisible(false);
				}
				if(playcard.spareListLength>0)//�������һ��returnCard֮���ٵ��backCardʱ��
				{
					int a=playcard.spareList.get(playcard.spareIndex);
					playcard.spareIndex++;
					int b=playcard.spareIndex*10;
					cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
					cardpile.cardLabel[a].setBounds(120,0,100,150);
					if(playcard.spareIndex==playcard.spareListLength)
					{
						cardpile.backCard[0].setVisible(false);
						playcard.spareList.clear();
						playcard.spareListLength=0;
						playcard.spareIndex=0;
					}
						
				}
				
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
			public void mouseReleased(MouseEvent e)
			{
				
			}
		};
		
		//��ӦreturnCard��������¼���
		MouseListener smallMouse2=new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//Ѱ��λ��spare_pile�ѵ��˿��ƣ�����Ż�deck_card���У�
				for(int i=0;i<52;i++)
				{
					Point point=new Point(0, 0);
					point=cardpile.cardLabel[i].getLocation();
					int a=point.x;
					int b=point.y;
					if(a==120 && b==0)
					{
						playcard.spareList.add(i);
						playcard.spareListLength++;
						cardview.mainJPanel.remove(cardpile.cardLabel[i]);//��ʱ�������ƴ�������Ƴ���
						
					}
				}
				if(playcard.spareListLength>0)
				{
					cardpile.backCard[0].setVisible(true);
				}
				//������������ˢ�����⣻
				cardview.mainJPanel.invalidate();
				cardview.mainJPanel.validate();
				cardview.mainJPanel.repaint();
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
			public void mouseReleased(MouseEvent e)
			{
				
			}
		};
		
		cardpile.backCard[0].addMouseListener(smallMouse);
		deckpile.returnCard.addMouseListener(smallMouse2);
		
		dragMouse smallDragMouse=new dragMouse();
		//Ϊ���е������˿�label��Ӽ�������
		for(int i=0;i<52;i++)
		{
			//ע��~~~~smallDragMouseһ��Ҫ�����·�ʽ������Σ�
			cardpile.cardLabel[i].addMouseListener(smallDragMouse);
			cardpile.cardLabel[i].addMouseMotionListener(smallDragMouse);
		}
		
        		
		
	}
//------------------------------------------------------
	public void cardPile(int k)//��ʼ��7���ƶѣ�k��ֵΪ1~7��
	{
		for(int i=0;i<k;i++)
		{
			int a=playcard.list.get(playcard.addLabel);
			playcard.addLabel++;
			int b=i*10;
			int x=0+(k-1)*120;
			int y=170+i*3;
			
			cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
			cardpile.cardLabel[a].setBounds(x,y,100,150);
			
			if(i!=k-1)
			{
				cardpile.cardLabel[a].setVisible(false);
				cardview.mainJPanel.add(cardpile.backCard[playcard.backNum],new Integer(10+b));
				cardpile.backCard[playcard.backNum].setBounds(x,y,100,150);
				playcard.backList.add(playcard.backNum);
				playcard.backListLength++;
				playcard.backNum++;
			}
			
		}
	}
//---------------------------------------------------------------
	private class dragMouse extends MouseInputAdapter//�ڲ��࣬���������϶�ֽ�Ƶ��¼���
	{
		public void mouseDragged(MouseEvent e)//���϶�labelʱ�������¼���
		{
			Point point=new Point(0, 0);//�������Ҫ�϶���label�ĵ�ǰ���ꣻ
			Point point2=new Point(0, 0);//�������λ��Ҫ�϶���label�����label�ĵ�ǰ���ꣻ
			
			
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//ȷ���¼�Դ��
				{
					int f=cardview.mainJPanel.getLayer(cardpile.cardLabel[i]);//�õ��¼�Դlabel��λ�ڵ�ͼ�㣻
					point=cardpile.cardLabel[i].getLocation();
					
					
					if(point.y>150)
					{
						for(int j=0;j<52;j++)//��ѭ������Ѱ��λ���¼�Դlabel�����label;
						{
							int d=cardview.mainJPanel.getLayer(cardpile.cardLabel[j]);
							if(j!=i && d>f)//������ɸѡ��ͼ��λ���¼�Դlabel֮�ϵ�label;
							{
								point2=cardpile.cardLabel[j].getLocation();
								int b=point2.x-point.x;
								int c=point2.y-point.y;
								if(b>-10 && b<10 && c>0)//������ͨ��λ�ý���ɸѡ��
								{
									playcard.dragList.add(j);//������������label��Ŵ��������У�
									playcard.layerList.add(d);//����Ӧ��ͼ����������У�
									playcard.xlist.add(b);//��������¼�Դlabel��x�������������У�
									playcard.ylist.add(c);//��������¼�Դlabel��y�������������У�
									playcard.dragCount++;//��¼������Ԫ�صĸ�����
								}
							}
						}
					}
					
					
					//���¼�Դlabel�ƶ�����λ�ã�
					cardpile.cardLabel[i].setLocation(e.getPoint().x+point.x,
		        			e.getPoint().y+point.y);
					playcard.highLay=cardview.mainJPanel.highestLayer();//highLay��ŵ�ǰͼ������ֵ��
					cardview.mainJPanel.remove(cardpile.cardLabel[i]);
					cardview.mainJPanel.add(cardpile.cardLabel[i],new Integer(playcard.highLay+10));
					
					playcard.dragFlat=true;
					
					break;
				}
			}
		}
		public void mouseReleased(MouseEvent e)//���ɿ����ʱ�������¼���
		{
			//System.out.println("***********"+dragCount);
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//�õ��¼�Դ��
				{
					
					//System.out.println("***********************!!");
					if(playcard.dragFlat && cardpile.cardLabel[i].getLocation().y>150)
					{
						checkRule(i);
						playcard.dragFlat=false;
					}
					if(playcard.dragFlat && cardpile.cardLabel[i].getLocation().y<100)
					{
						checkSuit(i);
						playcard.dragFlat=false;
					}
					checkWin();
					
					for(int k=0;k<playcard.dragCount;k++)//ȡ�������е�Ԫ�أ�
					{
						int j=playcard.dragList.get(k);//�õ���Ҫ�ƶ���label��
						int d=playcard.layerList.get(k);//�õ���Ҫ�ƶ���labelԭ�������ڵ�ͼ�㣻
						int b=playcard.xlist.get(k);//�õ���Ҫ�ƶ���label������¼�Դlabel��x����
						int c=playcard.ylist.get(k);//�õ���Ҫ�ƶ���label������¼�Դlabel��y����
						//��label�ƶ�����λ�ã�
						cardpile.cardLabel[j].setLocation(cardpile.cardLabel[i].getLocation().x+b,
								cardpile.cardLabel[i].getLocation().y+c);
						cardview.mainJPanel.remove(cardpile.cardLabel[j]);
						cardview.mainJPanel.add(cardpile.cardLabel[j],new Integer(playcard.highLay+10+d));
					}
					//����ù���������Ϊ��Ĵ����¼���Ҫ�õ���
					playcard.dragList.clear();
					playcard.layerList.clear();
					playcard.xlist.clear();
					playcard.ylist.clear();
					playcard.dragCount=0;
					
					scanBack();
					
					break;
				}
			}
			
		}
		public void mousePressed(MouseEvent e)//����걻����ʱ�������¼���
		{
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//�õ��¼�Դ��
				{
					//���������ƶ�ǰ��λ�ü�¼������
					playcard.original=cardpile.cardLabel[i].getLocation();
					playcard.originLayer=cardview.mainJPanel.getLayer(cardpile.cardLabel[i]);
				}
			}
		}
	}
//---------------------------------------------------------------
	public void checkRule(int k)//����м�7���ѵ��˿��Ʒ����Ƿ���Ϲ���
	{
		Point point=new Point(0,0);
		Point point2=new Point(0,0);
		ArrayList<Integer> adjustList;
		adjustList=new ArrayList<Integer>();
		int adjustListLength=0,top=0;
		
		point=cardpile.cardLabel[k].getLocation();
		for(int i=0;i<52;i++)
		{
			if(i!=k)
			{
				point2=cardpile.cardLabel[i].getLocation();
				int a=point2.x-point.x;
				int b=point2.y-point.y;
				if(a>-10 && a<10 && b<0 && point2.y>=170)
				{
					adjustList.add(i);
					adjustListLength++;
				}
			}
		}
		if(adjustListLength==0)
		{
			if(playcard.cardNum[k]==13)
			{
				if(point.x<20)
					cardpile.cardLabel[k].setLocation(0,170);
				if(point.x>=110 && point.x<=130)
					cardpile.cardLabel[k].setLocation(120,170);
				if(point.x>=230 && point.x<=250)
					cardpile.cardLabel[k].setLocation(240,170);
				if(point.x>=350 && point.x<=370)
					cardpile.cardLabel[k].setLocation(360,170);
				if(point.x>=470 && point.x<=490)
					cardpile.cardLabel[k].setLocation(480,170);
				if(point.x>=590 && point.x<=610)
					cardpile.cardLabel[k].setLocation(600,170);
				if(point.x>=710 && point.y<=730)
					cardpile.cardLabel[k].setLocation(720,170);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
			}
		}
		if(adjustListLength>0)
			top=adjustList.get(0);
		for(int i=1;i<adjustListLength;i++)
		{
			int a=adjustList.get(i);
			int b=cardpile.cardLabel[top].getLocation().y;
			int c=cardpile.cardLabel[a].getLocation().y;
			
			if(c>b)
				top=a;
		}
		if(adjustListLength>0)
		{
			int a=playcard.cardColor[k];
			int b=playcard.cardColor[top];
			int c=playcard.cardNum[k];
			int d=playcard.cardNum[top];
			
			if((a+b!=5) && (c==d-1) && (a!=b))
			{
				point2=cardpile.cardLabel[top].getLocation();
				cardpile.cardLabel[k].setLocation(point2.x,point2.y+20);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
			}
		}
		
	}
//--------------------------------------------------------------
	public void checkSuit(int k)//���suit_card�ѵķ����Ƿ���Ϲ���
	{
		Point point=new Point();
		Point point2=new Point(0,0);
		
		ArrayList<Integer> suitList;
		suitList=new ArrayList<Integer>();
		
		int suitListLength=0,top=0;
		
		point=cardpile.cardLabel[k].getLocation();
		
		for(int i=0;i<52;i++)
		{
			if(i!=k)
			{
				point2=cardpile.cardLabel[i].getLocation();
				int a=point2.x-point.x;
				int b=point2.y-point.y;
				if(a>-10 && a<10 && point2.y==0)
				{
					suitList.add(i);
					suitListLength++;
				}
			}
		}
		if(suitListLength==0)
		{
			if(playcard.cardNum[k]==1)
			{
				if(point.x>=350 && point.x<=380)
					cardpile.cardLabel[k].setLocation(360,0);
				if(point.x>=470 && point.x<=500)
					cardpile.cardLabel[k].setLocation(480,0);
				if(point.x>=590 && point.x<=620)
					cardpile.cardLabel[k].setLocation(600,0);
				if(point.x>=710 && point.y<=740)
					cardpile.cardLabel[k].setLocation(720,0);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
				cardview.mainJPanel.remove(cardpile.cardLabel[k]);
				cardview.mainJPanel.add(cardpile.cardLabel[k],new Integer(playcard.originLayer));
			}
		}
		if(suitListLength>0)
			top=suitList.get(0);
		for(int i=1;i<suitListLength;i++)
		{
			int a=suitList.get(i);
			int b=cardview.mainJPanel.getLayer(cardpile.cardLabel[top]);
			int c=cardview.mainJPanel.getLayer(cardpile.cardLabel[a]);
			
			if(c>b)
				top=a;
		}
		if(suitListLength>0)
		{
			int a=playcard.cardColor[k];
			int b=playcard.cardColor[top];
			int c=playcard.cardNum[k];
			int d=playcard.cardNum[top];
			
			if((a==b) && (c==d+1))
			{
				point2=cardpile.cardLabel[top].getLocation();
				cardpile.cardLabel[k].setLocation(point2);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
				cardview.mainJPanel.remove(cardpile.cardLabel[k]);
				cardview.mainJPanel.add(cardpile.cardLabel[k],new Integer(playcard.originLayer));
			}
		}
		
	}
//----------------------------------------------------------------
	public void checkWin()//��鱾����Ϸ�Ƿ��ʤ��
	{
		Point point1=new Point(0,0);
		Point point2=new Point(0,0);
		Point point3=new Point(0,0);
		Point point4=new Point(0,0);
		
		point1=cardpile.cardLabel[12].getLocation();
		point2=cardpile.cardLabel[25].getLocation();
		point3=cardpile.cardLabel[38].getLocation();
		point4=cardpile.cardLabel[51].getLocation();
		
		if(point1.x>300 && point1.y==0 && point2.x>300 && point2.y==0
		    && point3.x>300 && point3.y==0 && point4.x>300 && point4.y==0)
		{
			//System.out.println("You have won this game !");
			smallWindow();
		}
		else
		{
			//System.out.println("Go on to play this game !");
		}
	}
//-----------------------------------------------------------------
	public void scanBack()//ɨ��7�����е�backCard�����λ����㣬���Զ���������
  	{
  		for(int i=0;i<playcard.backListLength;i++)
  		{
  			Point point=new Point(0, 0);
  			Point point2=new Point(0, 0);
  			
  			int top=-1;//�˱��������ж��ϲ��Ƶ������
  			int block=-1;//�˱���������¼���ñ�backCard��ס������cardLabel��������
  			int a=playcard.backList.get(i);
  			point=cardpile.backCard[a].getLocation();
  			//�жϸ�backCard�Ƿ������ϲ��backCard;
  			for(int j=0;j<playcard.backListLength && top!=0;j++)
  			{
  				if(j!=i)
  				{
  					int b=playcard.backList.get(j);
  					point2=cardpile.backCard[b].getLocation();
  					int c=point2.x-point.x;
					int d=point2.y-point.y;
					if(c>-10 && c<10 && d>0)
					{
						top=0;//������һ��backCard�����ϲ㣻
					}
  				}
  			}
  			//�жϸ�backCard�ϲ��Ƿ������泯�ϵ��ƣ�
  			for(int j=0;j<52 && top!=0 && top!=1;j++)
  			{
  				point2=cardpile.cardLabel[j].getLocation();
  				int c=point2.x-point.x;
				int d=point2.y-point.y;
				if(c==0 && d==0)
				{
					block=j;
				}
				if(c>-10 && c<10 && d>0)
				{
					top=1;//�ϲ�������泯�ϵ��ƣ�
				}
  			}
  			//�����backCard�����ڵ��ƶѵ����ϲ��ƣ��򡰷�ת����
  			if(top!=0 && top!=1)
  			{
  				cardpile.cardLabel[block].setVisible(true);
  				cardview.mainJPanel.remove(cardpile.backCard[a]);//�������ȥ������backCard;
  				playcard.backList.remove(i);//��Ҫ���Ƕ�Ӧ��������ҲҪ��Ӧ���Ƴ������ƣ�
  				playcard.backListLength--;
  				i--;//����ɾ��һ��Ԫ�غ������Ԫ�ػ��Զ�ǰ�ƣ�����Ҫ��ɨ���α�ǰ��һ��λ�ã�
  			}
  		}
  	}
//-----------------------------------------------------------------
	public void smallWindow()
	{
		JFrame winFrame;
		JLabel winLabel;
		
		winFrame=new JFrame("��Ϸ��ʤ");
		winLabel=new JLabel("̫ţ�ˣ���ϲ�㣡");
		winLabel.setIcon(new ImageIcon("image/fireworks.gif"));
		
		winFrame.getContentPane().add(winLabel);
		winFrame.setSize(400,300);
		winFrame.setLocationRelativeTo(cardview.mainJFrame);
		winFrame.setVisible(true);
		winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
//-----------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardGame cardgame=new CardGame();

	}

}
